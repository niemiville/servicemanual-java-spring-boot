package com.etteplan.servicemanual;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.etteplan.servicemanual.factorydevice.FactoryDeviceRepository;
import com.etteplan.servicemanual.maintenancetask.MaintenanceTaskRepository;

@SpringBootApplication
public class ServiceManualApplication {

    public static void main(final String[] args) {
        SpringApplication.run(ServiceManualApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(final FactoryDeviceRepository deviceRepository, final MaintenanceTaskRepository taskRepository) {
        return (args) -> {
            
        	//Adding seed data for devices.
            deviceRepository.saveAll(FileReader.deviceDataReader("./device_seed_data.csv"));
            
            //Adding seed data for tasks.
            taskRepository.saveAll(FileReader.taskDataReader("./maintenance_task_seed_data.csv"));
        };
    }

}