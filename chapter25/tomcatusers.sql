create database tomcatusers;
use tomcatusers;

create table users(
user_name varchar(15) not null primary key,
user_pass varchar(15) not null
);

create table user_roles(
user_name varchar(15) not null,
role_name varchar(15) not null,
primary key(user_name,role_name)
);

insert into users values("xiaowang","1234");
insert into users values("xiaoming","1234");

insert into user_roles values("xiaowang","friend");
insert into user_roles values("xiaoming","guest");

