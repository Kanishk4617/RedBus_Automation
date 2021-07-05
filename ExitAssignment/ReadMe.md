#Automation Assignment

*[Visit Website](https://www.redbus.in/)*

---
#Module Description:

** 1.  Pages Package: ** 

_contains the page classes for all pages_

 classes contain locators and methods for the web elements

---

** 2. Test Package: **

 _contains the test cases for all pages_
 
 classes contain:  
 
 objects, and method calling from respective page class
 
 
---

** 3. Utils: ** 

_contains classes that have common usage throughout_

---

** 4. Drivers**

 _Folder contains drivers for _
 Chrome, Firefox & IE_

---

** 5. Failed Screenshots:** 

_ Folder where any failed screenshot gets saved_

---

** 6. log:** 

_ Folder contains the logs of a test run_

---

** 7. Reports:**

 _Folder contains the extent report generated after a test run_

---

** 8. Resources:** 

_Contains_


_ - config.properties file_ : contains the website url and browser options

_ -Data excel Sheet_ : excel file from where test data is fetched

_ -log4j. properties file_ : contains appenders for the log file, location and size of log file etc

---


** 9. test-output **

_contains_

_-docker-compose.yml file :_  initialization of services of chrome and firefox to start the docker functionality

_-pom.xml file :_ contains the dependencies required for code to run



---

###Steps to install external Jars/Custom Dependency
1. Go to project directory in cmd.

2. Open "ExternalJars" folder in cmd.

3. Execute the following command : 
 "mvn install:install-file -Dfile=ScreenshotUtility-0.0.1-SNAPSHOT.jar -DgroupId=ScreenshotUtility -DartifactId=ScreenshotUtility -Dversion=0.0.1-SNAPSHOT -Dpackaging=jar"
 
---
#### Steps to run the Project using Cmd:

1. Follow the steps to Install the custom dependency as mentioned above.

2. Then go back to project directory.

3. Run the command "mvn clean".

4. Run the command "mvn install".

---



**Run using testng:**

1. Go to the file testng.xml

2. Right click > run as TestNG Suite
---

#### Integration with Github and Jenkins
**Github Repository link :** *[Visit Github Repository](https://github.com/Kanishk4617/RedBus_Automation.git)*
or **github link**:- https://github.com/Kanishk4617/RedBus_Automation.git

** For Jenkins : ** Refer documentation in ./JenkinsScreenshots/JenkinsScreenshots.docx

---

#### Steps to run in docker
1. Open project directory in cmd.
2. Run following command: "docker-compose -f docker-compose.yml up -d"
3. Change configuration in config.properties.
4. To run test cases in parallel, add the following in testNG : **<suite thread-count="5" name="Suite" parallel="classes">**

---

