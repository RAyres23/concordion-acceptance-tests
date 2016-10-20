# Acceptance Testing using Concordion

We will be exploring Acceptance Testing Tool [Concordion](http://concordion.org/) using Java.

To make sure that you can get in on the exercise, please make sure that you have Maven installed on your machine. If you don't it's pretty simple (everything explained here is basically a copy of what is explained [here](http://maven.apache.org/install.html)) so feel free to check it out if you like.

If you have an IDE that already has Maven integrated, just open the project in this repository and you're good to go. NetBeans and Eclipse have Maven integration.

To install Maven simply download and extract the apache-maven-3.3.9-bin[.zip for Windows and .tar.gz for Unix-Based Systems] file from [here](http://maven.apache.org/download.cgi) to a folder of your choice.

After it's extracted add the bin directory of the created directory apache-maven-3.3.9 (apache-maven-3.3.9\bin) to the PATH environment variable.

Open a command prompt and run `mvn -v`. The result should be something like

```
Apache Maven 3.3.3 (7994120775791599e205a5524ec3e0dfe41d4a06; 2015-04-22T04:57:37-07:00)
Maven home: /opt/apache-maven-3.3.3
Java version: 1.8.0_45, vendor: Oracle Corporation
Java home: /Library/Java/JavaVirtualMachines/jdk1.8.0_45.jdk/Contents/Home/jre
Default locale: en_US, platform encoding: UTF-8
OS name: "mac os x", version: "10.8.5", arch: "x86_64", family: "mac"
```

After you clone this repository, open a command prompt and go to the project folder `SpreadsheetEngine`

In there you can:

###Build your project
```
mvn clean install
```

###Test your project
```
mvn test
```

###Run your project
```
mvn exec:java
```
