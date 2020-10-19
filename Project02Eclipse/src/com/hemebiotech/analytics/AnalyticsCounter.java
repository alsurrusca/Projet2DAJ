package com.hemebiotech.analytics;

import java.util.*;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Read, count and make symptoms in order.
 * @author Alissia Surrusca
 *
 *
 */




public class AnalyticsCounter {


	private List<String> listSymptoms;
	private Map<String, Integer> listSymptomsCount = new HashMap<String, Integer>();
	private Map<String, Integer> listOrderSymptoms;


	public void start()  {

		this.getSymptoms();
		this.countSymptoms();
		this.orderSymptoms();
		this.saveSymptoms();
	}


	private void getSymptoms() {

		/**
		 * @see ReadSymptomDataFromFile
		 */

		ReadSymptomDataFromFile readSymptomDataFromFile = new ReadSymptomDataFromFile("E:\\Etude\\Java\\Formation Java\\Projet 2\\Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application-master\\Project02Eclipse\\symptoms.txt");
		listSymptoms = readSymptomDataFromFile.getSymptoms();



	}


	private void countSymptoms() {

		/**
		 * @param listSymtoms
		 * @return list which count all symptom's occurrences
		 *
		 */

		for(String symptom : listSymptoms) {

		if (listSymptomsCount.containsKey(symptom)) { //check if key is on the Map
			listSymptomsCount.put(symptom, (listSymptomsCount.get(symptom) + 1)); // Key is ok, we count +1
		}
			else {
				listSymptomsCount.put(symptom, 1); //Key isn't ok, symptom = 1
			}


		}


	}




	public void orderSymptoms()  {

		/**
		 * Create a set of the same elements contained in the hash map
		 * Order by key
		 * @return LinkedHashMap
		 *
		 */
		listOrderSymptoms = listSymptomsCount.entrySet()
				.stream()
				.sorted(Map.Entry.comparingByKey())
				.collect(Collectors.toMap(
						Map.Entry :: getKey,
						Map.Entry :: getValue,
						(oldValue, newValue) -> oldValue, LinkedHashMap::new


				));

	}






	private void saveSymptoms() {

		/**
		 *
		 * Call WriteSymptomsFromData
		 *
		 * @see WriteSymptomsFromData
		 *
		 * @return void
		 *
		 */


			WriteSymptomsFromData writeSymptomsFromData = new WriteSymptomsFromData();
			writeSymptomsFromData.saveSymptoms(listOrderSymptoms);


	}


	}



