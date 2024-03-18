package config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import profiles.DevProfile;
import profiles.ProductionProfile;
import profiles.SystemProfile;

@Configuration
public class AppConfig {

    @Bean
    @ConditionalOnProperty(name = "netology.profile.dev", havingValue = "true")
    public SystemProfile devProfile() {
        return new DevProfile();
    }

    @Bean
    @ConditionalOnProperty(name = "netology.profile.dev", havingValue = "false")
    public SystemProfile prodProfile() {
        return new ProductionProfile();
    }
}