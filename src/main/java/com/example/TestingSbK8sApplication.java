package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import static reactor.core.publisher.Mono.just;

/**
 * @author wangbin
 */
@SpringBootApplication
public class TestingSbK8sApplication {
  @RestController
  class TestController {
    @GetMapping("/")
    public Mono<String> test() {
      return just("hello, world1");
    }
  }

  public static void main(String[] args) {
    SpringApplication.run(TestingSbK8sApplication.class, args);
  }
}
