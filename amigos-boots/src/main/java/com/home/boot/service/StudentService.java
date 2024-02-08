package com.home.boot.service;

import com.home.boot.model.Student;
import com.home.boot.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    @Autowired
    private final StudentRepository studentRepository;

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
}
