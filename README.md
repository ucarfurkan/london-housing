# london-housing
London Housing is an app that you can perform CRUD operations from the API.

It has dependencies, such as:
- spring-boot-starter
- springdoc-openapi-starter-webmvc-ui
- postgresql
- lombok
- commons-lang3

Application has 4 packages: Controller, Entities, Repository, Services

## <ins>Controller</ins>
### CustomExceptionHandler:
CustomExceptionHandler, which is used to handle exceptions thrown by RESTful API controllers in the application. This class provides a centralized and consistent way of handling validation errors in a Spring Boot application, making it easier to maintain and modify error handling logic.

### HouseController:
The controller has several endpoints for getting all houses, getting a house by id, adding a new house, deleting a house, updating a house, and searching for houses based on various criteria.

Let's see how to test that endpoints. Use this steps to start the project on your local:
1. Clone the project with following command: `git clone https://github.com/ucarfurkan/london-housing.git`
2. Change the application.properties in order to access your own database. Then import the following dataset into the database: https://www.kaggle.com/datasets/arnavkulkarni/housing-prices-in-london (name of the database must be "london_housing" and name of the table must be "houses".)
3. Move to the project file, then write `mvn clean package`
4. Open your browser, go to the http://localhost:8080/swagger-ui/index.html

You will see all endpoints that project has in it.  
**1- update:** There are parameters, like: id, propertyName, price, houseType, area, bedrooms, bathrooms, receptions, location, city, and postalCode. Only id is required. When the operation is performed, the House object of the entered id will be found, and the non-empty values that are desired to be updated will be replaced with the value of the found object. If no value other than the id is given, the operation will send the House object with that id.

**2- add:** When you try that operation out, you are going to see a request body, such as:
```
{
  "id": 0,
  "propertyName": "string",
  "price": 0,
  "houseType": "string",
  "area": 0,
  "bedrooms": 0,
  "bathrooms": 0,
  "receptions": 0,
  "location": "string",
  "city": "string",
  "postalCode": "string"
}
```
You can skip the id value and let it stay that way, the application is going to generate it itself. You need to pass the propertyName, price, houseType, and area in order to add a new House. The values of price, area, bedrooms, bathrooms, and receptions can not be negative.

**3- search:** There are parameters, like propertyName, price, houseType, area, bedrooms, bathrooms, receptions, location, city, and postalCode. You need to pass the values that you are searching for. If you left the page and the size empty, it's not going to be paginated and all the results matched will get. Otherwise, if you provide size and page values, it's going to do pagination and results will be get. If you left all the fields empty, all the results without any filtering will get.

**4- search/interval:** You need that operation if you want to search House objects with intervals. You need to write your intervals as "(min_price)-(max_price)" syntax, for number values. If you write only one number, without "-", the application is gonna recognize it as a minimum value and return the House objects who has that and higher values. If you left the page and the size empty, it's not going to be paginated and all the results matched will get. Otherwise, if you provide size and page values, it's going to do pagination and results will be get. If you left all the fields empty, all the results without any filtering will get.

**5- houses:** It's going to get all House objects when you perform that operation.

**6- houses/{id}:** It has only one parameter, id, and it's required. When you write an id and execute the operation, it's going to return the House object with that id, if exists, otherwise, it's going to return null.

**7- delete:** You need to provide a request body, such as:

```
{
  "id": 0,
  "propertyName": "string",
  "price": 0,
  "houseType": "string",
  "area": 0,
  "bedrooms": 0,
  "bathrooms": 0,
  "receptions": 0,
  "location": "string",
  "city": "string",
  "postalCode": "string"
}
```

and if the request body you provided exists, when you execute the operation, the House object you provide is going to be deleted.

**8- delete/{id}:** It has only one parameter, id, and it's required. When you provide an id, if exists, it's going to be deleted when you perform this operation.

## <ins>Entities</ins>
### House: House.java is class definition for a House entity.

## <ins>Repository</ins>
### HouseRepository: 
HouseRepository extends the JpaRepository interface. This interface defines four custom search queries using the @Query annotation. All four queries use the same WHERE clause to filter the House entities based on the provided parameters.

## <ins>Serivce</ins>
### HouseService:
HouseService interface declares methods for CRUD operations and searching for houses with various parameters.
### HouseServiceImpl:
The HouseServiceImpl class implements the HouseService interface and provides implementations for all the methods declared in the interface. The class uses an instance of HouseRepository to interact with the database.

 
