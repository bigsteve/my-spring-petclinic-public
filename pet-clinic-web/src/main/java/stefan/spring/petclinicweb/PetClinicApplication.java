package stefan.spring.petclinicweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"stefan.spring.petclinicdata", "stefan.spring.petclinicweb"})
@EntityScan("stefan.spring.petclinicdata")
@EnableJpaRepositories({"stefan.spring.petclinicdata"})
public class PetClinicApplication {

    public static void main(String... args) {
        SpringApplication.run(PetClinicApplication.class, args);
    }
}

