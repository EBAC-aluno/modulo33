package dev.pedrohflobo.carshopping.services;

import dev.pedrohflobo.carshopping.dao.CarDao;
import dev.pedrohflobo.carshopping.domain.Car;
import dev.pedrohflobo.carshopping.services.generics.GenericService;

public class CarService extends GenericService<Car, Long, CarDao> implements ICarService {

  public CarService(CarDao dao) {
    super(dao);
  }

}
