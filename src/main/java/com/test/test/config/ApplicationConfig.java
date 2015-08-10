package com.test.test.config;

import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.dialect.MySQLDialect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.test.test.dao.UserDao;

/**
 * web 服务配置项
 * 
 * @author houdg
 */

@Configuration
@ComponentScan(basePackages = {"com.test.test.service", "com.test.test.config"})
@EnableScheduling
@EnableWebMvc
@PropertySource("classpath:demo.properties")
@EnableJpaRepositories(basePackageClasses = { UserDao.class })
@EnableTransactionManagement
public class ApplicationConfig extends WebMvcConfigurerAdapter {

	@Value("${sql.showSql}")
	boolean showsql;

	@Value("${sql.jndi}")
	String jndi;

	@Value("${sql.ddl}")
	String sql_ddl;

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public DataSource dataSource() throws NamingException {
		javax.naming.Context ctx = new InitialContext();
		return (DataSource) ctx.lookup(jndi);
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(
			DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {

		LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
		lef.setDataSource(dataSource);
		lef.setJpaVendorAdapter(jpaVendorAdapter);
		lef.setPackagesToScan("com.test.test.domain");
		lef.setJpaProperties(getJpaProperties());
		return lef;
	}

	@Bean
	public Properties getJpaProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.id.new_generator_mappings", "true");
		properties.setProperty("hibernate.jdbc.use_get_generated_keys", "true");
		properties.setProperty("hibernate.format_sql", "true");

		properties.setProperty("hibernate.hbm2ddl.auto", sql_ddl);

		properties.setProperty("hibernate.show_sql", String.valueOf(showsql));
		properties.setProperty("hibernate.dialect",
				MySQLDialect.class.getName());

		return properties;
	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		return hibernateJpaVendorAdapter;
	}

	@Bean
	public JpaDialect jpaDialect() {
		return new HibernateJpaDialect();
	}

	@Bean
	public PlatformTransactionManager transactionManager(
			EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory);
		return txManager;
	}
}
