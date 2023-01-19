package dev.pedrohflobo.carshopping.services.generics;

import java.util.List;

import dev.pedrohflobo.carshopping.dao.generics.GenericDao;
import dev.pedrohflobo.carshopping.exception.CommitException;

public interface IGenericService<T, K, D extends GenericDao<T, K>> {

  void register(T entity) throws CommitException;

  List<T> getAll();

  void update(T entity) throws CommitException;

  void deleteAll(T entity) throws CommitException;

}
