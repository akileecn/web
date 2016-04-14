package cn.aki.cxf;

import javax.jws.WebService;

@WebService
public interface HelloCxfServcie {
	String hello(String name);
}
