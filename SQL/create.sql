CREATE DATABASE website;
CREATE TABLE user(user_id SERIAL PRIMARY KEY UNIQUE NOT NULL AUTO_INCREMENT,login_id varchar(255) UNIQUE NOT NULL,name varchar(255)  NOT NULL,address varchar(255) NOT NULL,password varchar(255) NOT NULL, create_date DATETIME NOT NULL, update_date DATETIME NOT NULL);
CREATE TABLE item(item_id SERIAL PRIMARY KEY UNIQUE NOT NULL AUTO_INCREMENT,item_name varchar(255) NOT NULL,price int NOT NULL,detail varchar(255) NOT NULL,create_date DATETIME NOT NULL, update_date DATETIME NOT NULL);
CREATE TABLE item_detail(item_detail_id SERIAL PRIMARY KEY UNIQUE NOT NULL AUTO_INCREMENT, item_id int NOT NULL,color_id int Not Null,size_id int NOT NULL, stock int not null,create_date DATETIME NOT NULL, update_date DATETIME NOT NULL);
CREATE TABLE buy(buy_id SERIAL PRIMARY KEY UNIQUE NOT NULL AUTO_INCREMENT,user_id int UNIQUE Not Null,tatal_price int not null,create_date DATETIME NOT NULL);
CREATE TABLE buy_detail(buy_detail_id SERIAL PRIMARY KEY UNIQUE NOT NULL AUTO_INCREMENT,buy_id int UNIQUE NOT NULL,item_id int UNIQUE NOT NULL,color_id int UNIQUE NOT NULL,size_id int UNIQUE NOT NULL,purchase_quantity int NOT NULL);
CREATE TABLE color(color_id SERIAL PRIMARY KEY UNIQUE NOT NULL AUTO_INCREMENT,color_name varchar(255) UNIQUE NOT NULL);
CREATE TABLE size(size_id SERIAL PRIMARY KEY UNIQUE NOT NULL AUTO_INCREMENT,size_name varchar(255) UNIQUE NOT NULL) ;
CREATE TABLE category(category_id SERIAL PRIMARY KEY UNIQUE NOT NULL AUTO_INCREMENT,category_name varchar(255) UNIQUE NOT NULL);
INSERT INTO category (category_name)VALUES ('accessories');
INSERT INTO category VALUES (2,'bathmats');
select * from caregory;
delete from category where category_id=1;
drop table file;
CREATE TABLE category(category_id SERIAL PRIMARY KEY UNIQUE NOT NULL AUTO_INCREMENT,category_name varchar(255) UNIQUE NOT NULL);
INSERT INTO color (color_name)VALUES ('natural');
INSERT INTO size (size_name)VALUES ('S');
CREATE TABLE favorite(favorite_id SERIAL PRIMARY KEY UNIQUE NOT NULL AUTO_INCREMENT, item_id int UNIQUE NOT NULL);
ALTER TABLE item_detail ADD item_id int NOT NULL;
CREATE TABLE file(file_id SERIAL PRIMARY KEY UNIQUE NOT NULL AUTO_INCREMENT, item_detail_id int NOT NULL, file_name varchar(255) NOT NULL);
UPDATE item_detail SET size_id='3' where item_id=15;
INSERT INTO item (item_name,price,category_id,detail,create_date,update_date) VALUES ('プレミアム品質コットンタオル（3枚セット）','1790','1','タオル重量:600g/m2',NOW(),NOW());
INSERT INTO item_detail (item_id,color_id,size_id,stock,create_date,update_date) VALUES ('18','4','3','30',NOW(),NOW());

INSERT INTO file (item_detail_id,file_name) VALUES ('8','JACQUARD WAFFLE KNIT TOWEL (SET OF 2)N3.jpg');
INSERT INTO item (item_name,price,category_id,detail,create_date,update_date)
VALUES ('ウッド ソープディッシュ','1790','4','シリンダー型ウッド製ソープディッシュ、10.5×2.0cm',NOW(),NOW());

