package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
@Service
public class CarServiceImpl implements CarService{
    private List<Car> carList;

    public CarServiceImpl() {
        carList = new ArrayList<>();
        carList.add(new Car("BMW", "black", 777));
        carList.add(new Car("Ford", "grey", 345));
        carList.add(new Car("Toyota", "gold", 222));
        carList.add(new Car("Mercedes-Benz", "black", 964));
        carList.add(new Car("Audi", "white", 117));
    }

    @Override
    public List<Car> getCars(int carsNumber) {
        if (carsNumber > 4) {
            return carList;
        }
        return   carList.subList(0,carsNumber);
    }
}
