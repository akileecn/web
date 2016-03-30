package cn.aki.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.aki.entity.User;
import cn.aki.service.UserService;

/**
 * 用户控制层
 * @author Aki
 * 2016年3月29日 上午12:24:54
 */
@Controller
@RequestMapping("/user")
public class UserController {
	private static Logger logger=Logger.getLogger(UserController.class);
	@Autowired
	private UserService userService;
	/**
	 * 用户列表
	 * @return
	 */
	@RequestMapping("/list")
	public String list(Model model){
		logger.info("list");
		model.addAttribute("user", "aki");
		List<User> list=userService.getList(null);
		System.err.println(list.size());
		return "userList";
	}
}
