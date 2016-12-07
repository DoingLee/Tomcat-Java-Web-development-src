drop database BookDB;
create database BookDB;
use BookDB;

create table BOOKS(
ID varchar(8) primary key,
NAME varchar(24),
TITLE varchar(96),
PRICE float,
YR int,
DESCRIPTION varchar(128),
SALE_AMOUNT int);　

insert into BOOKS values('201', '孙卫琴', 
 'Java面向对象编程',
 65, 2006, '让读者由浅入深掌握Java语言', 20000);

insert into BOOKS values('202', '孙卫琴', 
 '精通Struts', 49,
 2004, '真的很棒', 80000);

insert into BOOKS values('203', '孙卫琴', 
 'Tomcat与JavaWeb开发技术详解',
 45, 2004, '关于Tomcat与JavaWeb开发的最畅销的技术书', 40000);

insert into BOOKS values('204', '孙卫琴', 
 'Java网络编程精解',
55, 2007, '很值得一看', 20000);

insert into BOOKS values('205', '孙卫琴', 
 '精通Hibernate',
 59, 2005, '权威的Hibernate技术资料', 50000);

insert into BOOKS values('206', '孙卫琴', 
 'Java2认证考试指南与试题解析',
 88, 2002, '权威的Java技术资料', 8000);
