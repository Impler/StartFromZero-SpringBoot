package com.study.springboot.dao;

import com.study.springboot.dmo.UserCost;
import java.util.List;
import org.apache.ibatis.annotations.Select;

public interface UserCostDao {

  @Select("select * from t_user_cost")
  public List<UserCost> query();
}
