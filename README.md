# Welcome to Sary Task

This is a simple maven Java project using Shaft Engine framework to automate some simple scenarios in [Booking](https://www.booking.com/) website.

## How to install 
***Before you start make sure that you have already installed the following on your machine:***
 1. [Java](https://www.java.com/en/download/manual.jsp) JDK.
 2. [Apache maven](https://maven.apache.org/).
 3. IDE as [**_intellij_**](https://www.jetbrains.com/idea/) or [**_Eclipse_**](https://www.eclipse.org/).
 
***Steps to run the project:***

 1. Click on "Clone" button and copy the link.
 2. Open Intellij IDE and create new project from source control.
 3. Paste the URL which copied and set the path which you want to add your cloned project.
 4. Wait until all dependencies are finishing the setup.
 5. Click on "Run" tab > Edit configuration>Templates>TestNG>Listeners> Add the three listeners of shaft engine com.shaft.tools.* , note that is only required for first time configuration and on intelij IDE only ![Listeners of shaft](https://camo.githubusercontent.com/fab0e9219fafaecac372c6d28693097b78c61b8a193eb78ec3929a51dac787ec/68747470733a2f2f64726976652e676f6f676c652e636f6d2f75633f6578706f72743d646f776e6c6f61642669643d31376c796b4a794361435459676e6d5a59304e427a665778574c51477a784f7955)
 7. In the project panel click on "SaryTask folder, Then open the path "src/test/java/".
 8. Run Tests suit.

***Allure HTML Report:***
After every execution you will have a full clear report of your suite generate automatically

## Technologies used in the project

 - Shaft Engine framework [GitHub Link](https://github.com/MohabMohie/SHAFT_ENGINE)
 - Maven
 - Junit
 - Allure html reports
