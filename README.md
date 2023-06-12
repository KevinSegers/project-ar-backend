# Project 4WT - Adv programming topics of microservices with Spring Boot

### 1. INTRODUCTION
**Team members:** Michal Davidse (r0809700) & Kevin Segers (r0793406)

_Background information_  
The application shows the items on a page in AR. To start the user opens the app and has to choose a category. 
Per category there are several books. When a book is chosen the camera opens and the person can scan a page. The items on the page will appear!
The frond end of the application was made using flutter and wikitude. 
The models were made using Sketchup.

_Introduction & Documentation_  
This repository contains the project of Advanced programming topics of coding microservices using Spring Boot.
One _Edge service_ `brank-edge-service` will connect to two lower services `book-service` and `page-service` to request information which it will then process and combine into a single response to the user. 
The user is only supposed to communicate with the `brank-edge-service`.  We used github-actions to: docker-hub, sonarcloud and docker compose to deploy the project on okteto cloud.


Link to `edge-service` repository:  [edge-service](https://github.com/KevinSegers/nijntje-edge-service)   
Link to `book-service` repository:  [book-service](https://github.com/KevinSegers/nijntje-book-service)  
Link to `page-service` repository:  [page-service](https://github.com/KevinSegers/nijntje-page-service)  
Link to `docker-compose` repository:  [docker-compose](https://github.com/KevinSegers/nijntje-docker-compose) 


The example architecture is as follows:

![](readmeImages/SchemaProject.png)  


### 2. SET UP DOCKER CONTAINERS

#### 2.1 Local Set up

**Set up the Docker container with the MySQL database:**

`docker run --name books-mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=abc123 -d mysql `

**Set up the Docker container with the MongoDB database:**

`docker run --name pages-mongodb -p 27017-27019:27017-27019 -d mongo`

**Run the local set up**

#### 2.2 Run docker compose

Run the docker compose via following url: [docker-compose](https://github.com/KevinSegers/nijntje-docker-compose)

#### 2.3 Output 
Sonar cloud: 
  
![](readmeImages/SonarCloud.png)

DockerHub:  

![](readmeImages/DockerHub.png)  

Okteto:  

![](readmeImages/Okteto.png)


&nbsp;
### 3. SERVICES

#### 3.1 Book-service

**_3.1.1 End points_**

![](readmeImages/BookSwagger.png)

+ `GET /books`&emsp; Get all books
+ `GET /books/title/{title}`&emsp; Get book by title
+ `GET /books/category/{category}`&emsp; Get all books by category
+ `POST /books`&emsp; Add book
+ `PUT /books` &emsp; Update book
+ `DELETE  /books/{booktitle}`&emsp; Delete book   

&nbsp;

**_3.1.2 Testing_**  

Coverage unit testing: 

![](readmeImages/Testing/BookControllerUnitTests.png)

Coverage integration testing: 

![](readmeImages/Testing/BookControllerIntegrationTests.png)



#### 3.2 Page-service

**_3.2.1 End points_**

![](readmeImages/PageSwagger.png)

+ `GET /pages` &emsp; Get all pages
+ `GET /pages/booktitle/{bookTitle}` &emsp; Get all pages from book
+ `GET /pages/booktitle/{bookTitle}/pagenumber/{pageNumber}" ` &emsp;   Get one page by booktitle and pagenumber
+ `GET /pages/booktitle/{bookTitle}/pagenumber/{pageNumber}/items` &emsp; Get all items from a page
+ `GET /pages/booktitle/{bookTitle}/pagesseen` &emsp; Get seen pages in double
+ `POST /pages`&emsp;Add a page
+ `PUT /pages` &emsp; Update a page
+ `PUT /pages/booktitle/{bookTitle}/setpagesunseen` &emsp; Set all pages of a book unseen
+ `DELETE /pages/booktitle/{bookTitle}/pagenumber/{pageNumber}` &emsp; Delete a page


**_3.2.2 Testing_**  

Coverage unit testing:   

![](readmeImages/Testing/PageControllerUnitTests.png)

Coverage integration testing:  

![](readmeImages/Testing/PageControllerIntegrationTest.png)



#### 3.3 Edge-service
**_3.3.1 End points_**

  ![](readmeImages/EdgeSwagger.png)  
  &nbsp;  
+ `GET /interactivebooks/book/{bookTitle}`     
Get Book with pages  
  <sub>postman</sub>
  &nbsp;  
![](readmeImages/EdgeService/Postman/GetBookWithPages.png)
  &nbsp;  
  <sub>swagger</sub>  
  &nbsp;
  ![](readmeImages/EdgeService/Swagger/GetBookWithPages.png)
  &nbsp;  
  &nbsp;
+ `GET /interactivebooks/books/{bookTitle}/pagesseen`  
  Get pages seen in decimal  
  <sub>postman</sub>
  ![](readmeImages/EdgeService/Postman/GetBookPagesSeen.png)   
  &nbsp;  
  <sub>swagger</sub>  
  &nbsp;
  ![](readmeImages/EdgeService/Swagger/GetBookPagesSeen.png)    
  &nbsp;   
  &nbsp;
+ `GET /interactivebooks/booksbycategory/{category}`  
  Get books for category  
  <sub>postman</sub>
  ![](readmeImages/EdgeService/Postman/GetBooksByCategory.png)    
  &nbsp;  
  <sub>swagger</sub>  
  &nbsp;
  ![](readmeImages/EdgeService/Swagger/GetBooksByCategory.png)   
  &nbsp;    
  &nbsp;
+ `GET /interactivebooks/booktitle/{bookTitle}/pagenumber/{pageNumber}/items`  
  Get items from page  
  <sub>postman</sub>
  ![](readmeImages/EdgeService/Postman/GetItemsFromPage.png)   
  &nbsp;    
  <sub>swagger</sub>  
  &nbsp;
  ![](readmeImages/EdgeService/Swagger/GetItemsFromPage.png)
  &nbsp;    
  &nbsp;
+ `GET /interactivebooks/categorieswithurls`  
  Get categories with url  
  <sub>postman</sub>
  ![](readmeImages/EdgeService/Postman/GetCategorieswithUrls.png)  
  &nbsp;  
  <sub>swagger</sub>  
  &nbsp;  
  ![](readmeImages/EdgeService/Swagger/GetCategorieswithurls.png)
  &nbsp;    
  &nbsp;
+ `GET /interactivebooks/pages/booktitle/{bookTitle}/pagenumber/{pageNumber}`  
  Get page by booktitle and pagenumber  
  <sub>postman</sub>  
  ![](readmeImages/EdgeService/Postman/GetPageByBookTitleAndPageNumber.png)  
  &nbsp;
  <sub>swagger</sub>  
  &nbsp;
![](readmeImages/EdgeService/Swagger/GetPageByBookTitleAndPageNumber.png)
  &nbsp;    
  &nbsp;
+ `POST /interactivebooks/pages`  
  Add page to bookwithPages  
  <sub>postman</sub>
  ![](readmeImages/EdgeService/Postman/AddPage.png)  
  &nbsp;
  <sub>swagger</sub>  
  &nbsp;
![](readmeImages/EdgeService/Swagger/AddPage.png)
  &nbsp;    
  &nbsp;
+ `PUT /interactivebooks/books/{bookTitle}/setpagesunseen`  
  Set pages from book unseen    
  <sub>postman</sub>  
  ![](readmeImages/EdgeService/Postman/GetBookPagesUnseen.png)  
  &nbsp;   
  <sub>swagger</sub>  
  &nbsp;
![](readmeImages/EdgeService/Swagger/SetBookPagesUnseen.png)  
  &nbsp;      
  &nbsp;
+ `PUT /interactivebooks/pages`  
  Update page from Book with page  
  <sub>postman</sub>
  ![](readmeImages/EdgeService/Postman/UpdatePage.png)  
  &nbsp;  
  <sub>swagger</sub>  
  &nbsp;
![](readmeImages/EdgeService/Swagger/UpdatePage.png)
  &nbsp;    
  &nbsp;
+ `PUT /interactivebooks/pages/booktitle/{bookTitle}/pagenumber/{pageNumber}`  
  Update page to seen given booktitle and pagenumber  
  <sub>postman</sub>
  ![](readmeImages/EdgeService/Postman/UpdatePageSeen.png)
  &nbsp;  
  <sub>swagger</sub>  
  &nbsp;
  ![](readmeImages/EdgeService/Swagger/UpdatePageSeen.png)
  &nbsp;    
  &nbsp;
+ `PUT /interactivebooks/updatebook`  
  Update book  
  <sub>postman</sub>  
  ![](readmeImages/EdgeService/Postman/Updatebook.png)
  &nbsp;   
  <sub>swagger</sub>  
  &nbsp;
  ![](readmeImages/EdgeService/Swagger/UpdateBook.png)
  &nbsp;    
  &nbsp;
+ `DELETE /interactivebooks/pages/booktitle/{bookTitle}/pagenumber/{pageNumber}`  
  Delete page    
  <sub>postman</sub>
  ![](readmeImages/EdgeService/Postman/DeletePage.png)
  &nbsp;  
  <sub>swagger</sub>  
  &nbsp;
  ![](readmeImages/EdgeService/Swagger/DeletePage.png)
  &nbsp;     
  &nbsp;  

**_3.3.2 Testing_**  

coverage unit testing:  

![](readmeImages/Testing/BookWithPagesUnitTests.png)

