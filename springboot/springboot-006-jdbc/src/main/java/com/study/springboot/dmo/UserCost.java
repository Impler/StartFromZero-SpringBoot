package com.study.springboot.dmo;

import java.util.Date;

public class UserCost {

  private Long id;
  private String uid;
  private Date cdate;
  private Double money;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUid() {
    return uid;
  }

  public void setUid(String uid) {
    this.uid = uid;
  }

  public Date getCdate() {
    return cdate;
  }

  public void setCdate(Date cdate) {
    this.cdate = cdate;
  }

  public Double getMoney() {
    return money;
  }

  public void setMoney(Double money) {
    this.money = money;
  }

  @Override
  public String toString() {
    return "UserCost{" +
        "id=" + id +
        ", uid='" + uid + '\'' +
        ", cdate=" + cdate +
        ", money=" + money +
        '}';
  }
}
