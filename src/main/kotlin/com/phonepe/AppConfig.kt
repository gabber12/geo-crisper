package com.phonepe

import com.fasterxml.jackson.annotation.JsonProperty
import com.phonepe.config.DatabaseConfig
import com.phonepe.config.MongoDBConfig
import io.dropwizard.Configuration
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration

class AppConfig : Configuration() {
    @JsonProperty("swagger")
    var swaggerBundleConfiguration: SwaggerBundleConfiguration = SwaggerBundleConfiguration()

    @JsonProperty("database")
    var database: MongoDBConfig = MongoDBConfig()
}

