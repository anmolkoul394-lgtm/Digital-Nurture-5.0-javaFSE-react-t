# Setting up a Spring Project with Maven

Maven is a build tool - it downloads your dependencies (jars), compiles your code,
runs tests, and packages everything into a jar/war, all based on one config file:
`pom.xml`.

## Why Maven specifically

Before Maven, developers manually downloaded jars and added them to a classpath by
hand. Maven fixes this by pulling dependencies (and their own dependencies, transitively)
from a central repository, based on a coordinate system: `groupId:artifactId:version`.

## Structure of a Maven project

```
demo-project
├── pom.xml
└── src
    ├── main/java     <- your actual application code
    └── test/java     <- your test code
```

Maven expects this exact folder layout by convention - you don't have to configure
source folders manually like you might in older build systems.

## Anatomy of a pom.xml

- `groupId` / `artifactId` / `version` - identifies your own project
- `properties` - things like Java version, encoding
- `dependencies` - the jars your project needs (Spring, JUnit, etc.)
- `build > plugins` - build behaviour (compiler plugin, surefire for tests, etc.)

## Adding Spring to a project

You add the `spring-context` dependency (the core IoC container) to `pom.xml`, and Maven
takes care of fetching it plus everything it needs.

## Files

- `demo-project/pom.xml` - a minimal Maven project with the Spring Context dependency added.
- `demo-project/src/main/java/App.java` - a tiny "hello" program to prove the project builds and runs.

## Running it

```bash
cd demo-project
mvn compile exec:java -Dexec.mainClass="App"
```

## Output

```
Maven project is set up and Spring dependency resolved correctly.
```

Reference: https://www.studytonight.com/spring-framework/spring-maven-project
