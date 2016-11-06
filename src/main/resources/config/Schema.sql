create database if not exists jrs;
use jrs;

CREATE TABLE account (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(100) NOT NULL unique,
  password VARCHAR(200) NOT NULL  
);
insert into account values(NULL,'u','p');
