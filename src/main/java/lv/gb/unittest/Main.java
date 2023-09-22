package lv.gb.unittest;

import lv.gb.unittest.hw2.Car;
import lv.gb.unittest.hw2.Motorcycle;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("Dodge", "Ram", 2010);
        Motorcycle motorcycle = new Motorcycle("Suzuki", "MModel", 2012);

        System.out.println(car);
        System.out.println(motorcycle);
    }



}