SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS `kitabook` ;
CREATE SCHEMA IF NOT EXISTS `kitabook` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `kitabook` ;

-- -----------------------------------------------------
-- Table `kitabook`.`Publisher`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `kitabook`.`Publisher` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `commercial_name` VARCHAR(100) NULL ,
  `corporate_name` VARCHAR(100) NULL ,
  `creation_date` DATE NULL ,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `commercial_name_UNIQUE` (`commercial_name` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kitabook`.`Book`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `kitabook`.`Book` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `title` VARCHAR(100) NULL ,
  `date_publishing` DATE NULL ,
  `pages_number` INT NULL ,
  `isbn` VARCHAR(45) NULL ,
  `version` int(11) NOT NULL,
  `Publisher_idPublisher` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_Book_Publisher1` (`Publisher_idPublisher` ASC) ,
  CONSTRAINT `fk_Book_Publisher1`
    FOREIGN KEY (`Publisher_idPublisher` )
    REFERENCES `kitabook`.`Publisher` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kitabook`.`Participant`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `kitabook`.`Participant` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `login` VARCHAR(10) NOT NULL ,
  `mdp` VARCHAR(45) NULL ,
  `first_name` VARCHAR(45) NULL ,
  `last_name` VARCHAR(45) NULL ,
  `occupation` VARCHAR(45) NULL ,
  `birthday` DATE NULL ,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `login_UNIQUE` (`login` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kitabook`.`Contributor`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `kitabook`.`Contributor` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `last_name` VARCHAR(45) NULL ,
  `first_name` VARCHAR(45) NULL ,
  `occupation` VARCHAR(45) NULL ,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kitabook`.`Topic`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `kitabook`.`Topic` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(100) NULL ,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kitabook`.`InterestedInPublisher`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `kitabook`.`InterestedInPublisher` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `Participant_idParticipant` INT NOT NULL ,
  `Publisher_idPublisher` INT NOT NULL ,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`) ,
  UNIQUE KEY `UNQ1_INTERESTEDINPUB` (`Participant_idParticipant`,`Publisher_idPublisher`),
  INDEX `fk_User_has_Publisher_Publisher1` (`Publisher_idPublisher` ASC) ,
  INDEX `fk_User_has_Publisher_User1` (`Participant_idParticipant` ASC) ,
  CONSTRAINT `fk_User_has_Publisher_User1`
    FOREIGN KEY (`Participant_idParticipant` )
    REFERENCES `kitabook`.`Participant` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_has_Publisher_Publisher1`
    FOREIGN KEY (`Publisher_idPublisher` )
    REFERENCES `kitabook`.`Publisher` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kitabook`.`InterestedInContributor`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `kitabook`.`InterestedInContributor` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `Contributor_idContributor` INT NOT NULL ,
  `User_idParticipant` INT NOT NULL ,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`) ,
  UNIQUE KEY `UNQ2_INTERESTEDINCONTRIB` (`Contributor_idContributor`,`User_idParticipant`),
  INDEX `fk_Contributor_has_User_User1` (`User_idParticipant` ASC) ,
  INDEX `fk_Contributor_has_User_Contributor1` (`Contributor_idContributor` ASC) ,
  CONSTRAINT `fk_Contributor_has_User_Contributor1`
    FOREIGN KEY (`Contributor_idContributor` )
    REFERENCES `kitabook`.`Contributor` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Contributor_has_User_User1`
    FOREIGN KEY (`User_idParticipant` )
    REFERENCES `kitabook`.`Participant` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kitabook`.`InterestedInTopic`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `kitabook`.`InterestedInTopic` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `User_idParticipant` INT NOT NULL ,
  `Topic_idTopic` INT NOT NULL ,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`) ,
  UNIQUE KEY `UNQ3_INTERESTEDINTOPIC` (`User_idParticipant`,`Topic_idTopic`),
  INDEX `fk_User_has_Topic_Topic1` (`Topic_idTopic` ASC) ,
  INDEX `fk_User_has_Topic_User1` (`User_idParticipant` ASC) ,
  CONSTRAINT `fk_User_has_Topic_User1`
    FOREIGN KEY (`User_idParticipant` )
    REFERENCES `kitabook`.`Participant` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_has_Topic_Topic1`
    FOREIGN KEY (`Topic_idTopic` )
    REFERENCES `kitabook`.`Topic` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kitabook`.`Preface`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `kitabook`.`Preface` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `Book_idBook` INT NOT NULL ,
  `Contributor_idContributor` INT NOT NULL ,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`) ,
  UNIQUE KEY `UNQ4_BOOKCONTR` (`Book_idBook`,`Contributor_idContributor`),
  INDEX `fk_Book_has_Contributor_Contributor1` (`Contributor_idContributor` ASC) ,
  INDEX `fk_Book_has_Contributor_Book1` (`Book_idBook` ASC) ,
  CONSTRAINT `fk_Book_has_Contributor_Book1`
    FOREIGN KEY (`Book_idBook` )
    REFERENCES `kitabook`.`Book` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Book_has_Contributor_Contributor1`
    FOREIGN KEY (`Contributor_idContributor` )
    REFERENCES `kitabook`.`Contributor` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kitabook`.`Write`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `kitabook`.`Write` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `Contributor_idContributor` INT NOT NULL ,
  `Book_idBook` INT NOT NULL ,
  `writing_date` DATE NULL ,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`) ,
  UNIQUE KEY `UNQ5_CONTRBOOK` (`Contributor_idContributor`,`Book_idBook`),
  INDEX `fk_Contributor_has_Book_Book1` (`Book_idBook` ASC) ,
  INDEX `fk_Contributor_has_Book_Contributor1` (`Contributor_idContributor` ASC) ,
  CONSTRAINT `fk_Contributor_has_Book_Contributor1`
    FOREIGN KEY (`Contributor_idContributor` )
    REFERENCES `kitabook`.`Contributor` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Contributor_has_Book_Book1`
    FOREIGN KEY (`Book_idBook` )
    REFERENCES `kitabook`.`Book` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kitabook`.`Translate`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `kitabook`.`Translate` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `Book_idBook` INT NOT NULL ,
  `Contributor_idContributor` INT NOT NULL ,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`) ,
  UNIQUE KEY `UNQ6_BOOKCONTR` (`Contributor_idContributor`,`Book_idBook`),
  INDEX `fk_Book_has_Contributor_Contributor2` (`Contributor_idContributor` ASC) ,
  INDEX `fk_Book_has_Contributor_Book2` (`Book_idBook` ASC) ,
  CONSTRAINT `fk_Book_has_Contributor_Book2`
    FOREIGN KEY (`Book_idBook` )
    REFERENCES `kitabook`.`Book` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Book_has_Contributor_Contributor2`
    FOREIGN KEY (`Contributor_idContributor` )
    REFERENCES `kitabook`.`Contributor` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kitabook`.`Adress`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `kitabook`.`Adress` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `street_number` INT NULL ,
  `street` VARCHAR(300) NULL ,
  `postal_code` VARCHAR(6) NULL ,
  `city` VARCHAR(45) NULL ,
  `country` VARCHAR(45) NULL ,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kitabook`.`Habite`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `kitabook`.`Habite` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `Participant_idParticipant` INT NOT NULL ,
  `Adress_idAdress` INT NOT NULL ,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`) ,
  UNIQUE KEY `UNQ7_PARTADR` (`Participant_idParticipant`,`Adress_idAdress`),
  INDEX `fk_Participant_has_Adress_Adress1` (`Adress_idAdress` ASC) ,
  INDEX `fk_Participant_has_Adress_Participant1` (`Participant_idParticipant` ASC) ,
  CONSTRAINT `fk_Participant_has_Adress_Participant1`
    FOREIGN KEY (`Participant_idParticipant` )
    REFERENCES `kitabook`.`Participant` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Participant_has_Adress_Adress1`
    FOREIGN KEY (`Adress_idAdress` )
    REFERENCES `kitabook`.`Adress` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kitabook`.`Thematizes`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `kitabook`.`Thematizes` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `Book_idBook` INT NOT NULL ,
  `Topic_idTopic` INT NOT NULL ,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`) ,
  UNIQUE KEY `UNQ8_BOOKTOPIC` (`Book_idBook`,`Topic_idTopic`),
  INDEX `fk_Book_has_Topic_Topic1` (`Topic_idTopic` ASC) ,
  INDEX `fk_Book_has_Topic_Book1` (`Book_idBook` ASC) ,
  CONSTRAINT `fk_Book_has_Topic_Book1`
    FOREIGN KEY (`Book_idBook` )
    REFERENCES `kitabook`.`Book` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Book_has_Topic_Topic1`
    FOREIGN KEY (`Topic_idTopic` )
    REFERENCES `kitabook`.`Topic` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kitabook`.`Read`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `kitabook`.`Read` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `Book_idBook` INT NOT NULL ,
  `Participant_idParticipant` INT NOT NULL ,
  `pages_number` INT NULL ,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`) ,
  UNIQUE KEY `UNQ9_BOOKPARTREAD` (`Book_idBook`,`Participant_idParticipant`),
  INDEX `fk_Book_has_Participant_Participant1` (`Participant_idParticipant` ASC) ,
  INDEX `fk_Book_has_Participant_Book1` (`Book_idBook` ASC) ,
  CONSTRAINT `fk_Book_has_Participant_Book1`
    FOREIGN KEY (`Book_idBook` )
    REFERENCES `kitabook`.`Book` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Book_has_Participant_Participant1`
    FOREIGN KEY (`Participant_idParticipant` )
    REFERENCES `kitabook`.`Participant` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kitabook`.`WishRead`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `kitabook`.`WishRead` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `Book_idBook` INT NOT NULL ,
  `Participant_idParticipant` INT NOT NULL ,
  `planified_date` DATE NULL ,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`) ,
  UNIQUE KEY `UNQ10_BOOKPARTWISHREAD` (`Book_idBook`,`Participant_idParticipant`),
  INDEX `fk_Book_has_Participant_Participant2` (`Participant_idParticipant` ASC) ,
  INDEX `fk_Book_has_Participant_Book2` (`Book_idBook` ASC) ,
  CONSTRAINT `fk_Book_has_Participant_Book2`
    FOREIGN KEY (`Book_idBook` )
    REFERENCES `kitabook`.`Book` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Book_has_Participant_Participant2`
    FOREIGN KEY (`Participant_idParticipant` )
    REFERENCES `kitabook`.`Participant` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kitabook`.`Readed`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `kitabook`.`Readed` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `Participant_idParticipant` INT NOT NULL ,
  `Book_idBook` INT NOT NULL ,
  `version` int(11) NOT NULL,
  `when` DATE NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE KEY `UNQ11_BOOKPARTREADED` (`Book_idBook`,`Participant_idParticipant`),
  INDEX `fk_Participant_has_Book_Book1` (`Book_idBook` ASC) ,
  INDEX `fk_Participant_has_Book_Participant1` (`Participant_idParticipant` ASC) ,
  CONSTRAINT `fk_Participant_has_Book_Participant1`
    FOREIGN KEY (`Participant_idParticipant` )
    REFERENCES `kitabook`.`Participant` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Participant_has_Book_Book1`
    FOREIGN KEY (`Book_idBook` )
    REFERENCES `kitabook`.`Book` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kitabook`.`Comment`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `kitabook`.`Comment` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `Book_idBook` INT NOT NULL ,
  `Participant_idParticipant` INT NOT NULL ,
  `version` int(11) NOT NULL,
  `comment` VARCHAR(45) NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE KEY `UNQ12_BOOKPARTCOMMENT` (`Book_idBook`,`Participant_idParticipant`),
  INDEX `fk_Book_has_Participant_Participant3` (`Participant_idParticipant` ASC) ,
  INDEX `fk_Book_has_Participant_Book3` (`Book_idBook` ASC) ,
  CONSTRAINT `fk_Book_has_Participant_Book3`
    FOREIGN KEY (`Book_idBook` )
    REFERENCES `kitabook`.`Book` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Book_has_Participant_Participant3`
    FOREIGN KEY (`Participant_idParticipant` )
    REFERENCES `kitabook`.`Participant` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kitabook`.`Comments`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `kitabook`.`Comments` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kitabook`.`UserCommentedBook`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `kitabook`.`UserCommentedBook` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `Comment_Book_idBook` INT NOT NULL ,
  `Comment_Participant_idParticipant` INT NOT NULL ,
  `Comments_idComments` INT NOT NULL ,
  `version` int(11) NOT NULL,
  `comment` TEXT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE KEY `UNQ13_BOOKPARTCOMMENTS` (`Comment_Book_idBook`,`Comment_Participant_idParticipant`, `Comments_idComments`),
  INDEX `fk_Comment_has_Comments_Comments1` (`Comments_idComments` ASC) ,
  INDEX `fk_Comment_has_Comments_Comment1` (`Comment_Book_idBook` ASC, `Comment_Participant_idParticipant` ASC) ,
  CONSTRAINT `fk_Comment_has_Comments_Comment1`
    FOREIGN KEY (`Comment_Book_idBook` , `Comment_Participant_idParticipant` )
    REFERENCES `kitabook`.`Comment` (`Book_idBook` , `Participant_idParticipant` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Comment_has_Comments_Comments1`
    FOREIGN KEY (`Comments_idComments` )
    REFERENCES `kitabook`.`Comments` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kitabook`.`InterestedInParticipant`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `kitabook`.`InterestedInParticipant` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `InterstedP_idParticipant` INT NOT NULL ,
  `InterestingP_idParticipant` INT NOT NULL ,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`) ,
  UNIQUE KEY `UNQ14_INTERINPART` (`InterstedP_idParticipant`,`InterestingP_idParticipant`),
  INDEX `fk_Participant_has_Participant_Participant2` (`InterestingP_idParticipant` ASC) ,
  INDEX `fk_Participant_has_Participant_Participant1` (`InterstedP_idParticipant` ASC) ,
  CONSTRAINT `fk_Participant_has_Participant_Participant1`
    FOREIGN KEY (`InterstedP_idParticipant` )
    REFERENCES `kitabook`.`Participant` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Participant_has_Participant_Participant2`
    FOREIGN KEY (`InterestingP_idParticipant` )
    REFERENCES `kitabook`.`Participant` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kitabook`.`Chronic`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `kitabook`.`Chronic` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `Participant_idParticipant` INT NOT NULL ,
  `Book_idBook` INT NOT NULL ,
  `chronique` LONGTEXT NULL ,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`) ,
  UNIQUE KEY `UNQ15_PARTBOOKCHRONIC` (`Participant_idParticipant`,`Book_idBook`),
  INDEX `fk_Participant_has_Book_Book2` (`Book_idBook` ASC) ,
  INDEX `fk_Participant_has_Book_Participant2` (`Participant_idParticipant` ASC) ,
  CONSTRAINT `fk_Participant_has_Book_Participant2`
    FOREIGN KEY (`Participant_idParticipant` )
    REFERENCES `kitabook`.`Participant` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Participant_has_Book_Book2`
    FOREIGN KEY (`Book_idBook` )
    REFERENCES `kitabook`.`Book` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kitabook`.`Summarize`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `kitabook`.`Summarize` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `Participant_idParticipant` INT NOT NULL ,
  `Book_idBook` INT NOT NULL ,
  `summary` TINYTEXT NULL ,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`) ,
  UNIQUE KEY `UNQ16_PARTBOOKSUMM` (`Participant_idParticipant`,`Book_idBook`),
  INDEX `fk_Participant_has_Book_Book3` (`Book_idBook` ASC) ,
  INDEX `fk_Participant_has_Book_Participant3` (`Participant_idParticipant` ASC) ,
  CONSTRAINT `fk_Participant_has_Book_Participant3`
    FOREIGN KEY (`Participant_idParticipant` )
    REFERENCES `kitabook`.`Participant` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Participant_has_Book_Book3`
    FOREIGN KEY (`Book_idBook` )
    REFERENCES `kitabook`.`Book` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kitabook`.`MindMap`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `kitabook`.`MindMap` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `title` VARCHAR(100) NOT NULL ,
  `mindMap` BLOB NOT NULL ,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kitabook`.`DoMap`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `kitabook`.`DoMap` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `MindMap_idMindMap` INT NULL ,
  `Participant_idParticipant` INT NULL ,
  `Book_idBook` INT NOT NULL ,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`) ,
  UNIQUE KEY `UNQ17_PARTBOOKMAP` (`MindMap_idMindMap`,`Participant_idParticipant`,`Book_idBook`),
  INDEX `fk_MindMap_has_Participant_Participant1` (`Participant_idParticipant` ASC) ,
  INDEX `fk_MindMap_has_Participant_MindMap1` (`MindMap_idMindMap` ASC) ,
  INDEX `fk_MindMap_has_Participant_Book1` (`Book_idBook` ASC) ,
  CONSTRAINT `fk_MindMap_has_Participant_MindMap1`
    FOREIGN KEY (`MindMap_idMindMap` )
    REFERENCES `kitabook`.`MindMap` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_MindMap_has_Participant_Participant1`
    FOREIGN KEY (`Participant_idParticipant` )
    REFERENCES `kitabook`.`Participant` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_MindMap_has_Participant_Book1`
    FOREIGN KEY (`Book_idBook` )
    REFERENCES `kitabook`.`Book` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kitabook`.`Habite`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `kitabook`.`Habite` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `Contributor_idContributor` INT NOT NULL ,
  `Adress_idAdress` INT NOT NULL ,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`) ,
  UNIQUE KEY `UNQ18_CONTRADR` (`Contributor_idContributor`,`Adress_idAdress`),
  INDEX `fk_Participant_has_Adress_Adress1` (`Adress_idAdress` ASC) ,
  INDEX `fk_Participant_has_Adress_Contributor1` (`Contributor_idContributor` ASC) ,
  CONSTRAINT `fk_Participant_has_Adress_Participant1`
    FOREIGN KEY (`Contributor_idContributor` )
    REFERENCES `kitabook`.`Contributor` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Participant_has_Adress_Adress1`
    FOREIGN KEY (`Adress_idAdress` )
    REFERENCES `kitabook`.`Adress` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kitabook`.`hasHeadQuarter`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `kitabook`.`hasHeadQuarter` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `Publisher_idPublisher` INT NOT NULL ,
  `Adress_idAdress` INT NOT NULL ,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`) ,
  UNIQUE KEY `UNQ19_PUBLADRHEADERQUART` (`Publisher_idPublisher`,`Adress_idAdress`),
  INDEX `fk_Publisher_has_Adress_Adress1` (`Adress_idAdress` ASC) ,
  INDEX `fk_Publisher_has_Adress_Publisher1` (`Publisher_idPublisher` ASC) ,
  CONSTRAINT `fk_Publisher_has_Adress_Publisher1`
    FOREIGN KEY (`Publisher_idPublisher` )
    REFERENCES `kitabook`.`Publisher` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Publisher_has_Adress_Adress1`
    FOREIGN KEY (`Adress_idAdress` )
    REFERENCES `kitabook`.`Adress` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
