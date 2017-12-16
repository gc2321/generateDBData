package com.example.java;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        GenerateData gd = new GenerateData();

        //System.out.println(gd.getAddress("Vancouver", "BC"));

        for(int i = 0; i < 100; i++){

            String gender;
            if(i%2==0){
                gender = "F";
            }else{
                gender = "M";
            }

            int patientID = i+1;
            long PHN = gd.getID();
            String name = gd.getFullName(gender);
            String address = gd.getAddress("Vancouver", "BC");

            List<Integer> areaCode = new ArrayList<>(Arrays.asList(604, 778));
            String phoneNumber = gd.getPhoneNumber(areaCode);

            String ret = "INSERT into patient values ("+patientID+", "+PHN+", '"+name+"', '"
                    +gender+"', '"+ address +"', '"+phoneNumber+"');";

            System.out.println(ret);


        }



    }
}
