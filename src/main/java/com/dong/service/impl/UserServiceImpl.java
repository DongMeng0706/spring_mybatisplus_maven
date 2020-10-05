package com.dong.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dong.domain.User;
import com.dong.service.UserService;


@Service
public class UserServiceImpl extends ServiceImpl<BaseMapper<User>, User> implements UserService {

}
