create database session5_bt3;
use session5_bt3;

create table classes (
	class_id int auto_increment primary key,
	class_name varchar(50)
);

create table students (
	student_id int auto_increment primary key,
    student_name varchar(50),
    age int,
    email varchar(100)
);

insert into students (student_name, age, email) value ('Nguyen Quang An', 18, 'an@yahoo.com'),
('Nguyen Quang An', 18, 'an@yahoo.com'),
('Nguyen Quang An', 18, 'an@yahoo.com'),
('Nguyen Quang An', 18, 'an@yahoo.com'),
('Nguyen Quang An', 18, 'an@yahoo.com');

create table class_student (
	student_id int,
    foreign key (student_id) references students (student_id),
    class_id int,
    foreign key (class_id) references classes (class_id)
);

insert into class_student (student_id, class_id) value (1,1),
(2,1),
(3,2),
(4,2),
(5,2);

create table subjects (
	subject_id int auto_increment primary key,
	subject_name varchar(50)
);

create table marks (
	mark int,
    subject_id int,
    foreign key (subject_id) references subjects (subject_id),
    student_id int,
    foreign key (student_id) references students (student_id)
);

insert into marks (mark, subject_id, student_id) value (8,1,1),
(4,2,1),
(9,1,1),
(7,1,3),
(3,1,4),
(5,2,5),
(8,3,3),
(1,3,5),
(3,2,4);

-- Hien thi danh sach tat ca cac hoc vien
select * from students;

-- Hien thi danh sach tat ca cac mon hoc
select * from subjects;

-- Tinh diem trung binh
select sub.subject_name, stu.student_name, avg(mark) as dtb
from marks m
join subjects sub
on m.subject_id = sub.subject_id
join students stu
on m.student_id = stu.student_id
group by sub.subject_name, stu.student_name;


-- Hien thi mon hoc nao co hoc sinh thi duoc diem cao nhat
select sub.subject_name, stu.student_name, avg(mark) as dtb
from marks m
join subjects sub
on m.subject_id = sub.subject_id
join students stu
on m.student_id = stu.student_id
group by sub.subject_name, stu.student_name
having avg(mark) >= all(select avg(mark) from marks group by marks.student_id);

-- Danh so thu tu cua diem theo chieu giam
select * from marks order by mark desc;

-- Thay doi kieu du lieu cua cot SubjectName trong bang Subjects thanh nvarchar(max)
alter table subjects modify subject_name varchar(255);

-- Cap nhat them dong chu « Day la mon hoc « vao truoc cac ban ghi tren cot SubjectName trong bang Subjects
update subjects set subject_name = concat('Day la mon hoc: ', subject_name);
select * from subjects;

-- Viet Check Constraint de kiem tra do tuoi nhap vao trong bang Student yeu cau Age >15 va Age < 50
alter table students add constraint check( age > 15 and age < 50);

-- Loai bo tat ca quan he giua cac bang
alter table class_student drop foreign key class_student_ibfk_1;
alter table class_student drop foreign key class_student_ibfk_2;

alter table marks drop foreign key marks_ibfk_1;
alter table marks drop foreign key marks_ibfk_2;

-- Xoa hoc vien co StudentID la 1
delete from students where student_id = 1;

-- Trong bang Student them mot column Status co kieu du lieu la Bit va co gia tri Default la 1
alter table students add status bit(1) default(1);

-- Cap nhap gia tri Status trong bang Student thanh 0
update students set status = 0;