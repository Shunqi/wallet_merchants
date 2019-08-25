CREATE TABLE `merchant` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(64) COLLATE utf8_bin NOT NULL COMMENT 'merchants name',
  `logo_url` varchar(256) COLLATE utf8_bin NOT NULL COMMENT 'merchants logo',
  `business_license_url` varchar(256) COLLATE utf8_bin NOT NULL COMMENT 'merchants license',
  `phone_num` varchar(64) COLLATE utf8_bin NOT NULL COMMENT 'phone number',
  `address` varchar(64) COLLATE utf8_bin NOT NULL COMMENT 'address',
  `is_audit` BOOLEAN NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;