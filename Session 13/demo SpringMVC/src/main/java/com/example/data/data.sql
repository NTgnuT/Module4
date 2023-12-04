create database demo_spring_s13;
use demo_spring_s13;

create TABLE customer (
id int primary key auto_increment,
name varchar(50) NOT NULL ,
email varchar(50) NOT NULL ,
address varchar(255) NOT NULL
);

DELIMITER //
create procedure SHOW_CUS ()
BEGIN
SELECT * from customer;
end //
;

DELIMITER //
create procedure CREATE_CUS (IN name_in varchar(50), email_in varchar(50), address_in varchar(255))
BEGIN
INSERT INTO customer(name, email, address) values (name_in, email_in, address_in);
end //

DELIMITER //
create procedure EDIT_CUS (IN name_in varchar(50), email_in varchar(50), address_in varchar(255), id_in int)
BEGIN
UPDATE customer SET name = name_in, email = email_in, address = address_in WHERE id = id_in;
end //

DELIMITER //
create procedure DELETE_CUS (id_in int)
BEGIN
DELETE FROM customer where id = id_in;
end //

DELIMITER //
create procedure FIND_BY_ID_CUS (id_in int)
BEGIN
SELECT * from customer WHERE id=id_in;
end //

DELIMITER //
create procedure FIND_BY_NAME_CUS (name_in varchar(50))
BEGIN
SELECT * from customer WHERE name LIKE concat('%', name_in, '%');
end //
