# список фильмов, для каждого — с указанием общего числа посетителей за все время,
# среднего числа зрителей за сеанс и общей суммы сборов по каждому фильму
# (отсортировать по убыванию прибыли).
# Внизу таблицы должна быть строчка «итого», содержащая данные по всем фильмам сразу;
(select cinema.movies.title as 'фильм',
        count(distinct cinema.tickets.id)                                                   as 'зрители',
        sum(cinema.movie_sessions.price)                                                    as 'сборы',
        count(distinct cinema.tickets.id) / count(distinct cinema.tickets.movie_session_id) as 'среднее число зрителей'
 from cinema.tickets
          join cinema.movie_sessions on tickets.movie_session_id = movie_sessions.id
          join cinema.movies on movie_sessions.movie_id = movies.id
 group by movies.title
 order by 'сборы' desc
)
union
select 'Итого:',
       count(*),
       sum(cinema.movie_sessions.price),
       count(*) / count(distinct cinema.tickets.movie_session_id)
from cinema.tickets
         join cinema.movie_sessions on tickets.movie_session_id = movie_sessions.id;