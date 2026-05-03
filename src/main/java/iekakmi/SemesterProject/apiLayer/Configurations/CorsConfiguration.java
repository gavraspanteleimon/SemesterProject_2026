package iekakmi.SemesterProject.apiLayer.Configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class CorsConfiguration implements WebMvcConfigurer{
	
	@Override
	public void addCorsMappings(CorsRegistry reg)
	{
		reg.addMapping("/**").allowedMethods("*");
	}
	
}
