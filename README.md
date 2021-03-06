# JWDApplications
# Servlet Assignment – 1
1. Develop a servlet to get the client information who made the request.
2. Make a student registration form and retrieve the value in the servlet.
Note: Take all possible fields and do the validation.
3. Develop a servlet to illustrate the use of Session Tracking.
4. Develop a servlet to illustrate the use of Servlet Config and Servlet Context.
5. Do the following:
 Create department and employee table with appropriate fields and
integrity constraints.
 Write Servlet to insert , update , delete and display the records in
department and employee. (Do validate the fields in filter)
 Display the following reports:
 department wise employees.
 Print department-wise total salary of employees. (Use Stored
procedure call using JDBC)
6. To control the no of transaction with database server, It is decided to go for
batch execution. That means collect all the DML SQL operations and then
execute them in a batch. Write JDBC code for this purpose.
7. A retail company with department stores in many major Indian cities. The
company has a large number of employees and sells a varied line of
products. To manage all information about the company structure and
products, a database system is used. The company has a number of
employees, who sell items at the different stores. Sales are registered in the
sale and purchase tables. The company has contracts with various suppliers,
who supply items for sale . Create appropriate database for the above
scenario.
 Write JDBC application for the scenario which should contain
 Data entry form for company, employee, stores, items, customers,
suppliers, sales and purchase.
 Give the report of employeewise sales, supplierwise purchase ,
storwise sales and purchase of various items with their cost and stock
report of all items.
Note : employee data and item data should have respective images to
be stored in database.
8. A Computer Shop wishes to have its presence on web, It sells branded
,assembeled computers and separate parts like RAM, CD-ROM, Monitor
etc. to its client. All the clients need to register them with the site providing
some crucial information regarding them selves. After providing their
registration information they are allowed to login. After successful login
they can view the computer shop. Perform shopping, prepare their bill and
make payments. The User with Administrative rights can enter records
required to maintain the computer shop. Do the following task
 Design adequate database for the above scenario
 Provide an attractive home page . The home page must have facility to
login, register new user and remember password and forgot password
facility.
 Present a registration form to the new users with facility of Captcha
code in it. Also give the facility to edit the profile.
 Provide a Authentication Filter to protect other pages from direct
access.
 Present data entry links and forms to administrators to enter data for
new items with facility of add delete , update and find. (Give the
interface for Item Master and category Master)
 The successfully logged users should be presented with A shop. Allow
customers to select items and drop them into shopping cart. Give them
facility to add, edit and delete items from shopping cart. Also give
them facility to prepare bill. Store the bill into a database with status
of payment.
 Keep a track of every body who visits the shop and records all session
ID of the users in the database using Listeners.
 Give a report of the
 Stock of all the items.
 Clients who have visited the site more than 5 times.
 Send an auto email to all the clients on their birthday.
Note: include only essential fields in registration form. Assume the payment
to be offline.


# JSP Assignment-2
1. Convert the Servlet assignment to JSP.
2. Develop a jsp page to illustrate the use of Session Tracking.
3. Create a custom tag for the following:
(a) reverse a string (reverse is the attribute)
(b) Database connection tag
(c) employee tag and dept attribute
4. Create an xml file for employees. Parse the xml and read the file.
Take a Department combo and according to the selection, display the
employee names.
5. Create a JSP page and perform ajax for the following:
(a) show the listing of employees whose name starts with a character
typed in textbox.
(b) dependent combo box -> take dept combo and accordingly
display the employees in employee combo
6. Create a JSP Application for Employee Management.Use Java Bean
and perform the operations like add, update, delete, search. Give the
facility of registration. Also authenticate the user. When employee
logs in , list out all the projects he has been assigned with.
Note: Validate the fields.
Table Structure:
deptTB : deptid, deptname
empTB : empid, empname, designation, deptid
projectTB: projectid, projectname, description, duration
project_assignTB: projectid, empid
7. Create a JSP Application for the departmental store that has a large
number of employees and sells a varied line of products. To manage
all information about the departmental structure and products, a
database system is used. It has a number of employees, who sell
items. Sales are registered in the sale and purchase tables. The store
has contracts with various suppliers, who supply items for sale.
Make use of Java Bean.
Create appropriate database for the above scenario.
Write JDBC code for the scenario which should contain:
(a) Data entry form for department, employee, items, customers,
suppliers, sales and purchase.
(b) Give the report of employeewise sales, supplierwise sales and
purchase of various items with their cost and stock report of all
items.
Note : employee data and item data should have respective images to
be stored in database.
8. Create a JSP Application for Computer Shop that wishes to have its
presence on web, It sells branded, assembeled computers and
separate parts like RAM, CD-ROM, Monitor etc. to its client. All the
clients need to register them with the site providing some crucial
information regarding them selves. After providing their registration
information they are allowed to login. After successful login they can
view the computer shop. Perform shopping, prepare their bill and
make payments. The User with Administrative rights can enter
records required to maintain the computer shop.
Make use of JSTL SQL.
Perform the following task:
 Design adequate database for the above scenario
 Provide an attractive home page . The home page must have facility
to login, register new user and remember password and forgot
password facility.
 Present a registration form to the new users with facility of Captcha
code in it. Also give the facility to edit the profile.
 Present data entry links and forms to administrators to enter data for
new items with facility of add delete , update and find. (Give the
interface for Item Master and category Master)
 The successfully logged users should be presented with A shop.
Allow customers to select items and drop them into shopping cart.
Give them facility to add, edit and delete items from shopping cart.
Also give them facility to prepare bill. Store the bill into a database
with status of payment.
 Give a report for the following:
(a) Stock of all the items.
(b) Send an auto email to all the clients on their birthday.
Note: Include only essential fields in registration form. Assume the
payment to be offline.
