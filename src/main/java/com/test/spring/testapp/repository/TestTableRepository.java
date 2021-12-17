package com.test.spring.testapp.repository;

import com.test.spring.testapp.dto.TestTable;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TestTableRepository {

  @Select("select * from test_table")
  public List<TestTable> findAll();
}
