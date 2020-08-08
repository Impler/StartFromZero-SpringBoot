package com.study.springboot;

import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataSourceTest {


  @Autowired
  private DataSource dataSource;

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Test
  public void testDataSource() {
    System.out.println(dataSource.getClass().getName());
  }

  @Test
  public void testQuery(){
    List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from t_user_cost");
    System.out.println(maps);
  }
}
