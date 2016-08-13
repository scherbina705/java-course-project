INSERT INTO HOBBY (HOBBY_ID, DESCRIPTION, TITLE) VALUES (1, 'Playing tennis with friends', 'Tennis');
INSERT INTO HOBBY (HOBBY_ID, DESCRIPTION, TITLE) VALUES (2, 'Reading books at home alone', 'Reading');
INSERT INTO HOBBY (HOBBY_ID, DESCRIPTION, TITLE) VALUES (3, 'Watching tv shows, serials', 'TV');
INSERT INTO HOBBY (HOBBY_ID, DESCRIPTION, TITLE) VALUES (4, 'Fishing with friends', 'Fishing');

INSERT INTO PERSON (PERSON_ID, BIRTHDAY, EMAIL, FIRST_NAME, LAST_NAME, LOGIN, PASSWORD) values (1, '2000-06-06', 'email1@mail.com', 'John', 'Johnson', 'johny', '12345');
INSERT INTO PERSON_HOBBY (Person_PERSON_ID, hobbies_HOBBY_ID) values (1, 1);
INSERT INTO PERSON_HOBBY (Person_PERSON_ID, hobbies_HOBBY_ID) values (1, 2);
INSERT INTO PERSON_HOBBY (Person_PERSON_ID, hobbies_HOBBY_ID) values (1, 4);
INSERT INTO POST (POST_ID, CONTENT, PERSON_ID, PLACE_TIME, TITLE) values (1, 'Наш директор подошёл к банкомату и снял зарплату, теперь банкомат говорит, что у него закончились купюры', 1, '2016-06-06 15:22:14', 'Деньги...');
INSERT INTO POST (POST_ID, CONTENT, PERSON_ID, PLACE_TIME, TITLE) values (2, '— Бэрримор, что это за вой на болотах? — Вы так и не свозили свою бабу на море, сэр.', 1, '2016-05-06 11:10:14', 'Неисотвый вой');

INSERT INTO PERSON (PERSON_ID, BIRTHDAY, EMAIL, FIRST_NAME, LAST_NAME, LOGIN, PASSWORD) values (2, '2000-01-01', 'email2@mail.com', 'Sam', 'Smith', 'smithy', '12345');
INSERT INTO PERSON_HOBBY (Person_PERSON_ID, hobbies_HOBBY_ID) values (2, 2);
INSERT INTO PERSON_HOBBY (Person_PERSON_ID, hobbies_HOBBY_ID) values (2, 1);
INSERT INTO POST (POST_ID, CONTENT, PERSON_ID, PLACE_TIME, TITLE) values (3, 'Супруг сегодня говорит: а пойдем на пристань сходим. Я так обрадовалась: море, закат, романтика... А он: МНЕ ТАМ НАДО ВОДНЫХ ПОКЕМОНОВ ПОЛОВИТЬ.', 2, '2016-06-03 09:10:11', 'Супружская жись');
INSERT INTO POST (POST_ID, CONTENT, PERSON_ID, PLACE_TIME, TITLE) values (4, 'Хабр, очередная статья на тему "почему ООП мертв"

xxx: Goto живо, а они ООП хоронят :)', 2, '2016-07-06 11:10:14', 'ООП');

INSERT INTO PERSON (PERSON_ID, BIRTHDAY, EMAIL, FIRST_NAME, LAST_NAME, LOGIN, PASSWORD) values (3, '2000-02-02', 'email3@mail.com', 'Jack', 'Jackson', 'jacky', '12345');
INSERT INTO PERSON_HOBBY (Person_PERSON_ID, hobbies_HOBBY_ID) values (3, 3);
INSERT INTO PERSON_HOBBY (Person_PERSON_ID, hobbies_HOBBY_ID) values (3, 1);
INSERT INTO POST (POST_ID, CONTENT, PERSON_ID, PLACE_TIME, TITLE) values (5, 'xxx: как успехи с переходом на инглиш?
yyy: yt jxtym).', 3, '2016-06-03 09:10:11', 'Не могу в иностраннй');
