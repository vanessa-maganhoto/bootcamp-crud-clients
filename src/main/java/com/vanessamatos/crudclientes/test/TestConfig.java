/*package com.vanessamatos.crudclientes.test;

import com.vanessamatos.crudclientes.model.Client;
import com.vanessamatos.crudclientes.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void run(String... args) throws Exception {

        Client c1 = new Client(null, "Helena", "500.398.550-90", 3200.00, Instant.now(), "0" );
        Client c2 = new Client(null, "Maria Clara", "500.398.550-90", 3200.00, Instant.now(), "0" );
        Client c3 = new Client(null, "Aline", "500.398.550-90", 3200.00, Instant.now(), "0" );
        Client c4 = new Client(null, "Pedro", "500.398.550-90", 3200.00, Instant.now(), "0" );

        clientRepository.saveAll(Arrays.asList(c1, c2, c3, c4));
    }
}*/
