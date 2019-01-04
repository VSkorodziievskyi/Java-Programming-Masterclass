package classes.inner.playlist;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private SongList songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new SongList();
    }

    public String getName() {
        return name;
    }

    public boolean addNewSong(String title, String duration) {
        return this.songs.add(new Song(title, duration));
    }

    public boolean addSongToPlaylist(int trackNumber, LinkedList<Song> playList) {
        int index = trackNumber - 1;
        Song checkedSong = this.songs.findSong(trackNumber);
        if (checkedSong != null) {
            playList.add(checkedSong);
            System.out.println("Playlist added song: " + songs.getSongs().get(index).getTitle() + " | Album: " + this.name + ". | Artist: " + this.artist + ".");
            return true;
        } else {
            System.out.println("Album " + this.name + " does not have the track at number " + trackNumber + ".");
            return false;
        }
    }

    public boolean addSongToPlaylist(String title, LinkedList<Song> playList) {
        Song checkedSong = this.songs.findSong(title);
        if (checkedSong != null) {
            playList.add(checkedSong);
            System.out.println("Playlist added song: " + title + " | Album: " + this.name + ". | Artist: " + this.artist + ".");
            return true;
        } else {
            System.out.println("Album " + this.name + " does not have the track called " + title + ".");
            return false;
        }
    }

    private class SongList {
        private ArrayList<Song> songs;

        private SongList() {
            this.songs = new ArrayList<>();
        }

        private ArrayList<Song> getSongs() {
            return songs;
        }

        private boolean add(Song song) {
            if (findSong(song.getTitle()) == null) {
                this.songs.add(song);
                return true;
            } else {
                System.out.println("Cannot add " + song.getTitle() + " to " + Album.this.getName() + " album, it already exists.\n");
                return false;
            }
        }

        private Song findSong(String title) {
            for (Song checkedSong : this.songs) {
                if (checkedSong.getTitle().equals(title)) {
                    return checkedSong;
                }
            }
            return null;
        }

        private Song findSong(int trackNumber) {
            int index = trackNumber - 1;
            if ((index >= 0) && (index < this.songs.size())) {
                return this.songs.get(index);
            } else {
                return null;
            }
        }
    }
}
