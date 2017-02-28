package com.sh.controller;

import com.sh.model.Order;
import com.sh.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/order")
@RestController
public class OrderController {

    private final OrderService service;

    @Autowired
    public OrderController(OrderService service) {
        this.service = service;
    }

    @RequestMapping("/findAll")
    public List<Order> findAll(){
        return service.findAll();
    }


    @RequestMapping(value = "/insertOne",method = RequestMethod.GET)
    public int insertOne(@RequestParam String key, @RequestParam String order){
        System.out.println(order);
        return service.insertOne(key,order);
    }

    @RequestMapping("/insertMore")
    public int insertMore(@RequestParam String key,@RequestParam String orders){
        return service.insertMore(key,orders);
    }

    @RequestMapping("/getSchedule/{serverId}")
    public String getSchedule(@PathVariable int serverId){
        return service.getSchedule(serverId);
    }


}