INSERT INTO item (item_name,price,category_id,detail,create_date,update_date)
VALUES ('ウッド ディスペンサー','3290','4','シリンダー型ウッド製ソープディスペンサー、16.0×7.0cm',NOW(),NOW());

INSERT INTO item (item_name,price,category_id,detail,create_date,update_date)
VALUES ('ストライプセラミック コップ','890','4','縦ストライプのレリーフ付きサークルベースのセラミックソープディッシュ、11.0×7.0×7.0cm',NOW(),NOW());

INSERT INTO item (item_name,price,category_id,detail,create_date,update_date)
VALUES ('ストライプセラミック ディスペンサー','1390','4','縦ストライプのレリーフ付きサークルベースのセラミックソープディスペンサー、11.0×7.0×7.0cm',NOW(),NOW());

INSERT INTO item (item_name,price,category_id,detail,create_date,update_date)
VALUES ('ストライプセラミック ソープディッシュ','890','4','縦ストライプのレリーフ付きサークルベースのセラミックソープディッシュ、11.0×7.0×7.0cm',NOW(),NOW());

INSERT INTO item (item_name,price,category_id,detail,create_date,update_date)
VALUES ('シルバーディテール ガラスディスペンサー','2790','4','上部シルバー仕上げのスクエアベースのガラスソープディスペンサー、14.0×7.0×7.0cm',NOW(),NOW());

INSERT INTO item (item_name,price,category_id,detail,create_date,update_date)
VALUES ('マザーオブパール ティッシュケース','6590','4','マザーオブパールのピースでコーティングされたレジン製のスクエアベース ティッシュケース、13.5×14.0×14.0cm',NOW(),NOW());

INSERT INTO item (item_name,price,category_id,detail,create_date,update_date)
VALUES ('マーブルテイストティッシュ ケース','6590','4','マーブルテイストレジン製ティッシュケース、13.5×23.0×8.0cm',NOW(),NOW());

INSERT INTO item_detail(item_id,color_id,size_id,stock,create_date,update_date)VALUES
('30','12','21','30',NOW(),NOW());

INSERT INTO item_detail(item_id,color_id,size_id,stock,create_date,update_date)VALUES
('31','11','21','30',NOW(),NOW());


INSERT INTO item_detail(item_id,color_id,size_id,stock,create_date,update_date)VALUES
('32','11','21','30',NOW(),NOW());


INSERT INTO item_detail(item_id,color_id,size_id,stock,create_date,update_date)VALUES
('33','11','21','30',NOW(),NOW());


INSERT INTO item_detail(item_id,color_id,size_id,stock,create_date,update_date)VALUES
('34','3','21','30',NOW(),NOW());

INSERT INTO item_detail(item_id,color_id,size_id,stock,create_date,update_date)VALUES
('35','3','21','30',NOW(),NOW());
INSERT INTO item_detail(item_id,color_id,size_id,stock,create_date,update_date)VALUES
('36','3','21','30',NOW(),NOW());

INSERT INTO item_detail(item_id,color_id,size_id,stock,create_date,update_date)VALUES
('37','13','21','30',NOW(),NOW());

INSERT INTO item_detail(item_id,color_id,size_id,stock,create_date,update_date)VALUES
('38','13','21','30',NOW(),NOW());
INSERT INTO item_detail(item_id,color_id,size_id,stock,create_date,update_date)VALUES
('39','13','21','30',NOW(),NOW());

INSERT INTO file(item_detail_id,file_name)VALUES('109','BLACKDISPENSER1.jpg');
INSERT INTO file(item_detail_id,file_name)VALUES('30','BLACKDISPENSER2.jpg');
INSERT INTO file(item_detail_id,file_name)VALUES('30','BLACKDISPENSER3.jpg');

INSERT INTO file(item_detail_id,file_name)VALUES('31','WOODEN TUMBLER1.jpg');
INSERT INTO file(item_detail_id,file_name)VALUES('31','WOODEN TUMBLER2.jpg');
INSERT INTO file(item_detail_id,file_name)VALUES('31','WOODEN TUMBLER3.jpg');

