package com.hemebiotech.analytics;

import java.io.*;
import java.util.*;
import java.util.HashMap;
import java.util.List;


public class AnalyticsCounter {
	private static int headacheCount = 0;    // initialize to 0
	private static int rashCount = 0;        // initialize to 0
	private static int pupilCount = 0;        // initialize to 0

	private List<String> result;
	private Object tableMotCle;

	public void start() {

		this.GetSymptoms(); //appeler les symptomes
		this.countSymptoms(); // Les compter
		//this.orderSymptoms(); // Mettre en ordre alphabétique
		//this.saveSymptoms(); // Sauvegarder dans un fichier
	}


	private void GetSymptoms() {

		ReadSymptomDataFromFile readSymptomDataFromFile = new ReadSymptomDataFromFile("E:\\Etude\\Java\\Formation Java\\Projet 2\\Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application-master\\Project02Eclipse\\symptoms.txt");
		result = readSymptomDataFromFile.GetSymptoms();
		//System.out.println(result);
		return;

	}


	private void countSymptoms() {

		// compte les symptomes de result

		String fichier = "E:\\Etude\\Java\\Formation Java\\Projet 2\\Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application-master\\Project02Eclipse\\symptoms.txt";
		Map<String, Integer> symptoms = new HashMap<>();
		String ligne;


		try {
			BufferedReader br = new BufferedReader(new FileReader(fichier));

			while ((ligne = br.readLine()) != null) {
				ligne = ligne.toLowerCase();
				StringTokenizer st = new StringTokenizer(ligne);
				while (st.hasMoreTokens()) {
					String str = st.nextToken();
					if (symptoms.containsKey(str)) {
						symptoms.put(str, (symptoms.get(str) + 1));
					} else {
						symptoms.put(str, 1);
					}


				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		System.out.println(symptoms.toString());
		return;
	}


	/*private void orderSymptoms() throws NullPointerException {


		Collections.sort(countSymptoms());
		System.out.println(tableMotCle);

	}

	/*private void saveSymptoms() {

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

	}*/
}


