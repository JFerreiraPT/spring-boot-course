package com.springboot.restApiDemo.restapi.demo.repository;

import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface IBaseRepository<T> {

    <S extends T> List<S> getAll();
    <S extends T> S persist(S entity);

}
