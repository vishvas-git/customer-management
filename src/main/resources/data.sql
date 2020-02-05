DROP TABLE IF EXISTS customer;
  
CREATE TABLE customer (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  email_id VARCHAR(100) DEFAULT NULL
);

INSERT INTO customer (first_name, last_name, email_id) VALUES
  ('Prahlad', 'Awasthi','prahlada@hcl.com'),
  ('Vishvas', 'Srivastava','vishvass@hcl.com'),
  ('Lokesh', 'Gupta','lokeshg@hcl.com'),
  ('Deja', 'Vu','dejav@hcl.com'),
  ('Caption', 'America','');