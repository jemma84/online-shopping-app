package com.example.onlineshoppingapp.repository;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Testcontainers
public class AbstractPostgreSQLTestContainerIT {
    private static final String POSTGRES_VERSION = "postgres:13.1";
    public static PostgreSQLContainer database;

    static {
        database = new PostgreSQLContainer(POSTGRES_VERSION);
        database.start();
    }
}
