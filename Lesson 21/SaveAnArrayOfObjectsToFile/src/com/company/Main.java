package com.company;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static final String PATH = "Users/juda/Desktop/myfile.txt";

    public static void main(String[] args) {

        File file = new File(PATH);
        List<Expense> expenses = new ArrayList<>();
        expenses.add(new Expense("gas", 454444.656, "some gas"));
        expenses.add(new Expense("clothes", 3466545.3, "pink dress for Moshe"));
        expenses.add(new Expense("food", 126443.5, "Banana"));
        expenses.add(new Expense("Mac Book Pro", 23465.5, "i7 16GB RAM"));
        //writeToFile(file, expenses);

        /*List<Expense> expenses = readFromFile(file);
        for(Expense expense : expenses){
            System.out.println("expense: " + expense.getName() +
                    " " + expense.getPrice() +
                    " " + expense.getDescription());
        }*/


        //writeToFile2(file, expenses);
        List<Expense> expenses1 = readFromFile2(file);
        for(Expense expense : expenses1){
            System.out.println("expense: " + expense.getName() +
                    " " + expense.getPrice() +
                    " " + expense.getDescription());
        }

    }


    public static List<Expense> readFromFile2(File file){
        if(!file.exists())
            return null;
        InputStream inputStream = null;
        List<Expense> result = new ArrayList<>();
        try{
            inputStream = new FileInputStream(file);
            int nameLength;
            int actuallyRead;
            while((nameLength = inputStream.read()) != -1){
                byte[] nameBytes = new byte[nameLength];
                actuallyRead = inputStream.read(nameBytes);
                if(actuallyRead != nameLength)
                    throw new IOException();
                int descriptionLength = inputStream.read();
                if(descriptionLength == -1)
                    throw new IOException();
                byte[] descriptionBytes = new byte[descriptionLength];
                actuallyRead = inputStream.read(descriptionBytes);
                if(actuallyRead != descriptionLength)
                    throw new IOException();
                byte[] priceBytes = new byte[8];
                actuallyRead = inputStream.read(priceBytes);
                if(actuallyRead != 8)
                    throw new IOException();
                Expense expense = new Expense(
                        new String(nameBytes),
                        ByteBuffer.wrap(priceBytes).getDouble(),
                        new String(descriptionBytes));
                result.add(expense);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(inputStream != null)
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        return result;
    }

    public static void writeToFile2(File file, List<Expense> expenses){
        OutputStream outputStream = null;
        try{
            outputStream = new FileOutputStream(file);
            for(Expense expense : expenses){
                outputStream.write(expense.getBytes());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(outputStream != null)
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }


    public static void writeToFile(File file, List<Expense> expenses){
        OutputStream outputStream = null;
        JSONArray jsonExpenses = new JSONArray();
        try {
            for (Expense expense : expenses) {
                JSONObject jsonExpense = new JSONObject();
                jsonExpense.put("name", expense.getName());
                jsonExpense.put("price", expense.getPrice());
                jsonExpense.put("description", expense.getDescription());
                jsonExpenses.put(jsonExpense);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try{
            outputStream = new FileOutputStream(file);
            outputStream.write(jsonExpenses.toString().getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(outputStream != null)
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }


    public static List<Expense> readFromFile(File file) {
        if (!file.exists())
            return null;
        List<Expense> result = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        JSONArray jsonArray = null;
        InputStream inputStream = null;
        byte[] buffer = new byte[256];
        int actuallyRead;
        try {
            inputStream = new FileInputStream(file);
            while ((actuallyRead = inputStream.read(buffer)) != -1)
                stringBuilder.append(new String(buffer, 0, actuallyRead));
            jsonArray = new JSONArray(stringBuilder.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null)
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        if (jsonArray == null)
            return null;
        try {
            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonExpense = jsonArray.getJSONObject(i);
                Expense expense = new Expense(
                        jsonExpense.getString("name"),
                        jsonExpense.getDouble("price"),
                        jsonExpense.getString("description"));
                result.add(expense);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result;
    }
}
