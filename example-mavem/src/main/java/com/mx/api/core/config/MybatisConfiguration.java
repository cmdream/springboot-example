package com.mx.api.core.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;


@Configuration
public class MybatisConfiguration {

    @Bean()
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "secondDatasource")
    @ConfigurationProperties(prefix = "spring.second-datasource")
    public DataSource secondDataSource() {
        return DataSourceBuilder.create().build();
    }

    /*@Bean(name="sqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);

        // 加入对Java8 Time的支持
        // 设置MyBatis PageHelper插件
        *//*PageHelper pageHelper = new PageHelper();
        Properties pageHelperProps = new Properties();
        pageHelperProps.setProperty("dialect", "postgresql");
        pageHelperProps.setProperty("offsetAsPageNum", "true");
        pageHelperProps.setProperty("pageSizeZero", "true");
        pageHelperProps.setProperty("rowBoundsWithCount", "true");
        pageHelper.setProperties(pageHelperProps);*//*

        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();
        sqlSessionFactory.getConfiguration().setMapUnderscoreToCamelCase(true);
        return sqlSessionFactory;
    }

    @Bean(name="secondSqlSessionFactory")
    public SqlSessionFactory secondSqlSessionFactory(@Qualifier("secondDatasource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);

        // 设置MyBatis PageHelper插件
        *//*PageHelper pageHelper = new PageHelper();
        Properties pageHelperProps = new Properties();
        pageHelperProps.setProperty("dialect", "postgresql");
        pageHelperProps.setProperty("offsetAsPageNum", "true");
        pageHelperProps.setProperty("pageSizeZero", "true");
        pageHelperProps.setProperty("rowBoundsWithCount", "true");
        pageHelper.setProperties(pageHelperProps);*//*

        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();
        sqlSessionFactory.getConfiguration().setMapUnderscoreToCamelCase(true);

        return sqlSessionFactory;
    }*/

}
