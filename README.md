# ProductApi

To Run the Project:

1. CURL to check if service is up and runnig : 

curl --location --request GET 'http://localhost:9021/v1/products/info' \
--data-raw ''


2. CURL to Add the Product in DB : 

curl --location --request POST 'http://localhost:9021/v1/products/view' \
--header 'Content-Type: application/json' \
--data-raw '{
    
      "name": "Dye shirt,",
      "description":"Dye hugo boss shirt",
      "brand":"Dye boss",
      "tags":[
          "Dye",
          "shirt"

      ],
      "category":"clothes"
}'



3. CURL to view all products in DB : 

curl --location --request GET 'http://localhost:9021/v1/products/view' \
--data-raw ''


4. CURL to search by category :

curl --location --request GET 'http://localhost:9021/v1/products/Apparel' \
--data-raw ''



