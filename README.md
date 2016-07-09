[![Build Status](https://travis-ci.org/Drc0w/JukeBox.svg?branch=master)](https://travis-ci.org/Drc0w/JukeBox)

#What is JukeBox?

The goal of JukeBox is to be a lightweight and easy-to-use music reader.
It allows you to create multiple playlists, open folder and load songs from subfolders.
It also allows you to save your playlists.

JukeBox is not an awesome project, but its goal is to be honest with the users. It provides
an eas-to-use user interface in Swing, and some cool features.

#What are the pre-requisites?

JukeBox uses Java VM in order to run. So you have to install it if it is not done yet.
It is based on the JDK8 from oracle, but also works with open-jdk8.

If you are using Linux, you can install the jdk and the Java VM with this line:
```
sudo apt-get install openjdk-8-jdk openjdk-8-jre
```

In order to build JukeBox, you must have Maven. Version 3 of Maven is recommended.

If you are using Linux, you can install Maven with the following line:
```
sudo apt-get install maven
```

#How can I build JukeBox and start it?

This line will allow you to compile JukeBox:
```
mvn package
```

It will produce the file JukeBox-1.0-SNAPSHOT.jar in the folder target/.

You can start JukeBox with the following command:
```
java -jar target/JukeBox-1.0-SNAPSHOT.jar
```
or by double-clicking on the file.

#