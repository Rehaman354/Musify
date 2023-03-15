import java.util.*;

public class Main {
    public static List<Album> albums=new ArrayList<>();
    public static void main(String[] args)
    {
        //adding albums to albumslist
      Album album1=new Album("Old songs","ArjitSingh");

      album1.addSongToAlbum("TumHiHo",3.5);
      album1.addSongToAlbum("Bekhayali",3.52);
      album1.addSongToAlbum("pattanjoom",3.4);
      albums.add(album1);

        Album album2=new Album("New songs","A.R.Rehman");

        album2.addSongToAlbum("sakiya",3.56);
        album2.addSongToAlbum("rangde",3.46);
        album2.addSongToAlbum("nadhan",3.49);
        albums.add(album2);

        //creating LinkedList of Playlist
        LinkedList<Song> playList=new LinkedList<>();//automatically doubly linkedlist

        //adding song from albums to playlist
        albums.get(0).addSongToPlayList(1,playList);
        albums.get(0).addSongToPlayList(3,playList);
        albums.get(0).addSongToPlayList(2,playList);
        albums.get(1).addSongToPlayList(3,playList);
        albums.get(1).addSongToPlayList(2,playList);

        //after adding songs to playlist ,start play
        play(playList);

    }
    public static void play(LinkedList<Song> playList)
    {
        //adding iterator to playlist
        ListIterator<Song> listIterator= playList.listIterator();

        if(playList.size()==0)return;

        //playing first song automatically and forward variable as true
        System.out.println(listIterator.next().toString());
        boolean forward=true;
        boolean quit=false;
        //print menu
        printMenu();
        Scanner sc=new Scanner(System.in);
        while(!quit) {
            int choice = sc.nextInt();
            switch (choice) {
                case 0: //exit function
                    quit=true;
                    break;
                case 1: //nextSong function
                      if(!forward){
                          listIterator.next();
                          forward=true;
                      }
                    if(listIterator.hasNext())
                        System.out.println(listIterator.next().toString());
                    else
                        System.out.println("you are already at last song");
                    break;
                case 2: //prevSong function
                    if(forward)
                    {
                        listIterator.previous();
                        forward=false;
                    }
                    if(listIterator.hasPrevious())
                         System.out.println(listIterator.previous().toString());
                    else
                        System.out.println("you are already at first song");
                    break;
                case 3: //replaySong function
                    if(forward) {
                        System.out.println(listIterator.previous().toString());
                        forward=false;
                    }
                    else {
                        System.out.println(listIterator.next().toString());
                        forward=true;
                    }
                    break;
                case 4: //list of songs
                    printAllSongs(playList);
                    break;
                case 5: //menu (options available)
                    printMenu();
                    break;
                case 6: //delete curr song
                    if(playList.size()>0)
                    {
                        if(forward) {
                            System.out.println(listIterator.previous().toString()+" got deleted");
                            forward=false;
                        }
                        else {
                            System.out.println(listIterator.next().toString()+" got deleted");
                            forward=true;
                        }
                       listIterator.remove();
                       if(playList.size()==0)
                       {
                           System.out.println("playList is empty Now");
                       }
                       else if(listIterator.hasPrevious())
                       {
                           System.out.println(listIterator.previous().toString());
                           forward=false;
                       }
                       else if(listIterator.hasNext())
                       {
                           System.out.println(listIterator.next().toString());
                           forward=true;
                       }
                    }
                    else
                        System.out.println("playList is already empty");


            }
        }
    }

    private static void printAllSongs(LinkedList<Song> playList) {
        ListIterator li=playList.listIterator();
        while(li.hasNext())
        {
            System.out.println(li.next().toString());
        }
    }

    public static void printMenu()
    {
        System.out.println("press\n"+"0 for exit\n"+"1 for nextSong\n"+"2 for prevSong\n"+"3 for replay the song\n"+
                "4 for list of Songs\n"+"5 for options available\n"+"6 for deleting current Song");
    }
}
