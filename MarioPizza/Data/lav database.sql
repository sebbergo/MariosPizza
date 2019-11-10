drop database if exists mario;
CREATE DATABASE mario;

use mario;

CREATE TABLE `pizza` (
   `pizza_id` int(11) NOT NULL AUTO_INCREMENT,
   `pizza_navn` varchar(255) NOT NULL,
   `pizza_pris` double NOT NULL,
   `pizza_fyld` varchar(255) NOT NULL,
   PRIMARY KEY (`pizza_id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

CREATE TABLE `kunde` (
   `kunde_id` int(11) NOT NULL AUTO_INCREMENT,
   `kunde_tlf` int(11) NOT NULL,
   `kunde_navn` double NOT NULL,
   PRIMARY KEY (`kunde_id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;
 
 CREATE TABLE `order` (
   `order_id` int(11) NOT NULL AUTO_INCREMENT,
   `kunde_id` int(11) NOT NULL,
   `order_pizzaer` varchar(255) NOT NULL,
   `order_pris` double NOT NULL,
   `order_status` varchar(50) NOT NULL,
   PRIMARY KEY (`order_id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;
