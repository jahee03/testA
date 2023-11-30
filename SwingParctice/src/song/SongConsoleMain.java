package song;

import mgr.Factory;
import mgr.Manager;

public class SongConsoleMain extends Manager<Song> {
	public SongConsoleMain() {
		readAllSongs("songs.txt");
	}
	//Scanner scan = new Scanner(System.in);
	void readAllSongs(String filename) {
		super.readAll(filename, new Factory<Song>() {
			public Song create() {
				return new Song();
			}
		});
	}
	public static void main(String[] args) {
		SongConsoleMain engine = new SongConsoleMain();
		engine.printAll();
	}

}
