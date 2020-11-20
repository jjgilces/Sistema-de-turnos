/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javafx.fxml.FXML;
import javafx.scene.media.MediaView;
import TDA.CircularSimplyLinkedList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author user
 */
public class VisorVideos {
    private MediaView mediaVideo;
    private Media media;
    private MediaPlayer mediaPlayer;

    
//    public VisorVideos(){
//        createMediaView(leerVideos());   
//    }
    
    public VisorVideos(MediaView mediaVideo){
        this.mediaVideo = mediaVideo;
    }

    
    public void initMediaPlayer(){
        mediaPlayer = new MediaPlayer(new Media(new File(("src/recursos/videos/video1.mp4")).toURI().toString()));
        mediaPlayer.setAutoPlay(true);
//        mediaPlayer.setOnEndOfMedia(() -> {
//            initMediaPlayer(mediaView);
//        });
        mediaVideo.setMediaPlayer(mediaPlayer);
       
    }
    
    
     public static CircularSimplyLinkedList<String> leerVideos(){
        CircularSimplyLinkedList<String> videos=new CircularSimplyLinkedList<>();
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
