CREATE TABLE PAYMENTS(
  order_id INT PRIMARY KEY,
  pay_type VARCHAR(255) NOT NULL,
  amount FLOAT NOT NULL,
  time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (order_id) REFERENCES ORDERS(id)
);