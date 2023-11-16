create database session3_bt1;
use session3_bt1;

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

drop database session3_bt1;
-- Hiển thị tất cả các sinh viên có tên bắt đầu bảng ký tự ‘h’
select * from student where student_name like 'h%';

-- Hiển thị các thông tin lớp học có thời gian bắt đầu vào tháng 12.
select * from class where month(start_date) = 12;

-- Hiển thị tất cả các thông tin môn học có credit trong khoảng từ 3-5.
select * from subjects where credit between 3 and 5;

-- Thay đổi mã lớp(ClassID) của sinh viên có tên ‘Hung’ là 2.
update student set class_id = 2 where student_name = 'Hung';
select * from student;

-- Hiển thị các thông tin: StudentName, SubName, Mark. Dữ liệu sắp xếp theo điểm thi (mark) giảm dần. nếu trùng sắp theo tên tăng dần.
