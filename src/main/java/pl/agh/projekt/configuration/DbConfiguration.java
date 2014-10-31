package pl.agh.projekt.configuration;

import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by karol on 27.10.14.
 */
@Configuration
@EnableTransactionManagement
public class DbConfiguration {

    @Bean(destroyMethod = "close")
    public DataSource dataSource(){
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setMaximumPoolSize(50);
        hikariDataSource.setUsername("root");
        hikariDataSource.setPassword("");
        hikariDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/northwind");
        hikariDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return hikariDataSource;
    }

    @Bean
    public SessionFactory sessionFactory() throws IOException {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setHibernateProperties(hibernateProperties());
        sessionFactory.setPackagesToScan("com.kiwipowered.kiwiwebapi.domain");
        sessionFactory.afterPropertiesSet();
        return sessionFactory.getObject();
    }

    private Properties hibernateProperties() {
        final Properties properties = new Properties();
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.hbm2ddl.auto", "validate");
        return properties;
    }

    @Bean
    public HibernateTransactionManager transactionManager() throws IOException {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory());
        return transactionManager;
    }

}
