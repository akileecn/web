package cn.aki.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class CommController {
	/**
	 * 跳转至首页
	 * @return
	 */
	@RequestMapping("/home")
	public String home(){
		return "home";
	}
}
