package com.dong.utils;

import com.dong.domain.Car;
import com.dong.domain.User;
import com.dong.mapper.CarMapper;
import com.dong.mapper.UserMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author:dm
 * @Date:2020/10/5 11:55
 * @Description:
 */
public class TestCar {

    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:application-*.xml");
        //得到UserMapper
        CarMapper carMapper = context.getBean(CarMapper.class);

        Car car = new Car();
        car.setCarnumber("鄂A3306");
        car.setCarname("保时捷");

        carMapper.insert(car);
    }
}
