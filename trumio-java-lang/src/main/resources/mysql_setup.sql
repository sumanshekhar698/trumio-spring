Windows PowerShell
Copyright (C) Microsoft Corporation. All rights reserved.

Install the latest PowerShell for new features and improvements! https://aka.ms/PSWindows

PS C:\Users\suman> cd "C:\Program Files\MySQL\MySQL Server 8.0\bin"
PS C:\Program Files\MySQL\MySQL Server 8.0\bin> .\mysql.exe -u root -p
Enter password: *******
Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 21
Server version: 8.0.44 MySQL Community Server - GPL

Copyright (c) 2000, 2025, Oracle and/or its affiliates.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| information_schema |
| mysql              |
| performance_schema |
| sakila             |
| sys                |
| world              |
+--------------------+
6 rows in set (0.00 sec)

mysql> CREATE DATABASE IF NOT EXISTS trumio_db;
Query OK, 1 row affected (0.01 sec)

mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| information_schema |
| mysql              |
| performance_schema |
| sakila             |
| sys                |
| trumio_db          |
| world              |
+--------------------+
7 rows in set (0.00 sec)

mysql> USE trumio_db;
Database changed

mysql> SELECT DATABASE();
+------------+
| DATABASE() |
+------------+
| trumio_db  |
+------------+
1 row in set (0.00 sec)

mysql> SOURCE C:/Users/suman/Downloads/mysqlsampledatabase/mysqlsampledatabase.sql;
Query OK, 1 row affected (0.01 sec)

Database changed
Query OK, 0 rows affected, 1 warning (0.01 sec)

Query OK, 0 rows affected, 1 warning (0.00 sec)

Query OK, 0 rows affected, 1 warning (0.00 sec)

Query OK, 0 rows affected, 1 warning (0.00 sec)

Query OK, 0 rows affected, 1 warning (0.00 sec)

Query OK, 0 rows affected, 1 warning (0.00 sec)

Query OK, 0 rows affected, 1 warning (0.00 sec)

Query OK, 0 rows affected, 1 warning (0.00 sec)

Query OK, 0 rows affected (0.03 sec)

Query OK, 0 rows affected, 1 warning (0.04 sec)

Query OK, 0 rows affected (0.02 sec)

Query OK, 0 rows affected (0.04 sec)

Query OK, 0 rows affected (0.04 sec)

Query OK, 0 rows affected (0.02 sec)

Query OK, 0 rows affected (0.03 sec)

Query OK, 0 rows affected, 1 warning (0.03 sec)

Query OK, 7 rows affected (0.01 sec)
Records: 7  Duplicates: 0  Warnings: 0

Query OK, 110 rows affected (0.01 sec)
Records: 110  Duplicates: 0  Warnings: 0

Query OK, 7 rows affected (0.01 sec)
Records: 7  Duplicates: 0  Warnings: 0

Query OK, 23 rows affected (0.00 sec)
Records: 23  Duplicates: 0  Warnings: 0

Query OK, 122 rows affected (0.01 sec)
Records: 122  Duplicates: 0  Warnings: 0

Query OK, 326 rows affected (0.01 sec)
Records: 326  Duplicates: 0  Warnings: 0

Query OK, 273 rows affected (0.01 sec)
Records: 273  Duplicates: 0  Warnings: 0

Query OK, 2996 rows affected (0.05 sec)
Records: 2996  Duplicates: 0  Warnings: 0

mysql> SHOW DATABASES;
+--------------------+
| Database           |
+--------------------+
| classicmodels      |
| information_schema |
| mysql              |
| performance_schema |
| sakila             |
| sys                |
| trumio_db          |
| world              |
+--------------------+
8 rows in set (0.00 sec)

mysql> SELECT DATABASE();
+---------------+
| DATABASE()    |
+---------------+
| classicmodels |
+---------------+
1 row in set (0.00 sec)

