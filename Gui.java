package KihyeonPark;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.text.View;

public class Gui extends JFrame {

	static JButton b1, b2, b3, b4, b5;
	static JLabel jl , j2  ;
	private static JTextField tf ,tf2 ; // 텍스트필드 초기화
	private static JTextArea dashboard ;
	static JScrollPane scrollPane ;
	int windowX = 500, windowY = 500 ;
	
	public Gui() {

		JFrame frame = new JFrame("20123361 KihyeonPark ") ;
		Dimension frameSize = frame.getSize() ;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize() ;
		frame.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height-frameSize.height)/4);
		Container cp = frame.getContentPane();
		
		cp.setLayout(new FlowLayout(1));  // 1 is center
		
		Font font = new Font("SansSerif", Font.BOLD, 13);
		
		jl = new JLabel("총 판매금액"); // 레이블 초기화
		j2 = new JLabel("지불 금액");
		tf = new JTextField(10); 
		tf2 = new JTextField(10);
		dashboard = new JTextArea(20,40) ;
		
		dashboard.setFont(font);
		tf.setBackground(Color.black);
		tf2.setBackground(Color.black);
		dashboard.setBackground(Color.black);
		
		
		b1 = new JButton("바코드 찍기");
		b2 = new JButton("Clean");
		b3 = new JButton("결제방법");
		b4 = new JButton("재고");
		b5 = new JButton("도움말");
		scrollPane = new JScrollPane(dashboard);  //스크롤판 추가
	
		
		cp.add(jl) ;
		cp.add(tf) ;
		cp.add(j2) ;
		cp.add(tf2) ;
		cp.add(scrollPane) ;

		cp.add(b1);
		cp.add(b2);
		cp.add(b3);
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

		// b3텍스트 bottom center로 위치
		b3.setVerticalTextPosition(JButton.BOTTOM);
		b3.setHorizontalTextPosition(JButton.CENTER);
		b3.setMnemonic('D'); 

		b4.setMnemonic('F'); 
		b4.setToolTipText("이건 풍선 도움말이에요~~"); // 마우스를 갖다대면 뜸

		MyEventHandler my = new MyEventHandler();

		b1.addActionListener(my);
		b2.addActionListener(my);
		b3.addActionListener(my);
		b4.addActionListener(my);
		b5.addActionListener(my);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setSize(windowX,windowY) ;
		frame.setVisible(true);

	}

	static class MyEventHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			if (obj == b1) {
				JOptionPane.showMessageDialog(b1, "바코드가 정상적으로 찍혔습니다.", "바코드", JOptionPane.INFORMATION_MESSAGE);
				Counting_Item();
			} 
			else if (obj == b2) {
				int result = JOptionPane.showConfirmDialog(b2, "내용을 삭제하시겠습니까?", "삭제", JOptionPane.OK_OPTION );	
				if(result ==0){
					dashboard.setText("");
				}
			}
			else if (obj == b3) {		
				String[] buttons = {"카드", "현금"};
				JOptionPane.showOptionDialog(b3, "결제 방법을 선택하세요.", "결제 방법", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, buttons, "두번째값");
			} 
			else if (obj == b4) {
				JOptionPane.showConfirmDialog(b4, DataBase.Show_DB(), "재고", JOptionPane.OK_OPTION);
			}
			else if (obj == b5) {
				String helper = "ALT + A : 바코드 찍기 \n" + "ALT + S : 창 지우기\n" + "ALT + D : 결제방법 \n" + "ALT + F : 재고 확인\n" ;
				JOptionPane.showMessageDialog(b5, helper, "도움말", JOptionPane.INFORMATION_MESSAGE);
			}
		}
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
	            	Util.LitteDelay_time(1) ;
	            }
	        }
	    }).run();
	}
	
	static JTextField Gettf(){
		return tf ;
	}
	
	static JTextField Gettf2(){
		return tf2 ;
	}
	
	static JTextArea GetDashboard(){
		return dashboard ;
	}
	
	static JScrollPane GetScroll(){
		return scrollPane ;
	}
}
