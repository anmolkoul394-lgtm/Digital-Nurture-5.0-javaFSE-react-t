// GreetingLambda.java
// A genuinely runnable AWS Lambda function - implements RequestHandler, which is
// the standard interface Lambda's Java runtime calls into. handleRequest() is
// invoked once per event; there's no "server" or "main loop" running continuously.

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.HashMap;
import java.util.Map;

public class GreetingLambda implements RequestHandler<Map<String, String>, Map<String, String>> {

    @Override
    public Map<String, String> handleRequest(Map<String, String> input, Context context) {
        // "input" here is whatever JSON payload triggered this invocation -
        // e.g. from API Gateway, an S3 event notification, or a direct CLI invoke.
        String name = input.getOrDefault("name", "World");

        // context gives access to Lambda-specific info - request id, remaining
        // execution time, log group, etc. - useful for logging/debugging.
        context.getLogger().log("Handling greeting request for: " + name);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello, " + name + "! This greeting came from AWS Lambda.");
        return response;
    }

    // A plain main method purely for LOCAL testing, before ever deploying to AWS -
    // Lambda itself never calls this; it only calls handleRequest() above.
    public static void main(String[] args) {
        GreetingLambda lambda = new GreetingLambda();

        Map<String, String> testInput = new HashMap<>();
        testInput.put("name", "Anitha");

        Map<String, String> result = lambda.handleRequest(testInput, null);
        System.out.println(result);
    }
}
