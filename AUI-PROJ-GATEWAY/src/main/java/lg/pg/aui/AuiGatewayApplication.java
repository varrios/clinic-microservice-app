package lg.pg.aui;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class AuiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication
                .run(AuiGatewayApplication.class, args);
	}


    @Bean
    public RouteLocator routeLocator(
            RouteLocatorBuilder builder,
            @Value("${aui.appointment.url}") String appointmentUrl,
            @Value("${aui.doctor.url}") String doctorUrl,
            @Value("${aui.gatewy.host}") String host
    ) {
        return builder
                .routes()
                .route("appointments", route -> route
                        .host(host)
                        .and()
                        .path(
                                "/api/appointments/{uuid}",
                                "/api/appointments",
                                "/api/appointment",
                                "/api/doctors/{uuid}/appointments",
                                "/api/doctors/{uuid}/appointments/**"
                        )
                        .uri(appointmentUrl)
                )
                .route("doctors", route -> route
                        .host(host)
                        .and()
                        .path(
                                "/api/doctors",
                                "/api/doctors/**",
                                "/api/doctor/**"
                        )
                        .uri(doctorUrl)
                )
                .build();
    }

}
