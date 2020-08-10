package com.luban.kzhou.annotation;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.transaction.Transaction;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.luban.kzhou.service")
@MapperScan("com.luban.kzhou.dao")
public class AppConfig {

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(){
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        sqlSessionFactoryBean.setTransactionFactory(transactionFactory());
        return sqlSessionFactoryBean;
    }

    @Bean
    public DataSource dataSource(){
        DataSource dataSource = new DruidDataSource();
        ((DruidDataSource) dataSource).setDriverClassName("com.mysql.jdbc.Driver");
        ((DruidDataSource) dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/test_db");
        ((DruidDataSource) dataSource).setUsername("root");
        ((DruidDataSource) dataSource).setPassword("11111");
        return dataSource;
    }

    @Bean
    public TransactionFactory transactionFactory(){
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        return transactionFactory;
    }
}
