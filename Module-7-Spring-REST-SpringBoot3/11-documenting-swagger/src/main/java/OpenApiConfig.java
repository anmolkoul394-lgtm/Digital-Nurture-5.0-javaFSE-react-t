// OpenApiConfig.java
// Gives the whole API a proper title/description/version, shown at the top of
// the Swagger UI page instead of a bare, unlabeled endpoint list.

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Task Manager API",
                version = "1.0",
                description = "A small demo API for learning Spring REST + Swagger/OpenAPI documentation"
        )
)
public class OpenApiConfig {
}
