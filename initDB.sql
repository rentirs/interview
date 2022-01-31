drop schema if exists geekbrains;
create schema geekbrains;
use geekbrains;
drop table if exists students;
create table students (
    'id' int not null auto_increment primary key,
    'name' varchar(255) not null,
    'mark' int not null
)
