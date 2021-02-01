CREATE TABLE `user` (
  `first_name` varchar(80) DEFAULT NULL,
  `last_name` varchar(80) DEFAULT NULL,
  `middle_name` varchar(80) DEFAULT NULL,
  `mobile_number` bigint(10) DEFAULT NULL,
  `id` bigint NOT NULL,
   KEY `id` (branch_id`),
   CONSTRAINT `id` FOREIGN KEY (`branch_id`) REFERENCES `branch`  (`branch_id`)  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `city` (
  `id` bigint NOT NULL,
  `city_name` DEFAULT NULL
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `route` (
`id` bigint (80) NOT NULL,
`bus_stop` varchar (255) DEFAULT NULL
`route_code` varchar (255) DEFAULT NULL,
PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `bus_type` (
`id` bigint (22) NOT NULL,
`class` varchar (225) DEFAULT NULL,
PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `fare` (
`id` bigint (22) NOT NULL,
`bus_fare` varchar (225) DEFAULT NULL,
 KEY `id` (`route_id`)
 CONSTRAINT `id` FOREIGN KEY (`route_id`) REFERENCES `route`  (`route_id`)  ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `role` (
`id` bigint (22) NOT NULL,
`name_id` varchar (225) DEFAULT NULL,
 KEY `id` (`user_id`)
 CONSTRAINT `id` FOREIGN KEY (`user_id`) REFERENCES `user`  (`user_id`)  ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `branch` (
`id` bigint (22) NOT NULL,
`center_name` varchar (225) DEFAULT NULL,
`street_name` varchar (225) DEFAULT NULL,
 KEY `id` (`city_id`)
 CONSTRAINT `id` FOREIGN KEY (`city_id`) REFERENCES `city`  (`city_id`)  ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `customer` (
  `first_name`  varchar(80) DEFAULT NULL,
  `last_name`   varchar(80) DEFAULT NULL,
  `middle_name` varchar(80) DEFAULT NULL,
  `email` varchar(80) DEFAULT NULL
  `mobile_number` bigint(10) DEFAULT NULL,
  `id` bigint NOT NULL,
  PRIMARY KEY (`id`)
  )ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `bus_schedule`(
`arrival_city` varchar(80) DEFAULT NULL,
`departure_city` varchar(80) DEFAULT NULL,
`travel_date` varchar(80) DEFAULT NULL ,
 KEY `id` (`bus_fare_id`) (`bus_type_id`),
  CONSTRAINT `id` FOREIGN KEY (`bus_type_id`)(`bus_fare_id`)  REFERENCES `bus_type`` (`bus_type_id`) `bus_fare` (`bus_fare_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `reservation` (
  `booking_date` date NOT NULL,
  `departure_date` date NOT NULL,
  `type` varchar(45) NOT NULL,
  `total_fare` varchar(45) NOT NULL,
  `id` bigint NOT NULL,
  KEY `id` (`bus_id`) (`customer_id`) (`user_id`),
  CONSTRAINT `id` FOREIGN KEY (`bus_id`)(`customer_id`) (`user_id`) REFERENCES `user` (`user_id`) `customer` (`customer_id`) `bus` (`bus_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

