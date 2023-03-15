import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    public String albumName;
    public String artistName;
    public List<Song> songList;//list of songs in album

    public Album(String albumName, String artistName) {
        this.albumName = albumName;
        this.artistName = artistName;
        songList = new ArrayList<>();
    }
    public boolean findSonginAlbum(String title)
    {
        for(Song song:songList)
        {
            if(title.equals(song.name))return true;
        }
        return false;
    }
    public String addSongToAlbum(String title,double duration)
    {
        //check
        if(findSonginAlbum(title))return"Song is already present in album";
        //adding song to album
        songList.add(new Song(title,duration));
        return "Song has been added to album successfully";
    }
    public String addSongToPlayList(int trackNo, LinkedList<Song> playList)
    {
       int index=trackNo-1;//index of song in songlist is one less than track no
       if(index>=0 && index<this.songList.size())
       {
           playList.add(songList.get(index));
           return "Song has been added to playlist successfully";
       }
        return "trackNO doesnot exist";
    }
    public String addSongToPlayList(String title, LinkedList<Song> playList)
    {
         //searching for song in album list
        for(Song song:songList)
        {
            if(title.equals(song.name)) {
                playList.add(song);
                return "Song has been added to playlist successfully";
            }
        }
        return "Song doesnot exist in the album";
    }

}
