# cs5200-fall2019-GroupSet26-GroupProject
Project submission link for DBMS final project

# Database Connection

Host: cs5200-fall2019-mahapatra.c4pog4fxhxtx.us-east-2.rds.amazonaws.com

Username: admin

Password: mysql123

port: 3306

# Project on Hosted Server

http://cs5200-fall2019-final-project.us-east-2.elasticbeanstalk.com/

# Roles:

1. admin/admin

2. alice/alice: Vendor

3. bob/bob: Customer

4. charlie/charlie: Customer

5. dan/dan: Vendor

#  A vendor can perform the following functionalities:

1. Add rooms to an existing hotel that is assigned to her (hotel can be added only by admin).

2. Can view all the rooms added by her.  

3. Can view all the bookings for that room (bookings are done by the customer). 

4. Can set the room to be inActive, this way the room will not be visible to the customer for booking.

5. Can delete/deactivate rooms. 

6. Can delete bookings of customer

# A customer can perform the following functionalities:

1. can view all hotels.

2. can view all rooms in a hotel.

3. can book a room.

4. Can cancel a booking.

5. can update his email ID.

# An admin can perform the following functionalities: 

1. Adding hotels.

2. Assigning vendor to an added hotel.

3. Adding rooms in a hotel.

4. Delete/deactivate rooms.

5. create users.

6. Update customer's email.

7. Delete users.

8. View all users.

# Domain Object: 

 - 1. Hotel: 

	attributes- id, name, description, city, vendorId etc.

 - 2. RoomDetails: 
	
	attribute- id, check-in-date, check-out-date, is-active, is-booked, hotelId etc.

 - 3. User: 

	attributes- dtype, id, firstName, lastName, email, username, password etc.

 - 4. Booking: 

	attributes: id, check-in-date, check-out-date, number-of-adults, customerId etc, roomDetailsId etc.


# Link to Installation and Configuration on Github:

 - 1. Go to github link
 
 - 2. clone the project
 
 - 3. go to Project-3\cs5200_fall2019_final_project
 
 - 4. run mvn clean install in the command prompt for this project path:
	
	```
		Project-3\cs5200_fall2019_final_project

 	```
 
- 5. run 
	
	```
         	java -jar .\target\cs5200_fall2019_final_project-0.0.1-SNAPSHOT.war
	
	```
 - 6. open localhost:8080/ that will open the home page.
 
 - 7. Kindly follow the youtube video to navigate through pages:

	```
         	  https://youtu.be/kCUfoKOUzYs
	
	```
# cs5200-dbms-final-project-booking-management-system
