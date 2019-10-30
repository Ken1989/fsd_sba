CREATE TABLE `sba_system_db`.`sba_user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `sex` VARCHAR(45) NULL,
  `idno` VARCHAR(45) NULL,
  `status` VARCHAR(1) NULL,
  `birthdate` DATETIME NULL,
  `password` VARCHAR(200) NULL,
  `jwtstr` VARCHAR(200) NULL,
  `createdby` VARCHAR(45) NULL,
  `createdate` DATETIME NULL,
  `modifiedby` VARCHAR(45) NULL,
  `modifieddate` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));


CREATE TABLE `sba_system_db`.`sba_menu` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NULL,
  `icon` VARCHAR(200) NULL,
  `url` VARCHAR(200) NULL,
  `active` VARCHAR(45) NULL,
  `status` VARCHAR(45) NULL,
  `createdby` VARCHAR(45) NULL,
  `createddate` DATETIME NULL,
  `modifiedby` VARCHAR(45) NULL,
  `modifieddate` DATETIME NULL,
  PRIMARY KEY (`id`));


CREATE TABLE `sba_system_db`.`sba_role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `status` VARCHAR(45) NULL,
  `createdby` VARCHAR(45) NULL,
  `createddate` DATETIME NULL,
  `modifiedby` VARCHAR(45) NULL,
  `modifieddate` DATETIME NULL,
  PRIMARY KEY (`id`));


CREATE TABLE `sba_system_db`.`sba_role2menu` (
  `id` INT NOT NULL,
  `role_id` INT NULL,
  `resource_id` INT NULL,
  `status` VARCHAR(1) NULL,
  `createdby` VARCHAR(45) NULL,
  `createdate` DATETIME NULL,
  `modifiedby` VARCHAR(45) NULL,
  `modifieddate` DATETIME NULL,
  PRIMARY KEY (`id`));
