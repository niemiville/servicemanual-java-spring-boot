package com.etteplan.servicemanual.maintenancetask;

public class MaintenanceTaskNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

    MaintenanceTaskNotFoundException(Long id) {
        super("Could not find maintenance task " + id);
    }
}
