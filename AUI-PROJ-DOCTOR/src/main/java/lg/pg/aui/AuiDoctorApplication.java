package lg.pg.aui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;

@SpringBootApplication
public class AuiDoctorApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuiDoctorApplication.class, args);
	}


	/**
     * @param baseUrl base URL
     * @return configured endpoint for doctor module
     */

	@Bean
    public RestTemplate restTemplate(@Value("${aui.doctor.url}") String baseUrl) {
        return new RestTemplateBuilder().rootUri(baseUrl).build();
    }

}