INSERT INTO file(item_detail_id,file_name)VALUES('32','WOODEN SOAP DISH1.jpg');
INSERT INTO file(item_detail_id,file_name)VALUES('32','WOODEN SOAP DISH2.jpg');
INSERT INTO file(item_detail_id,file_name)VALUES('32','WOODEN SOAP DISH3.jpg');

INSERT INTO file(item_detail_id,file_name)VALUES('33','wd1.jpg');
INSERT INTO file(item_detail_id,file_name)VALUES('33','wd2.jpg');
INSERT INTO file(item_detail_id,file_name)VALUES('33','wd3.jpg');

INSERT INTO file(item_detail_id,file_name)VALUES('34','STRIPED CERAMIC TUMBLER1.jpg');
INSERT INTO file(item_detail_id,file_name)VALUES('34','STRIPED CERAMIC TUMBLER2.jpg');
INSERT INTO file(item_detail_id,file_name)VALUES('34','STRIPED CERAMIC TUMBLER3.jpg');

INSERT INTO file(item_detail_id,file_name)VALUES('35','GROOVED CERAMIC DISPENSER1.jpg');
INSERT INTO file(item_detail_id,file_name)VALUES('35','GROOVED CERAMIC DISPENSER2.jpg');
INSERT INTO file(item_detail_id,file_name)VALUES('35','GROOVED CERAMIC DISPENSER3.jpg');

INSERT INTO file(item_detail_id,file_name)VALUES('36','GROOVED CERAMIC SOAP DISH1.jpg');
INSERT INTO file(item_detail_id,file_name)VALUES('36','GROOVED CERAMIC SOAP DISH2.jpg');
INSERT INTO file(item_detail_id,file_name)VALUES('36','GROOVED CERAMIC SOAP DISH3.jpg');

INSERT INTO file(item_detail_id,file_name)VALUES('37','GLASS DISPENSER WITH A SILVER DETAIL1.jpg');
INSERT INTO file(item_detail_id,file_name)VALUES('37','GLASS DISPENSER WITH A SILVER DETAIL2.jpg');
INSERT INTO file(item_detail_id,file_name)VALUES('37','GLASS DISPENSER WITH A SILVER DETAIL3.jpg');

INSERT INTO file(item_detail_id,file_name)VALUES('38','MOTHER-OF-PEARL TISSUE BOX1.jpg');
INSERT INTO file(item_detail_id,file_name)VALUES('38','MOTHER-OF-PEARL TISSUE BOX2.jpg');
INSERT INTO file(item_detail_id,file_name)VALUES('38','MOTHER-OF-PEARL TISSUE BOX3.jpg');

INSERT INTO file(item_detail_id,file_name)VALUES('39','TISSUE BOX1.jpg');
INSERT INTO file(item_detail_id,file_name)VALUES('39','TISSUE BOX2.jpg');
INSERT INTO file(item_detail_id,file_name)VALUES('39','TISSUE BOX3.jpg');

INSERT INTO item (item_name,price,category_id,detail,create_date,update_date)
VALUES ('ジオメトリック柄レリーフ コップ','1390','4','ジオメトリック柄レリーフ入りホワイトセラミック製 コップ、11.0×7.0cm',NOW(),NOW());
INSERT INTO item (item_name,price,category_id,detail,create_date,update_date)
VALUES ('ジオメトリック柄レリーフ ソープディッシュ','1390','4','ジオメトリック柄レリーフ入りホワイトセラミック製 ソープディッシュ、12.5×2.0cm',NOW(),NOW());

INSERT INTO item (item_name,price,category_id,detail,create_date,update_date)
VALUES ('ジオメトリック柄レリーフ ディスペンサー','2790','4','ジオメトリック柄レリーフ入りホワイトセラミック製 ソープディスペンサー、10.5×17.0cm',NOW(),NOW());

INSERT INTO item_detail(item_id,color_id,size_id,stock,create_date,update_date)VALUES
('40','3','21','30',NOW(),NOW());

INSERT INTO item_detail(item_id,color_id,size_id,stock,create_date,update_date)VALUES
('41','3','21','30',NOW(),NOW());

