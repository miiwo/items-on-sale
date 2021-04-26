package com.miiwo.itemsonsale.configs;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final List<String> domains = List.of("shopping.rbc.com");
	private final List<String> methods = List.of("GET");
	private final List<String> headers = List.of("Origin");

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated()
		.and().exceptionHandling().authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.FORBIDDEN))
		.and().httpBasic();
    }

    /**
	 *  Configurations for CORS.
	 */
	@Bean
	public CorsFilter setCorsConfig() {
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowedOrigins(domains);
		config.setAllowedHeaders(headers); // Consider getting rid of this
		config.setAllowedMethods(methods);

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", config);

		return new CorsFilter(source);
	}
}
