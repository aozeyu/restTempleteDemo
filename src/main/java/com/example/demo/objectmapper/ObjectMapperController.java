package com.example.demo.objectmapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yaozeyu
 */
@RestController
public class ObjectMapperController {
  @GetMapping("/convert")
  public String convert() throws JsonProcessingException {
    User user = new User();
    user.setId(1);
    user.setName("Judy");
    user.setContactEmail("test.com");
    ObjectMapper objectMapper = new ObjectMapper();

    // User 一> json 字串
    String jsonResult = objectMapper.writeValueAsString(user);
    System.out.println("json 的值为: " + jsonResult);

    //  json 字串 一> User
    String json = "{" +
        "\"id\":3," +
        "\"name\":\"Amy\"," +
        "\"age\":20," +
        "\"contact_email\":\"hello@test.com\"}";

    User userResult = objectMapper.readValue(json, User.class);
    System.out.println("User 的 id 值為: " + userResult.getId());
    System.out.println("User 的 name 值為: " + userResult.getName());
    System.out.println("User 的 email值為: " + userResult.getContactEmail());
    return "success";
  }
}
