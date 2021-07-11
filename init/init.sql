-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema service
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema service
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `service` ;
USE `service` ;

-- -----------------------------------------------------
-- Table `service`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `service`.`role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `service`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `service`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `firstname` VARCHAR(45) NOT NULL,
  `middle_name` VARCHAR(45) NULL,
  `lastname` VARCHAR(45) NOT NULL,
  `mobile` VARCHAR(45) NOT NULL,
  `phone_home` VARCHAR(45) NULL,
  `phone_office` VARCHAR(45) NULL,
  `birthdate` VARCHAR(45) NOT NULL,
  `role_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_user_role_idx` (`role_id` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  CONSTRAINT `fk_user_role`
    FOREIGN KEY (`role_id`)
    REFERENCES `service`.`role` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `service`.`password`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `service`.`password` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `password` VARCHAR(45) NOT NULL,
  `date` DATETIME NOT NULL,
  `active` TINYINT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_password_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_password_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `service`.`user` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `service`.`country`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `country` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`country_code` char(3) NOT NULL DEFAULT '',
	`country_name` varchar(100) NOT NULL DEFAULT '',
	`currency_code` char(3) DEFAULT NULL,
	`fips_code` char(2) DEFAULT NULL,
	`iso_numeric` char(4) DEFAULT NULL,
	`north` varchar(30) DEFAULT NULL,
	`south` varchar(30) DEFAULT NULL,
	`east` varchar(30) DEFAULT NULL,
	`west` varchar(30) DEFAULT NULL,
	`capital` varchar(30) DEFAULT NULL,
	`continent_name` varchar(100) DEFAULT NULL,
	`continent` char(2) DEFAULT NULL,
	`languages` varchar(100) DEFAULT NULL,
	`iso_alpha3` char(3) DEFAULT NULL,
	`geoname_id` int(10) DEFAULT NULL,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- -----------------------------------------------------
-- Table `service`.`state`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `state` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `country_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_state_country1_idx` (`country_id` ASC) VISIBLE,
  CONSTRAINT `fk_state_country1`
    FOREIGN KEY (`country_id`)
    REFERENCES `service`.`country` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `service`.`city`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `service`.`city` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `state_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_city_state1_idx` (`state_id` ASC) VISIBLE,
  CONSTRAINT `fk_city_state1`
    FOREIGN KEY (`state_id`)
    REFERENCES `service`.`state` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `service`.`district`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `service`.`district` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `city_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_district_city1_idx` (`city_id` ASC) VISIBLE,
  CONSTRAINT `fk_district_city1`
    FOREIGN KEY (`city_id`)
    REFERENCES `service`.`city` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `service`.`location`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `service`.`location` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `place_code` VARCHAR(200) NOT NULL,
  `provider` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `service`.`address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `service`.`address` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `line1` VARCHAR(45) NOT NULL,
  `line2` VARCHAR(45) NULL,
  `user_id` INT NOT NULL,
  `district_id` INT NOT NULL,
  `location_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_address_user1_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_address_district1_idx` (`district_id` ASC) VISIBLE,
  INDEX `fk_address_location1_idx` (`location_id` ASC) VISIBLE,
  CONSTRAINT `fk_address_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `service`.`user` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_address_district1`
    FOREIGN KEY (`district_id`)
    REFERENCES `service`.`district` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_address_location1`
    FOREIGN KEY (`location_id`)
    REFERENCES `service`.`location` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `service`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `service`.`category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `code` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NULL,
  `category_id` INT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `code_UNIQUE` (`code` ASC) VISIBLE,
  INDEX `fk_category_category1_idx` (`category_id` ASC) VISIBLE,
  CONSTRAINT `fk_category_category1`
    FOREIGN KEY (`category_id`)
    REFERENCES `service`.`category` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `service`.`available_service`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `service`.`available_service` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `code` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  `suggested_duration` INT NOT NULL,
  `suggested_price` DECIMAL(15,2) NOT NULL,
  `category_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `code_UNIQUE` (`code` ASC) VISIBLE,
  INDEX `fk_service_category1_idx` (`category_id` ASC) VISIBLE,
  CONSTRAINT `fk_service_category1`
    FOREIGN KEY (`category_id`)
    REFERENCES `service`.`category` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `service`.`server`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `service`.`server` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `active` TINYINT NOT NULL DEFAULT 1,
  `rating` DECIMAL(5,2) NULL DEFAULT 0,
  `price` DECIMAL(15,2) NOT NULL,
  `duration` INT NOT NULL,
  `user_id` INT NOT NULL,
  `available_service_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_server_user1_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_server_service1_idx` (`available_service_id` ASC) VISIBLE,
  CONSTRAINT `fk_server_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `service`.`user` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_server_service1`
    FOREIGN KEY (`available_service_id`)
    REFERENCES `service`.`available_service` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `service`.`availability`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `service`.`availability` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `monday` TINYINT NOT NULL DEFAULT 1,
  `tuesday` TINYINT NOT NULL DEFAULT 1,
  `wednesday` TINYINT NOT NULL DEFAULT 1,
  `thursday` TINYINT NOT NULL DEFAULT 1,
  `friday` TINYINT NOT NULL DEFAULT 1,
  `saturday` TINYINT NOT NULL DEFAULT 0,
  `sunday` TINYINT NOT NULL DEFAULT 0,
  `time_from` TIME NOT NULL,
  `time_to` TIME NOT NULL,
  `price` DECIMAL(15,2) NOT NULL,
  `server_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_availability_server1_idx` (`server_id` ASC) VISIBLE,
  CONSTRAINT `fk_availability_server1`
    FOREIGN KEY (`server_id`)
    REFERENCES `service`.`server` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `service`.`appointment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `service`.`appointment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `time_from` DATETIME NOT NULL,
  `time_to` DATETIME NOT NULL,
  `availability_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_appointment_availability1_idx` (`availability_id` ASC) VISIBLE,
  CONSTRAINT `fk_appointment_availability1`
    FOREIGN KEY (`availability_id`)
    REFERENCES `service`.`availability` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `service`.`service`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `service`.`service` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `request_date` DATETIME NOT NULL,
  `end_date` VARCHAR(45) NULL,
  `rating` DECIMAL(5,2) NULL,
  `comments` VARCHAR(100) NULL,
  `amount` DECIMAL(15,2) NULL DEFAULT 0,
  `duration` INT NULL DEFAULT 0,
  `status` VARCHAR(20) NOT NULL,
  `user_id` INT NOT NULL,
  `cancellation_reason` VARCHAR(45) NULL,
  `appointment_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_service_user1_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_service_appointment1_idx` (`appointment_id` ASC) VISIBLE,
  CONSTRAINT `fk_service_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `service`.`user` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_service_appointment1`
    FOREIGN KEY (`appointment_id`)
    REFERENCES `service`.`appointment` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `service`.`permission`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `service`.`permission` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `service`.`module`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `service`.`module` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NULL,
  `main` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `service`.`module_permission`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `service`.`module_permission` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `permission_id` INT NOT NULL,
  `module_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_module_permission_permission1_idx` (`permission_id` ASC) VISIBLE,
  INDEX `fk_module_permission_module1_idx` (`module_id` ASC) VISIBLE,
  CONSTRAINT `fk_module_permission_permission1`
    FOREIGN KEY (`permission_id`)
    REFERENCES `service`.`permission` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_module_permission_module1`
    FOREIGN KEY (`module_id`)
    REFERENCES `service`.`module` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `service`.`role_permission`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `service`.`role_permission` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `permission_id` INT NOT NULL,
  `role_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_role_permission_permission1_idx` (`permission_id` ASC) VISIBLE,
  INDEX `fk_role_permission_role1_idx` (`role_id` ASC) VISIBLE,
  CONSTRAINT `fk_role_permission_permission1`
    FOREIGN KEY (`permission_id`)
    REFERENCES `service`.`permission` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_role_permission_role1`
    FOREIGN KEY (`role_id`)
    REFERENCES `service`.`role` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
