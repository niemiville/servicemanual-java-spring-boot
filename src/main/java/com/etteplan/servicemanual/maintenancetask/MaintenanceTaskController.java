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

/**
 * RESTful API controller for MaintenanceTask.
 * 
 * @author Ville Niemi
 */
@RestController
public class MaintenanceTaskController {

    private final MaintenanceTaskRepository repository;

    MaintenanceTaskController(MaintenanceTaskRepository repository) {
        this.repository = repository;
    }

    /**
     * Find all maintenance tasks operation with ordering by severity then by registration time.
     * @return List of all maintenance tasks.
     */
    @GetMapping("/maintenancetasks")
    List<MaintenanceTask> all() {
        return repository.findAllByOrderBySeverityAscRegistrationTimeAsc();
    }
    
    /**
     * Find all tasks by target device id.
     * @param targetId id of the target device.
     * @return list of all maintenance tasks directed to certain target device.
     */
    @GetMapping("/maintenancetasks/target/{targetId}")
    List<MaintenanceTask> byTarget(@PathVariable Long targetId) {
    	List<MaintenanceTask> tasks = repository.findByTargetId(targetId);
    	if(tasks.isEmpty()) {
    		throw new TargetDeviceHasNoMaintenanceTasksException(targetId);
    	}
        return tasks;
    }
    
    /**
     * Find maintenance task by id.
     * @param id id of the maintenance task.
     * @return single maintenance task.
     */
    @GetMapping("/maintenancetasks/{id}")
    MaintenanceTask one(@PathVariable Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new MaintenanceTaskNotFoundException(id));
    }
    
    /**
     * Saves new maintenance task.
     * @param task task to be saved.
     * @return the saved task.
     */
	@PostMapping("/maintenancetasks") 
	MaintenanceTask saveMaintenanceTask(
	  @Validated @RequestBody MaintenanceTask task) { 
		return repository.save(task);
	}
	
    /**
     * Updates the maintenance task specified by id with new values.
     * @param task new values for old task.
     * @param taskId id of the task to be updated.
     * @return the updated task or null if update failed.
     */
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
			new MaintenanceTaskNotFoundException(taskId);
		}
        return null;
    }
  
    /**
     * Deletes existing maintenance task.
     * @param taskId id of the task.
     * @return message of succesful deletion.
     */
    @DeleteMapping("/maintenancetasks/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long taskId)
    {
    	try {
    		repository.deleteById(taskId);
    	} catch (Exception e) {
    		e.printStackTrace();
    		throw new MaintenanceTaskNotFoundException(taskId);
    	}
    	return "Maintenance task deleted successfully.";
    }
	
}
