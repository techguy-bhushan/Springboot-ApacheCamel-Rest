**SpringBoot Rest Camel**
this is a sample curd app based on SpringBoot  Apache-Camel Rest component.

Required in System for project setup:
Maven
Java 8 (if you have java 7 then you can change source and target property in maven pom)

H2 data based use so no db required.

**Swagger: Api doc**

http://0.0.0.0:8080/api/api-doc/swagger.yaml
OR
http://0.0.0.0:8080/api/api-doc/swagger.json

**Create User:**
Http Method: POST
Url:http://0.0.0.0:8080/api/users
Content-Type=application/json
Row data:
{
    "name": "Ankit"
}

output:
 `{
        "id": 1,
        "name": "Ankit"
 }`


**Find User By ID**

url:http://0.0.0.0:8080/api/users/{user_id}
Http Method: GET

eg: http://0.0.0.0:8080/api/users/1

output:
`{
    "id": 1,
    "name": "Ankit"
}`

**Find All User**

url:http://0.0.0.0:8080/api/users
Http Method: GET

Output:
`[
    {
        "id": 1,
        "name": "Bhushan"
    },
    {
        "id": 2,
        "name": "Ankit"
    }
]`


**DELETE USER**
url:http://0.0.0.0:8080/api/users/{user_id}
Http Method: DELETE

eg: http://0.0.0.0:8080/api/users/1


**Update User**
url=http://0.0.0.0:8080/api/users/{user_id}
Http Method: PUT
Content-Type=application/json





