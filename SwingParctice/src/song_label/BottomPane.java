package song_label;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

class BottomPane extends JPanel implements ActionListener {
    private static final long serialVersionUID = 1L;
	JTextField edit;
	JTextField numField;
	SongListPanel parent = null;
	void init(SongListPanel parent) {
		this.parent = parent;
		edit = new JTextField("", 10);
		numField = new JTextField("", 10);
		add(new JLabel("번호:"));
		add(numField);
		add(new JLabel("곡명변경:"));
		add(edit);
		JButton buttons[] = new JButton[3];
		String btnTexts[] = { "수정", "추가", "삭제" };
		for (int i = 0; i < 3; i++) {
			buttons[i] = new JButton(btnTexts[i]);
			buttons[i].addActionListener(this);
			add(buttons[i]);
		}
		buttons[1].setEnabled(false);
	}

	void clearEdits() {
		edit.setText("");
	}
	public void actionPerformed(ActionEvent e) {
		int n = Integer.parseInt(numField.getText());
		switch (e.getActionCommand()) {
		case "추가":
			//
			break;
		case "수정":
    		GUIMain.engine.update(n,  edit.getText());
    		parent.loadData("");
    		break;
		case "삭제":
			GUIMain.engine.removeAt(n);
    		parent.loadData("");
    		break;
    	default: break;
		}
	}
}
