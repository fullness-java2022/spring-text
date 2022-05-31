drop table if exists item;
drop table if exists item_category;

create table item_category(
  id serial primary key,
  name character varying(20)
);

create table item(
  id serial primary key,
  name character varying(30),
  price integer,
  category_id integer references item_category(id)
);

/* 商品カテゴリ */
insert into item_category values(nextval('item_category_id_seq'),'文房具');
insert into item_category values(nextval('item_category_id_seq'),'雑貨');
insert into item_category values(nextval('item_category_id_seq'),'パソコン周辺機器');

/* 商品 */
insert into item values(nextval('item_id_seq'),'水性ボールペン(黒)',120,1);
insert into item values(nextval('item_id_seq'),'水性ボールペン(赤)',120,1);
insert into item values(nextval('item_id_seq'),'水性ボールペン(青)',120,1);
insert into item values(nextval('item_id_seq'),'油性ボールペン(黒)',100,1);
insert into item values(nextval('item_id_seq'),'油性ボールペン(赤)',100,1);
insert into item values(nextval('item_id_seq'),'油性ボールペン(青)',100,1);
insert into item values(nextval('item_id_seq'),'蛍光ペン(黄)',130,1);
insert into item values(nextval('item_id_seq'),'蛍光ペン(赤)',130,1);
insert into item values(nextval('item_id_seq'),'蛍光ペン(青)',130,1);
insert into item values(nextval('item_id_seq'),'蛍光ペン(緑)',130,1);
insert into item values(nextval('item_id_seq'),'鉛筆(黒)',100,1);
insert into item values(nextval('item_id_seq'),'鉛筆(赤)',100,1);
insert into item values(nextval('item_id_seq'),'色鉛筆(12色)',400,1);
insert into item values(nextval('item_id_seq'),'色鉛筆(48色)',1300,1);
insert into item values(nextval('item_id_seq'),'レザーネックレス',300,2);
insert into item values(nextval('item_id_seq'),'ワンタッチ開閉傘',3000,2);
insert into item values(nextval('item_id_seq'),'金魚風呂敷',500,2);
insert into item values(nextval('item_id_seq'),'折畳トートバッグ',600,2);
insert into item values(nextval('item_id_seq'),'アイマスク',900,2);
insert into item values(nextval('item_id_seq'),'防水スプレー',500,2);
insert into item values(nextval('item_id_seq'),'キーホルダ',800,2);
insert into item values(nextval('item_id_seq'),'ワイヤレスマウス',900,3);
insert into item values(nextval('item_id_seq'),'ワイヤレストラックボール',1300,3);
insert into item values(nextval('item_id_seq'),'有線光学式マウス',500,3);
insert into item values(nextval('item_id_seq'),'光学式ゲーミングマウス',4800,3);
insert into item values(nextval('item_id_seq'),'有線ゲーミングマウス',3800,3);
insert into item values(nextval('item_id_seq'),'USB有線式キーボード',1400,3);
insert into item values(nextval('item_id_seq'),'無線式キーボード',1900,3);

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