package com.intech.telecom.configs;



import com.intech.telecom.configs.initializer.TestDataInitializer;
import com.intech.telecom.security.configs.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@EnableWebMvc
@Configuration
@ComponentScan({"com.intech.telecom"})
@EnableTransactionManagement
@PropertySource(value = {"classpath:hibernate.properties"})
@Import({SecurityConfig.class})
public class AppConfig {

	@Autowired
	private Environment environment;

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();

		entityManagerFactory.setDataSource(dataSource);
		entityManagerFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		entityManagerFactory.setJpaDialect(new HibernateJpaDialect());
		entityManagerFactory.setPackagesToScan("com.intech.telecom");

		entityManagerFactory.setJpaPropertyMap(hibernateJpaProperties());
		return entityManagerFactory;
	}

	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {

		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
		jpaTransactionManager.setEntityManagerFactory(emf);
		return jpaTransactionManager;
	}

	private Map<String, ?> hibernateJpaProperties() {
		HashMap<String, String> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
		properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));


		return properties;
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getRequiredProperty("hibernate.connection.driver_class"));
		dataSource.setUrl(environment.getRequiredProperty("hibernate.connection.url"));
		dataSource.setUsername(environment.getRequiredProperty("hibernate.connection.username"));
		dataSource.setPassword(environment.getRequiredProperty("hibernate.connection.password"));
		return dataSource;
	}

	@Bean(initMethod = "init")
	public TestDataInitializer initTestData() {
		return new TestDataInitializer();
	}

}
