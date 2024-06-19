package com.learnaws.hello;

import java.net.http.HttpHeaders;
import java.time.Instant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class HelloApplication {

  public static void main(String[] args) {
    SpringApplication.run(HelloApplication.class, args);
  }

  @GetMapping("/")
  public ResponseEntity<String> welcome() {
    String body = """
        <h1>Welcome to Spring boot</h1>
        <p>Made by <a href='https://learnaws.io'>LearnAWS.io</a>
        """;
    return ResponseEntity.ok().header("Content-Type", "text/html").body(body);
  }

  @GetMapping("/hello")
  public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
    return String.format("Hello %s! It's %s", name, Instant.now());
  }

}
