package com.home.boot.student;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.home.boot.model.Student;
import com.home.boot.repository.StudentRepository;
import com.home.boot.service.StudentService;
import jakarta.inject.Inject;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class StudentControllerTest {

	public static final String API_ROUTH = "/api/v1/student";

	@MockBean
	StudentRepository studentRepository;
	@Inject
	StudentService studentService;
	@Autowired
	TestRestTemplate testRestTemplate;

	@BeforeEach
	void setUp() {
	}

	@Test
	void testCaseForCreation() {
		var student = Student.builder().id(1L).name("light").email("light@gmail.com").dob(LocalDate.of(1999, 12, 12))
				.age(Period.between(LocalDate.of(1999, 12, 12), LocalDate.now()).getYears()).build();
		ResponseEntity<Void> response = testRestTemplate.postForEntity(API_ROUTH, student, Void.class);
		when(studentRepository.save(any(Student.class))).thenReturn(student);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		ArgumentCaptor<Student> studentCaptor = ArgumentCaptor.forClass(Student.class);
		verify(studentRepository).save(studentCaptor.capture());
		var captor = studentCaptor.getValue();
		assertThat(captor.getId()).isEqualTo(student.getId());
		assertThat(captor.getName()).isEqualTo(student.getName());
		assertThat(captor.getEmail()).isEqualTo(student.getEmail());
		assertThat(captor.getDob()).isEqualTo(student.getDob());
		assertThat(captor.getAge()).isEqualTo(student.getAge());
	}

	@Test
	void testCaseForUpdate() {
		var student = Student.builder().id(1L).name("light").email("light@gmail.com").dob(LocalDate.of(1999, 12, 12))
				.age(Period.between(LocalDate.of(1999, 12, 12), LocalDate.now()).getYears()).build();
		when(studentRepository.findById(student.getId())).thenReturn(Optional.of(student));
		when(studentRepository.save(any(Student.class))).thenReturn(student);
		ResponseEntity<Void> response = testRestTemplate.postForEntity(API_ROUTH, student, Void.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		System.out.println("Create Response: " + response);
		var updatedEmail = "kira@gmail.com";
		student.setEmail(updatedEmail);
		when(studentRepository.save(any(Student.class))).thenReturn(student);
		testRestTemplate.put(API_ROUTH, student);
		ResponseEntity<Student> updateResponse = testRestTemplate.exchange(API_ROUTH + "/" + student.getId(),
				HttpMethod.GET, null, new ParameterizedTypeReference<Student>() {
				});
		System.out.println("Update Response: " + updateResponse);
		assertThat(updateResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
		var updated = updateResponse.getBody();
		if (updated == null) {
			throw new RuntimeException("not found");
		}
		assertThat(updated.getEmail()).isEqualTo(updatedEmail);
		assertThat(updated.getName()).isEqualTo(student.getName());
		assertThat(updated.getDob()).isEqualTo(student.getDob());
		assertThat(updated.getAge()).isEqualTo(student.getAge());
		assertThat(updated.getId()).isEqualTo(student.getId());
	}

	@Test
	void testCaseForDelete() {
		var student = Student.builder().id(1L).name("light").email("light@gmail.com").dob(LocalDate.of(1999, 12, 12))
				.age(Period.between(LocalDate.of(1999, 12, 12), LocalDate.now()).getYears()).build();
		when(studentRepository.findById(student.getId())).thenReturn(Optional.of(student));
		when(studentRepository.save(any(Student.class))).thenReturn(student);
		doNothing().when(studentRepository).delete(student);
		ResponseEntity<Void> response = testRestTemplate.postForEntity(API_ROUTH, student, Void.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		ResponseEntity<Student> createResponse = testRestTemplate.exchange(API_ROUTH + "/" + student.getId(),
				HttpMethod.GET, null, new ParameterizedTypeReference<Student>() {
				});
		assertThat(createResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(createResponse.getBody()).isNotNull();
		HttpEntity<Student> deleteRequest = new HttpEntity<>(student);
		ResponseEntity<Void> deleteResponse = testRestTemplate.exchange(API_ROUTH, HttpMethod.DELETE, deleteRequest,
				Void.class);
		assertThat(deleteResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
		verify(studentRepository, times(1)).delete(student);
		when(studentRepository.findById(student.getId())).thenReturn(Optional.empty());
		ResponseEntity<Student> getAfterDeleteResponse = testRestTemplate.exchange(API_ROUTH + "/" + student.getId(),
				HttpMethod.GET, null, new ParameterizedTypeReference<Student>() {
				});
		assertThat(getAfterDeleteResponse.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
