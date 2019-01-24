package com.itrjp.seckill.bean;/**
 * Created by renjp on 2019/1/24.
 */

import lombok.Data;

import javax.persistence.Table;

/**
 * @author renjp
 * @Date 2019/1/24 14:12
 * @Version 1.0
 */
@Data
@Table(name = "sk_goods")
public class Goods {
    protected Long id;
    protected String goodsName;
    protected String goodsTitle;
    protected String goodsImg;
    protected String goodsDetail;
    protected Double goodsPrice;
    protected Integer goodsStock;
}
