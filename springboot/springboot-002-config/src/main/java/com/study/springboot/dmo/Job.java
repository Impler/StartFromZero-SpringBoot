package com.study.springboot.dmo;

public class Job {

  private String name;
  private Double incoming;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getIncoming() {
    return incoming;
  }

  public void setIncoming(Double incoming) {
    this.incoming = incoming;
  }

  @Override
  public String toString() {
    return "Job{" +
        "name='" + name + '\'' +
        ", incoming=" + incoming +
        '}';
  }
}
