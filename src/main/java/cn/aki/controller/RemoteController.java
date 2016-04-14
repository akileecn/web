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

import cn.aki.cxf.HelloCxfServcie;
import cn.aki.hessian.HelloHessianService;
@Controller
@RequestMapping("/remote")
public class RemoteController {
	//代理类,由于服务端和客户端在一个应用内,为了区分来源采用按 name注入
	@Resource(name="helloHessianServiceProxy")
	private HelloHessianService helloHessianService;
	@Resource(name="helloCxfServiceProxy")
	private HelloCxfServcie helloCxfServcie;
	
	@ResponseBody
	@RequestMapping(path="/hessian",method=RequestMethod.GET)
	private String fromHessian(){
		return helloHessianService.hello();
	}
	
	@ResponseBody
	@RequestMapping(path="/cxf",method=RequestMethod.GET)
	private String fromCxf(String name){
		return helloCxfServcie.hello(name);
	}
}
