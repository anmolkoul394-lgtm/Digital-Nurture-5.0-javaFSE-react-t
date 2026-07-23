# AWS Lambda - Serverless Functions & Integration with AWS Services

## What "serverless" actually means

There are still servers involved somewhere - "serverless" means YOU never provision,
patch, or scale them. You give AWS a function; AWS runs it in response to events,
scales the number of concurrent executions automatically (including down to zero
when nothing's happening), and you're billed per invocation and execution time,
not for idle capacity sitting around.

## AWS Lambda's execution model

Lambda functions are **event-driven** - a function doesn't run continuously, it runs
in response to a trigger, does its work, and then stops:

```
Event Source (S3 upload, API Gateway request, DynamoDB Stream, schedule...)
        |
        v
   Lambda Function invoked  -->  runs your code  -->  returns a result / stops
```

## Common event sources / triggers

- **S3** - run a function whenever a file is uploaded (e.g. generate a thumbnail
  when an image lands in a bucket)
- **API Gateway** - run a function in response to an HTTP request (covered fully
  in the next topic) - this is how you build a REST API with NO server at all
- **DynamoDB Streams** - run a function whenever an item in a DynamoDB table changes

## Creating and deploying a function (Console walkthrough, summarized)

1. Lambda Console → "Create function"
2. Choose a runtime (Java 17, Node.js, Python, etc.)
3. Write/upload your code (for Java, this means packaging a JAR with your handler class)
4. Configure a trigger (e.g. API Gateway, or an S3 event)
5. Deploy - Lambda handles the rest

## Lambda runtime for Java

A Java Lambda function implements `RequestHandler<InputType, OutputType>` - the
`handleRequest` method is what Lambda calls on each invocation. It needs to be
packaged as an "uber jar" (all dependencies bundled in) since Lambda has no Maven
to resolve dependencies for you at runtime.

## Pay-per-execution pricing

Billed on: (1) number of requests, and (2) execution duration × memory allocated,
rounded up to the nearest millisecond. AWS's free tier includes 1 million free
requests and 400,000 GB-seconds of compute per month - enough that a small side
project or learning exercise essentially never gets billed.

## Files

- `src/main/java/GreetingLambda.java` - a genuinely runnable Lambda handler (a
  small Java function you could actually deploy), takes a name and returns a greeting.
- `pom.xml` - packages it as a shaded (uber) jar, the format Lambda needs.
- `deploy-lambda-cli.sh` - creates the function via the AWS CLI, using the built jar.

## Running/testing it locally (before deploying)

```bash
mvn package
```

`GreetingLambda.handleRequest(...)` can be called directly in a plain `main` method
or a unit test to verify the logic works, without needing to deploy to AWS at all -
worth doing before wiring up any real trigger.

## Output (once deployed and invoked via the AWS CLI)

```
$ aws lambda invoke --function-name greeting-lambda --payload '{"name":"Anitha"}' response.json
$ cat response.json
{"message":"Hello, Anitha! This greeting came from AWS Lambda."}
```

Reference: https://www.geeksforgeeks.org/devops/introduction-to-aws-lambda/
