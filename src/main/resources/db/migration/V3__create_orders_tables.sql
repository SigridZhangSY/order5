CREATE TABLE ORDERS(
  id INT AUTO_INCREMENT PRIMARY KEY,
  user_id INT NOT NULL,
  name VARCHAR(255) NOT NULL,
  address VARCHAR(255) NOT NULL,
  phone VARCHAR(255) NOT NULL,
  total_price FLOAT NOT NULL,
  time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (user_id) REFERENCES USERS(id)
);

CREATE TABLE ORDERITEMS(
  id INT AUTO_INCREMENT PRIMARY KEY,
  order_id INT NOT NULL ,
  product_id INT NOT NULL ,
  quantity INTEGER NOT NULL,
  amount FLOAT NOT NULL ,
  FOREIGN KEY (order_id) REFERENCES ORDERS(id),
  FOREIGN KEY (product_id) REFERENCES PRODUCTS(id)
);