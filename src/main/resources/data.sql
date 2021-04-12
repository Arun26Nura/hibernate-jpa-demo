insert into course(id,name) values (10001,'Java')
insert into course(id,name) values (10002,'SQL')
insert into course(id,name) values (10003,'Python')

insert into passport(id,number) values (30001,'E0001')
insert into passport(id,number) values (30002,'E0002')
insert into passport(id,number) values (30003,'E0003')

insert into student(id,name,passport_id) values (20001,'Arun',30001)
insert into student(id,name,passport_id) values (20002,'Babu',30002)
insert into student(id,name,passport_id) values (20003,'Guru',30003)



insert into review (id, rating,description,course_id) values (40001,5,'Good',10001)
insert into review (id, rating,description,course_id) values (40002,3,'Okay',10001)
insert into review (id,rating, description,course_id) values (40003,1,'Bad',10003)

insert into student_course(student_id,course_id) values (20001,10001)
insert into student_course(student_id,course_id) values (20001,10003)
insert into student_course(student_id,course_id) values (20002,10001)
insert into student_course(student_id,course_id) values (20003,10001)
insert into student_course(student_id,course_id) values (20003,10003)