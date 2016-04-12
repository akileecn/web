package cn.aki.hessian.exporter;

import org.springframework.stereotype.Service;

import cn.aki.hessian.HelloHessianService;

@Service("helloHessianService")
public class HelloHessianServiceImpl implements HelloHessianService{

	public String hello() {
		return "hello from hessian";
	}

}
