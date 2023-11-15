create database session2;
use session2;

create table category (
	id int,
    name varchar(50),
    status bit(1)
);

insert into category (id, name, status) values (1, 'Áo', 1);
insert into category (id, name, status) values (1, 1);

drop table category;

create table category (
	id int primary key auto_increment,
    name varchar(50) not null unique,
    status bit(1) default (1) 
);
-- RÀNG BUỘC 
-- not null: trường dữ liệu không được trống
-- default: không nhập thông tin vào trường thì nó sẽ mang giá trị default được gán từ đầuninstall
-- unique: đảm bảo dữ liệu của cột là duy nhất
-- auto_increment: set auto cho id, bắt đầu từ 1 và bước nhảy là 1
-- primary key: khóa chính xác định giá trị trên tập các cột làm khóa chính phải là duy nhất, không được trùng lặp. Khóa chính yêu cầu các cột phải NOT NULL.
-- FOREIGN KEY: khóa ngoại, tham chiếu đến bảng khác thông qua giá trị của cột được liên kết. Giá trị của cột được liên kết phải là duy nhất trong bảng kia. 
-- check: Bảo đảm tất cả giá trị trong cột thỏa mãn điều kiện nào đó.

-- THAO TÁC TRÊN BẢNG 
-- Tạo bảng
-- Xóa bảng
-- Chỉnh sửa bảng:
alter table category add column desscription varchar(255);
  









