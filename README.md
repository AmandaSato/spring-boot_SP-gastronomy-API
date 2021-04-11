# Restaurants Manager

## Description
API created with Spring Boot to register and manage restaurant' data.

## Data
- Restaurant's name
- Adress
- Food type or Restaurant's concept
- Rating
 
## Running the API
Using a tool that supports HTTP requests, such as [Postman](https://www.postman.com/), run the following commands.

### POST: 
Register restaurant.
```
http://localhost:8082/api/v1/restaurants
```

```JSON
{
  "name": "Coco Bambu",
  "local": "R. Azevedo Soares, 2150 - Jardim Analia Franco",
  "type": "Seafood",
  "rating": 4.5
}
```

### GET:
Search for all registered restaurants or get restaurant by ID.
```
http://localhost:8080/api/v1/restaurants
```
```
http://localhost:8080/api/v1/restaurants/{id}
```


### PUT:
Modify registered data of a certain restaurant by ID.

http://localhost:8080/api/v1/restaurants/{id}

```JSON
{
    "id": 1,
  "name": "Coco Bambu",
  "local": "R. Azevedo Soares, 2150 - Jardim Analia Franco",
  "type": "Gourmet Seafood",
  "rating": 5.0
}
```

### DELETE:
Delete a restaurant by ID.

```
http://localhost:8080/api/v1/restaurants/{id}
```



 
