# число посетителей и кассовые сборы, сгруппированные по времени начала фильма:
# с 9 до 15, с 15 до 18, с 18 до 21, с 21 до 00:00 (сколько посетителей пришло с 9 до 15 часов и т.д.).
select
    case
        when hour(cinema.movie_sessions.start_time) >= 9 and hour(cinema.movie_sessions.start_time) <= 15
            then '9:00 - 15:00'
        when hour(cinema.movie_sessions.start_time) > 15 and hour(cinema.movie_sessions.start_time) <= 18
            then '15:00 - 18:00'
        when hour(cinema.movie_sessions.start_time) > 18 and hour(cinema.movie_sessions.start_time) <= 21
            then '18:00 - 21:00'
        when hour(cinema.movie_sessions.start_time) > 21
            then '21:00 - 00:00'
        end as hour,
    sum(price),
    count(*)
from cinema.movie_sessions
         join cinema.tickets on movie_sessions.id = tickets.movie_session_id
group by hour;