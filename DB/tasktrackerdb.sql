-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema tasktrackerdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `tasktrackerdb` ;

-- -----------------------------------------------------
-- Schema tasktrackerdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `tasktrackerdb` DEFAULT CHARACTER SET utf8 ;
USE `tasktrackerdb` ;

-- -----------------------------------------------------
-- Table `task`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `task` ;

CREATE TABLE IF NOT EXISTS `task` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NULL,
  `details` VARCHAR(1000) NULL,
  `location` VARCHAR(200) NULL,
  `task_date` DATE NULL,
  `task_time` VARCHAR(45) NULL,
  `category` VARCHAR(45) NULL,
  `priority_level` VARCHAR(45) NULL,
  `notes` VARCHAR(45) NULL,
  `status` VARCHAR(45) NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS tasktracker@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'tasktracker'@'localhost' IDENTIFIED BY 'tasktracker';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'tasktracker'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `task`
-- -----------------------------------------------------
START TRANSACTION;
USE `tasktrackerdb`;
INSERT INTO `task` (`Id`, `name`, `details`, `location`, `task_date`, `task_time`, `category`, `priority_level`, `notes`, `status`) VALUES (1, 'Go to store', 'List: Apples, Eggs, Milk', '1155 S. Havana Rd Aurora, CO 80247', '2021-12-12', '00:00:00', 'Shopping', 'Low', '20$ budget', 'Not complete');

COMMIT;

