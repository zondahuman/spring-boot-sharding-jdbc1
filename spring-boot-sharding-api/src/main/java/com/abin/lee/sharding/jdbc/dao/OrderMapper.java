package com.abin.lee.sharding.jdbc.dao;

import com.abin.lee.sharding.jdbc.entity.TOrder;
import org.apache.ibatis.annotations.*;

@Mapper
public interface OrderMapper {

    @Insert("INSERT INTO t_order (order_id,user_id) VALUES (#{orderId},#{userId})")
    public void insert(TOrder order);

    @Results(value = { @Result(property = "userId", column = "user_id"),
            @Result(property = "orderId", column = "order_id"), })
    @Select("SELECT * FROM t_order WHERE order_id=#{id}")
    public TOrder findById(int id);

}
