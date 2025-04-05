package com.astafiev.recipemanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
* #TODO: (no particular order really)
*   1. Make code more consistent
*            2. Try using constructor injection in Serivce layer
*   3. Testing (unit)
*            4. Notification microservice (therefore Kafka)
*            5. Redis cache
*            6. Try using docker
*   7. Bring back Spring security, rn it's kinda abandoned
*            8. Clean-up. I've got so much stuff that I don't use anymore
*   9. Also swagger. It'll be easier if I start it now
*      9.1 Continue swagger-ing endpoints xd
 */

@SpringBootApplication
public class RecipeManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipeManagerApplication.class, args);
	}

}
