//package song;
//
//import java.util.List;
//import mgr.Factory;
//import mgr.Manager;
//import song_label.GUIMain;
//
//public class SongMgr extends Manager<Song> {
//	public SongMgr() {
//		readAllSongs("songs.txt");
//	}
//	//Scanner scan = new Scanner(System.in);
//	void readAllSongs(String filename) {
//		super.readAll(filename, new Factory<Song>() {
//			public Song create() {
//				return new Song();
//			}
//		});
//	}
//	public List<Song> search(String kwd) {
//		if (kwd == null)
//			return mList;
//		return findAll(kwd);
//	}
//	public void update(int n, String title) {
//		// TODO Auto-generated method stub
//		Song s = find(""+n);
//		s.set(title);
//	}
//	public void removeAt(int num) {
//		// TODO Auto-generated method stub
//		Song s = find(""+num);
//		mList.remove(s);
//	}
//	public static void main(String[] args) {
//		SongMgr engine = new SongMgr();
//		GUIMain.startGUI(engine);
//	}
//}
