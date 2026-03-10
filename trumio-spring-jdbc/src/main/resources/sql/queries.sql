 /*
  Name: MySQL Sample Database student
  Link: 
*/
 
 /* Create the database */
 CREATE DATABASE IF NOT EXISTS trumio_db;
 
 /* Switch to the trumio_db database */
 USE trumio_db;
 
 SELECT DATABASE();
 
 /* Drop existing tables  */
 DROP TABLE IF EXISTS student;
 DROP TABLE IF EXISTS EXAMPLE_TIMESTAMP;
 
 
  /* Create New tables  */
 create table student(id int primary key, name varchar(100) not null,city varchar(200));
 

 
 CREATE TABLE EXAMPLE_TIMESTAMP(
   ID INT PRIMARY KEY AUTO_INCREMENT,
   DATA varchar(100) NOT NULL,
   CUR_TIMESTAMP TIMESTAMP DEFAULT CURRENT_TIMESTAMP);
   
   
  /* Insert Sample Data  */
 insert into student(id,name,city) values(01,'Suman Shekhar','Delhi');
 