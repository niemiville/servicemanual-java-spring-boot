package com.etteplan.servicemanual.maintenancetask;

public class TargetDeviceHasNoMaintenanceTasksException extends RuntimeException {

	private static final long serialVersionUID = 1L;

    TargetDeviceHasNoMaintenanceTasksException(Long id) {
        super("Could not find device with id " + id);
    }
}
