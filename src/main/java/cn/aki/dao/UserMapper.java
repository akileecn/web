package cn.aki.dao;

import java.util.List;

import cn.aki.entity.User;

public interface UserMapper {
	List<User> getList(User user);
}
