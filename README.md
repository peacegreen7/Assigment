# Assessment configuration
##Prepare environment

- Step 1: Install JDK: [Tutorial](https://www.guru99.com/install-java.html)
- Step 2: Install Eclipse: [Tutorial](https://www.eclipse.org/downloads/)
- Step 3: Install Maven and set up your eclipse. Refer [Tutorial](https://www.guru99.com/maven-jenkins-with-selenium-complete-tutorial.html)
- Step 4: Download [Selenium Client & WebDriver Language Bindings](https://selenium-release.storage.googleapis.com/3.141/selenium-java-3.141.59.zip)
- Step 5: Check your browser Chrome version then go to [Link](https://chromedriver.chromium.org/downloads) to find and download the suitable Chrome version. 


##Import Project

- Step 1: Open Eclipse
- Step 2: Open File->Open project from file system
- Step 3: Select the location of the Source Code
- Step 4: Make sure the Project you want is checked, then click Finish.
- Step 5: Click on project name, then click on "driver" folder and replace file "chromedriver.exe" in folder "driver" using file you have recently downloaded in step preparation
- Step 6: Right-click on Project > Select Run As > Maven build path. 
- Step 7: Now you need to add Selenium WebDriver’s Jar files into Java build path.
1) Right-click on Project > Select Properties > Java build path. Then navigate to Libraries tab and click Add External JARs.
2) Add Selenium Java jar, you may add the source file too.
3) Add all the jars from the libs folder as well.
4) Click OK.
