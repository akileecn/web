package cn.aki.entity;

import java.io.Serializable;
import java.util.List;
/**
 * 用户
 * @author aki
 * 2016年4月1日 上午9:25:56
 */
public class User implements Serializable{
	private static final long serialVersionUID = 4316328239249215538L;
	private Integer id;
	private String username;
	private String password;
	private List<Role> roles;//角色集合
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
}
