package com.myapp.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.SessionFactory;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.config.SessionFactoryFactoryBean;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.core.convert.CassandraConverter;
import org.springframework.data.cassandra.core.convert.MappingCassandraConverter;
import org.springframework.data.cassandra.core.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.core.mapping.SimpleUserTypeResolver;

import com.datastax.oss.driver.api.core.CqlSession;

@Configuration
public class AppConfig {
	
	 @Bean

	   SessionFactoryFactoryBean sessionFactory(CqlSession session,CassandraConverter converter) {

	       

	       SessionFactoryFactoryBean sessionFactory = new SessionFactoryFactoryBean();

	       sessionFactory.setSession(session);

	       

	       sessionFactory.setConverter(converter);

	       sessionFactory.setSchemaAction(SchemaAction.CREATE_IF_NOT_EXISTS);

	       return sessionFactory;

	   }

	   

	   @Bean

	   CassandraMappingContext mappingContext(CqlSession session) {

	       CassandraMappingContext mappingContext = new CassandraMappingContext();

	       return mappingContext;

	   }



	   @Bean

	   CassandraConverter converter(CassandraMappingContext mappingContext,CqlSession session) {



	       MappingCassandraConverter mc = new MappingCassandraConverter(mappingContext);

	       mc.setUserTypeResolver(new SimpleUserTypeResolver(session));

	       return mc;

	   }

	   

	   @Bean

	   CassandraOperations cassandraTemplate(SessionFactory sessionFactory,

	           CassandraConverter converter) {

	       return new CassandraTemplate(sessionFactory,converter);

	   }

}
