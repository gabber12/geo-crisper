package com.phonepe.data

import com.phonepe.requests.Location
import com.phonepe.requests.LocationRequest


/**
 * Created by shubham.ppe on 30/08/17.
 */
interface DataSource {
    fun save(location: LocationRequest)
    fun getLast(deviceId: String)
}