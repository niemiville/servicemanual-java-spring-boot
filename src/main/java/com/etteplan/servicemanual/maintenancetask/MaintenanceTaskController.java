package com.etteplan.servicemanual.maintenancetask;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class MaintenanceTaskController {

    private final MaintenanceTaskRepository repository;

    MaintenanceTaskController(MaintenanceTaskRepository repository) {
        this.repository = repository;
    }

    //Find all operation with ordering by severity then by registration time
    @GetMapping("/maintenancetasks")
    List<MaintenanceTask> all() {
        return repository.findAllByOrderBySeverityAscRegistrationTimeAsc();
    }
    
    // Find all tasks by target device id
    @GetMapping("/maintenancetasks/target/{targetId}")
    List<MaintenanceTask> byTarget(@PathVariable Long targetId) throws Exception {
        return repository.findByTargetId(targetId);
    }
    
    // Find by id operation
    @GetMapping("/maintenancetasks/{id}")
    MaintenanceTask one(@PathVariable Long id) throws Exception {
        return repository.findById(id)
            .orElseThrow(() -> new Exception());
    }
    
    // Save operation
	@PostMapping("/maintenancetasks") 
	MaintenanceTask saveMaintenanceTask(
	  @Validated @RequestBody MaintenanceTask task) { 
		return repository.save(task);
	}
	
    // Update operation
    @PutMapping("/maintenancetasks/{id}")
    MaintenanceTask updateTask(@RequestBody MaintenanceTask task,
                     @PathVariable("id") Long taskId)
    {
    	Optional<MaintenanceTask> oldTask = repository.findById(taskId);
    	if (oldTask.isPresent()) {
			MaintenanceTask _task = oldTask.get();
			_task.setTargetId(task.getTargetId());
			_task.setDescription(task.getDescription());
			_task.setSeverity(task.getSeverity());
			_task.setStatus(task.getStatus());
			
			return repository.save(_task);
		} else {
			new Exception();
		}
        return null;
    }
  
    // Delete operation
    @DeleteMapping("/maintenancetasks/{id}")
    public void deleteDepartmentById(@PathVariable("id")
                                       Long taskId)
    {
    	repository.deleteById(taskId); 
    }
	
}
