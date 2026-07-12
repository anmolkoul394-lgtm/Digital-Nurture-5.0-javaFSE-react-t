# Module 5 - Spring Core and Maven

Spring is basically a container that creates your objects (beans) and wires their
dependencies together for you, instead of you writing `new SomeService(new SomeRepo())`
everywhere. This module covers the core container concepts plus Maven, since almost
every Spring project is built with Maven (or Gradle).

| Topic | Folder |
|---|---|
| Introduction to Spring | `01-intro-to-spring` |
| Maven project setup | `02-maven-setup` |
| IoC Container | `03-ioc-container` |
| Bean Configuration | `04-bean-configuration` |
| Dependency Injection | `05-dependency-injection` |
| Spring AOP | `06-spring-aop` |
| Spring MVC and ORM | `07-spring-mvc-orm` |
| Spring Boot intro | `08-spring-boot-intro` |

Go in order if you're new to this - each topic builds a bit on the previous one
(IoC container concept -> how beans get configured -> how DI actually happens -> AOP
sitting on top of it all -> MVC/ORM -> and finally Spring Boot, which wraps all of this
so you barely have to configure anything by hand).
