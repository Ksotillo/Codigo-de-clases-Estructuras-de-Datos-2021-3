/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.LinkedList;
import Model.Song;
import java.util.Map.Entry;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Ksotillo
 */
public class Controller {
    
    private LinkedList mapDataFromJSON(JSONArray data) {
        LinkedList<Song> list = new LinkedList<>();
        
        for (Object s : data) {
            JSONObject songJSON = (JSONObject)s;
            Object[] entries = songJSON.entrySet().toArray();
            String[] attributes = new String[entries.length];
            String[] values = new String[entries.length];
            for (int i = 0; i < entries.length; i++) {
                String[] entry = entries[i].toString().split("=");
                attributes[i] = entry[0];
                if (entry[0].equals("album")) {
                    Entry albumEntry = (Entry) entries[i];
                    JSONObject album = (JSONObject) albumEntry.getValue();
                    values[i] = album.get("title").toString();
                } else {
                    values[i] = entry[1];
                }
            }
            
            Song song = mapDataToSong(attributes, values);
            list.addLast(song);
            
        }
        
        return list;
    }
    
    private Song mapDataToSong(String[] attributes, String[] values) {
        Song song = new Song();
        for (int i = 0; i < attributes.length; i++) {
            String attribute = attributes[i];
            String value = values[i];
            
            switch (attribute) {
                case "id":
                    song.setId(Long.parseLong(value));
                    break;
                case "title":
                    song.setTitle(value);
                    break;
                case "titleShort":
                    song.setTitle_short(value);
                    break;
                case "album":
                    song.setAlbum(value);
                    break;
                case "link":
                    song.setLink(value);
                    break;
                case "duration":
                    song.setDuration(Integer.parseInt(value));
                    break;
                case "rank":
                    song.setRank(Integer.parseInt(value));
                    break;
                case "explicityLyrics":
                    song.setExplicit_lyrics("TRUE".equals(value));
                    break;
                case "preview":
                    song.setPreview(value);
                default:
                    break;
            }
            
        }
        
        song.setIsSingle(song.getAlbum().equals(song.getTitle()));
        
        return song;
    }
    
    
    private LinkedList mapRawData(String data, String sep) {
        LinkedList<Song> list = new LinkedList<>();
        
        String[] songs = data.split("\n");
        String[] attributes = songs[0].split(sep);
        for (int i = 1; i < songs.length; i++) {
            String[] songInfo = songs[i].split(sep);
            Song song = mapDataToSong(attributes, songInfo);
            list.addLast(song);
        }
        
        return list;
    }
    
    
    public void main() {
        ReadFile reader = new ReadFile();
        LinkedList list;
        String songs = reader.readFile("src\\files\\benito.txt");
//        System.out.println(songs);
        list = mapRawData(songs, "_");
        list.print();
        songs = reader.readFile("src\\files\\benito.csv");
//        System.out.println(songs);
        list = mapRawData(songs, ",");
        list.print();
        JSONArray songs3 = reader.readJson("src\\files\\benito.json");
        list = mapDataFromJSON(songs3);
        list.print();
        
        
    }
    
}
