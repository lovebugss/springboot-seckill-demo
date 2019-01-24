package com.itrjp.seckill.aop;/**
 * Created by renjp on 2019/1/24.
 */

import com.itrjp.seckill.exception.GlobalException;
import com.itrjp.seckill.result.CodeMsg;
import com.itrjp.seckill.result.Result;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author renjp
 * @Date 2019/1/24 9:23
 * @Version 1.0
 */
@Component
@Aspect
public class AopControllerHandle {

    //本地异常日志记录对象
    private  static  final Logger logger = (Logger) LoggerFactory.getLogger(AopControllerHandle.class);
    //Controller层切点
    @Pointcut("execution(public com.itrjp.seckill.result.Result *(..))")
    public  void controllerAspect() {
    }
    /**
     * 异常通知 用于拦截记录异常日志
     * @param joinPoint
     */
    @Around(value = "controllerAspect()")
    public  Object doAfterThrowing(ProceedingJoinPoint joinPoint) {
        long startTime = System.currentTimeMillis();
        Object result;
        try {
            result =  joinPoint.proceed();

            // 如果需要打印入参，可以从这里取出打印
            Object[] args = joinPoint.getArgs();

            // 本次操作用时（毫秒）
            long elapsedTime = System.currentTimeMillis() - startTime;
            logger.info("[{}] use time: {} ms >> args:{} >> result:[{}]", joinPoint.getSignature(),elapsedTime,args, result);
        } catch (Throwable e) {
            result = handlerException(joinPoint, e);
        }

        return result;
    }
    private Result<?> handlerException(ProceedingJoinPoint pjp, Throwable e) {
        Result<?> result = null;

        // 已知异常【注意：已知异常不要打印堆栈，否则会干扰日志】
        // 校验出错，参数非法
        if (e instanceof GlobalException || e instanceof IllegalArgumentException) {
            result = Result.error(CodeMsg.SERVER_ERROR);
        }
        else {
            logger.error(pjp.getSignature() + " error ", e);

            // TODO 未知的异常，应该格外注意，可以发送邮件通知等
        }

        return result;
    }
}