USE `diverse`;  # `useradmin`;

UNLOCK TABLES;

DROP TABLE IF EXISTS `order`;
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(90) NOT NULL,
  `password` varchar(45) NOT NULL,
  `role` varchar(20) NOT NULL DEFAULT 'customer',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

CREATE TABLE `order` (
  `createtime` VARCHAR(20) NOT NULL,
  `user_id` int(11) NOT NULL,
  `sendtime` VARCHAR(20),
  `length` INT(20) NOT NULL,
  `width` INT(20) NOT NULL,
  `height` INT(20) NOT NULL,
  PRIMARY KEY (`createtime`),
  INDEX `userid_idx` (`user_id` ASC),
  CONSTRAINT `user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `diverse`.`user` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
    

LOCK TABLE `user` WRITE, `order` WRITE;
INSERT INTO `user` VALUES 
(1,'jens@somewhere.com','jensen','customer'),
(2,'ken@somewhere.com','kensen','customer'),
(3,'robin@somewhere.com','batman','employee');

INSERT INTO `order` VALUES 
('2012-06-15 10:00:00',2,null,4,4,3),
('2013-06-15 10:00:00',2,null,4,5,3),
('2014-06-15 10:00:00',2,null,5,5,3);

UNLOCK TABLES;
