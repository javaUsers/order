package com.sh.dao;

import com.sh.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

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
 * Description: 订单数据dao
 * Copyright(©) 2017 by xiaomo.
 **/
@Repository
public interface OrderDao extends JpaRepository<Order, String> {

    List<Order> findOrdersByServeridOrderByTimeAsc(int serverId);
}
