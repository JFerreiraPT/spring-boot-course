package com.springboot.restApiDemo.restapi.demo.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.lang.reflect.ParameterizedType;
import java.util.List;

@NoRepositoryBean
public class BaseRepository<T> implements IBaseRepository<T> {
    @PersistenceContext
    private EntityManager em;

    private Class<T> typeOfT;

    public BaseRepository(Class<T> typeOfT) {
        System.out.println("here");
        System.out.println(typeOfT.getName());
        this.typeOfT = typeOfT;
    }

    @Override
    public <S extends T> List<S> getAll() {
        List<S> entities = (List<S>) em.createNamedQuery("getAll", typeOfT).getResultList();

        return entities;
    }

    @Override
    public <S extends T> S persist(S entity) {
        em.persist(entity);
        return entity;
    }
}
