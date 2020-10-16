package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomsFromData  implements ISymptomWriter {



    @Override
    public  void saveSymptoms(Map <String, Integer> listOrderSymptoms) {


        if (listOrderSymptoms != null) {
            try {
                FileWriter writer = new FileWriter("result.out");


                for (Map.Entry<String, Integer> listFinalSymptoms : listOrderSymptoms.entrySet()) {
                    String key = listFinalSymptoms.getKey();
                    Integer value = listFinalSymptoms.getValue();
                    System.out.println(listFinalSymptoms);
                    writer.write(key + " = " + value + "\n");
                }


                writer.close();

            } catch (
                    IOException e) {

                System.err.println("Impossible de lire le contenu du fichier");
            }


        }


    }

}




