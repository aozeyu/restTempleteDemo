package com.example.demo.resttemplete;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author yaozeyu
 */
public class Student {
  Integer id;
  String name;

  @JsonProperty("contact_phone")
  String contactPhone;

  public String getContactPhone() {
    return contactPhone;
  }

  public void setContactPhone(String contactPhone) {
    this.contactPhone = contactPhone;
  }
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
