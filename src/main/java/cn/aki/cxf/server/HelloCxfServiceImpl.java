package cn.aki.cxf.server;

import javax.jws.WebService;

import org.springframework.stereotype.Service;

import cn.aki.cxf.HelloCxfServcie;

@Service("helloCxfService")
@WebService(endpointInterface="cn.aki.cxf.HelloCxfServcie")
public class HelloCxfServiceImpl implements HelloCxfServcie{

	public String hello(String name) {
		return "hello "+name;
	}

}
