package dev.danvega.rc;

import dev.danvega.rc.post.PostService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		System.setProperty("jdk.httpclient.HttpClient.log","all");
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(PostService postService) {
		return args -> {
			System.out.println(postService.findAll());
		};
	}
}
