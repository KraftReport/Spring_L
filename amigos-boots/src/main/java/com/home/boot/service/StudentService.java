package com.home.boot.service;

import com.home.boot.model.Student;
import com.home.boot.model.StudentCsvResperentation;
import com.home.boot.repository.StudentRepository;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.opencsv.bean.concurrent.ProcessCsvLine;

import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {

    @Autowired
    private final StudentRepository studentRepository;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public List<Student> returnStudentList(){
        return studentRepository.findAll();
    }

    public void addStudent(Student student){
        studentRepository.save(student);
    }

    public void updateStudent(Student student) {
        Long student1 = student.getId();
        Student student_id = studentRepository.findById(student1).orElseThrow();
        student_id.setId(student.getId());
        student_id.setName(student.getName());
        student_id.setAge(student.getAge());
        student_id.setDob(student.getDob());
        student_id.setEmail(student.getEmail());
        studentRepository.save(student_id);
    }

    public void deleteStudent(Student student) {
        studentRepository.delete(student);
    }

    public void addNewStudent(Student student){
        Optional<Student> studentByEmail = studentRepository.findByEmail(student.getEmail());
        if(studentByEmail.isPresent()){
            throw new IllegalArgumentException();
        }
        studentRepository.save(student);
    }

    public void delete(Long id) {
        boolean isExist =  studentRepository.existsById(id);
        if(!isExist){
            throw  new IllegalStateException("not exist");
        }
        studentRepository.deleteById(id);
    }

    @Transactional
    public void update(Long id, String name, String email) {
        var student = studentRepository.findById(id).orElseThrow(()->new IllegalStateException());
        if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }
        if(email!=null && email.length()>0 && !Objects.equals(student.getEmail(),email)){
            Optional<Student> studentOptional = studentRepository.findByEmail(email);
            if(studentOptional.isPresent()){
                throw new IllegalStateException("email is present");
            }
            student.setEmail(email);
        }
    }
    
    
	public Long uploadCsv(MultipartFile file) throws IOException {
		Set<Student> students = parseCsv(file);
		studentRepository.saveAll(students);
		return (long) students.size();
	}
	
	private Set<Student> parseCsv(MultipartFile file) throws IOException{
		try(Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))){
			HeaderColumnNameMappingStrategy<StudentCsvResperentation> strategy = new HeaderColumnNameMappingStrategy<>();
			strategy.setType(StudentCsvResperentation.class);
			CsvToBean<StudentCsvResperentation> csvToBean = new CsvToBeanBuilder<StudentCsvResperentation>(reader)
					.withMappingStrategy(strategy)
					.withIgnoreEmptyLine(true)
					.withIgnoreLeadingWhiteSpace(true)
					.build();
			return csvToBean.parse()
                    .stream()
                    .map(csvLine -> Student.builder()
                    		.name(csvLine.getName())
                    		.email(csvLine.getEamil())
                    		.dob(LocalDate.parse(csvLine.getDob(),formatter))
                    		.age(Period.between(LocalDate.parse(csvLine.getDob(),formatter), LocalDate.now()).getYears())
                    		.build()
					)
                    .collect(Collectors.toSet());
		}
	}
}
