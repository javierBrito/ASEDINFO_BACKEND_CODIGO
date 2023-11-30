package ec.gob.educacion;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "spring1EntityManagerFactory", transactionManagerRef = "spring1TransactionManager", 
	basePackages = { "ec.gob.educacion.repositorio.wordpress"})
public class MySQLConfigWP {
	
	@Autowired
	private Environment env;
	
	@Bean(name = "spring1DataSource")
	public DataSource spring1DataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(env.getProperty("spring1.datasource.url"));
		dataSource.setUsername(env.getProperty("spring1.datasource.username"));
		dataSource.setPassword(env.getProperty("spring1.datasource.password"));
		dataSource.setDriverClassName(env.getProperty("spring1.datasource.driver-class-name"));
		
		return dataSource;
	}
	
	@Bean(name = "spring1EntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(spring1DataSource());
		em.setPackagesToScan("ec.gob.educacion.modelo.wordpress");
		
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		
		Map<String, Object> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", env.getProperty("spring1.jpa.hibernate.ddl-auto"));
		properties.put("hibernate.show-sql", env.getProperty("spring1.jpa.show-sql"));
		properties.put("hibernate.dialect", env.getProperty("spring1.jpa.database-platform"));
		
		em.setJpaPropertyMap(properties);
		
		return em;
		
	}
	
	@Bean(name = "spring1TransactionManager")
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		
		return transactionManager;
	}

}