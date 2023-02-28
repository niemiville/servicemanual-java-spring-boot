package com.etteplan.servicemanual.maintenancetask;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MaintenanceTaskRepository extends JpaRepository<MaintenanceTask, Long> {
    
	public List<MaintenanceTask> findAllByOrderBySeverityAscRegistrationTimeAsc();
	
	public List<MaintenanceTask> findByTargetId(Long targetId);
}
