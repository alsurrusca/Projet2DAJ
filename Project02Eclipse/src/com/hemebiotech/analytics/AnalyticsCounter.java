package com.hemebiotech.analytics;

import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class AnalyticsCounter {


	private List<String> listSymptoms;
	private Map<String, Integer> listSymptomsCount = new HashMap<String, Integer>();
	private Map<String, Integer> listOrderSymptoms;
	private Map<String, Integer> listFinalSymptoms;



	public void start() {

		this.getSymptoms(); //appeler les symptomes
		this.countSymptoms(); // Les compter
		this.orderSymptoms(); // Mettre en ordre alphabétique
		this.saveSymptoms(); // Sauvegarder dans un fichier
	}


	private void getSymptoms() {

		ReadSymptomDataFromFile readSymptomDataFromFile = new ReadSymptomDataFromFile("E:\\Etude\\Java\\Formation Java\\Projet 2\\Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application-master\\Project02Eclipse\\symptoms.txt");
		listSymptoms = readSymptomDataFromFile.getSymptoms();
		//System.out.println(result);


	}


	private void countSymptoms() {

		// compte les symptomes de result

		for(String symptom : listSymptoms) {

		if (listSymptomsCount.containsKey(symptom)) { // On vérifie si la clé est dans le tableau
			listSymptomsCount.put(symptom, (listSymptomsCount.get(symptom) + 1)); // Si le mot est présent, ajouter +1
		}
			else {
				listSymptomsCount.put(symptom, 1); // Sinon on l'initialise à 1
		}

		}


		//System.out.println(ListSymptomsCount);



	}




	private  void orderSymptoms()  {





		listOrderSymptoms = listSymptomsCount.entrySet()
				.stream()
				.sorted(Map.Entry.comparingByKey())
				.collect(Collectors.toMap(
						Map.Entry :: getKey,
						Map.Entry :: getValue,
						(oldValue, newValue) -> oldValue, LinkedHashMap::new

				));



		}






	private void saveSymptoms() throws IOException {



		FileWriter writer = new FileWriter("result.out");

				for( String listFinalSymptoms : listOrderSymptoms) {

					if (listOrderSymptoms.containsKey(listFinalSymptoms)) { // On vérifie si la clé est dans le tableau
				writer.write(listOrderSymptoms.put(listFinalSymptoms ,(listOrderSymptoms.get(listFinalSymptoms)))); // Si le mot est présent, ajouter +1

			} else {
				writer.write(listOrderSymptoms.put(listFinalSymptoms, 1));
			}

		/* next generate output
		try {


			FileWriter writer = new FileWriter("result.out");
			writer.write(String.valueOf(listFinalSymptoms));
			writer.write("\n");
			writer.close();

		} catch (IOException e) {

			System.err.println("Impossible de lire le contenu du fichier");
		}*/


	}}



