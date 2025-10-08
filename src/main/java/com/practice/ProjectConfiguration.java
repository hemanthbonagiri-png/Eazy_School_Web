package com.practice;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration

@ComponentScan(basePackages = "com.practice")
public class ProjectConfiguration {


    @Bean
    Vehicle vehicle(){

        var veh = new Vehicle();
        veh.setName("Audi");
        return veh;
    }


    @Bean
    Person person(){
        var pers = new Person();
        pers.setName("Lucy");
        pers.setVehicle(vehicle());
        return pers;
    }


}
