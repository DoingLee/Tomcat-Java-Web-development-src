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
SALE_AMOUNT int);��

insert into BOOKS values('201', '������', 
 'Java���������',
 65, 2006, '�ö�����ǳ��������Java����', 20000);

insert into BOOKS values('202', '������', 
 '��ͨStruts', 49,
 2004, '��ĺܰ�', 80000);

insert into BOOKS values('203', '������', 
 'Tomcat��JavaWeb�����������',
 45, 2004, '����Tomcat��JavaWeb����������ļ�����', 40000);

insert into BOOKS values('204', '������', 
 'Java�����̾���',
55, 2007, '��ֵ��һ��', 20000);

insert into BOOKS values('205', '������', 
 '��ͨHibernate',
 59, 2005, 'Ȩ����Hibernate��������', 50000);

insert into BOOKS values('206', '������', 
 'Java2��֤����ָ�����������',
 88, 2002, 'Ȩ����Java��������', 8000);
