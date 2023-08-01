CREATE USER 'springstudent'@'localhost' IDENTIFIED BY 'Admin@123';

GRANT ALL PRIVILEGES ON * . * TO 'springstudent'@'localhost';

ALTER USER 'springstudent'@'localhost' IDENTIFIED WITH mysql_native_password BY 'Admin@123';