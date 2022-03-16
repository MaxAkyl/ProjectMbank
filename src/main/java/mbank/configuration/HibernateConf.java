package mbank.configuration;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * created by Beksultan Mamatkadyr uulu
 * project : SpringMVC-CRUD
 * 1/11/21
 * Monday 21:48
 */
@Configuration
@EnableTransactionManagement
@PropertySource("classpath:hibernate.properties")
public class HibernateConf {


    @Value("${spring.datasource.driver_class_name}")
    private String DRIVER_CLASS_NAME;

    public static final String PACKAGE_TO_SCAN = "mbank";

    @Value("${spring.datasource.url}")
    private String URL;

    @Value("${spring.datasource.username}")
    private String USERNAME;

    @Value("${spring.datasource.password}")
    private String PASSWORD;

    @Value("${spring.datasource.jpa.hibernate.dialect}")
    private String DIALECT;

    @Value("${spring.datasource.jpa.hibernate.hbm2ddl_auto}")
    private String HBM2DDL_AUTO;

    @Value("${spring.datasource.jpa.show_sql}")
    private String SHOW_SQL;

    //define LocalSessionFactoryBean
    @Bean
    public LocalSessionFactoryBean factoryBean() {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setPackagesToScan(PACKAGE_TO_SCAN);
        factoryBean.setHibernateProperties(hibernateProperties());
        return factoryBean;
    }

    //define DataSource
    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(DRIVER_CLASS_NAME);
        dataSource.setUrl(URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);
        return dataSource;
    }

    //define HibernateTransactionManager
    @Bean
    public PlatformTransactionManager transactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(factoryBean().getObject());
        return transactionManager;
    }

    //define properties
    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty(Environment.HBM2DDL_AUTO , HBM2DDL_AUTO);
        properties.setProperty(Environment.DIALECT, DIALECT);
        properties.setProperty(Environment.SHOW_SQL, SHOW_SQL);
        return properties;
    }
}
