# Interview_Project
Create a test framework using java and selenium. The framework must use page object model and
page factory (https://github.com/SeleniumHQ/selenium/wiki/PageFactory) and 
HTML Element (https://github.com/yandex-qatools/htmlelements) framework

Browser: Chrome

Tools:

Test framework: TestNG
Build: Gradle
Logger: Log4j2
Dependency Injection: Google Guice
Additional: -Singleton pattern for Driver

Using that framework automate the following test case:
Go to https://myrcc.rcdev.redcapcloud.com/
Login with the user created in precondition
Click on 'Interview' card                                          
Click on the 'Demo' link from FORMS panel                        
Fill all the fields from the form with valid data
Click 'Cancel' button                                               
Verify that the status for 'Demo' is "Not Started"   
