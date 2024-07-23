package com.home.boot.student;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.Period;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.boot.test.context.SpringBootTest;

import com.home.boot.model.Student;
import com.home.boot.repository.StudentRepository;

@SpringBootTest
public class StudentRepositoryTest {

	@Autowired
	StudentRepository studentRepository;

	@BeforeEach
	void beforeEach() {
		var student = Student.builder().name("test-person").dob(LocalDate.of(2002, 12, 26))
				.age(Period.between(LocalDate.of(2002, 12, 26), LocalDate.now()).getYears())
				.email("testperson@gmail.com").build();

		studentRepository.save(student);
	}

	@AfterEach
	void afterEach() {
		studentRepository.deleteAll();
	}

	@Test
	public void TestCaseForMethodFindByEmailNotFound() {

		assertThat(studentRepository.findByEmail("noperson@gmail.com")).isNotPresent();
	}

	@Test
	public void TestCaseForMethodFindByEmail() {

		assertThat(studentRepository.findByEmail("testperson@gmail.com")).isPresent();
	}

}
