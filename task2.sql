# перерывы 30 минут и более между фильмами — выводить по уменьшению длительности перерыва.
# Колонки «фильм 1», «время начала», «длительность», «время начала второго фильма», «длительность перерыва»;
select movies_1.title              'фильм 1',
       movie_sessions_1.start_time 'время начала',
       movies_1.duration           'длительность',
       movie_sessions.start_time   'время начала второго фильма',
       timestampdiff(minute, movie_sessions_1.start_time, movie_sessions.start_time) -
       movies_1.duration as        'длительность перерыва'
from movie_sessions
         join movies on movie_sessions.movie_id = movies.id
         left join movie_sessions movie_sessions_1 on movie_sessions_1.id = movie_sessions.id - 1
         left join movies movies_1 on movies_1.id = movie_sessions_1.movie_id
where timestampdiff(minute, movie_sessions_1.start_time, movie_sessions.start_time) - movies_1.duration >= 30
order by movie_sessions.start_time desc
;