package com.luban.config;

import com.luban.mapper.UserMapper;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.luban")
@MapperScan("com.luban.mapper")
public class AppConfig {

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setPassword("11111");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/test_db");
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return  driverManagerDataSource;
    }
    @Bean
    //这边是原生的mybatis事务，不是Spring的事务
    public TransactionFactory transactionFactory(){
        return new JdbcTransactionFactory();
    }

    @Bean
    //这边可以用参数传，也可以直接调用方法，因为加了@Component使用代理
    public Environment environment(){
        Environment environment = new Environment("development",transactionFactory(),dataSource());
        return environment;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource, TransactionFactory transactionFactory){
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTransactionFactory(transactionFactory);
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        //configuration.setLogImpl(Log4jImpl.class);
        sqlSessionFactoryBean.setConfiguration(configuration);
        return sqlSessionFactoryBean;
    }
}