INSERT INTO item_detail(item_id,color_id,size_id,stock,create_date,update_date)VALUES
('42','3','21','30',NOW(),NOW());

INSERT INTO file(item_detail_id,file_name)VALUES('109','TUMBLER WITH RAISED GEOMETRIC DESIGN1.jpg');
INSERT INTO file(item_detail_id,file_name)VALUES('109','TUMBLER WITH RAISED GEOMETRIC DESIGN2.jpg');
INSERT INTO file(item_detail_id,file_name)VALUES('109','TUMBLER WITH RAISED GEOMETRIC DESIGN3.jpg');

INSERT INTO file(item_detail_id,file_name)VALUES('110','RAISED GEOMETRIC DESIGN SOAP DISH1.jpg');
INSERT INTO file(item_detail_id,file_name)VALUES('110','RAISED GEOMETRIC DESIGN SOAP DISH2.jpg');
INSERT INTO file(item_detail_id,file_name)VALUES('110','RAISED GEOMETRIC DESIGN SOAP DISH3.jpg');

INSERT INTO file(item_detail_id,file_name)VALUES('111','RAISED GEOMETRIC DESIGN SOAP DISPENSER1.jpg');
INSERT INTO file(item_detail_id,file_name)VALUES('111','RAISED GEOMETRIC DESIGN SOAP DISPENSER2.jpg');
INSERT INTO file(item_detail_id,file_name)VALUES('111','RAISED GEOMETRIC DESIGN SOAP DISPENSER3.jpg');
select t1.*
	from `item_detail` t1
		inner join item_detail t2 on
			t1.`item_id` = t2.`item_id`
			and t2.`color_id` = t2.`color_id`
	where
		t2.`item_detail_id` = 91
		and t1.`size_id` = 15;

		INSERT INTO item (item_name,price,category_id,detail,create_date,update_date)
VALUES ('ウッド ソープディッシュ','1790','4','シリンダー型ウッド製ソープディッシュ、10.5×2.0cm',NOW(),NOW());

INSERT INTO item (item_name,price,category_id,detail,create_date,update_date)
VALUES ('ウッド ディスペンサー','3290','4','シリンダー型ウッド製ソープディスペンサー、16.0×7.0cm',NOW(),NOW());

INSERT INTO item (item_name,price,category_id,detail,create_date,update_date)
VALUES ('ストライプセラミック コップ','890','4','縦ストライプのレリーフ付きサークルベースのセラミックソープディッシュ、11.0×7.0×7.0cm',NOW(),NOW());

INSERT INTO item (item_name,price,category_id,detail,create_date,update_date)
VALUES ('ストライプセラミック ディスペンサー','1390','4','縦ストライプのレリーフ付きサークルベースのセラミックソープディスペンサー、11.0×7.0×7.0cm',NOW(),NOW());

INSERT INTO item (item_name,price,category_id,detail,create_date,update_date)
VALUES ('ストライプセラミック ソープディッシュ','890','4','縦ストライプのレリーフ付きサークルベースのセラミックソープディッシュ、11.0×7.0×7.0cm',NOW(),NOW());

INSERT INTO item (item_name,price,category_id,detail,create_date,update_date)
VALUES ('シルバーディテール ガラスディスペンサー','2790','4','上部シルバー仕上げのスクエアベースのガラスソープディスペンサー、14.0×7.0×7.0cm',NOW(),NOW());

INSERT INTO item (item_name,price,category_id,detail,create_date,update_date)
VALUES ('マザーオブパール ティッシュケース','6590','4','マザーオブパールのピースでコーティングされたレジン製のスクエアベース ティッシュケース、13.5×14.0×14.0cm',NOW(),NOW());

INSERT INTO item (item_name,price,category_id,detail,create_date,update_date)
VALUES ('マーブルテイストティッシュ ケース','6590','4','マーブルテイストレジン製ティッシュケース、13.5×23.0×8.0cm',NOW(),NOW());

INSERT INTO item_detail(item_id,color_id,size_id,stock,create_date,update_date)VALUES
('30','12','21','30',NOW(),NOW());

INSERT INTO item_detail(item_id,color_id,size_id,stock,create_date,update_date)VALUES
('31','11','21','30',NOW(),NOW());


