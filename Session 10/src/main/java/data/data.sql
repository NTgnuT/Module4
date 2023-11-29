create database session10;
use session10;

create table category
(
    id     int auto_increment primary key,
    name   varchar(50),
    status bit(1)
);

create table product
(
    id          int auto_increment primary key ,
    name        varchar(50),
    price       int,
    category_id int not null,
    foreign key (category_id) references category (id)
);

DELIMITER //
CREATE PROCEDURE CREATE_CATEGORY(IN name_in varchar(50), status_in bit(1))
BEGIN
    INSERT INTO category(name, status) VALUES (name_in, status_in);
end //

DELIMITER //
CREATE PROCEDURE UPDATE_CATEGORY(IN id_in int, name_in varchar(50), status_in bit(1))
BEGIN
    UPDATE category
    SET name   = name_in,
        status = status_in
    WHERE id = id_in;
end //

DELIMITER //
CREATE PROCEDURE DELETE_CATEGORY(IN id_in int)
BEGIN
    DELETE FROM category WHERE id = id_in;
end //

DELIMITER //
CREATE PROCEDURE FIND_CATEGORY(IN id_in int)
BEGIN
    SELECT * FROM category WHERE id = id_in;
end //


DELIMITER //
CREATE PROCEDURE CREATE_PRODUCT(IN name_in varchar(50), price_in int, category_id_in int)
BEGIN
    INSERT INTO product(name, price, category_id) VALUES (name_in, price_in, category_id_in);
end //

DELIMITER //
CREATE PROCEDURE UPDATE_PRODUCT(IN id_in int, name_in varchar(50), price_in int, category_id_in int)
BEGIN
    UPDATE product
    SET name   = name_in,
        price = price_in,
        category_id = category_id_in
    WHERE id = id_in;
end //

DELIMITER //
CREATE PROCEDURE DELETE_PRODUCT(IN id_in int)
BEGIN
    DELETE FROM product WHERE id = id_in;
end //

DELIMITER //
CREATE PROCEDURE FIND_PRODUCT(IN id_in int)
BEGIN
    SELECT * FROM product WHERE id = id_in;
end //

DELIMITER //
CREATE PROCEDURE SHOW_CATEGORY()
BEGIN
    SELECT * FROM category;
end //

DELIMITER //
CREATE PROCEDURE SHOW_PRODUCT()
BEGIN
    SELECT * FROM product;
end //

