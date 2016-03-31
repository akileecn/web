package cn.aki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.Page;

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
	@Autowired
	private UserService userService;
	/**
	 * 用户列表
	 * @return
	 */
	@RequestMapping("/list")
	public String list(Model model){
		Page<User> page=userService.getPage(1, 4, null);
		model.addAttribute("page", page);
		model.addAttribute("total",page.getTotal());
		return "userList";
	}
}
