package Project;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class OTT_Main extends JFrame{
	
	private JButton btnCoupang, btnDisney, btnNetflix, btnTving, btnListandSearch, btnExit;

	public OTT_Main() {
		super("오늘 뭐 봐 ๑•‿•๑");
		getContentPane().setBackground(Color.WHITE);
		setSize(800, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBackground(Color.WHITE);
		pn1.setBounds(0, 0, 784, 205);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		//쿠팡 플레이 JButton
		btnCoupang = new JButton("");
		btnCoupang.setIcon(new ImageIcon(OTT_Main.class.getResource("/images/CoupangMain.jpg")));
		btnCoupang.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 25));
		btnCoupang.setBounds(0, 0, 196, 205);
		pn1.add(btnCoupang);
		
		//디즈니 플러스 JButton
		btnDisney = new JButton("");
		btnDisney.setIcon(new ImageIcon(OTT_Main.class.getResource("/images/Disney Main.jpg")));
		btnDisney.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 25));
		btnDisney.setBounds(196, 0, 196, 205);
		pn1.add(btnDisney);
		
		//넷플릭스 JButton
		btnNetflix = new JButton("");
		btnNetflix.setIcon(new ImageIcon(OTT_Main.class.getResource("/images/Netflix Main.jpg")));
		btnNetflix.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 25));
		btnNetflix.setBounds(392, 0, 196, 205);
		pn1.add(btnNetflix);
		
		//티빙 JButton
		btnTving = new JButton("");
		btnTving.setIcon(new ImageIcon(OTT_Main.class.getResource("/images/Tving Main.jpg")));
		btnTving.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 25));
		btnTving.setBounds(588, 0, 196, 205);
		pn1.add(btnTving);
		
		JPanel pn2 = new JPanel();
		pn2.setBackground(Color.WHITE);
		pn2.setBounds(0, 211, 784, 170);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		JLabel lblTitle = new JLabel("오  늘  뭐  봐  ?");
		lblTitle.setBackground(new Color(255, 255, 255));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("배달의민족 한나는 열한살", Font.BOLD, 60));
		lblTitle.setBounds(0, 0, 784, 170);
		pn2.add(lblTitle);
		
		JPanel pn3 = new JPanel();
		pn3.setBackground(Color.WHITE);
		pn3.setBounds(0, 461, 784, 90);
		getContentPane().add(pn3);
		pn3.setLayout(null);
		
		btnListandSearch = new JButton("전 체 보 기 & 검 색");
		btnListandSearch.setBackground(new Color(255, 255, 255));
		btnListandSearch.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 25));
		btnListandSearch.setBounds(56, 10, 410, 70);
		pn3.add(btnListandSearch);
		
		btnExit = new JButton("종      료");
		btnExit.setBackground(Color.WHITE);
		btnExit.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 25));
		btnExit.setBounds(522, 10, 205, 70);
		pn3.add(btnExit);
	
		
		//쿠팡 플레이 버튼 마우스 클릭시 쿠팡 플레이로 넘어가기
		btnCoupang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new OTT_ListSearch("Coupang Play");
			}
		});
		
		//디즈니 플러스 버튼 마우스 클릭시 디즈니 플러스로 넘어가기
		btnDisney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new OTT_ListSearch("Disney Plus");
			}
		});
		
		//넷플릭스 버튼 마우스 클릭시 넷플릭스로 넘어가기
		btnNetflix.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new OTT_ListSearch("Netflix");
			}
		});
		
		//티빙 버튼 마우스 클릭시 티빙으로 넘어가기
		btnTving.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new OTT_ListSearch("Tving");
			}
		});
		
		//전체보기&검색 버튼 마우스 클릭시 전체보기&검색으로 넘어가기
		btnListandSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Main_ListSearch("전체보기 & 검색");
			}
		});
		
		
		// 종료 버튼 마우스 클릭시 창 닫힘
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
//==============================================================	
		setVisible(true);
//==============================================================
		
	}
	
	public static void main(String[] args) {
		new OTT_Main();
	}
}
