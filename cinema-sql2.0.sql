-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema cinemaEBooking
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema cinemaEBooking
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `cinemaEBooking` DEFAULT CHARACTER SET utf8 ;
USE `cinemaEBooking` ;

-- -----------------------------------------------------
-- Table `cinemaEBooking`.`Actor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemaEBooking`.`Actor` (
  `id` INT(11) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cinemaEBooking`.`UserStatus`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemaEBooking`.`UserStatus` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `userStatusName` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cinemaEBooking`.`Customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemaEBooking`.`Customer` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `statusID` INT(11) NOT NULL,
  `firstName` VARCHAR(45) NOT NULL,
  `lastName` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `enrolledForPromotions` TINYINT(4) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_statusID` (`statusID` ASC),
  CONSTRAINT `fk_statusID`
    FOREIGN KEY (`statusID`)
    REFERENCES `cinemaEBooking`.`UserStatus` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cinemaEBooking`.`Address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemaEBooking`.`Address` (
  `id` INT(11) NOT NULL,
  `customerID` INT(11) NOT NULL,
  `streetName` VARCHAR(45) NULL DEFAULT NULL,
  `city` VARCHAR(45) NULL DEFAULT NULL,
  `state` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_addressCustomerID` (`customerID` ASC),
  CONSTRAINT `fk_addressCustomerID`
    FOREIGN KEY (`customerID`)
    REFERENCES `cinemaEBooking`.`Customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cinemaEBooking`.`Admin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemaEBooking`.`Admin` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(45) NOT NULL,
  `lastName` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cinemaEBooking`.`AgeCategory`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemaEBooking`.`AgeCategory` (
  `id` INT(11) NOT NULL,
  `category` VARCHAR(45) NOT NULL,
  `price` DOUBLE NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cinemaEBooking`.`CardPayment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemaEBooking`.`CardPayment` (
  `creditCardNo` CHAR(16) NOT NULL,
  `customerID` INT(11) NOT NULL,
  `creditCardType` VARCHAR(45) NULL DEFAULT NULL,
  `expirationDate` DATETIME NULL DEFAULT NULL,
  `securityCode` CHAR(3) NOT NULL,
  PRIMARY KEY (`creditCardNo`),
  INDEX `fk_cardCustomerID` (`customerID` ASC),
  CONSTRAINT `fk_cardCustomerID`
    FOREIGN KEY (`customerID`)
    REFERENCES `cinemaEBooking`.`Customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cinemaEBooking`.`Movie`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemaEBooking`.`Movie` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `ratingID` INT(11) NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  `trailerVideo` VARCHAR(45) NULL DEFAULT NULL,
  `trailerPicture` VARCHAR(45) NULL DEFAULT NULL,
  `director` VARCHAR(45) NULL DEFAULT NULL,
  `synopsis` TEXT NULL DEFAULT NULL,
  `review` TEXT NULL DEFAULT NULL,
  `rating` VARCHAR(45) NULL DEFAULT NULL,
  `producer` VARCHAR(45) NULL DEFAULT NULL,
  `cast` TEXT NULL DEFAULT NULL,
  `duration` TIMESTAMP(2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`, `ratingID`),
  INDEX `fk_Movie_USRating1` (`ratingID` ASC),
  CONSTRAINT `fk_Movie_USRating1`
    FOREIGN KEY (`ratingID`)
    REFERENCES `cinemaEBooking`.`USRating` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cinemaEBooking`.`Booking`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemaEBooking`.`Booking` (
  `id` INT(11) NOT NULL,
  `customerID` INT(11) NOT NULL,
  `movieID` INT(11) NOT NULL,
  `creditCardNo` CHAR(16) NOT NULL,
  `totalPrice` DOUBLE NOT NULL,
  `numTickets` INT(11) NOT NULL,
  `promoApplied` TINYINT(4) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_customerBookingID` (`customerID` ASC),
  INDEX `fk_movieBookingID` (`movieID` ASC),
  INDEX `fk_cardPaymentBookingID` (`creditCardNo` ASC),
  CONSTRAINT `fk_cardPaymentBookingID`
    FOREIGN KEY (`creditCardNo`)
    REFERENCES `cinemaEBooking`.`CardPayment` (`creditCardNo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_customerBookingID`
    FOREIGN KEY (`customerID`)
    REFERENCES `cinemaEBooking`.`Customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_movieBookingID`
    FOREIGN KEY (`movieID`)
    REFERENCES `cinemaEBooking`.`Movie` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cinemaEBooking`.`Hall`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemaEBooking`.`Hall` (
  `id` INT(11) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `totalSeats` INT(11) NOT NULL,
  `availableSeats` INT(11) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cinemaEBooking`.`Showtime`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemaEBooking`.`Showtime` (
  `id` INT(11) NOT NULL,
  `time` VARCHAR(45) NOT NULL,
  `date` DATE NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cinemaEBooking`.`MovieShow`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemaEBooking`.`MovieShow` (
  `id` INT(11) NOT NULL,
  `movieID` INT(11) NOT NULL,
  `showTimeID` INT(11) NOT NULL,
  `hallID` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_showtimeMovieShowID` (`showTimeID` ASC),
  INDEX `fk_movieMovieShowID` (`movieID` ASC),
  INDEX `fk_hallMovieShowID` (`hallID` ASC),
  CONSTRAINT `fk_hallMovieShowID`
    FOREIGN KEY (`hallID`)
    REFERENCES `cinemaEBooking`.`Hall` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_movieMovieShowID`
    FOREIGN KEY (`movieID`)
    REFERENCES `cinemaEBooking`.`Movie` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_showtimeMovieShowID`
    FOREIGN KEY (`showTimeID`)
    REFERENCES `cinemaEBooking`.`Showtime` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cinemaEBooking`.`Promo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemaEBooking`.`Promo` (
  `id` INT(11) NOT NULL,
  `bookingID` INT(11) NOT NULL,
  `code` VARCHAR(45) NOT NULL,
  `expirationDate` DATETIME NOT NULL,
  `discountPercent` DOUBLE NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `bookingID` (`bookingID` ASC),
  CONSTRAINT `bookingID`
    FOREIGN KEY (`bookingID`)
    REFERENCES `cinemaEBooking`.`Booking` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cinemaEBooking`.`Role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemaEBooking`.`Role` (
  `actorID` INT(11) NOT NULL,
  `movieID` INT(11) NOT NULL,
  `character` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`actorID`, `movieID`),
  INDEX `fk_Movie_has_Actor_Movie` (`movieID` ASC),
  CONSTRAINT `fk_Movie_has_Actor_Actor1`
    FOREIGN KEY (`actorID`)
    REFERENCES `cinemaEBooking`.`Actor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Movie_has_Actor_Movie`
    FOREIGN KEY (`movieID`)
    REFERENCES `cinemaEBooking`.`Movie` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cinemaEBooking`.`Seat`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemaEBooking`.`Seat` (
  `id` INT(11) NOT NULL,
  `hallID` INT(11) NOT NULL,
  `location` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_hallSeatID` (`hallID` ASC),
  CONSTRAINT `fk_hallSeatID`
    FOREIGN KEY (`hallID`)
    REFERENCES `cinemaEBooking`.`Hall` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cinemaEBooking`.`SeatShowtime`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemaEBooking`.`SeatShowtime` (
  `seatID` INT(11) NOT NULL,
  `showtimeID` INT(11) NOT NULL,
  `taken` TINYINT(4) NOT NULL,
  PRIMARY KEY (`seatID`, `showtimeID`),
  INDEX `fk_ShowTimeID_has_Seat_ShowTimeID1` (`showtimeID` ASC),
  CONSTRAINT `fk_ShowTimeID_has_Seat_Seat1`
    FOREIGN KEY (`seatID`)
    REFERENCES `cinemaEBooking`.`Seat` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ShowTimeID_has_Seat_ShowTimeID1`
    FOREIGN KEY (`showtimeID`)
    REFERENCES `cinemaEBooking`.`Showtime` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cinemaEBooking`.`Ticket`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemaEBooking`.`Ticket` (
  `id` INT(11) NOT NULL,
  `ageCategoryID` INT(11) NOT NULL,
  `bookingID` INT(11) NOT NULL,
  `seatID` INT(11) NOT NULL,
  `movieShowID` INT(11) NOT NULL,
  `price` DOUBLE NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_bookingTicketID` (`bookingID` ASC),
  INDEX `fk_seatTicketID` (`seatID` ASC),
  INDEX `fk_movieShowTicketID` (`movieShowID` ASC),
  INDEX `fk_Ticket_AgeCategory1` (`ageCategoryID` ASC),
  CONSTRAINT `fk_Ticket_AgeCategory1`
    FOREIGN KEY (`ageCategoryID`)
    REFERENCES `cinemaEBooking`.`AgeCategory` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_bookingTicketID`
    FOREIGN KEY (`bookingID`)
    REFERENCES `cinemaEBooking`.`Booking` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_movieShowTicketID`
    FOREIGN KEY (`movieShowID`)
    REFERENCES `cinemaEBooking`.`MovieShow` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_seatTicketID`
    FOREIGN KEY (`seatID`)
    REFERENCES `cinemaEBooking`.`Seat` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
