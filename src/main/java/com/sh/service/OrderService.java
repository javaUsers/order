package com.sh.service;

import com.sh.model.Order;

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
 * Date: 2017/2/28 下午4:32
 * Description:
 * Copyright(©) 2017 by xiaomo.
 **/
public interface OrderService{
    List<Order> findAll();

    int insertOne(String key, String order);

    int insertMore(String key, String orders);

    String getSchedule(int serverId);
}