INSERT INTO item_detail(item_id,color_id,size_id,stock,create_date,update_date)VALUES
('32','11','21','30',NOW(),NOW());


INSERT INTO item_detail(item_id,color_id,size_id,stock,create_date,update_date)VALUES
('33','11','21','30',NOW(),NOW());


INSERT INTO item_detail(item_id,color_id,size_id,stock,create_date,update_date)VALUES
('34','3','21','30',NOW(),NOW());

INSERT INTO item_detail(item_id,color_id,size_id,stock,create_date,update_date)VALUES
('35','3','21','30',NOW(),NOW());
INSERT INTO item_detail(item_id,color_id,size_id,stock,create_date,update_date)VALUES
('36','3','21','30',NOW(),NOW());

INSERT INTO item_detail(item_id,color_id,size_id,stock,create_date,update_date)VALUES
('37','13','21','30',NOW(),NOW());

INSERT INTO item_detail(item_id,color_id,size_id,stock,create_date,update_date)VALUES
('38','13','21','30',NOW(),NOW());
INSERT INTO item_detail(item_id,color_id,size_id,stock,create_date,update_date)VALUES
('39','13','21','30',NOW(),NOW());

INSERT INTO file(item_detail_id,file_name)VALUES('109','BLACKDISPENSER1.jpg');
INSERT INTO file(item_detail_id,file_name)VALUES('30','BLACKDISPENSER2.jpg');
INSERT INTO file(item_detail_id,file_name)VALUES('30','BLACKDISPENSER3.jpg');

INSERT INTO file(item_detail_id,file_name)VALUES('31','WOODEN TUMBLER1.jpg');
INSERT INTO file(item_detail_id,file_name)VALUES('31','WOODEN TUMBLER2.jpg');
INSERT INTO file(item_detail_id,file_name)VALUES('31','WOODEN TUMBLER3.jpg');

INSERT INTO file(item_detail_id,file_name)VALUES('32','WOODEN SOAP DISH1.jpg');
INSERT INTO file(item_detail_id,file_name)VALUES('32','WOODEN SOAP DISH2.jpg');
INSERT INTO file(item_detail_id,file_name)VALUES('32','WOODEN SOAP DISH3.jpg');

INSERT INTO file(item_detail_id,file_name)VALUES('33','wd1.jpg');
INSERT INTO file(item_detail_id,file_name)VALUES('33','wd2.jpg');
INSERT INTO file(item_detail_id,file_name)VALUES('33','wd3.jpg');

INSERT INTO file(item_detail_id,file_name)VALUES('34','STRIPED CERAMIC TUMBLER1.jpg');
INSERT INTO file(item_detail_id,file_name)VALUES('34','STRIPED CERAMIC TUMBLER2.jpg');
INSERT INTO file(item_detail_id,file_name)VALUES('34','STRIPED CERAMIC TUMBLER3.jpg');

INSERT INTO file(item_detail_id,file_name)VALUES('35','GROOVED CERAMIC DISPENSER1.jpg');
INSERT INTO file(item_detail_id,file_name)VALUES('35','GROOVED CERAMIC DISPENSER2.jpg');
INSERT INTO file(item_detail_id,file_name)VALUES('35','GROOVED CERAMIC DISPENSER3.jpg');

INSERT INTO file(item_detail_id,file_name)VALUES('36','GROOVED CERAMIC SOAP DISH1.jpg');
INSERT INTO file(item_detail_id,file_name)VALUES('36','GROOVED CERAMIC SOAP DISH2.jpg');
INSERT INTO file(item_detail_id,file_name)VALUES('36','GROOVED CERAMIC SOAP DISH3.jpg');

INSERT INTO file(item_detail_id,file_name)VALUES('37','GLASS DISPENSER WITH A SILVER DETAIL1.jpg');
INSERT INTO file(item_detail_id,file_name)VALUES('37','GLASS DISPENSER WITH A SILVER DETAIL2.jpg');
INSERT INTO file(item_detail_id,file_name)VALUES('37','GLASS DISPENSER WITH A SILVER DETAIL3.jpg');

