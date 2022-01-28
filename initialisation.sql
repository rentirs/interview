drop schema if exists cinema;
create schema cinema;
use cinema;
drop table if exists movies;
drop table if exists movie_sessions;
drop table if exists tickets;
create table movies
(
    id       int          not null primary key auto_increment,
    title    varchar(255) not null unique,
    duration int          not null
);
create table movie_sessions
(
    id         int    not null primary key auto_increment,
    movie_id   int    not null,
    start_time time   not null,
    price      double not null,
    constraint movie_id foreign key (movie_id) references movies (id) on delete no action on update no action
);
create table tickets
(
    id               int not null primary key auto_increment,
    movie_session_id int not null,
    constraint movie_session_id foreign key (movie_session_id) references movie_sessions (id) on delete no action on update no action
);
insert into cinema.movies (title, duration)
values ('фильм 1', 60);
insert into cinema.movies (title, duration)
values ('фильм 2', 90);
insert into cinema.movies (title, duration)
values ('фильм 3', 120);
insert into cinema.movies (title, duration)
values ('фильм 4', 60);
insert into cinema.movies (title, duration)
values ('фильм 5', 90);
insert into cinema.movie_sessions (movie_id, start_time, price)
values (1, '10:10:00', 150);
insert into cinema.movie_sessions (movie_id, start_time, price)
values (2, '11:00:00', 200);
insert into cinema.movie_sessions (movie_id, start_time, price)
values (3, '13:00:00', 300);
insert into cinema.movie_sessions (movie_id, start_time, price)
values (4, '14:30:00', 400);
insert into cinema.movie_sessions (movie_id, start_time, price)
values (5, '16:10:00', 500);
insert into cinema.tickets (movie_session_id)
values (3);
insert into cinema.tickets (movie_session_id)
values (5);
insert into cinema.tickets (movie_session_id)
values (2);
insert into cinema.tickets (movie_session_id)
values (1);
insert into cinema.tickets (movie_session_id)
values (5);
insert into cinema.tickets (movie_session_id)
values (5);
insert into cinema.tickets (movie_session_id)
values (5);