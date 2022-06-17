package es.agenda.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

@Configuration
public class TilesConfiguration {

	@Bean
	public UrlBasedViewResolver tilesViewResolver() {
		
		UrlBasedViewResolver tilesViewResolver = new UrlBasedViewResolver();

		tilesViewResolver.setViewClass(TilesView.class);

		return tilesViewResolver;
	}

	@Bean
	public TilesConfigurer tilesConfigurer() {
		
		TilesConfigurer tilesConfigurer = new TilesConfigurer();

		String[] defs = { "WEB-INF/tiles-definition.xml" };

		tilesConfigurer.setDefinitions(defs);
		tilesConfigurer.setCheckRefresh(true);
				
		return tilesConfigurer;
	}
	
	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver irv = new InternalResourceViewResolver();
	    irv.setPrefix("/WEB-INF/jsp/");
	    irv.setSuffix(".jsp");
	 
	    return irv;
	}
}
