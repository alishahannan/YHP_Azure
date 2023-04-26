# Youth Homelessness Project
## Youth Homelessness Project for Valencia BAS CTSD Senior Capstone - Spring 2023
### Continuation of Capstone Summer and Fall 2022 Project

This is a Java Spring MVC project which collects data via survey and presents helpful resources based on responses. The anonymous data collected can then be used by city officials to generate reports which will help them visualize the problem and develop targeted solutions.

Survey questions were inspired by this [Student Financial Wellness Survey](https://valenciacollege.edu/academics/analytics-and-planning/institutional-evaluation/research-and-evaluation/documents/valencia_fall2020-sfws-school-report.pdf).

### Deployed Website
https://yhp.azurewebsites.net/

## Azure DevOps

To edit the files with local IDE:

### IntelliJ IDEA
1. Install the Azure DevOps plugin.
2. Click the "Get From VCS" button.
3. Select "Azure DevOps Git" for Version control.
4. Click Clone.
5. Follow Sign In prompts.
6. Select YHP_AZURE as the repository.
7. Chose your preferred parent directory.
8. Click Clone.

You should now have the Azure DevOps files available to edit on your local machine.

#### Database Connection
URL: jdbc:mysql://studentsuccess.mysql.database.azure.com:3306?serverTimezone=UTC&useSSL=true&requireSSL=false

### Database Login
User: test

Password: rFhuj3849fsd

### To Run Program In Azure DevOps:
Navigate to Pipelines and Run the Youth Homelessness Project-Maven-CI pipeline.

### Website Test Users:
# Student Account
Username: student

Password: student 

# Employee Account
Username: testEmp 

Password: employee

# Admin Account
Username: testAdmin

Password: admin
