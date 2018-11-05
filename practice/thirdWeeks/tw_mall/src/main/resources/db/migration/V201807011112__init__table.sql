CREATE TABLE mall.goods (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) NOT NULL DEFAULT '',
  `price` double NOT NULL,
  `type` varchar(20) NOT NULL DEFAULT '',
  `brand` varchar(20) NOT NULL DEFAULT '',
  `describes` varchar(100) NOT NULL DEFAULT '',
  `production_day` date NOT NULL,
  `place` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;