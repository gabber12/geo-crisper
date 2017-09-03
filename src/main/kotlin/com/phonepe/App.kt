package com.phonepe

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.DeserializationFeature
import com.phonepe.data.MongoDeviceSource
import com.phonepe.resources.LocationResource
import io.dropwizard.Application
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment
import io.federecio.dropwizard.swagger.SwaggerBundle
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration

/**
 * Created by shubham.ppe on 29/08/17.
 */
class App: Application<AppConfig>() {
    override fun run(config: AppConfig?, environment: Environment?) {
        environment?.getObjectMapper()?.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        environment?.getObjectMapper()?.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        if (config != null) {
            var source = MongoDeviceSource(config.database)
            environment?.jersey()?.register(LocationResource(source))
        };
    }

    override fun initialize(bootstrap: Bootstrap<AppConfig>?) {
        super.initialize(bootstrap)
        val swaggerBundle = object: SwaggerBundle<AppConfig>() {
            override fun getSwaggerBundleConfiguration(appConfig: AppConfig?): SwaggerBundleConfiguration {
                var config = SwaggerBundleConfiguration()
                if (appConfig != null) {
                    config = appConfig.swaggerBundleConfiguration
                }
                return config
            }

        }
        bootstrap?.addBundle(swaggerBundle)
    }
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            App().run(*args)
        }
    }
}