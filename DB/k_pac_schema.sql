CREATE USER IF NOT EXISTS 'k_pac_user_dev'@'%' IDENTIFIED BY 'kpac_7dev%';
CREATE DATABASE IF NOT EXISTS k_pac_dev CHARACTER SET utf8 COLLATE utf8_general_ci;
GRANT ALL ON k_pac_dev.* TO 'k_pac_user_dev'@'%';
FLUSH PRIVILEGES;

# In clude login to the user

CREATE  TABLE IF NOT EXISTS k_pac_dev.k_pac (
  id INT  NOT NULL AUTO_INCREMENT ,
  title VARCHAR(250) NOT NULL ,
  description VARCHAR(2000) ,
  creation_date DATE ,
  PRIMARY KEY (id) )
ENGINE = InnoDB;

CREATE  TABLE IF NOT EXISTS k_pac_dev.set (
  id INT  NOT NULL AUTO_INCREMENT ,
  title VARCHAR(250) NOT NULL ,
  PRIMARY KEY (id) )
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS k_pac_dev.k_pac_set (
    id INT  NOT NULL AUTO_INCREMENT ,
    k_pac_id INT NULL,
    set_id INT  NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (k_pac_id) REFERENCES k_pac_dev.k_pac(id),
    FOREIGN KEY (set_id) REFERENCES k_pac_dev.set(id))
ENGINE = InnoDB; 