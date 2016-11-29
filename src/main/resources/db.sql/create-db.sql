create schema market;

CREATE TABLE market.tbl_products (
  product_id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  product_title NVARCHAR(100) NOT NULL,
  product_description NVARCHAR(500),
  product_price int(14),
  product_count int(14)
);

CREATE TABLE myTestDB.tbl_product_groups
(
  product_group_id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  product_group_title NVARCHAR(100) NOT NULL,
  product_group_description NVARCHAR(500),
);

CREATE INDEX INDEX_tbl_product_groups ON market.INDEX_tbl_product_groups(product_group_title);

CREATE TABLE myTestDB.tbl_roles (
  role_id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  role_name NVARCHAR(50) NOT NULL,
  role_description NVARCHAR(500)
);

CREATE INDEX INDEX_tbl_roles ON market.tbl_roles(role_name);

CREATE TABLE myTestDB.tbl_users (
  user_id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  user_login NVARCHAR(50) NOT NULL,
  user_password NVARCHAR(50) NOT NULL,
  user_email NVARCHAR(50) NOT NULL,
  user_first_name NVARCHAR(100) NOT NULL,
  user_last_name NVARCHAR(100) NOT NULL,
  user_birthday TIMESTAMP (8) NOT NULL,
  user_role_id int (14) NOT NULL
);

CREATE INDEX INDEX_tbl_users ON market.tbl_users(user_login, user_email);

ALTER TABLE myTestDB.tbl_users
ADD CONSTRAINT fk_tbl_users_role_id FOREIGN KEY (user_role_id) REFERENCES market.tbl_roles(role_id);

CREATE TABLE myTestDB.tbl_history (
  history_id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  user_id INT NOT NULL,
  product_id INT NOT NULL,
  product_count INT,
  product_price INT,
  history_date TIMESTAMP(8)
);

ALTER TABLE myTestDB.tbl_history
ADD CONSTRAINT fk_tbl_history_user_id FOREIGN KEY (user_id) REFERENCES market.tbl_user(user_id);

ALTER TABLE myTestDB.tbl_history
ADD CONSTRAINT fk_tbl_history_product_id FOREIGN KEY (history_product_id) REFERENCES market.tbl_products(product_id);

CREATE INDEX INDEX_tbl_history ON market.tbl_history(user_id, product_id);

CREATE TABLE myTestDB.tbl_relation_adv_country (
  id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  advertising_id INT NOT NULL,
  country_id INT NOT NULL,
  adv_is_allowed BIT NOT NULL
);

CREATE INDEX INDEX_relation_adv_c ON market.tbl_relation_adv_country(advertising_id, country_id);

ALTER TABLE myTestDB.tbl_relation_adv_country
ADD CONSTRAINT fk_tbl_relation_adv_country_advertising_id FOREIGN KEY (advertising_id) REFERENCES myTestDB.tbl_advertising(advertising_id);

ALTER TABLE myTestDB.tbl_relation_adv_country
ADD CONSTRAINT fk_tbl_relation_adv_country_country_id FOREIGN KEY (country_id) REFERENCES myTestDB.tbl_country(country_id);