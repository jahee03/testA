package aFirst;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UpDownFrame2 extends JFrame {
	private static final long serialVersionUID = 1L;
	final String labelPrefix = "<html><body><h3>";
	JTextField input = new JTextField("0", 20);
	JLabel bottomLabel = new JLabel(labelPrefix);

	public void addComponentsToPane() {
		setTitle("Up Down Test");
		Container pane = getContentPane(); // 여기서만 쓰이는 것은 지역변수로

		JPanel top = new JPanel();
		JButton up = new JButton("UP");
		JButton down = new JButton("DOWN");
		JButton reset = new JButton("RESET");
		JButton record = new JButton("RECORD");
		top.setPreferredSize(new Dimension(300, 40));
		top.add(input);
		pane.add(top, BorderLayout.PAGE_START);
		
		JPanel center = new JPanel(new GridLayout(1,2));
		center.add(down, BorderLayout.CENTER);
		center.add(reset, BorderLayout.CENTER);

		pane.add(up, BorderLayout.LINE_START);
		pane.add(down, BorderLayout.CENTER);
		pane.add(record, BorderLayout.LINE_END);

		ActionListener listener = new ButtonListener();
		up.addActionListener(listener);
		down.addActionListener(listener);
		reset.addActionListener(listener);
		record.addActionListener(listener);

		bottom.add(bottomLabel);
		bottom.setPreferredSize(new Dimension(300, 200));
		pane.add(bottom, BorderLayout.PAGE_END);
	}

	JPanel bottom = new JPanel();
	int count = 1;
	int last = 0;

	private void createAndShowGUI() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(300, 120));
		addComponentsToPane();
		// 컴포넌트 크기를 설정하는 방법
		setPreferredSize(new Dimension(300, 300));
		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		UpDownFrame2 frame = new UpDownFrame2();
		frame.createAndShowGUI();
	}

	class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String buttonName = e.getActionCommand();
			int result = Integer.parseInt(input.getText());
			switch (buttonName) {
			case "UP":
				result++;
				break;
			case "DOWN":
				result--;
				break;
			case "RESET":
				input.setText("0");
				bottomLabel.setText(labelPrefix);
				result=0;
				bottom.setBackground(Color.white);
			case "RECORD":
				int gap = result - last;
				String line = String.format("[%d] %d %d\n", count, result, gap);
				count++;
				last = result;
				String showValue = bottomLabel.getText() + line ;
				//String showValue = labelPrefix + input.getText();
				bottomLabel.setText(showValue);
				bottom.setBackground(getRandomColor());
			}
			input.setText("" + result);
		}
	}

	Random rand = new Random();


	private Color getRandomColor() {
		return new Color(rand.nextInt(125, 256), rand.nextInt(125, 256), rand.nextInt(125, 256));
	}

}
