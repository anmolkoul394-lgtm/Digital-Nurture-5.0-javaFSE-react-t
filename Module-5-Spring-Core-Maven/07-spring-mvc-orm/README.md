# Spring MVC and ORM

Two separate ideas that usually show up together in a real Spring web app.

## MVC recap in a Spring context

Same Model-View-Controller split from Week 1's design patterns module, just with
Spring's specific pieces:
- **Controller** - a class annotated `@Controller` (or `@RestController` for pure
  JSON APIs), handles incoming HTTP requests via `@GetMapping`/`@PostMapping`/etc.
- **Model** - your domain/entity classes, plus the `Model` object Spring passes into
  a controller method so you can push data into the view.
- **View** - traditionally a JSP or Thymeleaf template that renders HTML using data
  from the Model. `@RestController` skips this entirely and just returns JSON/data directly.

### Request flow

```
Browser --request--> DispatcherServlet --routes to--> Controller --updates--> Model
                                                              |
                                                        picks a View
                                                              |
                                                    View renders using Model data
                                                              |
                                                     Response sent back to Browser
```

`DispatcherServlet` is the front controller - every request goes through it first,
and it figures out which of your `@Controller` methods should handle it.

## Form handling, validation, exceptions

- Form data binds to a Java object automatically via `@ModelAttribute`
- `@Valid` + Bean Validation annotations (`@NotNull`, `@Size`, etc.) validate incoming data
- `@ExceptionHandler` methods (or a global `@ControllerAdvice` class) catch exceptions
  thrown anywhere in a controller and turn them into a proper error response instead of
  a raw stack trace

## Where ORM fits in

ORM (Object-Relational Mapping) is what lets your Java objects map directly onto
database tables, instead of writing SQL and manually converting `ResultSet` rows into
objects yourself. Spring's own piece here is minimal - it mostly just integrates with
Hibernate (the actual ORM implementation) through Spring Data JPA, which is the entire
subject of Module 6.

## Files

- `src/main/java/GreetingController.java` - a minimal controller showing path variables,
  query parameters, and returning data - written so it can be read and understood without
  needing a running servlet container, since this folder is about the concepts, not a
  full deployable web app (Module 6/7 build on real running examples).

## Reading it

There's no `main` method to run here on its own - `GreetingController` is meant to be
dropped into a Spring Boot web app (see `../08-spring-boot-intro` and Module 7 in Week 3
for a fully working REST setup). Read through the comments to see how each mapping works.

Reference: https://www.geeksforgeeks.org/spring-mvc-framework/
