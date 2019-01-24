package com.itrjp.seckill.vo;

import com.itrjp.seckill.bean.Goods;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * Created by jiangyunxiong on 2018/5/22.
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class GoodsVo extends Goods {
    private Double seckillPrice;
    private Integer stockCount;
    private Date startDate;
    private Date endDate;
    private Integer version;
}

