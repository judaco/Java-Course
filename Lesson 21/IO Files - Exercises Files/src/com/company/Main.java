package com.company;

import java.io.*;
import java.nio.ByteBuffer;

public class Main {

    static final String path = "/Users/Juda/Desktop/MyFile.dat";
    static final String path2 = "/Users/Juda/Desktop/MyFile2.dat";

    public static void main(String[] args) {

        createFile();
        removeAll(1);
        printFile();


    }

    static void createFile(){
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(path);
            byte[] bytes = new byte[4];
            for (int i = 0; i < 100; i++) {
                ByteBuffer.wrap(bytes).putInt(i%3);
                outputStream.write(bytes);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("file created");
    }

    static void printFile(){
        System.out.println("beginning of file");
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(path);
            byte[] bytes = new byte[4];
            int actuallyRead;
            while((actuallyRead=inputStream.read(bytes)) != -1){
                if(actuallyRead != 4){
                    System.out.println("error reading from file");
                    return;
                }
                int x = ByteBuffer.wrap(bytes).getInt();
                System.out.println(x);
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
        System.out.println("end of file");
    }

    static void removeAll(int numberToRemove) {
        System.out.println("start removing");
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = new FileInputStream(path);
            outputStream = new FileOutputStream(path2);
            byte[] bytes = new byte[4];
            int actuallyRead;
            while ((actuallyRead = inputStream.read(bytes)) != -1) {
                if (actuallyRead != 4) {
                    System.out.println("error reading from file");
                    return;
                }
                int x = ByteBuffer.wrap(bytes).getInt();
                if(x != numberToRemove){
                    outputStream.write(bytes);
                }
                System.out.println(x);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null)
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if(outputStream != null)
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        System.out.println("done removing");
        try {
            outputStream = new FileOutputStream(path);
            inputStream = new FileInputStream(path2);
            byte[] bytes = new byte[1024];
            int actuallyRead;
            while((actuallyRead = inputStream.read(bytes)) != -1){
                outputStream.write(bytes, 0, actuallyRead);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null)
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if(outputStream != null)
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        File file = new File(path2);
        file.delete();
    }
}