mysql> USE trumio_db;
Database changed
mysql> SELECT DATABASE();
+------------+
| DATABASE() |
+------------+
| trumio_db  |
+------------+
1 row in set (0.00 sec)

mysql>  create table student(id int primary key, name varchar(100) not null,city varchar(200));
Query OK, 0 rows affected (0.05 sec)

mysql>  insert into student(id,name,city) values(01,'Suman Shekhar','Delhi');
Query OK, 1 row affected (0.01 sec)

mysql>  CREATE TABLE EXAMPLE_TIMESTAMP(
    ->    ID INT PRIMARY KEY AUTO_INCREMENT,
    ->    DATA varchar(100) NOT NULL,
    ->    CUR_TIMESTAMP TIMESTAMP DEFAULT CURRENT_TIMESTAMP);
Query OK, 0 rows affected (0.05 sec)

mysql> SELECT DATABASE();
+------------+
| DATABASE() |
+------------+
| trumio_db  |
+------------+
1 row in set (0.00 sec)

mysql> SHOW TABLES;
+---------------------+
| Tables_in_trumio_db |
+---------------------+
| example_timestamp   |
| student             |
+---------------------+
2 rows in set (0.00 sec)

mysql> SELECT COUNT(*) FROM STUDENT;
+----------+
| COUNT(*) |
+----------+
|        5 |
+----------+
1 row in set (0.01 sec)

mysql> SELECT * FROM STUDENT;
+-----+-----------+---------+
| id  | name      | city    |
+-----+-----------+---------+
|   1 | Balwinder | NY      |
|   6 | Vijay     | Kolkata |
|  10 | Balwinder | Punjab  |
|  66 | Ritika    | NULL    |
| 100 | Sourabh   | Miami   |
+-----+-----------+---------+
5 rows in set (0.00 sec)

mysql>  SELECT * FROM STUDENT LIMIT 2;
+----+-----------+---------+
| id | name      | city    |
+----+-----------+---------+
|  1 | Balwinder | NY      |
|  6 | Vijay     | Kolkata |
+----+-----------+---------+
2 rows in set (0.00 sec)

mysql>  SELECT * FROM STUDENT LIMIT 1;
+----+-----------+------+
| id | name      | city |
+----+-----------+------+
|  1 | Balwinder | NY   |
+----+-----------+------+
1 row in set (0.00 sec)

mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| classicmodels      |
| information_schema |
| mysql              |
| performance_schema |
| sakila             |
| sys                |
| trumio_db          |
| world              |
+--------------------+
8 rows in set (0.01 sec)

mysql> use classicmodels;
Database changed
mysql> show tables;
+-------------------------+
| Tables_in_classicmodels |
+-------------------------+
| customers               |
| employees               |
| offices                 |
| orderdetails            |
| orders                  |
| payments                |
| productlines            |
| products                |
+-------------------------+
8 rows in set (0.00 sec)

mysql> select * FROM customer LIMIT 1;
ERROR 1146 (42S02): Table 'classicmodels.customer' doesn't exist
mysql> select * FROM customers LIMIT 1;
+----------------+-------------------+-----------------+------------------+------------+----------------+--------------+--------+-------+------------+---------+------------------------+-------------+
| customerNumber | customerName      | contactLastName | contactFirstName | phone      | addressLine1   | addressLine2 | city   | state | postalCode | country | salesRepEmployeeNumber | creditLimit |
+----------------+-------------------+-----------------+------------------+------------+----------------+--------------+--------+-------+------------+---------+------------------------+-------------+
|            103 | Atelier graphique | Schmitt         | Carine           | 40.32.2555 | 54, rue Royale | NULL         | Nantes | NULL  | 44000      | France  |                   1370 |    21000.00 |
+----------------+-------------------+-----------------+------------------+------------+----------------+--------------+--------+-------+------------+---------+------------------------+-------------+
1 row in set (0.00 sec)

mysql>