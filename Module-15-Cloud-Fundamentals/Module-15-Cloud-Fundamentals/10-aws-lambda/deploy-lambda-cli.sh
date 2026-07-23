#!/bin/bash
# deploy-lambda-cli.sh
# Deploys the built jar (from "mvn package") as a new Lambda function,
# then invokes it once to confirm it works.

# 1) Package the function (produces target/greeting-lambda-demo-1.0.0.jar)
mvn package

# 2) Create the Lambda function, pointing at the handler class
aws lambda create-function \
  --function-name greeting-lambda \
  --runtime java17 \
  --role arn:aws:iam::123456789012:role/lambda-basic-execution-role \
  --handler GreetingLambda::handleRequest \
  --zip-file fileb://target/greeting-lambda-demo-1.0.0.jar \
  --timeout 10 \
  --memory-size 256

# 3) Invoke it directly (without needing API Gateway) to test
aws lambda invoke \
  --function-name greeting-lambda \
  --payload '{"name":"Anitha"}' \
  --cli-binary-format raw-in-base64-out \
  response.json

cat response.json
