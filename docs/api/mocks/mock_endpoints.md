{
"info": {
"name": "StoreEase_API_v1_Mock",
"\_postman_id": "00000000-0000-0000-0000-000000000000",
"description": "Mock API collection for StoreEase project, includes success and error responses.",
"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
},
"item": [
{
"name": "Authentication",
"item": [
{
"name": "POST /auth/login",
"request": {
"method": "POST",
"header": [],
"body": {
"mode": "raw",
"raw": "{\n \"username\": \"example_user\",\n \"password\": \"example_pass\"\n}"
},
"url": {
"raw": "{{baseUrl}}/auth/login",
"host": ["{{baseUrl}}"],
"path": ["auth", "login"]
}
},
"response": [
{
"name": "200 OK",
"originalRequest": {},
"status": "OK",
"code": 200,
"body": "{\n \"token\": \"abc123\",\n \"refreshToken\": \"xyz789\"\n}"
},
{
"name": "400 Bad Request",
"originalRequest": {},
"status": "Bad Request",
"code": 400,
"body": "{\n \"error\": \"Invalid request format\"\n}"
},
{
"name": "401 Unauthorized",
"originalRequest": {},
"status": "Unauthorized",
"code": 401,
"body": "{\n \"error\": \"Invalid credentials\"\n}"
}
]
},
{
"name": "POST /auth/logout",
"request": {
"method": "POST",
"header": [],
"url": {
"raw": "{{baseUrl}}/auth/logout",
"host": ["{{baseUrl}}"],
"path": ["auth", "logout"]
}
},
"response": [
{
"name": "200 OK",
"originalRequest": {},
"status": "OK",
"code": 200,
"body": "{\n \"message\": \"Logged out successfully\"\n}"
},
{
"name": "401 Unauthorized",
"originalRequest": {},
"status": "Unauthorized",
"code": 401,
"body": "{\n \"error\": \"Unauthorized\"\n}"
}
]
}
]
},
{
"name": "Cart",
"item": [
{
"name": "GET /cart",
"request": {
"method": "GET",
"header": [],
"url": {
"raw": "{{baseUrl}}/cart",
"host": ["{{baseUrl}}"],
"path": ["cart"]
}
},
"response": [
{
"name": "200 OK",
"originalRequest": {},
"status": "OK",
"code": 200,
"body": "{\n \"items\": []\n}"
},
{
"name": "401 Unauthorized",
"originalRequest": {},
"status": "Unauthorized",
"code": 401,
"body": "{\n \"error\": \"Unauthorized\"\n}"
}
]
},
{
"name": "POST /cart/add",
"request": {
"method": "POST",
"header": [],
"body": {
"mode": "raw",
"raw": "{\n \"itemId\": 123,\n \"quantity\": 2\n}"
},
"url": {
"raw": "{{baseUrl}}/cart/add",
"host": ["{{baseUrl}}"],
"path": ["cart","add"]
}
},
"response": [
{
"name": "201 Created",
"originalRequest": {},
"status": "Created",
"code": 201,
"body": "{\n \"message\": \"Item added to cart\"\n}"
},
{
"name": "400 Bad Request",
"originalRequest": {},
"status": "Bad Request",
"code": 400,
"body": "{\n \"error\": \"Invalid request data\"\n}"
},
{
"name": "404 Not Found",
"originalRequest": {},
"status": "Not Found",
"code": 404,
"body": "{\n \"error\": \"Item not found\"\n}"
}
]
}
]
}
],
"variable": [
{
"key": "baseUrl",
"value": "http://localhost:8080"
}
]
}
