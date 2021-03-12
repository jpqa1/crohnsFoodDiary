# CRUD PROJECT BACKEND

This is the README for my

# Crohns Food Diary

## Contents

1. Resources
2. Brief
3. Kanban Board
4. Database Structure
5. Data Stack
6. Testing
7. Front-end
8. Stretch Goals
9. Author

## Resources

* Presentation [located here](https://docs.google.com/presentation/d/1L9vyf0BpCYAN55QdCihMbbDBuXP-SayTcm5HaDCoV0U/edit?usp=sharing)
* Jira Board [located here](https://jp22237.atlassian.net/secure/RapidBoard.jspa?rapidView=1&projectKey=CFD&atlOrigin=eyJpIjoiMTg0ZTFkMDA2YmU0NGVmMGI1MWE4Mjk1MzIzZGY5NWYiLCJwIjoiaiJ9)
* Front-end Github Repo [located here](https://github.com/jpqa1/crohnsFoodDiaryFrontEnd)

## Brief

To create a fully functional CRUD application encompassing a fully functional front end. The CRUD application will be built utilising the supporting tools, methodologies and technologies that encapsulate the concepts covered during the training.

This project will involve concepts from all core training modules; more specificall:

* Project Management (Kanban Board + Version Control)
* Databases
* JAVA
* Spring Boot
* HTML + CSS + JAVASCRIPT
* Back-end testing (Junit and Mockito)
* Front-end testing (Selenium)

## Kanban Board
My Kanban board for this project is available [here](https://jp22237.atlassian.net/secure/RapidBoard.jspa?rapidView=1&projectKey=CFD&atlOrigin=eyJpIjoiMTg0ZTFkMDA2YmU0NGVmMGI1MWE4Mjk1MzIzZGY5NWYiLCJwIjoiaiJ9). For the Kanban board I used Jira Software and modelled it as an Agile Scrum Board.

![Jira Board](https://i.imgur.com/Ch9ykSI.png)

An example of a user strory is below:

![user story](https://i.imgur.com/ojK5BVK.png)

## Database Structure
The image below is an entity relationship diagram (ERD) for the database for my project.

![ERD](https://i.imgur.com/fPHUDoY.png)

## Data Stack

### Database
Two databases have been used for this project. A local H2 Console with a food-data.sql and a food-schema.sql that have been saved in the back end to auto populate the fields to extend. Using a local database provides a convenient and fast approach to testing the back end. A MYSQL database has been used for production purposes. 

### Backend
The back end is powered by Java using the Spring Boot Framework. This allows rapid and simple deployment of an integration structure between the database and the front-end. The back-end has the DB logic as well as the HTTP requests and allows the front-end to access the DB and work with the data there.

## Front-end
The front end is powered by HTML, CSS and Javascript, utilising the Bootstrap framework to fine tune the layout of the web page using containers, columns and rows in addition to providing a modal element for use with the update method in the application. HTML and CSS have been used to produce the look of the website and javascript has been used to get data from the DB to populate the elements on the webpage.

A screenshot of my final front-end can be seen below:

![front-end](https://i.imgur.com/ad6xfvt.png)
![front-end](https://i.imgur.com/hj1xByk.png)
![front-end](https://i.imgur.com/EbYjJtB.png)

## Testing
The total test coverage of my back end came to ?????% as shown in the screenshot below.

![coverage](https://imgur.com/MQMRKyw)

## Stretch Goals
Further improvements would consist of:

* Restricting data entry to prevent inaccurate records
* Functionality improvement of the application by adding a related database, allowing the user to create a meal plan for the day consisting of only foods that have a positive effect.
* Functionality to add warnings prior to the user deleting or updating records.
* Functionality to improve updating records, prepopulating the form with the current data so the user is only required to modify the data that needs updating.

## Author and Acknowledgeents
I would like to acknowledge the QA trainers in particular Jordan Harrison and Aswene Sivaraj for helping me to complete this project as well as my BAE cohort in particular to my colleagues in Team 2.

Project by Jonathan Platt.




