package net.tusdasa.evaluation;

import org.springframework.boot.SpringApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.SpringCloudApplication;

@EnableCaching
@SpringCloudApplication
public class CalculationRulesApplication {
    public static void main(String[] args) {
        SpringApplication.run(CalculationRulesApplication.class, args);
    }
}
