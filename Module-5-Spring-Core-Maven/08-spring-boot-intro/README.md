# Spring Boot (Introduction)

Everything so far in this module - XML/annotation bean config, component scanning,
manually adding dependency versions to `pom.xml` - Spring Boot removes most of the
tedium around. It's still plain Spring underneath, just heavily pre-configured.

## What Spring Boot actually adds

- **Auto-configuration** - Boot looks at what's on your classpath and configures
  sensible defaults automatically. Add the JPA starter and a DB driver, and Boot
  configures a `DataSource` and `EntityManagerFactory` for you, without you writing
  a single `@Bean` method for them.
- **Starter dependencies** - `spring-boot-starter-web`, `spring-boot-starter-data-jpa`,
  etc. bundle together everything you'd normally add one dependency at a time.
- **Embedded server** - a Boot web app has Tomcat bundled in, so `java -jar app.jar`
  just runs it. No separate app server to install or configure.
- **Convention over configuration** - if you follow Boot's expected structure and naming,
  most things just work without any explicit config at all.

## The one annotation that does the heavy lifting

```java
@SpringBootApplication
public class MyApp {
    public static void main(String[] args) {
        SpringApplication.run(MyApp.class, args);
    }
}
```

`@SpringBootApplication` is actually shorthand for three annotations stacked together:
`@Configuration` + `@ComponentScan` + `@EnableAutoConfiguration`.

## Files

- `src/main/java/HelloBootApplication.java` - the smallest possible Spring Boot app.
- `src/main/java/HelloController.java` - one REST endpoint, to prove the embedded server and auto-config work end to end.

## Running it

```bash
mvn spring-boot:run
```

Then hit `http://localhost:8080/hello` in a browser or with curl.

## Output

```
$ curl http://localhost:8080/hello
Spring Boot app is running - no manual server setup needed.
```

Reference: https://www.geeksforgeeks.org/spring-boot/