INSERT INTO file(item_detail_id,file_name)VALUES('38','MOTHER-OF-PEARL TISSUE BOX1.jpg');
INSERT INTO file(item_detail_id,file_name)VALUES('38','MOTHER-OF-PEARL TISSUE BOX2.jpg');
INSERT INTO file(item_detail_id,file_name)VALUES('38','MOTHER-OF-PEARL TISSUE BOX3.jpg');

INSERT INTO file(item_detail_id,file_name)VALUES('39','TISSUE BOX1.jpg');
INSERT INTO file(item_detail_id,file_name)VALUES('39','TISSUE BOX2.jpg');
INSERT INTO file(item_detail_id,file_name)VALUES('39','TISSUE BOX3.jpg');

INSERT INTO item (item_name,price,category_id,detail,create_date,update_date)
VALUES ('ジオメトリック柄レリーフ コップ','1390','4','ジオメトリック柄レリーフ入りホワイトセラミック製 コップ、11.0×7.0cm',NOW(),NOW());
INSERT INTO item (item_name,price,category_id,detail,create_date,update_date)
VALUES ('ジオメトリック柄レリーフ ソープディッシュ','1390','4','ジオメトリック柄レリーフ入りホワイトセラミック製 ソープディッシュ、12.5×2.0cm',NOW(),NOW());

INSERT INTO item (item_name,price,category_id,detail,create_date,update_date)
VALUES ('ジオメトリック柄レリーフ ディスペンサー','2790','4','ジオメトリック柄レリーフ入りホワイトセラミック製 ソープディスペンサー、10.5×17.0cm',NOW(),NOW());

INSERT INTO item_detail(item_id,color_id,size_id,stock,create_date,update_date)VALUES
('40','3','21','30',NOW(),NOW());

INSERT INTO item_detail(item_id,color_id,size_id,stock,create_date,update_date)VALUES
('41','3','21','30',NOW(),NOW());

INSERT INTO item_detail(item_id,color_id,size_id,stock,create_date,update_date)VALUES
('42','3','21','30',NOW(),NOW());

INSERT INTO file(item_detail_id,file_name)VALUES('109','TUMBLER WITH RAISED GEOMETRIC DESIGN1.jpg');
INSERT INTO file(item_detail_id,file_name)VALUES('109','TUMBLER WITH RAISED GEOMETRIC DESIGN2.jpg');
INSERT INTO file(item_detail_id,file_name)VALUES('109','TUMBLER WITH RAISED GEOMETRIC DESIGN3.jpg');

INSERT INTO file(item_detail_id,file_name)VALUES('110','RAISED GEOMETRIC DESIGN SOAP DISH1.jpg');
INSERT INTO file(item_detail_id,file_name)VALUES('110','RAISED GEOMETRIC DESIGN SOAP DISH2.jpg');
INSERT INTO file(item_detail_id,file_name)VALUES('110','RAISED GEOMETRIC DESIGN SOAP DISH3.jpg');

INSERT INTO file(item_detail_id,file_name)VALUES('111','RAISED GEOMETRIC DESIGN SOAP DISPENSER1.jpg');
INSERT INTO file(item_detail_id,file_name)VALUES('111','RAISED GEOMETRIC DESIGN SOAP DISPENSER2.jpg');
INSERT INTO file(item_detail_id,file_name)VALUES('111','RAISED GEOMETRIC DESIGN SOAP DISPENSER3.jpg');

INSERT INTO user(login_id,name,address,password,create_date,update_date)VALUES('admin','管理人','管理人だお','pass',NOW(),NOW());

ALTER TABLE buy_detail DROP COLUMN item_id;
ALTER TABLE buy_detail DROP COLUMN color_id;
ALTER TABLE buy_detail DROP COLUMN size_id;
ALTER TABLE buy_detail ADD item_detail_id int;
ALTER TABLE buy_detail ADD buy_id int not null;

