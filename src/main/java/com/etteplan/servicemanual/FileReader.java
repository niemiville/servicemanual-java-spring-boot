package com.etteplan.servicemanual;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.etteplan.servicemanual.factorydevice.FactoryDevice;
import com.etteplan.servicemanual.maintenancetask.MaintenanceTask;

import java.util.ArrayList;
import java.util.List;

public class FileReader {

	
	public static List<FactoryDevice> deviceDataReader(String filePath) {
		List<FactoryDevice> devices = new ArrayList<>();
		try {
			Scanner fileReader = new Scanner(new File(filePath));
			if (fileReader.hasNextLine()) fileReader.nextLine(); //Skipping the header row.
			while (fileReader.hasNextLine()) {
				String splittedRow[] = fileReader.nextLine().split(",");
				devices.add(new FactoryDevice(splittedRow[0], Integer.parseInt(splittedRow[1]), splittedRow[2]));
			}
			fileReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return devices;
	}
	
	public static List<MaintenanceTask> taskDataReader(String filePath) {
		List<MaintenanceTask> tasks = new ArrayList<>();
		try {
			Scanner fileReader = new Scanner(new File(filePath));
			if (fileReader.hasNextLine()) fileReader.nextLine(); //Skipping the header row.
			while (fileReader.hasNextLine()) {
				String splittedRow[] = fileReader.nextLine().split(",");
				System.out.print(splittedRow[2]);
				tasks.add(new MaintenanceTask(Long.parseLong(splittedRow[0]), splittedRow[1], splittedRow[2], splittedRow[3]));
			}
			fileReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(MaintenanceTask t : tasks) {
			System.out.println(t.toString());
		}
		
		return tasks;
	}
}
