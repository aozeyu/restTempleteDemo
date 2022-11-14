package com.example.demo.resttemplete;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yaozeyu
 */
@RestController
public class RestTemplateController {
  @GetMapping("/getForObject")
  public String getForObject() {
    RestTemplate restTemplate = new RestTemplate();
    Student student = restTemplate.getForObject("https://mocki.io/v1/6b827c59-0eb8-479f-b488-9fb0512da455", Student.class);

    System.out.println("Student 的 id 值為: " + student.getId());
    System.out.println("Student 的 name 值為: " + student.getName());
    System.out.println("Student 的 phone 值為: " + student.getContactPhone());
    return "getForObject Success!";
  }

  @GetMapping("/getForObjectWithParam")
  public String getForObjectWithParam() {
    RestTemplate restTemplate = new RestTemplate();
    Map<String, Object> queryParamMap = new HashMap<>();
    queryParamMap.put("graduate", true);
    Student student = restTemplate.getForObject("https://mocki.io/v1/77f69435-224e-4c90-b7cd-53f07bbf5604", Student.class, queryParamMap);
    return "getForObject with param success";

  }

  @GetMapping("/getForEntity")
  public String getForEntity() {
    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<Student> studentResponseEntity = restTemplate.getForEntity("https://mocki.io/v1/b7a68eb2-f77c-43cf-bffe-8c647e9a2514", Student.class);
    System.out.println("http状态码为: " + studentResponseEntity.getStatusCode());
    Student student = studentResponseEntity.getBody();
    assert student != null;
    System.out.println("student 的 id 值為: " + student.getId());
    System.out.println("student 的 name 值為: " + student.getName());
    System.out.println("student 的 phone 值為: " + student.getContactPhone());
    return "getForEntity success";

  }

}
