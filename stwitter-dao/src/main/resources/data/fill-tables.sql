INSERT INTO HOBBY (HOBBY_ID, DESCRIPTION, TITLE) VALUES (1, 'Playing tennis with friends', 'Tennis');
INSERT INTO HOBBY (HOBBY_ID, DESCRIPTION, TITLE) VALUES (2, 'Reading books at home alone', 'Reading');
INSERT INTO HOBBY (HOBBY_ID, DESCRIPTION, TITLE) VALUES (3, 'Watching tv shows, serials', 'TV');
INSERT INTO HOBBY (HOBBY_ID, DESCRIPTION, TITLE) VALUES (4, 'Fishing with friends', 'Fishing');

INSERT INTO PERSON (PERSON_ID, BIRTHDAY, EMAIL, FIRST_NAME, LAST_NAME, LOGIN, PASSWORD) values (1, '2000-06-06', 'email1@mail.com', 'John', 'Johnson', 'johny', '12345');
INSERT INTO PERSON_HOBBY (Person_PERSON_ID, hobbies_HOBBY_ID) values (1, 1);
INSERT INTO PERSON_HOBBY (Person_PERSON_ID, hobbies_HOBBY_ID) values (1, 2);
INSERT INTO PERSON_HOBBY (Person_PERSON_ID, hobbies_HOBBY_ID) values (1, 4);
INSERT INTO POST (POST_ID, CONTENT, PERSON_ID, PLACE_TIME, TITLE) values (1, 'Наш директор подошёл к банкомату и снял зарплату, теперь банкомат говорит, что у него закончились купюры', 1, '2016-06-06 15:22:14', 'Деньги...');
INSERT INTO POST (POST_ID, CONTENT, PERSON_ID, PLACE_TIME, TITLE) values (2, '— Бэрримор, что это за вой на болотах? — Вы так и не свозили свою бабу на море, сэр.', 1, '2016-08-14 11:10:14', 'Неисотвый вой');
INSERT INTO POST_LIKES (POST_ID, PERSON_ID) values (1, 1);
INSERT INTO POST_LIKES (POST_ID, PERSON_ID) values (1, 2);
INSERT INTO POST_LIKES (POST_ID, PERSON_ID) values (1, 3);
INSERT INTO POST_LIKES (POST_ID, PERSON_ID) values (2, 2);
INSERT INTO POST_LIKES (POST_ID, PERSON_ID) values (2, 3);

INSERT INTO PERSON (PERSON_ID, BIRTHDAY, EMAIL, FIRST_NAME, LAST_NAME, LOGIN, PASSWORD) values (2, '2000-01-01', 'email2@mail.com', 'Sam', 'Smith', 'smithy', '12345');
INSERT INTO PERSON_HOBBY (Person_PERSON_ID, hobbies_HOBBY_ID) values (2, 2);
INSERT INTO PERSON_HOBBY (Person_PERSON_ID, hobbies_HOBBY_ID) values (2, 1);
INSERT INTO POST (POST_ID, CONTENT, PERSON_ID, PLACE_TIME, TITLE) values (3, 'Супруг сегодня говорит: а пойдем на пристань сходим. Я так обрадовалась: море, закат, романтика... А он: МНЕ ТАМ НАДО ВОДНЫХ ПОКЕМОНОВ ПОЛОВИТЬ.', 2, '2016-06-03 09:10:11', 'Супружская жись');
INSERT INTO POST (POST_ID, CONTENT, PERSON_ID, PLACE_TIME, TITLE) values (4, 'Хабр, очередная статья на тему "почему ООП мертв" xxx: Goto живо, а они ООП хоронят :)', 2, '2016-07-06 11:10:14', 'ООП');
INSERT INTO POST_LIKES (POST_ID, PERSON_ID) values (3, 2);
INSERT INTO POST_LIKES (POST_ID, PERSON_ID) values (3, 3);
INSERT INTO POST_LIKES (POST_ID, PERSON_ID) values (4, 1);


INSERT INTO PERSON (PERSON_ID, BIRTHDAY, EMAIL, FIRST_NAME, LAST_NAME, LOGIN, PASSWORD) values (3, '2000-02-02', 'email3@mail.com', 'Jack', 'Jackson', 'jacky', '12345');
INSERT INTO PERSON_HOBBY (Person_PERSON_ID, hobbies_HOBBY_ID) values (3, 3);
INSERT INTO PERSON_HOBBY (Person_PERSON_ID, hobbies_HOBBY_ID) values (3, 1);
INSERT INTO POST (POST_ID, CONTENT, PERSON_ID, PLACE_TIME, TITLE) values (5, 'Неужели я настолько стара? У Убунты уже кончились буковки для названий дистрибутивов!', 3, '2016-06-03 09:10:11', 'Не могу в иностраннй');
INSERT INTO POST (POST_ID, CONTENT, PERSON_ID, PLACE_TIME, TITLE) values (6, 'Я — функциональщик. Прекрасно себя чувствую. Это вы от объектов такой раздражительный.', 3, '2016-01-07 09:27:16', 'Объекты не в радость');
INSERT INTO POST_LIKES (POST_ID, PERSON_ID) values (5, 1);
INSERT INTO POST_LIKES (POST_ID, PERSON_ID) values (5, 2);
INSERT INTO POST_LIKES (POST_ID, PERSON_ID) values (6, 1);
INSERT INTO POST_LIKES (POST_ID, PERSON_ID) values (6, 2);
INSERT INTO POST_LIKES (POST_ID, PERSON_ID) values (6, 3);
INSERT INTO POST_LIKES (POST_ID, PERSON_ID) values (6, 4);

INSERT INTO PERSON (PERSON_ID, BIRTHDAY, EMAIL, FIRST_NAME, LAST_NAME, LOGIN, PASSWORD) values (4, '2000-10-06', 'email4@mail.com', 'Cat', 'Catson', 'cat', '12345');
INSERT INTO PERSON_HOBBY (Person_PERSON_ID, hobbies_HOBBY_ID) values (4, 1);
INSERT INTO PERSON_HOBBY (Person_PERSON_ID, hobbies_HOBBY_ID) values (4, 2);
INSERT INTO PERSON_HOBBY (Person_PERSON_ID, hobbies_HOBBY_ID) values (4, 4);
INSERT INTO POST (POST_ID, CONTENT, PERSON_ID, PLACE_TIME, TITLE) values (7, 'Люблю минимализм, но... у меня трое детей, какой кхерам минимализм здесь! Детиигрушкираскидизм, папаченибутьещекупизм, дорогоймненечегоодетизм но не минимализм!', 4, '2016-08-13 15:22:14', 'Минимализм');
INSERT INTO POST_LIKES (POST_ID, PERSON_ID) values (7, 1);
INSERT INTO POST_LIKES (POST_ID, PERSON_ID) values (7, 2);
commit;
