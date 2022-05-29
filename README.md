K-Pac Deployment Steps

Clone the project

git clone https://github.com/nishadh-dev/k-pac.git -b develop

or download the project from https://github.com/nishadh-dev/k-pac

![image](https://user-images.githubusercontent.com/91365136/170892907-bf0d5e02-f655-4af6-8338-0629dbfd8d25.png)

After the cloning the project navigate to folder K-PAC/Source

Make sure your folder has the file pom.xml

Run the command “mvn clean install”

![image](https://user-images.githubusercontent.com/91365136/170892911-203a4d38-2685-4e98-9c59-35f04a37d935.png)



After running the command, it will generate a war file named k-pac.war in target folder.

![image](https://user-images.githubusercontent.com/91365136/170892923-a63d6842-1b3a-4c5c-9b0f-6c0ac5813933.png)



Copy that war file and put in web apps folder in tomcat.

Start the tomcat server.

Application will be running in http://localhost:port/k-pac

Make sure your local mysql server is up and running

Create below user and schema before running the application

CREATE USER IF NOT EXISTS 'k_pac_user_dev'@'%' IDENTIFIED BY 'kpac_7dev%'; 

CREATE DATABASE IF NOT EXISTS k_pac_dev CHARACTER SET utf8 COLLATE utf8_general_ci;

GRANT ALL ON k_pac_dev.* TO 'k_pac_user_dev'@'%';

FLUSH PRIVILEGES;


