# AWS API Gateway - Creating and Managing APIs

## What API Gateway does

**API Gateway** is a managed service for creating, publishing, and securing REST
(and WebSocket) APIs, without running your own web server. It sits in front of
whatever actually does the work - most commonly a Lambda function (previous
topic), though it can also front EC2/ECS-hosted services.

```
Client --request--> API Gateway --routes to--> Lambda function --response-->
                                                     back through API Gateway --> Client
```

This is the missing piece that turns the `GreetingLambda` from the previous topic
into an actual callable REST endpoint, instead of something only reachable via the
AWS CLI's `invoke` command.

## Creating a REST API (Console walkthrough, summarized)

1. API Gateway Console → "Create API" → REST API
2. Create a **resource** (a URL path, e.g. `/greet`)
3. Create a **method** on that resource (e.g. GET or POST)
4. Set the integration type to "Lambda Function" and pick `greeting-lambda`
5. **Deploy** the API to a **stage** (e.g. `dev`) - this is what actually gives you
   a callable URL

## Defining HTTP methods and routes

Each resource (URL path) can have multiple methods attached - `/tasks` might support
GET (list) and POST (create), while `/tasks/{id}` supports GET (one), PUT (update),
DELETE (remove) - directly mirroring the REST conventions from Week 3's Module 7,
just fronted by API Gateway + Lambda instead of a Spring Boot server holding a port
open all the time.

## Integrating API Gateway with Lambda

API Gateway passes the incoming HTTP request (path, query params, headers, body) to
the Lambda function as its event payload, and expects a specifically-shaped JSON
response back (status code, headers, body) to translate into an actual HTTP
response for the client.

## Deployment stages

A **stage** is a named, independently deployable snapshot of your API configuration
- typically `dev`, `staging`, `prod`. Each stage gets its own URL, and you can push
changes to `dev` and test them without affecting what `prod` is currently serving.

```
https://abc123xyz.execute-api.us-east-1.amazonaws.com/dev/greet
https://abc123xyz.execute-api.us-east-1.amazonaws.com/prod/greet
```

## Throttling and basic API security

- **Throttling** - API Gateway can cap requests per second (and burst capacity) per
  API key or client, protecting your backend from being overwhelmed - configured
  as a "usage plan".
- **API Keys** - a simple way to identify and rate-limit individual clients/customers.
- For anything beyond simple rate limiting, API Gateway also integrates with AWS
  Lambda authorizers or Amazon Cognito for actual authentication - a more
  AWS-native alternative to rolling your own JWT filter, which is how Week 3's
  Module 7 handled auth when the API was hosted directly on a Spring Boot server.

## Files

- `openapi-spec.yaml` - a minimal OpenAPI definition of the `/greet` endpoint,
  the same kind of spec API Gateway can import directly to create matching resources/methods automatically.
- `create-api-gateway-cli.sh` - creates a REST API, wires it to the `greeting-lambda`
  function from the previous topic, and deploys it to a `dev` stage.

## Output (once deployed)

```
$ curl https://abc123xyz.execute-api.us-east-1.amazonaws.com/dev/greet?name=Anitha
{"message":"Hello, Anitha! This greeting came from AWS Lambda."}
```

Reference: https://www.geeksforgeeks.org/devops/aws-tutorial/
