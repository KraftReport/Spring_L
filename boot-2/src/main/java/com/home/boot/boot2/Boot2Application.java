package com.home.boot.boot2;

import com.github.javafaker.Faker;
import com.home.boot.boot2.model.Author;
import com.home.boot.boot2.model.Video;
import com.home.boot.boot2.model.repository.AuthorRepository;
import com.home.boot.boot2.model.repository.VideoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class Boot2Application {

	public static void main(String[] args) {
		SpringApplication.run(Boot2Application.class, args);
	}
//
//	@Bean
//	public CommandLineRunner commandLineRunner(AuthorRepository repository, VideoRepository videoRepository){
//		return args -> {
////			var faker = new Faker();
////			for(int i = 0 ;i<50; i++){
////				var author = Author.builder()
////						.firstName(faker.name().firstName())
////						.lastName(faker.name().lastName())
////						.age(faker.number().numberBetween(1,70))
////						.email( faker.name().username()+"@gmail.com")
////						.build();
////				repository.save(author);
////			}
////			 repository.updateNameById("Kraft","Report",1);
//			repository.updateAge(100);
//			var video = Video.builder()
//					.name("abc")
//					.length(9)
//					.build();
//			System.out.println(videoRepository.save(video));;
//		};
//	}

}
