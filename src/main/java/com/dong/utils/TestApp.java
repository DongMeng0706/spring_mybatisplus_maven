package com.dong.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dong.domain.User;
import com.dong.mapper.UserMapper;

public class TestApp {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("classpath:application-*.xml");
		//得到UserMapper
		UserMapper userMapper = context.getBean(UserMapper.class);
		/*User user = userMapper.selectById(1);
		System.out.println(user);
		User user2 = userMapper.selectById(2);
		System.err.println(user2);*/

		//insertUser(userMapper);
		updateUser(userMapper);
//		deleteUser(userMapper);
//		query1(userMapper);
//		query2(userMapper);
		//query3(userMapper);


		System.out.println("执行结束");
		
	}

	/**
	 * 分页
	 * @param userMapper
	 */
	private static void query3(UserMapper userMapper) {
		IPage<User> page=new Page<>(2, 3);

		userMapper.selectPage(page, null);
		long total = page.getTotal();
		
		List<User> list = page.getRecords();
		for (User user : list) {
			System.out.println(user);
		}
		System.out.println("总条数:"+total);
	}

	/**
	 * 查询返回集合
	 * @param userMapper
	 */
	private static void query2(UserMapper userMapper) {
		List<Integer> idList=Arrays.asList(15,16,17,18);
//		List<User> list = userMapper.selectBatchIds(idList);//where id in()
//		Map<String, Object> columnMap=new HashMap<String, Object>();
//		columnMap.put("id", 15);
//		List<User> selectByMap = userMapper.selectByMap(columnMap);
//		Integer count = userMapper.selectCount(null);
//		System.out.println(count);
		QueryWrapper<User> queryWrapper=new QueryWrapper<>();
		queryWrapper.gt("id", 15);
		queryWrapper.like("name", "明");
//		List<User> list = userMapper.selectList(queryWrapper);
		List<Map<String, Object>> selectMaps = userMapper.selectMaps(queryWrapper);
		System.out.println(selectMaps);
//		for (User user : list) {
//			System.out.println(user);
//		}
	}

	/**
	 * 查询一个
	 * @param userMapper
	 */
	private static void query1(UserMapper userMapper) {
		//		User user = userMapper.selectById(15);
		QueryWrapper<User> queryWrapper=new QueryWrapper<>();
		queryWrapper.eq("id", 15);
		User user = userMapper.selectOne(queryWrapper);
		System.out.println(user);
	}

	/**
	 * 删除
	 * @param userMapper
	 */
	private static void deleteUser(UserMapper userMapper) {
//		int flag = userMapper.deleteById(8);  //根据主键删除
//		System.out.println(flag);
//		List<Integer> idList = Arrays.asList(9,10,11);
//		userMapper.deleteBatchIds(idList); //根据ID的集合批量删除
		
		UpdateWrapper<User> updateWrapper=new UpdateWrapper<>();
		updateWrapper.between("id", 10, 13);
		//		userMapper.delete(updateWrapper);//根据条件构造器删除
		Map<String, Object> columnMap=new HashMap<String, Object>();
		columnMap.put("id", 14);
		userMapper.deleteByMap(columnMap);//根据map集合里面key的值做等值判断
		
	}

	/**
	 * 修改用户
	 * @param userMapper
	 */
	private static void updateUser(UserMapper userMapper) {
		User user=new User(0, "小明", "北京", new Date());
		/*User user1=new User();
		user1.setId(16);
		user1.setName("大司马");
		userMapper.updateById(user1);//如果对象属性里面的值为null就不会修改*/
		
		//按条件修改  UpdateWrapper条件构造器
		UpdateWrapper<User> updateWrapper=new UpdateWrapper<>();
		updateWrapper.like("name","大");
		//updateWrapper.between("id", 10, 15);
		userMapper.update(user, updateWrapper);
		
	}

	/**
	 * 添加用户
	 * @param userMapper
	 */
	private static void insertUser(UserMapper userMapper) {
		 userMapper.insert(new User(17, "冯提莫2", "湖南长沙2", new Date()));
	}

}
