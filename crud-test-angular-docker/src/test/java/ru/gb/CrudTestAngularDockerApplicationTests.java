package ru.gb;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@TestPropertySource(locations = "classpath:application-test.properties")
@SpringBootTest
class CrudTestAngularDockerApplicationTests {

    @Test
    void contextLoads() {
    }

}
