package com.test.spring.testapp;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

  @Value("${database.schema}")
  private String databaseSchema;

  @Autowired
  private DataSource dataSource;

  @Autowired
  public void DataSourceConfig() {
    final String jdbcUrl = ((HikariDataSource) dataSource).getJdbcUrl();
    if (!StringUtils.isBlank(jdbcUrl) && !jdbcUrl.contains("currentSchema")) { // fix for GCP Cloud SQL library - schema is not added
      ((HikariDataSource) dataSource).setJdbcUrl(jdbcUrl.concat("&currentSchema=").concat(databaseSchema));
    }
  }
}
