package com.luban.kzhou.service;

import com.luban.kzhou.dao.OrderDao;
import com.luban.kzhou.entity.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderDao orderDao;

    public void handleOrderInfoById(String id){
        OrderEntity orderEntity = orderDao.getOrderById(id);

        if("1".equals(orderEntity.getCustomerId())){
            System.out.println("XXXXXXXXX");
        }else {
            System.out.println(orderEntity);
        }
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }
}
