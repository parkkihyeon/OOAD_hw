package KihyeonPark;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Gui extends JFrame {

	JButton b1, b2, b3, b4;
	JLabel jl , j2  ;
	private JTextField tf ,tf2 ; // 텍스트필드 초기화
	private JTextArea dashboard ;
	JScrollPane scrollPane ;
	
	
	public Gui() {
		super("20123361 KihyeonPark");
		JFrame frame = new JFrame("Frame") ;
		Dimension frameSize = frame.getSize() ;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize() ;
		System.out.println(screenSize.width + " " + frameSize.width);
		frame.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height-frameSize.height)/4);
		Container cp = frame.getContentPane();
		
		int center = 1  ;
		cp.setLayout(new FlowLayout(center)); 
		//cp.setBackground(Color.black) ;
		
		Font font = new Font("SansSerif", Font.BOLD, 13);
		
		jl = new JLabel("총 판매금액"); // 레이블 초기화
		j2 = new JLabel("지불 금액");
		tf = new JTextField(10); 
		tf2 = new JTextField(10);
		dashboard = new JTextArea(20,30) ;
		
		dashboard.setFont(font);
		tf.setBackground(Color.black);
		tf2.setBackground(Color.black);
		dashboard.setBackground(Color.black);
		
		
		b1 = new JButton("바코드 찍기");
		b2 = new JButton("Clean");
		b3 = new JButton("결제방법");
		b4 = new JButton("재고");
		scrollPane = new JScrollPane(dashboard);  //스크롤판 추가
	
		
		cp.add(jl) ;
		cp.add(tf) ;
		cp.add(j2) ;
		cp.add(tf2) ;
		cp.add(scrollPane) ;

		cp.add(b1);
		cp.add(b3);
		cp.add(b2);
		cp.add(b4);
		
		tf.setEnabled(false);
		tf2.setEnabled(false);
		dashboard.setEnabled(false);
		scrollPane.setEnabled(false);
		
		// 텍스트의 수직 위치=>top
		b2.setVerticalTextPosition(JButton.TOP);
		// 텍스트의 수평 위치=>center
		b2.setHorizontalTextPosition(JButton.CENTER);
		b2.setMnemonic('C'); // ALT+C

		// b3텍스트 bottom center로 위치
		b3.setVerticalTextPosition(JButton.BOTTOM);
		b3.setHorizontalTextPosition(JButton.CENTER);
		b3.setMnemonic('C'); // Alt+C

		b4.setMnemonic('A'); // Alt+A
		b4.setToolTipText("이건 풍선 도움말이에요~~"); // 마우스를 갖다대면 뜸

		MyEventHandler my = new MyEventHandler();

		b1.addActionListener(my);
		b2.addActionListener(my);
		b3.addActionListener(my);
		b4.addActionListener(my);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setSize(400,500) ;
		frame.setVisible(true);

	}

	class MyEventHandler implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			if (obj == b1) {
				JOptionPane.showMessageDialog(b1, "바코드가 정상적으로 찍혔습니다.", "바코드", JOptionPane.INFORMATION_MESSAGE);
			} else if (obj == b2) {
				int result = JOptionPane.showConfirmDialog(b2, "내용을 삭제하시겠습니까?", "삭제", JOptionPane.OK_OPTION );	
				if(result ==0){
					dashboard.setText("");
				}
			} else if (obj == b3) {		
				String[] buttons = {"카드", "현금"};
				int result = JOptionPane.showOptionDialog(b3, "결제 방법을 선택하세요.", "결제 방법", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, buttons, "두번째값");
				System.out.println(result) ;
				if(result ==0){ // 카드
					
				}

			} else if (obj == b4) {
				int result = JOptionPane.showConfirmDialog(b4, DataBase.Show_DB(), "재고", JOptionPane.OK_OPTION);
			}

		}
	}
	
	JTextField Gettf(){
		return tf ;
	}
	
	JTextField Gettf2(){
		return tf2 ;
	}
	
	JTextArea GetDashboard(){
		return dashboard ;
	}
	
	JScrollPane GetScroll(){
		return scrollPane ;
	}
}
