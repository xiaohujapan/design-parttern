package org.dxh.pattern.adapter;

import org.dxh.pattern.adapter.advance.AdvancedMediaPlayer;
import org.dxh.pattern.adapter.advance.Mp4Player;
import org.dxh.pattern.adapter.advance.VlcPlayer;

public class MediaAdapter implements MediaPlayer {
	
	 AdvancedMediaPlayer advancedMusicPlayer;
	   
	 public MediaAdapter(String audioType){
	    if(audioType.equalsIgnoreCase("vlc") ){
	       advancedMusicPlayer = new VlcPlayer();       
	    } else if (audioType.equalsIgnoreCase("mp4")){
	       advancedMusicPlayer = new Mp4Player();
	    }  
	 }

	@Override
	public void play(String audioType, String fileName) {
		// TODO Auto-generated method stub
	    if(audioType.equalsIgnoreCase("vlc")){
	        advancedMusicPlayer.playVlc(fileName);
	    }else if(audioType.equalsIgnoreCase("mp4")){
	       advancedMusicPlayer.playMp4(fileName);
	    }
	}

}
