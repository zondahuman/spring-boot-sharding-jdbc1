package com.abin.lee.sharding.jdbc.test;

import com.abin.lee.sharding.jdbc.dao.OrderMapper;
import com.abin.lee.sharding.jdbc.entity.TOrder;
import com.abin.lee.sharding.jdbc.main.ShardingJdbcApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ShardingJdbcApplication.class)
public class ShardingJdbcTest {

    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void test() {
        TOrder order = new TOrder();
        order.setUserId((int)(Math.random()*100000));
        order.setOrderId((int)(Math.random()*100000));
        orderMapper.insert(order);
    }

    @Test
    public void test2() {
        TOrder order = orderMapper.findById(60771);
        System.out.println("-----------------------------------------------------");
        System.out.println(order.getOrderId() + "--------= " + order.getUserId());
        System.out.println("-----------------------------------------------------");

    }

}
