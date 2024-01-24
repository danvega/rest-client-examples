package dev.danvega.rc.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.danvega.rc.post.Post;
import dev.danvega.rc.post.PostService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RestClientTest(PostService.class)
class PostServiceTest {

    @Autowired
    MockRestServiceServer server;

    @Autowired
    PostService postService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void shouldReturnAllPosts() throws JsonProcessingException {
        // given
        List<Post> data = List.of(
                new Post(1, 1, "Hello, World!", "This is my first post!"),
                new Post(2, 1, "Testing Rest Client with @RestClientTest", "This is a post about testing RestClient calls")
        );

        // when
        server
                .expect(requestTo("/posts"))
                .andRespond(withSuccess(objectMapper.writeValueAsString(data), MediaType.APPLICATION_JSON));

        // then
        List<Post> posts = postService.findAll();
        assertThat(posts.size()).isEqualTo(2);
    }

}