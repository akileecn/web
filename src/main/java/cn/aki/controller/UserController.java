package cn.aki.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
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
		return "user/list";
	}
	/**
	 * 跳转到登录页面
	 * @return
	 */
	@RequestMapping("/login")
	public String login(){
		return "user/login";
	}
	/**
	 * 登录操作
	 * @return
	 */
	@RequestMapping("/doLogin")
	public String doLogin(@ModelAttribute User user,Model model){
		if(user!=null&&!StringUtils.isEmpty(user.getUsername())){
			UsernamePasswordToken token=new UsernamePasswordToken(user.getUsername(), user.getPassword());
			token.setRememberMe(true);
			Subject subject=SecurityUtils.getSubject();
			try{
				subject.login(token);
				return "redirect:/home.do";
			}catch(IncorrectCredentialsException ex){
				//验证失败
				model.addAttribute("error", "验证失败");
			}catch(UnknownAccountException ex){
				//其他异常
				model.addAttribute("error", "未知异常");
			}
		}
		return "user/login";
	}
	
}
