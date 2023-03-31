package com.springboot.restApiDemo.restapi.demo.repository;

import com.springboot.restApiDemo.restapi.demo.entity.Student;
import com.springboot.restApiDemo.restapi.demo.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.repository.NoRepositoryBean;

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
    public <S extends T> S findById(Integer id) {
        return (S)em.find(typeOfT, id);
    }

    @Override
    public <S extends T> S findOrFail(Integer id) {
        S e = findById(id);

        if(e == null) {
            throw new NotFoundException("Entity doesn't exist");
        }

        return e;
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

    @Override
    public <S extends T> S update(S entity) {
        em.merge(entity);

        return entity;
    }

    @Override
    public <S extends T> S delete(Integer id) {
        S entity = this.findById(id);

        em.remove(entity);
        return entity;
    }


}
