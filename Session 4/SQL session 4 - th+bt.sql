create database session4_th1;
use session4_th1;

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

create table Mark(
mark_id int primary key auto_increment,
sub_id int,
foreign key (sub_id) references subjects (sub_id),
student_id int,
foreign key (student_id) references student (student_id),
mark int,
exam_times int
);

insert into Mark (sub_id, student_id, mark, exam_times) value (1, 1, 8, 1),
(1, 2, 10, 2),
(2, 1, 12, 1);

-- Hiển thị số lượng sinh viên ở từng nơi
	select address, count(student_id) as 'Số lương học viên'
    from student
    group by address;
    
-- Tính điểm trung bình các môn học của mỗi học viên
	select s.student_id, s.student_name, avg(Mark)
    from student s
    join Mark m 
    on s.student_id = m.student_id
    group by s.student_id, s.student_name;
    
-- Hiển thị những bạn học viên co điểm trung bình các môn học lớn hơn 15
	select s.student_id, s.student_name, avg(Mark)
    from student s
    join Mark m 
    on s.student_id = m.student_id
    group by s.student_id, s.student_name
    having avg(Mark) > 15;
    
-- Hiển thị thông tin các học viên có điểm trung bình lớn nhất.
	select s.student_id, s.student_name, avg(Mark)
    from student s
    join Mark m 
    on s.student_id = m.student_id
    group by s.student_id, s.student_name
    having avg(Mark) >= all (select avg(Mark) from Mark group by Mark.student_id);
    
-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
	select sub_id, sub_name, credit from subjects where credit =(select max(credit) from subjects);

-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
	select sub.sub_name, m.mark 
    from Mark m
    join subjects sub
    on sub.sub_id = m.sub_id
    where mark = (select max(mark) from Mark);

-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
	select s.student_id, s.student_name, avg(Mark) as 'điểm trung bình'
    from student s
    join Mark m on m.student_id = s.student_id
    join subjects sub on sub.sub_id = m.sub_id
    group by s.student_id, s.student_name
    order by 'điểm trung bình' desc;
    