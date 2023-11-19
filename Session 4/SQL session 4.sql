-- Hàm tính toán số học 
select abs(-5);

select round(1.5); -- hàm làm tròn 0.5

select ceil(0.1); -- hàm làm tròn lên

-- hàm GROUP_CONCAT(field SEPARATOR ",")

select date_format(current_date, "%d-%m-%Y");

select id, name, if (status = 1, 'true', 'false' ) as status from category;