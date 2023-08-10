INSERT INTO article(title, content) VALUES('aaaa', '1111');
INSERT INTO article(title, content) VALUES('bbbb', '2222');
INSERT INTO article(title, content) VALUES('cccc', '3333');

INSERT INTO member(id, email, password, name, age) VALUES(1, 'qwe1313@gmail.com', '1111', '여늘', 24);
INSERT INTO member(id, email, password, name, age) VALUES(2, 'qwe1212@gmail.com', '2222', '연서', 26);
INSERT INTO member(id, email, password, name, age) VALUES(3, 'qwe1414@gmail.com', '3333', '여하', 28);

INSERT INTO coffee(name, price) VALUES('아메리카노', '4500');
INSERT INTO coffee(name, price) VALUES('라떼', '5000');
INSERT INTO coffee(name, price) VALUES('카페 모카', '5500');

INSERT INTO bread(name, price) VALUES('크로와상', '3200');
INSERT INTO bread(name, price) VALUES('소보루', '2800');
INSERT INTO bread(name, price) VALUES('모카빵', '3100');


INSERT INTO article(title, content) VALUES('당신의 인생 영화는?', '댓글 ㄱ');
INSERT INTO article(title, content) VALUES('당신의 드림카는?', '댓글 ㄲ');
INSERT INTO article(title, content) VALUES('당신의 특기는?', '댓글 ㄱㄱㄱ');


INSERT INTO comment(article_id, nickname, body) VALUES(4, 'lee', '헝거게임');
INSERT INTO comment(article_id, nickname, body) VALUES(4, 'jay', '굿 윌 헌팅');
INSERT INTO comment(article_id, nickname, body) VALUES(4, 'park', '메이즈러너');

INSERT INTO comment(article_id, nickname, body) VALUES(5, 'lee', '맥라렌');
INSERT INTO comment(article_id, nickname, body) VALUES(5, 'jay', '벤츠');
INSERT INTO comment(article_id, nickname, body) VALUES(5, 'park', '아우디');

INSERT INTO comment(article_id, nickname, body) VALUES(6, 'lee', '알고리즘 문제 풀이');
INSERT INTO comment(article_id, nickname, body) VALUES(6, 'jay', '헬스');
INSERT INTO comment(article_id, nickname, body) VALUES(6, 'park', '미술');

INSERT INTO pizza(name, price) VALUES('페페로니 피자', 25900);
INSERT INTO pizza(name, price) VALUES('불고기 피자', 30000);
INSERT INTO pizza(name, price) VALUES('포테이토 피자', 26000);