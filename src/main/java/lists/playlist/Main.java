package lists.playlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) throws IOException {
        Album brothers = new Album("Brothers", "The Black Keys");
        brothers.addNewSong("Too Afraid to Love You", "3:25");
        brothers.addNewSong("Ten Cent Pistol", "4:29");
        brothers.addNewSong("I'm Not the One", "3:49");
        brothers.addNewSong("Unknown Brother", "4:00");
        brothers.addNewSong("Unknown Brother", "4:00");

        Album blackstar = new Album("Blackstar", "David Bowie");
        blackstar.addNewSong("Blackstar", "9:57");
        blackstar.addNewSong("Lazarus", "6:22");
        blackstar.addNewSong("I Can’t Give Everything Away", "5:47");


        LinkedList<Song> playlist = new LinkedList<>();

        brothers.addSongToPlaylist("Too Afraid to Love You", playlist);
        blackstar.addSongToPlaylist("Blackstar", playlist);
        blackstar.addSongToPlaylist("Lazarus", playlist);
        brothers.addSongToPlaylist("Ten Cent Pistol", playlist);
        brothers.addSongToPlaylist("Unknown Brother", playlist);

        brothers.addSongToPlaylist("Brother Unknown", playlist);
        blackstar.addSongToPlaylist("Unknown Brother", playlist);

        playList(playlist);

    }

    private static void playList(LinkedList<Song> playList) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean quit = false;
        boolean goingForward = true;
        ListIterator<Song> listIterator = playList.listIterator();
        System.out.println("\n   Welcome to the Playlist!");
        printMenu();

        if (playList.isEmpty()) {
            System.out.println("*Playlist is empty.*");
            quit = true;
        } else {
            System.out.println(">>> Now playing: " + listIterator.next() + " <<<\n");
        }

        while (!quit) {
            int action = Integer.parseInt(reader.readLine());
            switch (action) {
                case 0:
                    System.out.println("Quitting from the playlist.");
                    quit = true;
                    break;
                case 1:
                    if (!goingForward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println(">>> Now playing: " + listIterator.next() + " <<<");
                    } else {
                        System.out.println("We have reached the end of the list.");
                        goingForward = false;
                    }
                    break;
                case 2:
                    if (goingForward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println(">>> Now playing: " + listIterator.previous() + " <<<");
                    } else {
                        System.out.println("We are at the start of the playlist.");
                        goingForward = true;
                    }
                    break;
                case 3:
                    if (goingForward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println(">>> Now replaying: " + listIterator.previous() + " <<<");
                            goingForward = false;
                        } else {
                            System.out.println("We are at the start of the playlist.");
                        }
                    } else {
                        if (listIterator.hasNext()) {
                            System.out.println(">>> Now replaying: " + listIterator.next() + " <<<");
                            goingForward = true;
                        } else {
                            System.out.println("We have reached the end of the list.");
                        }
                    }
                    break;
                case 4:
                    if (!playList.isEmpty()) {
                        listIterator.remove();
                        System.out.println("The song removed.");
                        if (listIterator.hasNext()) {
                            System.out.println(">>> Now playing: " + listIterator.next() + " <<<");
                        } else if (listIterator.hasPrevious()) {
                            System.out.println(">>> Now playing: " + listIterator.previous() + " <<<");
                        }
                    } else {
                        System.out.println("\nThe playlist is empty now - you have deleted all of the songs.");
                        quit = true;
                    }
                    break;
                case 5:
                    printList(playList);
            }
        }
    }

    private static void printList(LinkedList<Song> playList) {
        Iterator<Song> iterator = playList.iterator();
        System.out.println("================================");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("================================");
    }

    private static void printMenu() {
        System.out.println("       Playlist Menu:\n" +
                "0 - to quit from playlist.\n" +
                "1 - skip forward to the next song.\n" +
                "2 - skip backward to the previous song.\n" +
                "3 - replay the current song.\n" +
                "4 - remove the current song.\n" +
                "5 - print the list of the songs.\n");
    }
}