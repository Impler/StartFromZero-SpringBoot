package com.study.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 标注springboot主程序
 */
@SpringBootApplication
public class App {

  public static void main(String[] args) {

    // 启动spring应用
    SpringApplication.run(App.class, args);
  }

}
