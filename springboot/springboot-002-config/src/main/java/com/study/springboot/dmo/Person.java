package com.study.springboot.dmo;

import java.util.List;
import java.util.Map;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 将配置文件中的配置映射到对象中
 */
@Component
@ConfigurationProperties(prefix = "person")
public class Person {

  private String name;
  private Integer age;
  private Map<String, Object> friends;
  private List<Pet> pets;
  private Job job;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public Map<String, Object> getFriends() {
    return friends;
  }

  public void setFriends(Map<String, Object> friends) {
    this.friends = friends;
  }

  public List<Pet> getPets() {
    return pets;
  }

  public void setPets(List<Pet> pets) {
    this.pets = pets;
  }

  public Job getJob() {
    return job;
  }

  public void setJob(Job job) {
    this.job = job;
  }

  @Override
  public String toString() {
    return "Person{" +
        "name='" + name + '\'' +
        ", age=" + age +
        ", friends=" + friends +
        ", pets=" + pets +
        ", job=" + job +
        '}';
  }
}
