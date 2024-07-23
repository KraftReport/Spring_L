package com.home.boot.student;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.home.boot.model.Student;
import com.home.boot.repository.StudentRepository;
import com.home.boot.service.StudentService;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
	
	StudentService service;
	@Mock
	StudentRepository studentRepository;
	@Captor
	ArgumentCaptor<Student> studentCaptor;
	
	@BeforeEach
	void setUp() {
		service = new StudentService(studentRepository);
	}
	
	@Test
	void testCaseForFindAll(){
		service.returnStudentList();
		verify(studentRepository).findAll(); 
	}
	
	@Test
	void testCaseForFindById1() {
		var id = 5L;
		when(studentRepository.findById(anyLong())).thenReturn(Optional.empty());
		assertThatThrownBy(()->
			service.getStudentById(id))
		.isInstanceOf(RuntimeException.class)
		.hasMessage("student with provied id is not found");
	}
	
	@Test
	void testCaseForFindById2() {
		var id = 5L;
		var name = "test-pserson";
		var email = "test@gmail.com";
		var dob = LocalDate.of(1998, 03, 21);
		var age = Period.between(dob, LocalDate.now()).getYears();
		var testPerson = Student.builder()
				.id(id)
				.name(name)
				.email(email)
				.dob(dob)
				.age(age)
				.build();
		studentRepository.save(testPerson);
		when(studentRepository.findById(id)).thenReturn(Optional.of(testPerson));
		var student = service.getStudentById(id).orElse(null);
		System.err.println(student); 
		assertThat(student.getId()).isEqualTo(id);
		assertThat(student.getName()).isEqualTo(name);
		assertThat(student.getEmail()).isEqualTo(email);
		assertThat(student.getDob()).isEqualTo(dob);
		assertThat(student.getAge()).isEqualTo(age);
	}
	
	@Test
	void testCaseForStudentCreation() {
		var student = Student.builder()
				.id(11L)
				.name("killer")
				.email("killer@gmail.com")
				.dob(LocalDate.of(1999, 11, 28))
				.age(Period.between(LocalDate.of(1999, 11, 28), LocalDate.now()).getYears())
				.build();
		service.addNewStudent(student);
		verify(studentRepository).save(studentCaptor.capture());
		var captor = studentCaptor.getValue();
		assertThat(captor.getId()).isEqualTo(student.getId());
		assertThat(captor.getName()).isEqualTo(student.getName());
		assertThat(captor.getEmail()).isEqualTo(student.getEmail());
		assertThat(captor.getDob()).isEqualTo(student.getDob());
		assertThat(captor.getAge()).isEqualTo(student.getAge());
	}
	
	@Test
	void testCaseForStudentUpdate1() {
		var student = Student.builder()
				.id(19L)
				.name("killer")
				.email("killer@gmail.com")
				.dob(LocalDate.of(1999, 11, 28))
				.age(Period.between(LocalDate.of(1999, 11, 28), LocalDate.now()).getYears())
				.build();
		when(studentRepository.findById(19L)).thenReturn(Optional.empty());
		assertThatThrownBy(()->service.updateStudent(student))
		.isInstanceOf(RuntimeException.class)
		.hasMessage("student not found with 19");
		verify(studentRepository,never()).save(any());
	}
	
	@Test
	void testCaseForStudentUpdate2() {
		var student = Student.builder()
				.id(11L)
				.name("killer")
				.email("killer@gmail.com")
				.dob(LocalDate.of(1999, 11, 28))
				.age(Period.between(LocalDate.of(1999, 11, 28), LocalDate.now()).getYears())
				.build();
		when(studentRepository.findById(11L)).thenReturn(Optional.of(student));
		service.update(11L, "kira", null);
		verify(studentRepository).save(studentCaptor.capture());
		var captor = studentCaptor.getValue();
		assertThat(captor.getName()).isEqualTo("kira");
		assertThat(captor.getAge()).isEqualTo(student.getAge());
	}
	
	@Test
	void testCaseForStudentDelete1() {
		when(studentRepository.existsById(17L)).thenReturn(false);
		assertThatThrownBy(()->service.delete(17L)).isInstanceOf(IllegalStateException.class).hasMessage("not exist");
		verify(studentRepository,never()).delete(any());
	}
	
	@Test
	void testCaseForStudentDelete2() {
		when(studentRepository.existsById(11L)).thenReturn(true);
		service.delete(11L);
		verify(studentRepository).deleteById(11L);
	}

}
