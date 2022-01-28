# ошибки в расписании (фильмы накладываются друг на друга), отсортированные по возрастанию времени.
# Выводить надо колонки «фильм 1», «время начала», «длительность», «фильм 2», «время начала», «длительность»;
select cinema.movies.title              'Фильм 1',
       cinema.movie_sessions.start_time 'Время начала',
       cinema.movies.duration           'Длительность',
       movie_second.title               'Фильм 1',
       movie_second.start_time          'Время начала',
       movie_second.duration            'Длительность'
from cinema.movie_sessions
         join cinema.movies on cinema.movie_sessions.movie_id = movies.id
         join (select cinema.movies.title,
                      cinema.movie_sessions.movie_id,
                      cinema.movie_sessions.start_time,
                      cinema.movies.duration,
                      cinema.movie_sessions.start_time + INTERVAL cinema.movies.duration MINUTE as end_time
               from cinema.movie_sessions
                        join cinema.movies on cinema.movie_sessions.movie_id = cinema.movies.id) as movie_second
              on (cinema.movie_sessions.start_time + INTERVAL cinema.movies.duration MINUTE >
                  movie_second.start_time)
                  and (movie_sessions.start_time + INTERVAL movies.duration MINUTE < movie_second.end_time)
                  and movie_sessions.movie_id != movie_second.movie_id
order by cinema.movie_sessions.start_time;