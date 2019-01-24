package com.itrjp.seckill.mapper;/**
 * Created by renjp on 2019/1/24.
 */

import com.itrjp.seckill.bean.Goods;
import com.itrjp.seckill.util.BaseMapper;
import com.itrjp.seckill.vo.GoodsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author renjp
 * @Date 2019/1/24 14:24
 * @Version 1.0
 */
@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {


    @Select("select g.*, sg.stock_count, sg.start_date, sg.end_date, sg.seckill_price, sg.version from sk_goods_seckill sg left join sk_goods g on sg.goods_id = g.id")
    List<GoodsVo> querySeckillGoodsList();
}
