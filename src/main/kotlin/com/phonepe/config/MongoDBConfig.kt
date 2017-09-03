package com.phonepe.config

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonTypeName
import com.mongodb.MongoClient
import com.mongodb.MongoClientURI
import com.phonepe.data.MongoDeviceSource
import org.hibernate.validator.constraints.NotEmpty
import java.util.stream.Collectors
import javax.validation.constraints.NotNull

/**
 * Created by shubham.ppe on 29/08/17.
 */
@JsonTypeName("mongo")
class MongoDBConfig: DatabaseConfig() {
    @JsonIgnore
    fun getDatabase(): MongoClient {
        return MongoClient(MongoClientURI(getMongoUri()))
    }

    @NotEmpty
    @NotNull
    var hostPorts: List<String> = ArrayList();

    @JsonIgnore
    fun getMongoUri(): String {
        var uri = hostPorts[0]
        hostPorts.subList(1, hostPorts.size).forEach { string -> uri+=","+string }
        return "mongodb://"+uri
    }
}
