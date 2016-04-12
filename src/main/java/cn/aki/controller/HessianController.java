package cn.aki.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * hessian测试controller
 * @author aki
 * 2016年4月12日 上午11:47:08
 */
import org.springframework.web.bind.annotation.ResponseBody;

import cn.aki.hessian.HelloHessianService;
@Controller
@RequestMapping("/hessian")
public class HessianController {
	//代理类
	@Resource(name="helloHessianServiceProxy")
	private HelloHessianService helloHessianService;
	
	@ResponseBody
	@RequestMapping(path="/test",method=RequestMethod.GET)
	private String test(){
		return helloHessianService.hello();
	}
}
