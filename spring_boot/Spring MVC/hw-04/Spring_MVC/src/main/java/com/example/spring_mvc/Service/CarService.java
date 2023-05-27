package com.example.spring_mvc.Service;

import com.example.spring_mvc.model.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    public final List<Car>cars=new ArrayList<>();
    public void creatData(){
        for (int i = 0; i <10 ; i++) {
            cars.add(new Car(i,"car"+i,"brand"+i,"color"+i));
        }
    }
    public List<Car> getCars(){
        creatData();
        return cars;
    }
}
