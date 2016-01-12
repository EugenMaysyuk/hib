CREATE TABLE user
(
  id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  username VARCHAR(256),
  password VARCHAR(256),
  age INT(11)
);

CREATE TABLE info
(
  info_id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  bank_id INT(11),
  text1 VARCHAR(256),
  text2 VARCHAR(256),
  text3 VARCHAR(256)
);

/* Data */

INSERT INTO hib.user (id, username, password, age) VALUES (1, 'Test', '12345', 23);
INSERT INTO hib.info (info_id, bank_id, text1, text2, text3) VALUES (1, 1, 'text1', 'text2', 'text3');