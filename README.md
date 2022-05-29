K-Pac Deployment Steps

Clone the project

git clone https://github.com/nishadh-dev/k-pac.git -b develop

or download the project from https://github.com/nishadh-dev/k-pac
![](/Users/nishadh/Desktop/Clone.png)


After the cloning the project navigate to folder K-PAC/Source

Make sure your folder has the file pom.xml

Run the command “mvn clean install”
![](/Users/nishadh/Desktop/mvn.png)


After running the command, it will generate a war file named k-pac.war in target folder.

![](/Users/nishadh/Desktop/Screenshot 2022-05-29 at 10.51.39 PM.png)

Copy that war file and put in web apps folder in tomcat.

Start the tomcat server.

Application will be running in http://localhost:port/k-pac

Make sure your local mysql server is up and running

Create below user and schema before running the application

CREATE USER IF NOT EXISTS 'k_pac_user_dev'@'%' IDENTIFIED BY 'kpac_7dev%'; 

CREATE DATABASE IF NOT EXISTS k_pac_dev CHARACTER SET utf8 COLLATE utf8_general_ci;

GRANT ALL ON k_pac_dev.* TO 'k_pac_user_dev'@'%';

FLUSH PRIVILEGES;


