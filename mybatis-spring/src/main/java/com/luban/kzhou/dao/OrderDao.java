package com.luban.kzhou.dao;

import com.luban.kzhou.entity.OrderEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface OrderDao {

    @Select("SELECT * FROM test_order WHERE ID = #{id}")
    public OrderEntity getOrderById(@Param("id") String id);
}
