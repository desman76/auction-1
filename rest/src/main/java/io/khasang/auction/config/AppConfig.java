package io.khasang.auction.config;


import io.khasang.auction.dao.BirdDao;
import io.khasang.auction.dao.impl.BirdDaoImpl;
import io.khasang.auction.entity.Bird;
import io.khasang.auction.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

@PropertySource(value = "classpath:util.properties")
@PropertySource(value = "classpath:auth.properties")
@PropertySource(value = "classpath:hibernate.properties")
@Configuration
public class AppConfig {
    @Autowired
    private Environment environment;

    @Bean
    public Message message(){
        return new Message("bean from config file");
    }

    @Bean
    public DriverManagerDataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.postgresql.driver"));
            dataSource.setUrl(environment.getRequiredProperty("jdbc.postgresql.url"));
            dataSource.setUsername(environment.getRequiredProperty("jdbc.postgresql.userName"));
            dataSource.setPassword(environment.getRequiredProperty("jdbc.postgresql.password"));
            return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());

        return jdbcTemplate;
    }

    @Bean
    public UserDetailsService userDetailsService () {
        JdbcDaoImpl jdbcDao = new JdbcDaoImpl();
        jdbcDao.setDataSource(dataSource());
        jdbcDao.setUsersByUsernameQuery(environment.getProperty("userByQuery"));
        jdbcDao.setAuthoritiesByUsernameQuery(environment.getProperty("rolesByQuery"));
                return jdbcDao;
    }

    @Bean
    public BirdDao birdDao(){
        return new BirdDaoImpl(Bird.class);
    }
}
