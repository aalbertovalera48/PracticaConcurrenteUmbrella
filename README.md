# PracticaConcurrenteUmbrella

Hecho por: Alberto Valera, Inés Elena Gómez, Mario Serrano

This project is a Spring Boot application that integrates with Firebase to manage biological data. It includes various services and configurations to handle CSV data, asynchronous tasks, and Firebase interactions.

## Project Structure

### `PracticaConcurrenteUmbrellaApplication.java`
- **Description**: Main class to run the Spring Boot application.
- **Methods**:
  - `main(String[] args)`: Initializes Firebase and runs the Spring Boot application.
  - `initializeFirebase()`: Configures and initializes Firebase.

### `FirebaseConfig.java`
- **Description**: Configuration class for Firebase.
- **Methods**:
  - `firebaseDatabase()`: Initializes and returns a `FirebaseDatabase` instance.

### `FirebaseService.java`
- **Description**: Service class to interact with Firebase.
- **Methods**:
  - `saveBiologicalData(BiologicalData data)`: Saves biological data to Firebase.
  - `getData()`: Retrieves biological data from Firebase.

### `CsvService.java`
- **Description**: Service class to parse CSV files.
- **Methods**:
  - `parseCsv(String filePath)`: Parses a CSV file and returns a list of `BiologicalData`.

### `DataController.java`
- **Description**: REST controller to handle data-related endpoints.
- **Methods**:
  - `uploadCsvToFirebase(String filePath)`: Endpoint to upload CSV data to Firebase.

### `BiologicalData.java`
- **Description**: Model class representing biological data.
- **Fields**: Various fields like `id`, `gender`, `age`, `heightCm`, etc.

### `BiologicalDataFlow.java`
- **Description**: Service class implementing `DataFlow` interface for processing biological data.
- **Methods**:
  - `processData()`: Processes biological data.

### `DataFlow.java`
- **Description**: Interface for data processing.
- **Methods**:
  - `processData()`: Method to process data.

### `LoggingService.java`
- **Description**: Service class for logging.
- **Methods**: (Commented out)
  - `logInfo(String message)`: Logs an info message.
  - `logError(String message, Throwable throwable)`: Logs an error message.

### `MyTask.java`
- **Description**: Runnable task for concurrent execution.
- **Methods**:
  - `run()`: Executes the task and logs its progress.

### `ThreadManager.java`
- **Description**: Manages and starts multiple threads.
- **Methods**:
  - `main(String[] args)`: Creates and starts multiple threads running `MyTask`.

### `AsyncService.java`
- **Description**: Service class for executing asynchronous tasks.
- **Methods**:
  - `executeAsyncTask()`: Executes an asynchronous task.

### `AsyncConfig.java`
- **Description**: Configuration class for enabling asynchronous execution.
- **Methods**:
  - `taskExecutor()`: Configures and returns a `ThreadPoolTaskExecutor`.

### `DataProcessingService.java`
- **Description**: Service class for processing biological data asynchronously.
- **Methods**:
  - `processBiologicalData()`: Processes biological data asynchronously.

### `HomeController.java`
- **Description**: Controller for handling home page requests.
- **Methods**:
  - `index(Model model)`: Fetches biological data and executes an asynchronous task.

### `CsvToFirebase.java`
- **Description**: Standalone class to upload CSV data to Firebase.
- **Methods**:
  - `main(String[] args)`: Reads a CSV file and uploads data to Firebase.

## Configuration Files

### `application.properties`
- **Description**: Configuration properties for the Spring Boot application.
- **Properties**: Includes Firebase database URL, credentials path, logging levels, etc.

### `Dockerfile`
- **Description**: Docker configuration for building and running the application.
- **Instructions**: Sets up the environment, copies necessary files, and runs the application.

### `compose.yaml`
- **Description**: Docker Compose configuration for running the application in a container.
- **Services**: Defines the application service, ports, environment variables, and volumes.

## Frontend

### `index.html`
- **Description**: HTML file for displaying biological data.
- **Scripts**: Uses D3.js to create charts from the fetched data.

## Dependencies

### `pom.xml`
- **Description**: Maven configuration file for managing project dependencies.
- **Dependencies**: Includes Spring Boot, Firebase, OpenCSV, and other necessary libraries.


URL: https://github.com/aalbertovalera48/PracticaConcurrenteUmbrella.git

URL DATABASE: https://concurrente-umbrella-default-rtdb.firebaseio.com/
