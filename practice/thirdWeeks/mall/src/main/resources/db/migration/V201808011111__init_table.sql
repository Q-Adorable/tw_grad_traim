CREATE TABLE mall.product (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) NOT NULL DEFAULT '',
  `price` double NOT NULL,
  `category` varchar(20) NOT NULL DEFAULT '',
  `brand` varchar(20) NOT NULL DEFAULT '',
  `description` varchar(100) NOT NULL DEFAULT '',
  `production_date` date NOT NULL,
  `production_place` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;