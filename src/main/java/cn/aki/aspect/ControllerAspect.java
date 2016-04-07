package cn.aki.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 控制层异常切面
 * @author aki
 * 2016年4月7日 下午5:11:20
 */
@Component//为了让类被spring自动扫描识别
@Aspect//表示为切面
public class ControllerAspect {

	@Pointcut("execution(* cn.aki.controller.*.*(..))")
	private void inAnyMethod(){
	}
	
	@Around("inAnyMethod()")
	public Object doAspect(ProceedingJoinPoint pjp){
		Object result=null;
		try {
			Logger logger=LoggerFactory.getLogger(pjp.getTarget().getClass());
			logger.info("拦截controller的方法"+pjp.getSignature().getName());
			result=pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return result;
	}
}
