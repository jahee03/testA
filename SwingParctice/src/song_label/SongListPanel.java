package song_label;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import student.Student;


public class SongListPanel extends JPanel {
    private static final long serialVersionUID = 1L;
	static BottomPane bottom;
	JLabel songListLabel = new JLabel("<html><body>000");
    public SongListPanel() {
    	super(new BorderLayout());
    }
    void addComponentsToPane() {
    	loadData("");
    	JScrollPane center = new JScrollPane(songListLabel);   
    	center.setPreferredSize(new Dimension(500, 400));
    	add(center, BorderLayout.CENTER);
    	
    	bottom = new BottomPane();
    	bottom.init(this);
        add(bottom, BorderLayout.PAGE_END);
        
    	setupTopPane();
    }
    void setupTopPane() {
    	JPanel topPane = new JPanel();
        JTextField kwdTextField = new JTextField("", 20);
        topPane.add(kwdTextField, BorderLayout.LINE_START);
        JButton search = new JButton("검색");
        topPane.add(search, BorderLayout.LINE_END);
        search.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (e.getActionCommand().equals("검색")) {
        			loadData(kwdTextField.getText());
            	}
           }
        });
        add(topPane, BorderLayout.PAGE_START);
    }
    void loadData(String kwd) {
    	List<Student> findList = GUIMain.engine.search(kwd);
    	String text = "<html><body>";
    	for (Student s: findList) 
    		text += s + "<br/>";
    	songListLabel.setText(text);
    }
}