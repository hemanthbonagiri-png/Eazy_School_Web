package com.practice;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Random;
import java.util.function.Supplier;


public class Main {

    public static  void main(String[] args){


        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);

        Supplier<Vehicle> AudiSupplier = () ->{

            Vehicle vehicle = new Vehicle();
            vehicle.setName("Audi");
            return vehicle;

        };


        Supplier<Vehicle> HondaSupplier = () ->{

            Vehicle vehicle = new Vehicle();
            vehicle.setName("Honda");
            return vehicle;
        };


        Random random = new Random();

        int number = random.nextInt(5);

        if(number % 2 == 0){
            context.registerBean("Audi", Vehicle.class, AudiSupplier);
        }else{
            context.registerBean("Honda", Vehicle.class, HondaSupplier);
        }

        Vehicle AudiVehicle = null;

        Vehicle HondaVehicle = null;

        try{
            AudiVehicle = context.getBean("Audi", Vehicle.class);

        }catch(NoSuchBeanDefinitionException noSuchBeanDefinitionException){
            System.out.println("Audi bean was not present with that name");
        }


        try{
            HondaVehicle = context.getBean("Honda", Vehicle.class);
        }catch(NoSuchBeanDefinitionException noSuchBeanDefinitionException){
            System.out.println("Honda bean was not present with that name");
        }


        if(AudiVehicle != null){
            System.out.println("vehicle has been created by program and name is "+AudiVehicle.getName());
        }

        if(HondaVehicle != null){
            System.out.println("vehicle has been created by program and name is "+HondaVehicle.getName());
        }

    }
}
