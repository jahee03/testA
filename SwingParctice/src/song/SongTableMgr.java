//package song;
//
//import java.util.List;
//
//import mgr.Factory;
//import mgr.Manager;
//import song_table.GUIMain;
//
//public class SongTableMgr extends Manager<Song> {
//	// 테이블의 헤더 데이터 제공 부분
//	String[] labels = {"랭킹", "이름", "제목", "년도", "가사"};
//	// 테이블의 열 제목을 스트링 배열로 돌려줌
//	public int getColumnCount() {
//		return labels.length;
//	}
//	public String[] getColumnNames() {		
//		return labels;
//	}
//	public SongTableMgr() {
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
//	public void addNewItem(String[] editTexts) {
//		// TODO Auto-generated method stub
//		Song s = new Song();
//		s.set(editTexts);
//		mList.add(s);
//		System.out.println("추가: "+s);
//	}
//	public void update(String[] editTexts) {
//		// TODO Auto-generated method stub
//		Song s = (Song)find(editTexts[0]);
//		s.set(editTexts);
//		System.out.println("수정: "+s);
//	}
//	public static void main(String[] args) {
//		SongTableMgr engine = new SongTableMgr();
//		GUIMain.startGUI(engine);
//	}
//	public void remove(String key) {
//		// TODO Auto-generated method stub
//		Song s = (Song)find(key);
//		mList.remove(s);
//		System.out.println("삭제: "+s);
//	}
//}
