#!/bin/bash
# create-api-gateway-cli.sh
# Creates a REST API in API Gateway, wires a GET /greet route to the
# greeting-lambda function (from the AWS Lambda topic), and deploys it to "dev".

# 1) Create the REST API
API_ID=$(aws apigateway create-rest-api --name "greeting-api" --query 'id' --output text)

# 2) Find the API's root resource id (needed to attach child resources to it)
ROOT_ID=$(aws apigateway get-resources --rest-api-id "$API_ID" --query 'items[0].id' --output text)

# 3) Create the /greet resource under the root
RESOURCE_ID=$(aws apigateway create-resource \
  --rest-api-id "$API_ID" \
  --parent-id "$ROOT_ID" \
  --path-part "greet" \
  --query 'id' --output text)

# 4) Add a GET method on /greet
aws apigateway put-method \
  --rest-api-id "$API_ID" \
  --resource-id "$RESOURCE_ID" \
  --http-method GET \
  --authorization-type NONE

# 5) Wire that method to the greeting-lambda function (Lambda proxy integration)
aws apigateway put-integration \
  --rest-api-id "$API_ID" \
  --resource-id "$RESOURCE_ID" \
  --http-method GET \
  --type AWS_PROXY \
  --integration-http-method POST \
  --uri arn:aws:apigateway:us-east-1:lambda:path/2015-03-31/functions/arn:aws:lambda:us-east-1:123456789012:function:greeting-lambda/invocations

# 6) Deploy the API to a "dev" stage - this is what actually makes it callable
aws apigateway create-deployment \
  --rest-api-id "$API_ID" \
  --stage-name dev

echo "API deployed. Callable at:"
echo "https://$API_ID.execute-api.us-east-1.amazonaws.com/dev/greet?name=Anitha"
