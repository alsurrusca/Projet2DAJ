package com.hemebiotech.analytics;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;
import java.util.ArrayList;




public class AnalyticsCounter {
	private static int headacheCount = 0;    // initialize to 0
	private static int rashCount = 0;        // initialize to 0
	private static int pupilCount = 0;        // initialize to 0

	private ArrayList<String> result;

	public void start() throws IOException {

		this.GetSymptoms(); //appeler les symptomes
		this.countSymptoms(); // Les compter
		//this.orderSymptoms(); // Mettre en ordre alphabétique
		//this.saveSymptoms(); // Sauvegarder dans un fichier
	}


	private ArrayList<String> GetSymptoms() {

		ReadSymptomDataFromFile readSymptomDataFromFile = new ReadSymptomDataFromFile("E:\\Etude\\Java\\Formation Java\\Projet 2\\Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application-master\\Project02Eclipse\\symptoms.txt");
		result = (ArrayList<String>) readSymptomDataFromFile.GetSymptoms();
		return result;

	}


	private void countSymptoms()  {

		// compte les symptomes de result

		ArrayList<String> liste = GetSymptoms();

		ArrayList<String> L1 = new ArrayList<>();
		L1 = liste;
			for(String str:liste);
			for(String o:L1);
			System.out.println(L1.size());

			ArrayList<String> L2 = new ArrayList<>();
		L2 = liste;
			for (String str : liste);
			for(String o:L2);
			System.out.println(L2.size());
			System.out.println(L2.get(5));


			ArrayList<String> L3 = new ArrayList<String>();
			for (int i=0; i< L1.size(); i++){
				if(L1.get(i).equals(L2.get(i)))
					L3.add("1");
				else
					L3.add("O");
			}

			System.out.println(L1.get(1));
			System.out.println(L2.get(1));
			System.out.println("L3 = " +L3);



	 } }



