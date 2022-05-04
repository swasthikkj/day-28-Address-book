package com.addressbook;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class JSONIO {
//    public static String CONTACT_READ_JSON = "src/main/resources/ContactRead.csv";
    public static String CONTACT_WRITE_JSON = "src/main/resources/ContactWriteJSON.html";
    ArrayList<Contact> entry = new ArrayList<>();
    Gson gson = new Gson();

    void addContact(){
        Contact obj1 = new Contact(1, "Swathi", "Kumari", "SLC", "Bhopal", "MP", "462022", "1234", "abc@gmail.com");
        Contact obj2 = new Contact(2, "Aashu", "Kumar", "BD", "Jaipur", "Rajasthan", "462025", "5678", "def@gmail.com");
        Contact obj3 = new Contact(3, "Arin", "Verma", "CB", "Bhopal", "MP", "462052", "3245", "ghi@gmail.com");
        Contact obj4 = new Contact(4, "Manju", "Verma", "TP", "Mumbai", "Maharastra", "467077", "1245", "asd@gmail.com");
        Contact obj5 = new Contact(5, "Jtmayay", "Mkpdh", "WF", "BLR", "Karnataka", "123416", "6969", "bal@gmail.com");
        Contact obj6 = new Contact(6, "James", "Bond", "KRMLA", "BLR", "Karnataka", "420696", "4201", "bad@gmail.com");
        entry.add(obj1);
        entry.add(obj2);
        entry.add(obj3);
        entry.add(obj4);
        entry.add(obj5);
        entry.add(obj6);
    }

    public void writeDataJSON(ArrayList<Contact> entries) throws IOException {
        Writer writer = new FileWriter(CONTACT_WRITE_JSON);
        Gson gson = new GsonBuilder().create();
        gson.toJson(entries, writer);
        writer.flush();
        writer.close();
    }
}