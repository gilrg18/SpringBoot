insert into user values(10001,sysdate(),'Gil')
insert into user values(10002,sysdate(),'Lau')
insert into user values(10003,sysdate(),'Maik')

insert into post values(hibernate_sequence.nextval, 'My First Post', 10001)
insert into post values(hibernate_sequence.nextval, 'My Second Post', 10001)