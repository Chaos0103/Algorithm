-- 코드를 입력하세요
SELECT b.title, b.board_id, r.reply_id, r.writer_id, r.contents, date_format(r.created_date, '%Y-%m-%d') as created_date
from used_goods_reply as r
join used_goods_board as b
on r.board_id=b.board_id
where year(b.created_date)=2022
and month(b.created_date)=10
order by r.created_date, b.title

-- DATE_FORMAT(DATE_OF_BIRTH, '%Y-%m-%d') as DATE_OF_BIRTH