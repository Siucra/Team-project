This is team 5's github repository for the team project module.
This github holds files related to "Grade-tracker" application.

Grade-Tracker is an advanced Java-based GUI application developed using Eclipse IDE, JavaFX and Gluon Scene Builder. It allows Leaving Certificate students to track their grades by subject and estimate their potential points for university applications.

Users are prompted to log in when launching the application. If they do not already have an account they can create one through the sign-up process. After logging in the user is presented with a list of their saved subjects along with their average score for each subject. If no subjects have been added yet the system displays a message prompting the student to add their first subject.

When adding a subject, students can select from a list of Leaving Certificate subjects and choose the appropriate level (Ordinary or Higher) as each level corresponds to different point values. Users can also edit an existing subject by selecting it which allows them to add a test score, remove a test score or delete the subject entirely.

 --------------------CONFIGURATION  -------------------- 
 
- Requirements!!!
Before running the project, make sure the following are installed:
- Eclipse IDE
- Gluon Scene Builder
- Git
- JavaFX

------------ Setting Up JavaFX in Eclipse ------------
1. Download JavaFX SDK
- Download the JavaFX SDK from the official website and extract it to a location on your computer.

2. Install JavaFX Plugin
- Install the JavaFX plugin in Eclipse if it is not already installed.

3. Create a New JavaFX Project
- In Eclipse:
	File → New → JavaFX Project

4. Create a User Library
- In Eclipse navigate to:
	Window → Preferences → Java → Build Path → User Libraries

Then:
Click New
Enter a library name (e.g. JavaFX)
	Click Add External JARs

Locate the lib folder inside the JavaFX SDK downloaded earlier
	Click Apply and Close

5. Set the User Library
- Right-click your project folder:
	Build Path → Add Libraries → User Library

Select the JavaFX library created in Step 4 and click Finish.

6. Configure Build Path
- Right-click the project folder:
	Build Path → Configure Build Path

Move the JavaFX library into the Modulepath.

7. Add VM Arguments
- Right-click the project folder:
	Run As → Run Configurations → Arguments

Add the following to VM Arguments:
--module-path "\path\to\javafx-sdk\lib" --add-modules javafx.controls,javafx.fxml

Replace the path with the location of your JavaFX SDK.

8. Run the Program
- Run the application.
  If setup is correct, a blank JavaFX window should appear.

------------ Connecting Scene Builder ------------

In Eclipse go to:
Window → Preferences → JavaFX  
Click Browse

Locate SceneBuilder.exe
Click Apply and Close

Scene Builder is now connected to Eclipse.

------------ Reference Tutorials ------------

The setup process was based on the following tutorials:

https://www.youtube.com/watch?v=_7OM-cMYWbQ

https://www.youtube.com/watch?v=-Obxf6NjnbQ

This project is done by:
- Denise Balasmeh X24701351 (Siucra)
- Celina Moali - X23477232 (xivicece)
- Ciara Lynch - X23461962 (ciaral05)
- Safiat Dao - X23160306 (safiatdao)
