package Project;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;

public class OTT_Input extends JFrame {
	
	private JTextField txtInputName, txtInputPoster;
	private final ButtonGroup btnCoupangGroup = new ButtonGroup();
	private JLabel lblCoupangInput, lblCoupangInputName, lblCoupangInputOTT, lblCoupangInputGenre, lblCoupangInputOpen, lblCoupangInputPoster;
	private JRadioButton rdInputDrama, rdInputEnter, rdInputMovie;
	private JButton btnInputInput, btnInputClear,  btnInputExit;
	private JComboBox cbInputOpen;

	OTTVO vo = null;
	OTTDAO dao = new OTTDAO();
	
	int res = 0;
	
	private String ott = "";
	private JTextField txtInputOTT;
	
	public OTT_Input(String ottName) {
		super(ottName + " 작품 등록");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBackground(Color.WHITE);
		pn1.setBounds(0, 0, 784, 78);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		String ottImage = "";
		if(ottName.equals("Coupang Play")) ottImage = "Coupang200.jpg";
		else if(ottName.equals("Disney Plus")) ottImage = "Disney100.jpg";
		else if(ottName.equals("Netflix")) ottImage = "Netflix180.jpg";
		else ottImage = "Tving250.jpg";
		//System.out.println("ottName : " + ottName + " , ottImage : " + ottImage);
		
		lblCoupangInput = new JLabel("");
		lblCoupangInput.setBounds(0, 0, 784, 78);
		lblCoupangInput.setIcon(new ImageIcon("images/" + ottImage));
		lblCoupangInput.setHorizontalAlignment(SwingConstants.CENTER);
		lblCoupangInput.setBackground(Color.WHITE);
		pn1.add(lblCoupangInput);
		
		JPanel pn2 = new JPanel();
		pn2.setBackground(Color.WHITE);
		pn2.setBounds(0, 78, 784, 407);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		lblCoupangInputName = new JLabel("제    목");
		lblCoupangInputName.setForeground(new Color(0, 0, 0));
		lblCoupangInputName.setHorizontalAlignment(SwingConstants.CENTER);
		lblCoupangInputName.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 25));
		lblCoupangInputName.setBounds(12, 19, 150, 58);
		pn2.add(lblCoupangInputName);
		
		txtInputName = new JTextField();
		txtInputName.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 25));
		txtInputName.setBounds(193, 19, 544, 58);
		pn2.add(txtInputName);
		txtInputName.setColumns(10);
		
		lblCoupangInputOTT = new JLabel("O T T");
		lblCoupangInputOTT.setHorizontalAlignment(SwingConstants.CENTER);
		lblCoupangInputOTT.setForeground(new Color(0, 0, 0));
		lblCoupangInputOTT.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 25));
		lblCoupangInputOTT.setBounds(12, 96, 150, 58);
		pn2.add(lblCoupangInputOTT);
		
		lblCoupangInputGenre = new JLabel("장    르");
		lblCoupangInputGenre.setHorizontalAlignment(SwingConstants.CENTER);
		lblCoupangInputGenre.setForeground(new Color(0, 0, 0));
		lblCoupangInputGenre.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 25));
		lblCoupangInputGenre.setBounds(12, 173, 150, 58);
		pn2.add(lblCoupangInputGenre);
		
		rdInputDrama = new JRadioButton("  드라마");
		rdInputDrama.setSelected(true);
		btnCoupangGroup.add(rdInputDrama);
		rdInputDrama.setBackground(new Color(255, 255, 255));
		rdInputDrama.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 25));
		rdInputDrama.setBounds(193, 173, 150, 58);
		pn2.add(rdInputDrama);
		
		rdInputEnter = new JRadioButton("  예   능");
		btnCoupangGroup.add(rdInputEnter);
		rdInputEnter.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 25));
		rdInputEnter.setBackground(Color.WHITE);
		rdInputEnter.setBounds(385, 173, 150, 58);
		pn2.add(rdInputEnter);
		
		rdInputMovie = new JRadioButton("  영   화");
		btnCoupangGroup.add(rdInputMovie);
		rdInputMovie.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 25));
		rdInputMovie.setBackground(Color.WHITE);
		rdInputMovie.setBounds(587, 173, 150, 58);
		pn2.add(rdInputMovie);
		
		lblCoupangInputOpen = new JLabel("개봉연도");
		lblCoupangInputOpen.setHorizontalAlignment(SwingConstants.CENTER);
		lblCoupangInputOpen.setForeground(new Color(0, 0, 0));
		lblCoupangInputOpen.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 25));
		lblCoupangInputOpen.setBounds(12, 250, 150, 58);
		pn2.add(lblCoupangInputOpen);
		
		lblCoupangInputPoster = new JLabel("포스터제목");
		lblCoupangInputPoster.setHorizontalAlignment(SwingConstants.CENTER);
		lblCoupangInputPoster.setForeground(new Color(0, 0, 0));
		lblCoupangInputPoster.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 25));
		lblCoupangInputPoster.setBounds(12, 327, 150, 58);
		pn2.add(lblCoupangInputPoster);
		
		cbInputOpen = new JComboBox();
		cbInputOpen.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 25));
		cbInputOpen.setModel(new DefaultComboBoxModel(new String[] {"2024", "2023", "2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010"}));
		cbInputOpen.setBounds(193, 250, 150, 58);
		pn2.add(cbInputOpen);
		
		txtInputPoster = new JTextField();
		txtInputPoster.setText(".jpg");
		txtInputPoster.setForeground(Color.BLACK);
		txtInputPoster.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 25));
		txtInputPoster.setColumns(10);
		txtInputPoster.setBounds(193, 327, 544, 58);
		pn2.add(txtInputPoster);
		
		txtInputOTT = new JTextField(ottName);
		txtInputOTT.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 25));
		txtInputOTT.setBounds(193, 100, 544, 58);
		pn2.add(txtInputOTT);
		txtInputOTT.setColumns(10);
		
		JPanel pn3 = new JPanel();
		pn3.setBackground(Color.WHITE);
		pn3.setBounds(0, 483, 784, 78);
		getContentPane().add(pn3);
		pn3.setLayout(null);
		
		btnInputExit = new JButton("메 인 으 로");
		btnInputExit.setBounds(622, 10, 150, 58);
		btnInputExit.setForeground(new Color(0, 0, 0));
		btnInputExit.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 25));
		btnInputExit.setBackground(Color.WHITE);
		pn3.add(btnInputExit);
		
		btnInputInput = new JButton("작 품 등 록");
		btnInputInput.setBounds(12, 10, 150, 58);
		btnInputInput.setForeground(new Color(0, 0, 0));
		btnInputInput.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 25));
		btnInputInput.setBackground(Color.WHITE);
		pn3.add(btnInputInput);
		
		btnInputClear = new JButton("다 시 입 력");
		btnInputClear.setBounds(321, 10, 150, 58);
		btnInputClear.setForeground(new Color(0, 0, 0));
		btnInputClear.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 25));
		btnInputClear.setBackground(Color.WHITE);
		pn3.add(btnInputClear);
		

	//=====================================================================================	
		setVisible(true);
	//=====================================================================================	
		
		
		// 작품등록 버튼을 마우스 클릭시 실행 --완료
		btnInputInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtInputName.getText().trim();
				String genre = "";
				String open = cbInputOpen.getSelectedItem().toString();
				String img = txtInputPoster.getText().trim();
						
				if(name.equals("")) {
			    JOptionPane.showMessageDialog(null, "성명을 입력하세요");
			    txtInputName.requestFocus();
				}
				else if(img.equals("")) {
			    JOptionPane.showMessageDialog(null, "포스터이름을 입력하세요");
			    txtInputPoster.requestFocus();
				}
				else {
					vo = dao.getNameSearchOTT(name);
					if(vo.getName() != null) {
						JOptionPane.showMessageDialog(null, "이미 등록된 작품입니다. 다른 작품을 등록해주세요.");
						txtInputName.requestFocus();
					}
					else {
						if(rdInputDrama.isSelected()) genre = "드라마";
						else if(rdInputEnter.isSelected()) genre = "드라마";
						else genre = "영화";
						
						vo.setName(name);
						vo.setOtt(ottName);
						vo.setGenre(genre);
						vo.setOpen(open);
						vo.setImg(img);
						
						res = dao.setOTTInput(vo);
						
						if(res != 0) {
							JOptionPane.showMessageDialog(null, "작품이 등록되었습니다.");
							dispose();
							new OTT_ListSearch(ottName);
						}
						else {
							JOptionPane.showMessageDialog(null, "작품 등록이 실패하였습니다. 다시 확인해주세요.");
							txtInputName.requestFocus();
						}
					}
				}
			}
		});
		
		
		// 다시입력 버튼 마우스 클릭시 실행
		btnInputClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtInputName.setText("");
				rdInputDrama.isSelected();
				//cbCoupangInputOpen.getSelectedItem("2024");
				txtInputPoster.setText(".jpg");
				txtInputName.requestFocus();
			}
		});
		
	
		// 메인으로 버튼 마우스 클릭시 실행 --완료
		btnInputExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new OTT_ListSearch(ottName);
			}
		});
	
	}
	
	
//	public static void main(String[] args) {
//		new CoupangInput();
//	}
}
