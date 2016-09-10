package com.company;

import java.io.*;
import java.nio.ByteBuffer;

public class Main {

    public static void main(String[] args) {
        Dog d = new Dog("snoopy", 300);
        try {
            /*OutputStream outputStream =
                    new FileOutputStream("/Users/Juda/Desktop/myfile.txt");
            //String s = "hello world";
            outputStream.write(d.toBytes());
            outputStream.close();*/
            InputStream inputStream = new FileInputStream("/Users/Juda/Desktop/myfile.txt");
            byte[] buffer = new byte[1024];
            int actuallyRead;
            actuallyRead = inputStream.read(buffer);
            Dog d2 = new Dog(buffer, actuallyRead);
            System.out.println(d2.getAge());
            System.out.println(d2.getName());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Dog{
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Dog(byte[] bytes, int length){
        this.age = ByteBuffer.wrap(bytes).getInt(0);
        this.name = new String(bytes, 4, length-4);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }





    public byte[] toBytes(){
        byte[] bytes = new byte[4 + name.length()];

//        bytes[0] = (byte)(age>>24);
//        bytes[1] = (byte)(age>>16);
//        bytes[2] = (byte)(age>>8);
//        bytes[3] = (byte) age;
        ByteBuffer.wrap(bytes).putInt(0, age);
        byte[] nameBytes = name.getBytes();
        for (int i = 0; i < nameBytes.length; i++) {
            bytes[4 + i] = nameBytes[i];
        }
        return bytes;
    }
}
