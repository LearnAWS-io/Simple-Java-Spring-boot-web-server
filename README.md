# Simple Java Spring boot web server

![hello world in spring on the root path](https://github.com/LearnAWS-io/Simple-Java-Spring-boot-web-server/assets/23727670/bf729286-976a-48d7-9ce2-40cf13307d7f)

## Using curl to preview the response:
```sh
❯ curl localhost:8080/hello\?name=LearnAWS.io
Hello LearnAWS.io! It's 2024-06-19T22:18:38.787292626Z%   
```

## How to run this?

- [x] Make sure you have [Java & JDK installed](https://openjdk.org/install/) in your system
- [x] [Install mvn](https://maven.apache.org/install.html) for managing dependencies

### Start the spring web server using `mvn`

```sh
mvn spring-boot:run
```

## Code for `GET` routes

```java
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
```
