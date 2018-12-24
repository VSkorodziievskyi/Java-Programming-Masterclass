package lists.playlist;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public boolean addNewSong(String title, String duration) {
        if (findSong(title) == null) {
            this.songs.add(new Song(title, duration));
            return true;
        }
        System.out.println("Cannot add " + title + " to " + this.getName() + " album, it already exists.\n");
        return false;
    }

    public boolean addSongToPlaylist(String title, LinkedList<Song> linkedList) {
        Song existingSong = findSong(title);
        if (existingSong != null) {
            linkedList.add(existingSong);
            System.out.println("Playlist added song: " + title + " | Album: " + this.getName() + ". | Artist: " + this.getArtist() + ".");
            return true;
        }
        System.out.println("Album " + this.getName() + " does not have the track called " + title + ".");
        return false;
    }

    private Song findSong(String songTitle) {
        for (int i = 0; i < this.songs.size(); i++) {
            if (this.songs.get(i).getTitle().equals(songTitle)) {
                return this.songs.get(i);
            }
        }
        return null;
    }
}
