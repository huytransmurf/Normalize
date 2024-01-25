/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

/**
 *
 * @author LAPTOP ACER
 */
public class Text {

    public String getNormalizedText() {
        return normalizedText.trim();
    }
    
    private String normalizedText;

    public Text() {
        loadData("Text.txt");
    }

    public void loadData(String fName) {
        StringBuilder sb = new StringBuilder();
        try {
            Scanner sc = new Scanner(new FileReader(fName));
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                sb.append(line);
            }
            sc.close();
        } catch (FileNotFoundException ex) {
            System.out.println("file not exist");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("out of bound");
        }
        normalizedText = sb.toString().trim();
    }

    public void saveFile(String file) throws IOException {
        try (FileWriter f = new FileWriter(new File(file))) {
            f.write(normalizedText);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private String capitalize(String text) {
        String[] words = text.split("\\s*\\.");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {

            words[i] = doCapitalize(words[i].trim());
            sb.append(words[i].trim());
            sb.append(". ");

        }
        return sb.toString();
    }

    private String doCapitalize(String word) {
        return Character.toUpperCase(word.charAt(0)) + word.substring(1);
    }
    public void doNormalize(){
        normalizedText=normalizedText.replaceAll("\\s+", " ").toLowerCase();
        normalizedText = capitalize(normalizedText);
        normalizedText = normalizedText.replaceAll("\\s*[,:]\\s*", ", ");
        normalizedText = normalizedText.replaceAll("\\s*\"\\s*", "\"");
    }
   

}
