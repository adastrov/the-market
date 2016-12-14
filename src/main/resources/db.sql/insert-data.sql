INSERT INTO market.tbl_products (product_title, product_description, product_price, product_count)
VALUES
  ('Product 1', 'Some description of a product 1', '500', '9000'),
  ('Product 2', 'Some description of a product 2', '20', '900'),
  ('Product 3', 'Some description of a product 3', '330', '70'),
  ('Product 4', 'Some description of a product 4', '540', '810'),
  ('Product 5', 'Some description of a product 5', '30', '21'),
  ('Product 6', 'Some description of a product 6', '9000', '300');

INSERT INTO market.tbl_product_groups (product_group_title, product_group_description)
VALUES
  ('Product group 1', 'Some description of a product group 1'),
  ('Product group 2', 'Some description of a product group 2'),
  ('Product group 3', 'Some description of a product group 3'),
  ('Product group 4', 'Some description of a product group 4');

INSERT INTO market.tbl_roles (role_name, role_description)
VALUES
  ('admin', 'Administrator'),
  ('user',  'User'),
  ('guest', 'Guest'),
  ('content_manager',  'Content-manager');

INSERT INTO market.tbl_users (user_login, user_password, user_email, user_first_name, user_last_name, user_birthday, user_sex, user_role_id)
VALUES
  ('admin', '123', 'admin@email.domain', 'Ad', "Min", "19920909", "male" ,"1"),
  ('user',  '123', 'user@email.domain',  'U', "Ser", "19920909", "female" ,"2"),
  ('guest',  '123', 'guest@email.domain',  'G', "Uest", "19920909", "male" ,"3"),
  ('content_manager',  '123', 'content-manager@email.domain',  'C', "Manager", "19920909", "female" ,"4");
