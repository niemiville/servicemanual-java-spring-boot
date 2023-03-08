package com.etteplan.servicemanual;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.etteplan.servicemanual.factorydevice.FactoryDevice;
import com.etteplan.servicemanual.maintenancetask.MaintenanceTask;

import java.util.ArrayList;
import java.util.List;

/**
 * File reader for FactoryDevice and MaintenanceTask seed data.
 * 
 * @author Ville Niemi
 */
public class FileReader {

	/**
	 * Reads csv file of FactoryDevice data and creates equivalent list of objects. 
	 * 
	 * @param filePath
	 * @return list of FactoryDevice objects
	 */
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
	
	/**
	 * Reads csv file of MaintenanceTask data and creates equivalent list of objects. 
	 * 
	 * @param filePath
	 * @return list of MaintenanceTask objects
	 */
	public static List<MaintenanceTask> taskDataReader(String filePath) {
		List<MaintenanceTask> tasks = new ArrayList<>();
		try {
			Scanner fileReader = new Scanner(new File(filePath));
			if (fileReader.hasNextLine()) fileReader.nextLine(); //Skipping the header row.
			while (fileReader.hasNextLine()) {
				String splittedRow[] = fileReader.nextLine().split(",");
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
