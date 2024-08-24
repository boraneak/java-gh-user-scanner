# Java gh user scanner

## About

Java Gh User Scanner is a command-line tool for fetching and displaying GitHub user information.

This tool connects to the GitHub API to fetch a list of users, displays their IDs, and allows the user to query details for specific user IDs. It provides information such as:

- Login name
- Profile link
- Number of repositories
- Number of followers
- Number of following users

## Getting started

### Requirements

- **Java 11 or Higher**: Ensure that Java 11 or a more recent version is installed on your machine. You can download and install the latest version of Java from the [Oracle website](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) or use a package manager for your operating system.

### Clone the Repository

To get started with the project, first clone the repository using Git:

```bash
git clone git@github.com:boraneak/java-gh-user-scanner.git
```
```bash
cd java-gh-user-scanner
```

### Build

To build the project, you need Apache Maven installed on your machine. If Maven is not already installed, you can download and install the latest version from the [Maven website](https://maven.apache.org/download.cgi).

Once Maven is installed, navigate to the project directory and run:

```bash
# This command can be run on: Mac/Linux, Window
mvn package
```

### Run the app

```bash
# This command can be run on: Mac/Linux, Window
java -jar target/java-gh-user-scanner-1.0-SNAPSHOT.jar
```
### Executable .jar file

You can find the .jar file at [here](https://github.com/boraneak/java-gh-user-scanner/tree/master/src/main/resources)

## Libraries Used

- **[Gson](https://github.com/google/gson)**: For JSON parsing.
- **[Apache HttpClient](https://github.com/apache/httpcomponents-client)**: For making HTTP requests.
