package com.phonepe.data

import com.mongodb.MongoClient
import com.mongodb.client.model.Filters.eq
import com.phonepe.config.MongoDBConfig
import com.phonepe.requests.Location
import com.phonepe.requests.LocationRequest
import org.bson.Document

/**
 * Created by shubham.ppe on 30/08/17.
 */
class MongoDeviceSource: DataSource {
    var mongoDBConfig: MongoDBConfig = MongoDBConfig()
    var mongoClient: MongoClient = MongoClient()
    constructor(mongoDBConfig: MongoDBConfig) {
        this.mongoDBConfig = mongoDBConfig
        this.mongoClient = mongoDBConfig.getDatabase()
    }

    override fun save(location: LocationRequest) {
        var document = Document("id", location.deviceId)
                .append("lat", location.location.lat)
                .append("lng", location.location.lng)
        mongoClient.getDatabase("DB").getCollection("device").insertOne(document)
    }

    override fun getLast(deviceId: String) {
        var document = mongoClient.getDatabase("DB").getCollection("device").find(eq("deviceId", deviceId)).first()

    }
}