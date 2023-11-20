create database session5_bt2;
use session5_bt2;

create table customer(
	c_id int primary key auto_increment,
    c_name varchar(50),
    c_age int
);

insert into customer (c_name, c_age) value ('Minh Quan', 10);
insert into customer (c_name, c_age) value ('Ngoc Oanh', 20);
insert into customer (c_name, c_age) value ('Hong Ha', 50);

create table orders(
	o_id int primary key auto_increment,
    c_id int,
    foreign key (c_id) references customer (c_id),
    o_date date,
    o_total_price int
);

insert into orders (c_id, o_date) value (1, '2023-06-23');
insert into orders (c_id, o_date) value (2, '2023-08-10');
insert into orders (c_id, o_date) value (1, '2023-05-29');

create table product(
	p_id int primary key auto_increment,
    p_name varchar(50),
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

-- Hiển thị các thông tin trong bảng Order, danh sách phải sắp xếp theo thứ tự ngày tháng, hóa đơn mới hơn nằm trên
select * from orders 
order by o_date desc;

-- Hiển thị tên và giá của các sản phẩm có giá cao nhất 
select p.p_name, p.p_price 
from product p
having p_price >= all(select p_price from product group by product.p_id); 

-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách đó 
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

-- Hiển thị chi tiết của từng hóa đơn 
select od.*, p.p_name, p.p_price 
from order_detail od
join product p
on p.p_id = od.p_id;

-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn 
-- (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn. Giá bán của từng loại được tính = odQTY*pPrice)
select o.o_id, o.o_date, sum(p.p_price * od.od_qty) as o_total_price 
from orders o
join order_detail od 
on o.o_id = od.o_id
join product p 
on od.p_id = p.p_id
group by o.o_id, o.o_date