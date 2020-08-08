package com.study.springboot.controller;

import com.study.springboot.dao.ProvincesDao;
import com.study.springboot.dao.UserCostDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

  @Autowired
  private UserCostDao costDao;

  @Autowired
  private ProvincesDao provincesDao;

  @GetMapping("/queryall")
  public String queryAll() {
    return costDao.query().toString();
  }

  @GetMapping("/queryallp")
  public String queryAllP() {
    return provincesDao.queryAll().toString();
  }
}
