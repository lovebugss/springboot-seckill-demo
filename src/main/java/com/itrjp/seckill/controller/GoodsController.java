package com.itrjp.seckill.controller;/**
 * Created by renjp on 2019/1/24.
 */

import com.itrjp.seckill.result.Result;
import com.itrjp.seckill.service.GoodsService;
import com.itrjp.seckill.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author renjp
 * @Date 2019/1/24 11:04
 * @Version 1.0
 */
@RestController
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    ThymeleafViewResolver thymeleafViewResolver;

    @GetMapping(value = "goods",produces = "text/html")
    public String goods(HttpServletRequest request, HttpServletResponse response, Model model) {

        List<GoodsVo> list = goodsService.querySeckillGoodsList();
        model.addAttribute("goodsList",list);

        // 手动渲染
        WebContext ctx = new WebContext(request, response, request.getServletContext(), request.getLocale(), model.asMap());
        String html = thymeleafViewResolver.getTemplateEngine().process("goods_list", ctx);
        return html;
    }
    @GetMapping("query")
    public Result<GoodsVo> query(){
        return Result.success(goodsService.query());
    }
}
