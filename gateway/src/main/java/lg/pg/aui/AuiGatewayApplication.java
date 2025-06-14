package lg.pg.aui;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;



@SpringBootApplication
public class AuiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication
                .run(AuiGatewayApplication.class, args);
	}


    @Bean
    public RouteLocator routeLocator(
            RouteLocatorBuilder builder,
            @Value("${aui.proj.appointment.url}") String appointmentUrl,
            @Value("${aui.proj.doctor.url}") String doctorUrl,
            @Value("${aui.proj.gateway.host}") String host
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


    @Bean
    public CorsWebFilter corsWebFilter() {

        final CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.setAllowedOrigins(Collections.singletonList("*"));
        corsConfig.setMaxAge(3600L);
        corsConfig.setAllowedMethods(Arrays.asList("GET", "POST", "DELETE", "PUT"));
        corsConfig.addAllowedHeader("*");

        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);

        return new CorsWebFilter(source);
    }


}
