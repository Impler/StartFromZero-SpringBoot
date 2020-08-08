package com.study.springboot;

import com.study.springboot.dmo.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootTester {

  @Autowired
  private Person person;

  @Test
  public void testConfig() {
    System.out.println(person);
  }


}