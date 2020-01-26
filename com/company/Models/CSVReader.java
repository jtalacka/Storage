package com.company.Models;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CSVReader {
    String csvFile;
    BufferedReader br = null;
    String line = "";
    String cvsSplitBy = ",";
    public CSVReader(String csvFile){
        this.csvFile=csvFile;
    }
    public void populateItems(Items items){
        items.clearData();
        try{
            br = new BufferedReader(new FileReader(csvFile));
            line=br.readLine();
            for(String parameters:line.split(cvsSplitBy)){
                items.addParameter(parameters);
            }
            while ((line = br.readLine()) != null) {

                String[] itemValues = line.split(cvsSplitBy);
                items.addToItemList(new Item(itemValues[0],itemValues[1],Integer.parseInt(itemValues[2]),itemValues[3]));

            }

        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
