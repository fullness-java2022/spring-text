drop table if exists account;
drop table if exists account_role;
-- アカウント権限
create table account_role(
	id serial primary key,
	name varchar(100) not null
);
insert into account_role values(nextval('account_role_id_seq'),'admin');
insert into account_role values(nextval('account_role_id_seq'),'user');
insert into account_role values(nextval('account_role_id_seq'),'guest');
-- アカウント
create table account(
	id serial primary key,
	name varchar(100) not null,
	password varchar(100) not null,
	account_role_id integer not null references account_role(id)
);