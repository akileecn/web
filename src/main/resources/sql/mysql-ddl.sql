/*2016-03-31*/
/**
 * 用户
 */
create table user(
	id int primary key auto_increment
	,username varchar(32) not null unique
	,password varchar(32) not null
);
/**
 * 角色
 */
create table role(
	id int primary key auto_increment
	,name varchar(32) not null unique
	,remark varchar(50)
);
/**
 * 用户角色关系
 */
create table user_role(
	user_id int not null
	,role_id int not null
	,primary key(user_id,role_id)
);
/**
 * 权限
 */
create table permission(
	id int primary key auto_increment
	,name varchar(32) not null unique
	,remark varchar(50)
);
/**
 * 角色权限关系
 */
create table role_permission(
	role_id int not null
	,permission_id int not null
	,primary key(role_id,permission_id)
);