create database session3_bt2;
use session3_bt2;

create table customer(
	c_id int auto_increment primary key,
    c_name varchar(25),
    c_age tinyint
);

insert into customer (c_name, c_age) value ('Minh Quan', 10);
insert into customer (c_name, c_age) value ('Ngoc Oanh', 20);
insert into customer (c_name, c_age) value ('Hong Ha', 50);

create table orders (
	o_id int primary key auto_increment,
    c_id int,
    foreign key (c_id) references customer (c_id),
    o_date date default(current_date()),
    o_total_price int
);

insert into orders (c_id) value (1);
insert into orders (c_id) value (2);
insert into orders (c_id) value (1);

create table product (
	p_id int primary key auto_increment,
    p_name varchar(25),
    p_price int
);

insert into product (p_name, p_price) value ('May Giat', 3);
insert into product (p_name, p_price) value ('Tu Lanh', 5);
insert into product (p_name, p_price) value ('Dieu Hoa', 7);
insert into product (p_name, p_price) value ('Quat', 1);
insert into product (p_name, p_price) value ('Bep Dien', 2);

create table order_detail (
	o_id int,
    foreign key (o_id) references orders (o_id),
    p_id int,
    foreign key (p_id) references product (p_id),
    od_qty int
);

insert into order_detail (o_id, p_id, od_qty) value (1, 1, 3);
insert into order_detail (o_id, p_id, od_qty) value (1, 3, 7);
insert into order_detail (o_id, p_id, od_qty) value (1, 4, 2);
insert into order_detail (o_id, p_id, od_qty) value (2, 1, 1);
insert into order_detail (o_id, p_id, od_qty) value (3, 1, 8);
insert into order_detail (o_id, p_id, od_qty) value (2, 5, 4);
insert into order_detail (o_id, p_id, od_qty) value (2, 3, 3);

-- Hiển thị các thông tin gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
select orders.o_id, orders.o_date, orders.o_total_price from orders;

-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
select c.c_name, p.p_name
from customer c
join orders o
on c.c_id = o.c_id
join order_detail od
on o.o_id = od.o_id
join product p
on od.p_id = p.p_id;

-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
select * from customer 
where c_id NOT IN (select c_id from orders);

-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn 
-- (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn. Giá bán của từng loại được tính = odQTY*pPrice)
select o.o_id, o.o_date, sum(p.p_price * od.od_qty) as o_total_price 
from orders o
join order_detail od 
on o.o_id = od.o_id
join product p 
on od.p_id = p.p_id
group by o.o_id, o.o_date





