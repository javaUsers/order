package com.sh.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

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
 * Date: 2017/2/28 下午4:37
 * Description:
 * Copyright(©) 2017 by xiaomo.
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_order")
@Entity
public class Order implements Serializable{

    @Id
    private String orderid;

    private long time;

    private String username;

    private int money;

    private float coin;

    private int roleid;

    private int uid;

    private int serverid;


}
