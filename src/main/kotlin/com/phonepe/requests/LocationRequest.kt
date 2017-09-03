package com.phonepe.requests

import javax.validation.constraints.NotNull

/**
 * Created by shubham.ppe on 29/08/17.
 */
class LocationRequest(@NotNull val location : Location = Location(0, 0),
                      @NotNull val deviceId : String = "")
