
DROP TABLE IF EXISTS role;

CREATE TABLE role (
  role_id int(11) NOT NULL AUTO_INCREMENT,
  role varchar(255) DEFAULT NULL,
  PRIMARY KEY (role_id)
); 




INSERT INTO role (role_id, role) VALUES(1,'ADMIN');
INSERT INTO role (role_id, role) VALUES(2,'EMPLOYEE');
INSERT INTO role (role_id, role) VALUES(3,'MANAGER');
INSERT INTO role (role_id, role) VALUES(4,'CEO');
INSERT INTO role (role_id, role) VALUES(5,'RND');





DROP TABLE IF EXISTS user;

CREATE TABLE user (
  user_id int(11) NOT NULL AUTO_INCREMENT,
  active int(11) DEFAULT NULL,
  email varchar(255) NOT NULL,
  last_name varchar(255) NOT NULL,
  name varchar(255) NOT NULL,
  password varchar(255) NOT NULL,
  PRIMARY KEY (user_id)
) ;




INSERT INTO user (user_id, active, email, last_name, name, password) VALUES(1,1,'dasarishiva1@gmail.com','Dasari','shiva','shiva');
INSERT INTO user (user_id, active, email, last_name, name, password)	VALUES(2,1,'dasariravi@gmail.com','Dasari','ravi','ravi');
INSERT INTO user (user_id, active, email, last_name, name, password)	VALUES(3,1,'dasarisatish@gmail.com','Dasari','satish','satish');





DROP TABLE IF EXISTS user_role;

CREATE TABLE user_role (
  user_id int(11) NOT NULL,
  role_id int(11) NOT NULL,
  
);




INSERT INTO user_role (user_id, role_id) VALUES(1,1);
INSERT INTO user_role (user_id, role_id) VALUES(1,2);


INSERT INTO user_role (user_id, role_id) VALUES(2,1);
INSERT INTO user_role (user_id, role_id) VALUES(2,2);
INSERT INTO user_role (user_id, role_id) VALUES(2,5);

INSERT INTO user_role (user_id, role_id) VALUES(3,1);
INSERT INTO user_role (user_id, role_id) VALUES(3,2);
INSERT INTO user_role (user_id, role_id) VALUES(3,3);
INSERT INTO user_role (user_id, role_id) VALUES(3,4);


