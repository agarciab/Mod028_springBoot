package com.vn.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration // Fichero de configuración
@EnableTransactionManagement // Habilitamos la transaccionalidad
@PropertySource({"classpath:database.properties"}) // Cargamos las propiedades del fichero database.properties
//@ComponentScan({"com.vn"}) // Ya no hace falta, Spring boot se encarga
@EnableJpaRepositories(basePackages = "com.vn.repository") // Habilitamos Spring Data JPA e indicamos dónde se encuentran los @Repository
public class PersistenceJPAConfig {

	/* Bean que representa el contexto de Spring */
	@Autowired
	private Environment env;

	/* Forma equivalente de cargar propiedades*/
	@Value("${hibernate.hbm2ddl.auto}")
	private String hbm2ddl;
	
	/*Spring boot creará el DataSource automáticamente mediante la configuración de application.properties y los jars del classpath (H2) */
//	@Bean
//	public DataSource dataSource() {
//		final DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName(driverCalss);
//		dataSource.setUrl(env.getProperty("jdbc.url"));
//		dataSource.setUsername(env.getProperty("jdbc.user"));
//		dataSource.setPassword(env.getProperty("jdbc.pass"));
//		return dataSource;
//	}

	/* Configuramos el gestor de transacciones */
	@Bean
	public PlatformTransactionManager transactionManager(final EntityManagerFactory emf) {
		final JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);

		return transactionManager;
	}

	/* Configuración fina de Hibernate */
	final Properties additionalProperties() {
		final Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", hbm2ddl); //Opción create-drop para generar automáticamente el schema
		hibernateProperties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		hibernateProperties.setProperty("hibernate.cache.use_second_level_cache", env.getProperty("hibernate.cache.use_second_level_cache"));
		hibernateProperties.setProperty("hibernate.cache.use_query_cache", env.getProperty("hibernate.cache.use_query_cache"));

		return hibernateProperties;
	}
	
	/* Indicaremos que el proveedor de acceso a datos JPA es Hibernate */
	@Bean
	public JpaVendorAdapter getJpaVendorAdapter() {
		JpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		return adapter;
	}
	
	/* Configuramos el Entity Manager, componente principal del JPA (equivalente a la SessionFactory en Hibernate) */
	@Bean
	/* El datasource se inyecta automáticamente */
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
	    LocalContainerEntityManagerFactoryBean emfBean = new LocalContainerEntityManagerFactoryBean();
	    emfBean.setJpaVendorAdapter(getJpaVendorAdapter());
	    emfBean.setDataSource(dataSource);
	    emfBean.setPersistenceUnitName("practica");
	    emfBean.setPackagesToScan("com.vn.entity"); // Hay que indicar dónde se ubican las @Entity
		/* 
		 * Configuración para la creación automática dle schema en base de datos
		 * y tambien otro tipo de configuración fina de Hibernate 
		 */
	    emfBean.setJpaProperties(additionalProperties());
	    return emfBean;
	}  

}
