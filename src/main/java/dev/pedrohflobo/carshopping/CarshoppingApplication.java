package dev.pedrohflobo.carshopping;

import java.io.PrintStream;
import java.util.List;
import java.util.Objects;

import dev.pedrohflobo.carshopping.dao.CarDao;
import dev.pedrohflobo.carshopping.domain.Acessory;
import dev.pedrohflobo.carshopping.domain.Car;
import dev.pedrohflobo.carshopping.domain.Manufacturer;
import dev.pedrohflobo.carshopping.exception.CommitException;
import dev.pedrohflobo.carshopping.exception.IdNotFoundException;
import dev.pedrohflobo.carshopping.services.CarService;
import dev.pedrohflobo.carshopping.utils.JpaUtil;
import jakarta.persistence.EntityManager;

public class CarshoppingApplication {

  public static void main(String[] args) throws CommitException, IdNotFoundException {
    JpaUtil.createEntityManagerFactory("default");
    EntityManager entityManager = JpaUtil.getentityManager();

    // Manufacturer manufacturer = new Manufacturer("Pionner");
    // ManufacturerDao manufacturerDao = new ManufacturerDao(entityManager);
    //
    // manufacturerDao.save(manufacturer);

    Car car = new Car("Palace", 1967, new Manufacturer("Citroen"), true);
    Car car1 = new Car("Ka", 2000, new Manufacturer("Ford"), true);
    car.addAcessory(new Acessory("Lampada Neon", car, new Manufacturer("Philips")));
   
    CarService carService = new CarService(new CarDao(entityManager));
    carService.register(car);
    carService.register(car1);
    
    List<Car> cars = carService.getAll();

    PrintStream p = Objects.requireNonNull(System.out);
    cars.forEach(o -> p.println(o.getModel()));

    System.out.println();
    carService.deleteAll(car);
    cars.forEach(o -> p.println(o.getModel()));


   // carDao.save(car);

   // Acessory acessories = new Acessory("Dvd",
   //     new ArrayList<Car>(Arrays.asList(
   //         new Car("Vectra", 2008, new Manufacturer("Chevrolet"), false),
   //         new Car("Uno", 2018, new Manufacturer("Fiat"), false),
   //         new Car("C4", 2018, new Manufacturer("Citroen"), false),
   //         new Car("C3", 2018, new Manufacturer("Citroen"), false),
   //         new Car("HB20", 2000, new Manufacturer("Hyundai"), false))),
   //     new Manufacturer("Pionner"));
   // AcessoryDao acessoryDao = new AcessoryDao(entityManager);
   // acessoryDao.save(acessories);

   // Car car2 = new Car("Palio", 1967, new Manufacturer("Fiat"), true);
   // car.addAcessory(new Acessory("Lampada Neon", car, new Manufacturer("Philips")));
   // carDao.save(car2);


    entityManager.close();

  }

}
