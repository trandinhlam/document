
GRANT ALL PRIVILEGES ON *.* TO 'root1'@'%' IDENTIFIED BY 'root1' WITH GRANT OPTION;
FLUSH PRIVILEGES;

SET GLOBAL validate_password_length = 4;
SET GLOBAL validate_password_number_count = 0;
SET GLOBAL validate_password_special_char_count = 0;
SET GLOBAL validate_password_policy = 'LOW';

SHOW VARIABLES LIKE 'validate_password%';

sudo vi /etc/mysql/mysql.conf.d/mysqld.cnf
