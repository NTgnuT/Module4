create database session3_th2;
use session3_th2;

create table class(
class_id int primary key auto_increment,
class_name varchar(10),
start_date date default(current_date()),
status bit (1)
);

insert into class (class_name, status) value ('A1', 1);
insert into class (class_name, status) value ('A2', 1);
insert into class (class_name, status) value ('B3', 0);

create table student(
student_id int primary key auto_increment,
student_name varchar(50),
address varchar (255),
phone varchar (15),
status bit (1),
class_id int,
foreign key (class_id) references class (class_id)
);

insert into student (student_name, address, phone, status, class_id) value ('Hung', 'Ha Noi', '0912113113', 1, 1),
('Hoa', 'Hai Phong', ' ', 1, 1),
('Manh', 'HCM', '0912113123', 0, 2);

create table subjects(
sub_id int primary key auto_increment,
sub_name varchar(50),
credit int,
status bit (1)
);

insert into subjects (sub_name, credit, status) value ('CF', 5, 1 ),
('C', 6, 1 ),
('HDJ', 5, 1 ),
('RDBMS', 10, 1 );

create table mark(
mark_id int primary key auto_increment,
sub_id int,
foreign key (sub_id) references subjects (sub_id),
student_id int,
foreign key (student_id) references student (student_id),
mark int,
exam_times int
);

insert into mark (sub_id, student_id, mark, exam_times) value (1, 1, 8, 1),
(1, 2, 10, 2),
(2, 1, 12, 1);

drop database session3_th2;
-- Hiển thị danh sách tất cả các học viên
select * from student;

-- Hiển thị danh sách các học viên đang theo học.
select * from student 
where status = 1;

-- Hiển thị danh sách các môn học có thời gian học nhỏ hơn 10 giờ.
select * from subjects 
where credit < 10;

-- Hiển thị danh sách học viên lớp A1
select s.student_id, s.student_name, c.class_name 
from student s
join class c
on s.class_id = c.class_id
where s.class_id = 1;

-- Hiển thị điểm môn CF của các học viên.
select s.student_id, s.student_name, sub.sub_name, m.mark
from student s 
join mark m
on s.student_id = m.student_id 
join subjects sub 
on m.sub_id = sub.sub_id
where sub.sub_name = 'CF';