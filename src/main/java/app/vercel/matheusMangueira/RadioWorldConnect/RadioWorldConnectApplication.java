package app.vercel.matheusMangueira.RadioWorldConnect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RadioWorldConnectApplication {

	public static void main(String[] args) {
		SpringApplication.run(RadioWorldConnectApplication.class, args);
	}

}
