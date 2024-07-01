package dev.danvega.rc;

import dev.danvega.rc.post.PostClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestClientCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		System.setProperty("jdk.httpclient.HttpClient.log","all");
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public RestClient restClient(RestClient.Builder builder) {
		return builder.build();
	}

	@Bean
	public RestClientCustomizer restClientCustomizer() {
		return (restClientBuilder) -> restClientBuilder
				.requestFactory(new JdkClientHttpRequestFactory())
				.baseUrl("https://jsonplaceholder.typicode.com");
	}

	@Bean
	CommandLineRunner commandLineRunner(PostClient postService) {
		return args -> {

		};
	}
}
