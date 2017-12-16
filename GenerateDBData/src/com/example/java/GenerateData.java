package com.example.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerateData {

    Random rand;

    List<String> lastName;
    List<String> firstMale;
    List<String> firstFemale;
    List<String> address;

    public GenerateData(){

        rand = new Random();
        lastName = new ArrayList<String>();
        firstMale = new ArrayList<String>();
        firstFemale = new ArrayList<String>();
        address = new ArrayList<String>();

        try {
            this.readFile(this.lastName, "src/com/example/java/allLast.txt", 0);
            this.readFile(firstMale, "src/com/example/java/allMale.txt", 0);
            this.readFile(this.firstFemale, "src/com/example/java/allFemale.txt", 0);
            this.readFile(this.address, "src/com/example/java/street.txt", 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getFullName(String gender){

        int indexLast = rand.nextInt(this.lastName.size());
        String lastName = this.lastName.get(indexLast);
        String firstName = "";

        if(gender=="F"){
            int index = rand.nextInt(this.firstFemale.size());
            firstName = firstFemale.get(index);
        }else{
            int index = rand.nextInt(this.firstMale.size());
            firstName = firstMale.get(index);
        }
        return firstName+" "+lastName;
    }

    public String getAddress(String city, String province){

        // generate street and street nr.
        int streetNr = rand.nextInt(9999) + 1;

        int index = rand.nextInt(this.address.size());
        String street = this.address.get(index).toUpperCase();

       return streetNr+" "+street+", "+city.toUpperCase()+", "+province.toUpperCase();
    }

    public String getPhoneNumber(List<Integer>areaCode){

        int max = 9999;
        int min = 1111;
        int range = max - min + 1;
        int lastFour =  rand.nextInt(range) + min;

        max = 999;
        min = 111;
        range = max - min + 1;
        int firstThree =  rand.nextInt(range) + min;

        int index = rand.nextInt(areaCode.size());

        return "("+areaCode.get(index)+")"+firstThree+"-"+lastFour;

    }

    public long getID(){

        long max = 999999999;
        long min = 111111111;

        return min+((long)(rand.nextDouble()*(max-min)));
    }


    public void readFile(List<String> list, String path, int all) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        try {

            String line = null;
            try {
                line = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            while (line != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(line);
                String [] s = sb.toString().split(" ");
                //System.out.println(s[0]);
                if(all==0) list.add(s[0]);
                else{
                    list.add(String.join(" ", s));
                }
                line = br.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            br.close();
        }

    }


}
