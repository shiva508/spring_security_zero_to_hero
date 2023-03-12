package com.pool.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pool.mapper.FormDomainMapper;
import com.pool.mapper.ModelDomainMapper;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

@Configuration
public class OrikaMappingConfig {
	@Bean
	public MapperFacade formDomainMapperFacade() {
		MapperFactory formDomainMapperFactory = new DefaultMapperFactory.Builder().mapNulls(false).build();
		FormDomainMapper formDomainMapper = new FormDomainMapper(formDomainMapperFactory);
		return formDomainMapperFactory.getMapperFacade();
	}
	@Bean
	public MapperFacade modelDomainMapperFacade() {
		MapperFactory modelDomainFactory=new DefaultMapperFactory.Builder().build();
		ModelDomainMapper modelDomainMapper=new ModelDomainMapper(modelDomainFactory);
		return modelDomainFactory.getMapperFacade();
	}
}
