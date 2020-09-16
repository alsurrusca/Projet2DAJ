package com.hemebiotech.analytics;

import java.io.*;
import java.util.List;


public class AnalyticsCounter {
	private static int headacheCount = 0;    // initialize to 0
	private static int rashCount = 0;        // initialize to 0
	private static int pupilCount = 0;        // initialize to 0

	private List<String> result;

	public void start() {

		this.getSymptoms(); //appeler les symptomes
		this.countSymptoms(); // Les compter
		this.orderSymptoms(); // Mettre en ordre alphabétique
		this.saveSymptoms(); // Sauvegarder dans un fichier
	}


	private void getSymptoms() {

		ReadSymptomDataFromFile readSymptomDataFromFile = new ReadSymptomDataFromFile("symptoms.txt");
		result = readSymptomDataFromFile.GetSymptoms();

	}


	private void countSymptoms() {

		// compte les symptomes de result
	}

	private void orderSymptoms() {

		// Mettre en ordre alphabétique les symptomes.
	}

	private void saveSymptoms() {

		// next generate output
		try {
			FileWriter writer = new FileWriter("result.out");
			writer.write("headache: " + headacheCount + "\n");
			writer.write("rash: " + rashCount + "\n");
			writer.write("dialated pupils: " + pupilCount + "\n");
			writer.close();

		} catch (IOException e) {

			System.err.println("Impossible de lire le contenu du fichier");
		}
	}
}

