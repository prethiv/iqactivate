package com.neilson.iqactivate;

import com.neilson.controllers.StoreShopperController;
import com.neilson.entity.ShoppingInfoRepo;
import jakarta.persistence.Entity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.neilson.*"})
@EnableJpaRepositories(basePackageClasses = {ShoppingInfoRepo.class})
@ComponentScan("com.neilson.*")
@EntityScan("com.neilson.*")
public class IqactivateApplication {

	public static void main(String[] args) {
		SpringApplication.run(IqactivateApplication.class, args);
	}

}
