package ru.volkov.integration.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.config.EnableIntegration;

@SpringBootApplication
@EnableIntegration
@ImportResource("classpath:integration_context.xml")
public class JdbcApplication implements ApplicationRunner {

    private CircuitGateway gateway;

    @Autowired
    public JdbcApplication(CircuitGateway gateway) {
        this.gateway = gateway;
    }

    public static void main(String[] args) {
        SpringApplication.run(JdbcApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Circuit newCircuit = new Circuit();
        newCircuit.setId("Pak");
        newCircuit.setId("PAK");
        gateway.save(newCircuit);
    }
}
