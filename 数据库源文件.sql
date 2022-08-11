drop database  if exists prodb;
create database prodb;
use prodb;
drop table if exists pro;
create table pro(
	id int auto_increment primary key,
    url varchar(20) not null,
    price decimal(8,2) check (price>0),
    getrecommendtext varchar(1000)
);
insert into pro values(1,'1.jpg',1399,'口水猪肝');
insert into pro values(2,'2.jpg',2399,'家常干锅排骨');
insert into pro values(3,'3.jpg',3399,'铁板豆腐');
insert into pro values(4,'4.jpg',4399,'红油肘泥蒜花');
insert into pro values(5,'5.jpg',5399,'藤椒鸡');
insert into pro values(6,'6.jpg',6399,'口水鸡');
insert into pro values(7,'7.jpg',7399,'辣炒花椰菜');
insert into pro values(8,'8.jpg',8399,'麻辣水煮鱼');
insert into pro values(9,'9.jpg',9399,'南瓜糯米羹');
insert into pro values(10,'10.jpg',10399,'香辣花蟹');
select * from pro;

drop table if exists users;
create table users(
	userid char(5),
    password varchar(1000)
);
insert into users values('1','12345');
select * from users;

drop table if exists orders;
create table orders(
	orderid char(5),
    orderdate char(20)
);
insert into orders values('1','');
select * from orders