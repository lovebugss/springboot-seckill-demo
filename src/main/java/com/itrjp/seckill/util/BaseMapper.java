package com.itrjp.seckill.util;/**
 * Created by renjp on 2019/1/24.
 */

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author renjp
 * @Date 2019/1/24 14:20
 * @Version 1.0
 */
public interface BaseMapper<T> extends Mapper<T> ,MySqlMapper<T> {
}
