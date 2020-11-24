/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import TDA.CircularSimplyLinkedList;
import java.io.File;
import javafx.fxml.FXML;
import javafx.scene.media.MediaView;
import java.util.Iterator;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author user
 */
public class VisorVideos {
    private MediaView mediaView;
    private Media media;
    private MediaPlayer mediaPlayer;

    
    
    public VisorVideos(MediaView mediaVideo){
        this.mediaView = mediaVideo;
    }

    
//    public void initMediaPlayer(){
//        String file = this.getClass().getResource("/recursos/videos/video1.mp4").toExternalForm();
//        Media media = new Media(file);
//        mediaPlayer = new MediaPlayer(media);
//        mediaPlayer.setAutoPlay(true);
//        mediaView.setMediaPlayer(mediaPlayer);
//       
//    }

    
    private void initMediaPlayer(Iterator<String> iterador){
        if (iterador.hasNext()){
        mediaPlayer = new MediaPlayer(new Media(new File(("src/recursos/videos/"+iterador.next())).toURI().toString()));
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setOnEndOfMedia(() -> {
            initMediaPlayer( iterador);
        });
        mediaView.setMediaPlayer(mediaPlayer);
    }}
    
    public void createMediaView(CircularSimplyLinkedList videos){
        initMediaPlayer( videos.iterator());
        mediaView.setOnMouseClicked(e->{
            if(mediaView.getMediaPlayer().getStatus()==MediaPlayer.Status.PLAYING){
                mediaView.getMediaPlayer().pause();
            }else if(mediaView.getMediaPlayer().getStatus()==MediaPlayer.Status.PAUSED){
                
                mediaView.getMediaPlayer().play();
            }
        });
    }
    
}
