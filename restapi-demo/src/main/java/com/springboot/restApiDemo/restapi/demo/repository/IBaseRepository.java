package com.springboot.restApiDemo.restapi.demo.repository;

import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface IBaseRepository<T> {


    <S extends T> S findById(Integer id);

    <S extends T> S findOrFail(Integer id);

    <S extends T> List<S> getAll();
    <S extends T> S persist(S entity);

    <S extends T> S update (S entity);

    <S extends T> S delete(Integer id);

}
