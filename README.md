## Student Study Space

Spring Boot Web application with three-layered architecture.

Supported features:
- create questions with title and text content;
- create answers with text content to a chosen question;
- create comments to a chosen question or answer;
- create task with a title;
- append chosen question to a chosen task.

## Build

Spring Boot
Gradle 3.2.1

```
./gradlew bootRun
```

## Javadoc

To generate html version run command

```
./gradlew javaDoc
```

*index.html* will be in *build/docs/javadoc*
