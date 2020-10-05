package com.dong.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dong.domain.Car;
import com.dong.service.CarService;
import org.springframework.stereotype.Service;

/**
 * @Author:dm
 * @Date:2020/10/5 12:55
 * @Description:
 */
@Service
public class CarServiceImpl  extends ServiceImpl<BaseMapper<Car>, Car> implements CarService {
}
