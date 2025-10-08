package com.practice;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {

    public static  void main(String[] args) {


        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);

        Vehicle vehicle = context.getBean(Vehicle.class);

        System.out.println(vehicle.getName());

        Person person = context.getBean(Person.class);

        System.out.println(person.getName());
        System.out.println(person.getVehicle().getName());

    }
}
