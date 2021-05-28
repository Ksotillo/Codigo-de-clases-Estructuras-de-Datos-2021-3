/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Ksotillo
 */
public class ReadFile {
    
    public String readFile(String path) {
        String line;
        String data = "";
        File file = new File(path);
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            while((line = br.readLine()) != null) {
                if (!line.isEmpty()) 
                    data += line + "\n";
            }
            br.close();
            
        } catch (Exception ex) {
            System.out.println("Ocurrio el siguiente error: " + ex);
        }
        
        return data;
    }
    
    
    public JSONArray readJson(String path) {
        JSONParser parser = new JSONParser();
        
        try {
            File file = new File(path);
            FileReader fr = new FileReader(file);
            JSONArray data = (JSONArray) parser.parse(fr);
            return data;
        } catch (FileNotFoundException e) {
            // En caso de que no se encuentre el archivo o no exista
            e.printStackTrace();
        } catch (IOException e) {
            // En case de que ocurra un error leyendo el archivo
            e.printStackTrace();
        }catch (ParseException e) {
            // En caso de que ocurra un error transformando el archivo
            e.printStackTrace();
        }
        return null;
    }
    
}
