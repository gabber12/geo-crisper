package com.phonepe.resources

import com.codahale.metrics.annotation.Metered
import com.fasterxml.jackson.annotation.JsonProperty
import com.phonepe.data.DataSource
import com.phonepe.data.MongoDeviceSource
import com.phonepe.requests.LocationRequest
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import javax.validation.Valid
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

/**
 * Created by shubham.ppe on 29/08/17.
 */
@Path("/location")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Api("Location Resource")
class LocationResource(var dataSource: DataSource) {
    @Path("/")
    @POST
    @ApiOperation("Add a location")
    @Metered
    fun create(@Valid locationRequest: LocationRequest) : Response{
        dataSource.save(locationRequest)
        return Response.ok().build();
    }
}

