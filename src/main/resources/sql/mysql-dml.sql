/*2016-03-31*/
insert into user(username,password)values('aki','123456');
insert into role(name)values('admin');
insert into role(name)values('r2');
insert into user_role(user_id,role_id)values(1,1);
insert into permission(name)values('p1');
insert into permission(name)values('p2');
insert into permission(name)values('p3');
insert into role_permission(role_id,permission_id)values(1,1);
insert into role_permission(role_id,permission_id)values(1,2);