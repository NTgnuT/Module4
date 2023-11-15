create database session2_bt2;
use session2_bt2;

create table customer (
	c_id int primary key auto_increment,
    c_name varchar(50) NOT NULL unique,
    c_age int
);

create table orders (
	o_id int primary key auto_increment,
    c_id int,
    foreign key (c_id) references customer (c_id),
    o_date date default(current_date()),
    o_total_price int
);

create table product (
	p_id int primary key auto_increment,
    p_name varchar(50),
    p_price int
);

create table order_detail (
	o_id int,
    foreign key (o_id) references orders (o_id),
    p_id int,
    foreign key (p_id) references product (p_id),
    order_qty int,
    primary key (o_id, p_id)
);