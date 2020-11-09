-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Families
--
-- Base de datos para almacenar informacion basica de una persona y su nucleo familiar
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Families` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;
USE `Families` ;

-- -----------------------------------------------------
-- Table `Families`.`Family`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Families`.`Family` (
  `familyId` INT NOT NULL AUTO_INCREMENT,
  `familyName` VARCHAR(45) NOT NULL,
  `residenceAddress` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`familyId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Families`.`Person`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Families`.`Person` (
  `personId` INT NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(45) NOT NULL,
  `lastName` VARCHAR(45) NOT NULL,
  `birthdate` DATE NOT NULL,
  `gender` CHAR(1) NOT NULL,
  `familyId` INT NOT NULL,
  PRIMARY KEY (`personId`),
  INDEX `fk_Person_Family_idx` (`familyId` ASC) VISIBLE,
  CONSTRAINT `fk_Person_Family`
    FOREIGN KEY (`familyId`)
    REFERENCES `Families`.`Family` (`familyId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Families`.`Audit`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Families`.`Audit` (
  `auditId` INT NOT NULL AUTO_INCREMENT,
  `httpMethod` VARCHAR(45) NULL,
  `startDate` DATE NULL,
  `endDate` DATE NULL,
  `input` VARCHAR(1000) NULL,
  `output` VARCHAR(45) NULL,
  `httpResponse` VARCHAR(45) NULL,
  `exception` VARCHAR(200) NULL,
  `urlParameters` VARCHAR(100) NULL,
  PRIMARY KEY (`auditId`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
