# Setup And Run Instructions For GraphQL With MongoDB

## Install MongoDB And Run Microservice Locally
1. Install [MongoDB Community Server](https://www.mongodb.com/try/download/community).
2. Connect To MongoDB Server through localhost and default port for the database server on 27017.
3. Create a database called `BookStore` with two containers called `book` and `author`.
4. Run `mvn clean install` (Requires Maven Setup) to install and compile all necessary packages and files.
5. Run the GraphQLAPISpringTestApplication and set active profile(s) to `local`.
6. Request can be sent and checked with [Insomnia](https://insomnia.rest/) with samples in the `SampleInsomniaRequests/` directory that can be imported into insomnia.
7. You can now query and mutate the database with this microservice on http://localhost:8080/graphql



## Create And Run GraphQL Microservice and MongoDB On Docker Locally
1. Install docker desktop through the DockerHub [here](https://www.docker.com/products/docker-desktop/).
2. Create a docker network so services can easily communicate with one another with command: `docker network create {NETWORK_NAME}`
3. Install/Run the mongodb docker container existing on port 8082 (The MongoDB container runs on port 27017 for any containerized applications)
   `docker run --name {MONGO_CONTAINER_NAME} -d -p 8082:27017 --network {NETWORK_NAME} mongo`
4. Build Docker Image for the microservice ` docker build -t {MICROSERVICE_IMAGE_NAME} .`
5. Connect mongo container to a  network that the microservice will run on with the command `docker network connect {NETWORK_NAME} {MONGO_CONTAINER_NAME}`
6. Run the docker image for the graphql microservice with the command `docker run -d -p 8080:8080 --network {NETWORK_NAME} -e MONGODB_HOST={MONGO_CONTAINER_NAME} --name {MICROSERVICE_CONTAINER_NAME} {MICROSERVICE_IMAGE_NAME}`
