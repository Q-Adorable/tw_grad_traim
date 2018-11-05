
CREATE TABLE `tw_order` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(20) NOT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `order_item` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `order_id` int(20) NOT NULL,
  `product_id` int(20) NOT NULL,
  `product_count` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;