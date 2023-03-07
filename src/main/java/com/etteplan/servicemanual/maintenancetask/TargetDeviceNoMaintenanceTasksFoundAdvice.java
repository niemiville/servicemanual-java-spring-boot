package com.etteplan.servicemanual.maintenancetask;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class TargetDeviceNoMaintenanceTasksFoundAdvice {
	@ResponseBody
    @ExceptionHandler(TargetDeviceHasNoMaintenanceTasksException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String factoryDeviceNotFoundHandler(TargetDeviceHasNoMaintenanceTasksException ex) {
        return ex.getMessage();
    }
}
