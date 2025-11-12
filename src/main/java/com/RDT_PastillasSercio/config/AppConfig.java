package com.RDT_PastillasSercio.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.RDT_PastillasSercio.util.EnvConst;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class AppConfig implements WebMvcConfigurer{

    @Autowired
    Environment env;

    @Bean
    @Primary
    DataSource dataSource() {
        HikariConfig config = new HikariConfig();

        config.setJdbcUrl(env.getProperty(EnvConst.DB_URL));
        config.setUsername(env.getProperty(EnvConst.dbUsername));
        config.setPassword(env.getProperty(EnvConst.dbPassword));
        config.setDriverClassName(env.getProperty(EnvConst.dbClassName));

        return new HikariDataSource(config);
    }

    @Bean
    JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }


}
