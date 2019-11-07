# Git URL
https://github.com/Ken1989/fsd_sba
# fsd_sba Init

1. Create the repository and readme file
2. Create the eureka server source code 
3. Create the config server instance and create the yml files for User_service, Admin_service and Mentor_service in config repository
   https://github.com/Ken1989/ConfigData
4. Create User_service
5. Create Mentor_service
6. Create Admin_service
7. Config Server Integration of services
8. Create gateway server and integrate config server
9. Coding for user service include JPA, controller related MVC
10. Integrade swagger into user_service and do the API test 
11. Create the system management service

#Back_end
#Gateway
1. Finished the gateway config and jwt security component
2. Setting the router for each service instance
3. Seeting the zuul and ribbon
4. Token configuration 

#System_service
1. Using Feign anotition to call rest api 
2. Implement token generator and validation method

#User-Service
1. Using JPA for support dao 
2. Creating the controller for register or find user

# Front-end
1. Create the source code of front end by Angular
2. Install the zorro core 
3. Create the layout, one is login layout and other is homepage
4. Seting the router and use hash
5. Create the core component like user, mentor list and implement the function
6. Add the proxy file that can forward RestAPI request
7. Set the child router
8. Add the Jenkins file
9. Add the Docker file
 
#CICD
1. Install Jenkins image by docker
2. Seting the git and some jobs for deployment
3. Add the docker files and jenkins file to each applications

# Database
1. Create the instance for every service
 	--System db include (admin, user, mentor, permission config basic information)
 		CREATE DATABASE `sba_system` CHARACTER SET utf8 COLLATE utf8_general_ci;

 	--Training db include (include td, training process, skills of mentor)
 		CREATE DATABASE `sba_training` CHARACTER SET utf8 COLLATE utf8_general_ci;

 	--Payment db include (account, payment record)
 		CREATE DATABASE `sba_payment` CHARACTER SET utf8 COLLATE utf8_general_ci;

 2. DDL



#Question
1.	Different module has the same function, how to aviod this problme
2.	If each module use the config server, then how to choose right properties

Finished

Thanks