package com.pool.config.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.pool.config.mapper.FormDomineMapper;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

@Configuration
public class OrikaMapperConfig {
	@Bean(name = "formDomineMapperfaced")
	public MapperFacade formDomineMapperfaced() {
		MapperFactory formToDomineMApperFactory = new DefaultMapperFactory.Builder().mapNulls(false).build();
		FormDomineMapper formDomineMapper = new FormDomineMapper(formToDomineMApperFactory);
		return formToDomineMApperFactory.getMapperFacade();
	}
}
