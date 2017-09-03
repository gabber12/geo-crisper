package com.phonepe.config

import com.fasterxml.jackson.annotation.JsonTypeInfo
import io.dropwizard.jackson.Discoverable

/**
 * Created by shubham.ppe on 29/08/17.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
open abstract class DatabaseConfig: Discoverable {
}
