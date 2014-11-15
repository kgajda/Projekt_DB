package pl.agh.projekt.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by karol on 27.10.14.
 */
@Configuration
@ComponentScan(basePackages ={
        "pl.agh.projekt.db.dao",
        "pl.agh.projekt.service",
        "pl.agh.projekt.untils"
})
@Import(DbConfiguration.class)
public class AppConfigurationSpring {

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
