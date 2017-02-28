package com.sh.service.impl;


import com.sh.dao.OrderDao;
import com.sh.model.Order;
import com.sh.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 把今天最好的表现当作明天最新的起点．．～
 * いま 最高の表現 として 明日最新の始発．．～
 * Today the best performance as tomorrow newest starter!
 * Created by IntelliJ IDEA.
 * <p>
 * author: xiaomo
 * github: https://github.com/syoubaku
 * email: hupengbest@163.com
 * QQ_NO: 83387856
 * Date: 2017/2/28 下午4:33
 * Description:
 * Copyright(©) 2017 by xiaomo.
 **/
@Service
public class OrderServiceImpl implements OrderService {

    private static final String KEY = "abc";


    private final OrderDao dao;


    @Autowired
    public OrderServiceImpl(OrderDao dao) {
        this.dao = dao;
    }


    @Override
    public List<Order> findAll() {
        return dao.findAll();
    }

    @Override
    public int insertOne(String key, String orderStr) {
        if (KEY.equals(key)) {
            Order order = getOrder(orderStr);
            if (order == null){
                return 0;
            }
            Order save = dao.save(order);
            if (save != null) {
                return 1;
            } else {
                return 0;
            }
        }
        return 0;
    }


    @Override
    public int insertMore(String key, String orders) {
        int count = 0;
        if (KEY.equals(key)) {
            String[] rows = orders.split("&");
            for (String rowStr : rows) {
                Order order = getOrder(rowStr);
                if (order == null) {
                    continue;
                }
                Order save = dao.save(order);
                if (save != null) {
                    count++;
                }
            }
        }

        return count;
    }

    @Override
    public String getSchedule(int serverId) {
        List<Order> orders = dao.findOrdersByServeridOrderByTimeAsc(serverId);
        Order order = orders.get(orders.size()-1);
        return order.getOrderid();
    }

    private Order getOrder(String orderStr) {
        String[] row = orderStr.split(",");
        Order order = new Order();
        try {
            String orderId = row[0];
            Long time = Long.valueOf(row[1]);
            String username = row[2];
            float coin = Float.parseFloat(row[3]);
            int roleId = Integer.parseInt(row[4]);
            int uid = Integer.parseInt(row[5]);
            int serverId = Integer.parseInt(row[6]);
            order.setTime(time);
            order.setOrderid(orderId);
            order.setUsername(username);
            order.setCoin(coin);
            order.setRoleid(roleId);
            order.setUid(uid);
            order.setServerid(serverId);
            return order;
        } catch (Exception e) {
            return null;
        }
    }
}
