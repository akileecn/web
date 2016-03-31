package cn.aki.entity;

import java.io.Serializable;
import java.util.Set;

import javax.management.relation.Role;

public class User implements Serializable{
	private static final long serialVersionUID = 4316328239249215538L;
	private Integer id;
	private String username;
	private String password;
	private Set<Role> roleSet;
	
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
	public Set<Role> getRoleSet() {
		return roleSet;
	}
	public void setRoleSet(Set<Role> roleSet) {
		this.roleSet = roleSet;
	}
	
}
