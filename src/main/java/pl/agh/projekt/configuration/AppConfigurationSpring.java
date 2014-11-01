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
@ComponentScan(basePackages = "pl.agh.projekt.db.dao")
@Import(DbConfiguration.class)
public class AppConfigurationSpring {

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
