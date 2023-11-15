create database session2_bt3;
use session2_bt3;

create table category (
	id int auto_increment primary key,
    name varchar(100) unique,
    status tinyint default (1)
);

insert into category (name) value ('Áo');
insert into category (name) value ('Quần');
insert into category (name) value ('Mũ');
insert into category (name) value ('Giày');
insert into category (name) value ('Kính');

create table product (
	id int auto_increment primary key,
    name varchar(200),
    price float check (price > 0),
    sale_price float,
    constraint check (sale_price < price),
    cat_id int,
    foreign key (cat_id) references category (id)
);
insert into product (name, price, sale_price, cat_id) value ('Áo phông', 50000, 45000, 1);
insert into product (name, price, sale_price, cat_id) value ('Quần jean', 450000, 400000, 2);
insert into product (name, price, sale_price, cat_id) value ('Mũ tai bèo', 120000, 100000, 3);
insert into product (name, price, sale_price, cat_id) value ('Giày thể thao', 1500000, 1200000, 4);
insert into product (name, price, sale_price, cat_id) value ('Kính râm', 80000, 50000, 5);


create table customer (
	id int auto_increment primary key,
    name varchar(100),
    email varchar(100),
    birthday date,
    gender tinyint
);

insert into customer (name, email, birthday, gender) value ('Nguyễn A', 'a@gmail.com', '2000-01-20', 1);
insert into customer (name, email, birthday, gender) value ('Nguyễn B', 'b@gmail.com', '2001-07-07', 1);
insert into customer (name, email, birthday, gender) value ('Nguyễn C', 'c@gmail.com', '2003-05-30', 0);
insert into customer (name, email, birthday, gender) value ('Nguyễn D', 'd@gmail.com', '2005-02-18', 1);
insert into customer (name, email, birthday, gender) value ('Nguyễn E', 'e@gmail.com', '2004-11-24', 0);

create table orders (
	id int primary key auto_increment,
    cus_id int,
    foreign key (cus_id) references customer (id),
    created date default (current_date()),
    status tinyint
);

create table order_detail (
	order_id int,
    foreign key (order_id) references orders (id),
    product_id int,
    foreign key (product_id) references product (id),
    primary key (order_id, product_id),
    quantity int,
    price float
);

drop table orders;
alter table orders add column note text;
