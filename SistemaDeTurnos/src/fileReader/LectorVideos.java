/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileReader;

import TDA.CircularSimplyLinkedList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import static Serializado.Data.videos;

/**
 *
 * @author user
 */
public class LectorVideos {

   
     public static CircularSimplyLinkedList<String> leerArchivoVideos(){
        try(BufferedReader bf=new BufferedReader(new FileReader("src/recursos/archivos/videos.txt"))){
            String linea;
            while((linea=bf.readLine())!=null){
                videos.addLast(linea);
            }
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        
        return videos;
    }
    
}
