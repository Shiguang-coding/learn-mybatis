package com.shiguang.mybatis.test;


import com.shiguang.mybatis.mapper.DeptMapper;
import com.shiguang.mybatis.pojo.Dept;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Date:2021/11/30
 * Author:ybc
 * Description:
 */
public class MBGTest {

    @Test
    public void testMBG(){
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
            //查询所有数据
            List<Dept> list = mapper.selectByExample(null);
            list.forEach(System.out::println);

            //根据条件查询  QBC(Query By Criteria)风格,根据条件查询
//            DeptExample example = new DeptExample();
//            example.createCriteria().andDeptNameEqualTo("管理部").andDidEqualTo(1);
//            example.or().andDidIsNotNull();
//            List<Dept> list = mapper.selectByExample(example);
//            list.forEach(System.out::println);

            //修改
//            mapper.updateByPrimaryKeySelective(new Dept(1,"法务部"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
