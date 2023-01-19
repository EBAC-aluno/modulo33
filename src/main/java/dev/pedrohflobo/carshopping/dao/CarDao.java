package dev.pedrohflobo.carshopping.dao;

import dev.pedrohflobo.carshopping.dao.generics.GenericDao;
import dev.pedrohflobo.carshopping.domain.Car;
import jakarta.persistence.EntityManager;

public class CarDao extends GenericDao<Car, Long> implements ICarDao {

  public CarDao(EntityManager entityManager) {
    super(entityManager);
  }

}
