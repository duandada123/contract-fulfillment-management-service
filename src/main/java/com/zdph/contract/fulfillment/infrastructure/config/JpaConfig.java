package com.zdph.contract.fulfillment.infrastructure.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Configuration
public class JpaConfig {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Bean
    public EntityManager entityManager(){
       return entityManagerFactory.createEntityManager();
    }

    @Bean
    public JPAQueryFactory jpaQueryFactory(EntityManager entityManager) {
        return new JPAQueryFactory(entityManager);

    }


}