SELECT * FROM user WHERE login_id = 'admin' and password = 'pass';
SELECT * FROM user WHERE login_id = ? and password = ?;
SELECT * FROM item_detail
            INNER JOIN item ON item_detail.item_id = item_detail.item_id
            INNER JOIN file ON item_detail.item_detail_id =file.item_detail_id
            INNER JOIN size ON size.size_id=item_detail.size_id
            WHERE item_name LIKE '%タオル%' ORDER BY item_detail.item_detail_id ;

SELECT * FROM item_detail
            INNER JOIN item ON item_detail.item_id = item.item_id
            INNER JOIN file ON item_detail.item_detail_id =file.item_detail_id
            INNER JOIN size ON size.size_id=item_detail.size_id
            LEFT OUTER JOIN favorite ON item_detail.item_detail_id = favorite.item_detail_id
            WHERE category_id =3 ORDER BY file.item_detail_id;

INSERT INTO favorite(item_detail_id,user_id)VALUES (1,1);

select t1.*
	from `item_detail` t1
		inner join item_detail t2 on
			t1.`item_id` = t2.`item_id`
			and t2.`color_id` = t2.`color_id`
	where
		t2.`item_detail_id` = 91
		and t1.`size_id` = 15;

		select t1. * , item. *from item_detail t1
            		inner join item_detail t2 on
            			t1.item_id = t2.item_id
            			and t2.color_id = t2.color_id
            		INNER JOIN item ON t1.item_id = item.item_id
            	where t2.item_detail_id = 91
            		and t1.size_id = 15;
          sele


            	select t1. * , item. *,size_name, favorite. * , file.* from item_detail t1
            		            		inner join item_detail t2 on
            		            			t1.item_id = t2.item_id
            		            			and t1.color_id = t2.color_id
            		            		INNER JOIN item ON t1.item_id = item.item_id
            		INNER JOIN size ON size.size_id = t1.size_id

            		  JOIN file ON t2.item_detail_id = file.item_detail_id
            		LEFT OUTER JOIN favorite ON t1.item_detail_id = favorite.item_detail_id
            		            	where t2.item_detail_id = 91
            		            		and t1.size_id = 16;

SELECT * FROM buy INNER JOIN buy_detail ON buy.buy_id = buy_detail.buy_id
                    INNER JOIN item_detail on buy_detail.item_detail_id=item_detail.item_detail_id
                    INNER JOIN item ON item_detail.item_id = item.item_id
                    INNER JOIN file ON item_detail.item_detail_id =file.item_detail_id
                    INNER JOIN size ON size.size_id=item_detail.size_id


                    WHERE buy.buy_id = 3 ORDER BY file.item_detail_id DESC;

INSERT INTO buy(user_id,total_price,create_date) VALUES(1,2990,now());

SELECT * FROM buy INNER JOIN buy_detail ON buy.buy_id = buy_detail.buy_id
            		                   INNER JOIN item_detail on buy_detail.item_detail_id=item_detail.item_detail_id
            		                  INNER JOIN item ON item_detail.item_id = item.item_id
            		                   INNER JOIN file ON item_detail.item_detail_id =file.item_detail_id
            		                    INNER JOIN size ON size.size_id=item_detail.size_id
            		                    WHERE buy.buy_id = 13 ORDER BY file.item_detail_id DESC;

SELECT * FROM buy_detail INNER JOIN item_detail ON buy_detail.item_detail_id =item_detail.item_detail_id
            INNER JOIN item ON item.item_id =item_detail.item_id  WHERE buy_id = 13;


INSERT INTO user(login_id,name,address,password,create_date,update_date)VALUES("shiori","shiori","address","pass",now(),now()) ;



            select
            *
            from
            buy_detail
            where
            buy_id = 12;
select * from item_detail inner join item ON item_detail.item_id=item.item_id where category_id=1;

select * from file where item_detail_id=10;

SELECT * FROM size inner join item_detail on size.size_id = item_detail.size_id  where item_detail_id = 11;

select * from favorite where item_detail_id = 12;


select * from item_detail inner join item ON item_detail.item_id=item.item_id where category_id=3;

select * from item_detail inner join item ON item_detail.item_id=item.item_id where category_id=3 and size_id=20;

            
