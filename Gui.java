package KihyeonPark;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.text.View;

public class Gui extends JFrame {

	private static JButton b1, b2, b4, b5;
	private static JLabel jl, j2;
	private static JTextField tf, tf2; // 텍스트필드 초기화
	private static JTextArea dashboard;
	static JScrollPane scrollPane;
	int windowX = 500, windowY = 500;
	static Stock_gui stock_gui;

	public Gui() {
		Init_Gui() ;
		MyEventHandler my = new MyEventHandler();

		b1.addActionListener(my);
		b2.addActionListener(my);
		b4.addActionListener(my);
		b5.addActionListener(my);
	}

	void Init_Gui() {
		// 메인 프레임을 형성 하고
		JFrame frame = new JFrame("20123361 KihyeonPark ");
		Dimension frameSize = frame.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((screenSize.width - frameSize.width) / 3, (screenSize.height - frameSize.height) / 4);
		// 프레임을 형성 한 것을 cp 라는 객체에 대입.
		Container cp = frame.getContentPane();

		cp.setLayout(new FlowLayout(1)); // 1 is center

		Font font = new Font("SansSerif", Font.BOLD, 13);

		jl = new JLabel("총 판매금액"); // 레이블 초기화
		j2 = new JLabel("지불 금액");
		tf = new JTextField(10);
		tf2 = new JTextField(10);
		dashboard = new JTextArea(20, 40);

		b1 = new JButton("바코드 찍기");
		b2 = new JButton("대시보드 지우기");
		b4 = new JButton("재고");
		b5 = new JButton("도움말");
		scrollPane = new JScrollPane(dashboard); // 스크롤판 추가

		dashboard.setFont(font);
		tf.setBackground(Color.black);
		tf2.setBackground(Color.black);
		dashboard.setBackground(Color.black);

		cp.add(jl);
		cp.add(tf);
		cp.add(j2);
		cp.add(tf2);
		cp.add(scrollPane);

		cp.add(b1);
		cp.add(b2);
		cp.add(b4);
		cp.add(b5);

		tf.setEnabled(false);
		tf2.setEnabled(false);
		dashboard.setEnabled(false);
		scrollPane.setEnabled(false);

		b1.setMnemonic('A'); // ALT+S

		// 텍스트의 수직 위치=>top
		b2.setVerticalTextPosition(JButton.TOP);
		// 텍스트의 수평 위치=>center
		b2.setHorizontalTextPosition(JButton.CENTER);
		b2.setMnemonic('S');
		b4.setMnemonic('D');

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setSize(windowX, windowY);
		frame.setVisible(true);
		frame.setResizable(false);
	}

	static class MyEventHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			if (obj == b1) {
				JOptionPane.showMessageDialog(null, "바코드가 정상적으로 찍혔습니다.", "바코드", JOptionPane.INFORMATION_MESSAGE);
				Counting_Item();
			} else if (obj == b2) {
				int result = JOptionPane.showConfirmDialog(null, "내용을 삭제하시겠습니까?", "삭제", JOptionPane.OK_OPTION);
				if (result == 0)
					dashboard.setText("");
			} else if (obj == b4) {
				String[] buttons = { "구매하기", "취소" };
				int result = JOptionPane.showOptionDialog(null, DataBase.Show_DB(), "재고",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, buttons, "두번째값");
				if (result == 0) {
					if (stock_gui == null)
						stock_gui = new Stock_gui();
					else
						stock_gui.Init_stockgui();
				}
			} else if (obj == b5) {
				String helper = "ALT + A : 바코드 찍기 \n" + "ALT + S : 창 지우기\n" + "ALT + D : 재고 확인 \n";
				JOptionPane.showMessageDialog(null, helper, "도움말", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	static void SelectingPayment() {
		String[] buttons = { "카드", "현금" };
		int result = JOptionPane.showOptionDialog(null, "결제 방법을 선택하세요.", "결제 방법", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, buttons, "두번째값");
		Util.Delay_time(1);
		if (result == 1)
			Gui.GetDashboard().append("현금 받았습니다.\n");
		else
			Gui.GetDashboard().append("카드 받았습니다.\n");
	}

	static void Waiting_Barcord() {
		Pos.running = true;
		startLoop();
	}

	static void Counting_Item() {
		Pos.running = false;
	}

	static void startLoop() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (Pos.running) {
					// running
					Util.LitteDelay_time(1);
				}
			}
		}).run();
	}

	static JTextField Gettf() {
		return tf;
	}

	static JTextField Gettf2() {
		return tf2;
	}

	static JTextArea GetDashboard() {
		return dashboard;
	}

}
