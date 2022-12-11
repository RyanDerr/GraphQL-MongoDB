# Setup And Run Instructions For GraphQL With MongoDB

## Install MongoDB And Run Microservice Locally
1. Install [MongoDB Community Server](https://www.mongodb.com/try/download/community).
2. Connect To MongoDB Server through localhost and default port for the database server on 27017.
3. Create a database called `BookStore` with two containers called `book` and `author`.
4. Run `mvn clean install` (Requires Maven Setup) to install and compile all necessary packages and files.
5. Run the GraphQLAPISpringTestApplication and set active profile(s) to `local`.
6. Request can be sent and checked with [Insomnia](https://insomnia.rest/) with samples in the `SampleInsomniaRequests/` directory that can be imported into insomnia. 
7. You can now query and mutate the database with this microservice on http://localhost:8080/graphql



## Create And Run GraphQL Microservice and MongoDB On Docker
1. Install docker desktop through the DockerHub [here](https://www.docker.com/products/docker-desktop/).
2. Install/Run the mongodb docker container existing on port 8082 (The MongoDB container runs on port 27017 for any containerized applications run locally.)
`docker run --name mongodb -d -p 8082:27017 mongo`
3. Build Docker Image for the microservice ` docker build -t graphql-mongo .`
4. Within Docker Desktop run the graphql-mongo image and specify the host port as port `8080` when running the container. 

**Note:** If the microservice container cannot connect to the mongodb container you may need to check and change the host for the application-docker profile with the dockerized ip of MongoDB using the command `docker inspect mongodb | grep IPAddress`.
