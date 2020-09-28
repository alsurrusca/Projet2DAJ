package com.hemebiotech.analytics;

import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


public class AnalyticsCounter {
	private static int headacheCount = 0;    // initialize to 0
	private static int rashCount = 0;        // initialize to 0
	private static int pupilCount = 0;        // initialize to 0

	private List<String> ListSymptoms;
	private Map<String, Integer> ListSymptomsCount = new HashMap<String, Integer>();
	private Map<String, Integer> ListOrderSymptoms;



	public void start() {

		this.getSymptoms(); //appeler les symptomes
		this.countSymptoms(); // Les compter
		this.orderSymptoms(); // Mettre en ordre alphabétique
		this.saveSymptoms(); // Sauvegarder dans un fichier
	}


	private void getSymptoms() {

		ReadSymptomDataFromFile readSymptomDataFromFile = new ReadSymptomDataFromFile("E:\\Etude\\Java\\Formation Java\\Projet 2\\Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application-master\\Project02Eclipse\\symptoms.txt");
		ListSymptoms = readSymptomDataFromFile.getSymptoms();
		//System.out.println(result);


	}


	private void countSymptoms() {

		// compte les symptomes de result

		for(String symptom : ListSymptoms) {

		if (ListSymptomsCount.containsKey(symptom)) { // On teste et utilise la variable
			ListSymptomsCount.put(symptom, (ListSymptomsCount.get(symptom) + 1)); // Si le mot y est, ajouter +1
		}
			else {
				ListSymptomsCount.put(symptom, 1); // Sinon le mettre à 1
		}

		}


		//System.out.println(ListSymptomsCount);



	}




	private  void orderSymptoms()  {





		ListOrderSymptoms = ListSymptomsCount.entrySet()
				.stream()
				.sorted(Map.Entry.comparingByKey())
				.collect(Collectors.toMap(
						Map.Entry :: getKey,
						Map.Entry :: getValue,
						(oldValue, newValue) -> oldValue, LinkedHashMap::new
				));




	}



	private void saveSymptoms() {

		System.out.println(ListOrderSymptoms);

		// next generate output
		try {
			FileWriter writer = new FileWriter("result.out");
			writer.write("headache: " + headacheCount + "\n");
			writer.write("rash: " + rashCount + "\n");
			writer.write("dilated pupils: " + pupilCount + "\n");
			writer.close();

		} catch (IOException e) {

			System.err.println("Impossible de lire le contenu du fichier");
		}

	}}



