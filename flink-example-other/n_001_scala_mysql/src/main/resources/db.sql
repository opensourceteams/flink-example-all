drop table if exists t_user ;
CREATE TABLE `t_user`(
   `id` INT UNSIGNED AUTO_INCREMENT,
   `username` VARCHAR(100)  NULL,
   `age` int  NULL,
   `remark` VARCHAR(40)  NULL,

   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
