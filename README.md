# Kaldi Exercise Installation Guide

This guide will walk you through the steps to set up and run the Kaldi exercise using Docker for PostgreSQL and Quarkus.

## Prerequisites

Before you begin, ensure you have the following installed:

1. **Java Development Kit (JDK) 21+**
   - Check if Java is installed by running `java -version`. Install it from [Oracle](https://www.oracle.com/java/technologies/javase-jdk21-downloads.html) if needed.

2. **Maven 3.8.6+**
   - Check if Maven is installed by running `mvn -v`. Install it from [Maven's official website](https://maven.apache.org/download.cgi) if needed.

3. **Docker**
   - Verify Docker installation by running `docker --version`. Install Docker from [Docker's official site](https://docs.docker.com/get-docker/) if needed.

4. **Git**
   - Check if Git is installed by running `git --version`. Install it from [here](https://git-scm.com/downloads) if needed.

5. **Insomnia or cURL**
   - **Insomnia**: A GUI tool for API testing. Download it from [Insomnia's website](https://insomnia.rest/download) if needed.
   - **cURL**: A command-line tool for transferring data with URLs. Check if cURL is installed by running `curl --version`. Install it from [cURL's website](https://curl.se/download.html) if needed.

## Step 1: Clone the Repository

Start by cloning the Kaldi exercise repository to your local machine.

```
git clone https://github.com/zigavr/kaldi-exercise.git
```

## Step 2: Start PostgreSQL Database Using Docker

Start a PostgreSQL database using Docker. The repository includes a `docker-compose.yml` file for this purpose. Run:

```
docker-compose up -d
```

This will start the PostgreSQL database in a Docker container.

## Step 3: Build and Run the Quarkus Application

Build and run the Quarkus application using Maven. From the root directory of the cloned repository, run:

### To Build the Application

```
mvn clean install
```

### To Run the Application in Development Mode

```
mvn quarkus:dev
```

This will start the Quarkus application in development mode, allowing it to reload automatically if any source code changes are made.

## Step 4: Access the Application

Once the application is running, you can access it by navigating to `http://localhost:8080` in your web browser.
## Step 5: Test the Web Services

You can test the web services using Insomnia or cURL. Below are instructions for importing the Insomnia workspace and using cURL commands.

### Using Insomnia

1. **Open Insomnia**.

2. **Import the Insomnia File**:
   - Go to `File` > `Import`.
   - Select `Import From File` and choose the `iInsomnia_webservices_v1.json` file located in the project directory.

3. **Run the Requests**:
   - After importing, you will see a new workspace named "Kaldi exercise" with pre-configured requests.
   - You can run these requests directly within Insomnia to interact with the web services.

### Using cURL

You can also test the web services using cURL commands:

- **Login**:
  ```
  curl -X GET "http://localhost:8080/login" -H "Content-Type: application/json" -d '{"username": "ziga", "password": "111"}'
  ```

- **List Messages**:
  ```
  curl -X GET "http://localhost:8080/web/message/list" -H "User-Agent: cURL"
  ```

- **Message Answer**:
  ```
  curl -X PUT "http://localhost:8080/web/message/answer" -H "Content-Type: application/json" -d '{"messageId": 1, "reply": "Hi"}'
  ```

- **Message Takeover**:
  ```
  curl -X PUT "http://localhost:8080/web/message/takeover" -H "Content-Type: application/json" -d '{"messageId": 1, "userDesignation": 1}'
  ```

- **Get Message Answer**:
  ```
  curl -X GET "http://localhost:8080/mobile/message/answer" -H "Content-Type: application/json" -d '{"messageId": 1}'
  ```

- **Send Message**:
  ```
  curl -X POST "http://localhost:8080/mobile/message/send" -H "Content-Type: application/json" -H "Accept: application/json" -d '{"question": "What is your question?", "room": "Room 1A", "mobileUser": {"designation": "Manager", "firstName": "John", "lastName": "Doe"}}'
  ```