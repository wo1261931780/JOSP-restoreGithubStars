package wo1261931780.JOSP_restoreGithubStars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class JospRestoreGithubStarsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JospRestoreGithubStarsApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
