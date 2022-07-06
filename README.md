# Movie Info Backend

## Description
* This is the Backend Project for Movie Info Website(Client).
* Developed based on the SpringBoot

### The Overall Structure
![image](https://user-images.githubusercontent.com/58356151/177513596-0ec3f166-af33-40e0-9483-ccdffb428e26.png)

```
Process Flow 1
<Download the outside API data and Save the data in DB>
1. Scheduler execute the process at designated time
2. Download the outside API data with RestTemplate
3. Convert the partial data necessary for the Client's request to Entity
4. Save the Entity to DB with Repository
```

```
Process Flow 2
<Send the Data according to the Client's request>
1. RestController accepts the Client's request and call the Service's function for that
2. Extract the needed data from DB(Entity) with Repository
3. Convert the DB data(Entity) to Dto type(sending type)
4. Wrap the Dto data and make it as a ResponseEntity
5. RestController sent the ResponseEntity to the Client
```

### Test Result with Postman
![image](https://user-images.githubusercontent.com/58356151/177515698-362e6a98-ebca-41fd-b0cf-ce2137b9c904.png)

### The project includes several tests for the main functions.

#### MIT Free Software!
