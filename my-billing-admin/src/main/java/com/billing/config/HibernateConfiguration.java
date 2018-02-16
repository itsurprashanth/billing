package com.billing.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class HibernateConfiguration {
	
		@Bean
		@Autowired
		public  HibernateTemplate hibernateTemplate(SessionFactory sessionFactory) {
			HibernateTemplate hibernateTemplate=new HibernateTemplate();
			hibernateTemplate.setSessionFactory(sessionFactory);
			hibernateTemplate.setCheckWriteOperations(false);
			return hibernateTemplate;
		}
		@Bean
		@Autowired
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory= new LocalSessionFactoryBean();
		sessionFactory.setDataSource(datasource());
		sessionFactory.setHibernateProperties(hibernateProperties());
		sessionFactory.setPackagesToScan("com.billing");
		return sessionFactory;
	}
	@Bean
	public DataSource datasource() {
		DriverManagerDataSource datasource= new DriverManagerDataSource();
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost/test");
		datasource.setUsername("root");
		datasource.setPassword("Prashanth@123");
		return datasource;
	}

	@Bean
	public Properties hibernateProperties(){
		Properties properties= new Properties();
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		properties.put("hibernate.show_sql", "true");
		return properties;
	}

	@Bean
	@Autowired
	public HibernateTransactionManager hibernateTransactionManager(SessionFactory sessionfactory) {
		HibernateTransactionManager hibernateTransactionManager=new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(sessionfactory);
		return hibernateTransactionManager;
	}


	
}
