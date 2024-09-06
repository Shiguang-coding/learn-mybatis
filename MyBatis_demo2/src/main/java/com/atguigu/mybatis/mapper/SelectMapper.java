package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Date:2021/11/27
 * Author:ybc
 * Description:
 */
public interface SelectMapper {

    /**
     * 根据id查询用户信息
     */
    List<User> getUserById(@Param("id") Integer id);

    /**
     * 查询所有的用户信息
     */
    List<User> getAllUser();

    /**
     * 查询用户信息的总记录数
     */
    Integer getCount();

    /**
     * 根据id查询用户信息为一个map集合
     */
    Map<String, Object> getUserByIdToMap(@Param("id") Integer id);


    /**
     * 查询所有用户信息为map集合
     * 将表中的数据以map集合的方式查询，一条数据对应一个map;
     * 若有多条数据，就会产生多个map集合，此时可以将这些map放在一个1ist集合中获取
     */
    List<Map<String, Object>> getAllUserToListMap();


    /**
     * 查询所有用户信息为map集合
     * 将表中的数据以map集合的方式查询，一条数据对应一个map:
     * 若有多条数据，就会产生多个map集合，并且最终要以一个map的方式返回数据，
     * 此时需要通过@MapKey注解设置map集合的键，值是每条数据所对应的map集合
     */
    @MapKey("id")
    Map<String, Object> getAllUserToMap();

}
