package Project;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import java.util.regex.Pattern;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

public class OTT_ListSearch extends JFrame{
	private JTextField txtOTTCondition;
	private JButton btnOTTSearch, btnOTTList;
	private JScrollPane scrollPane;
	private JComboBox cbOTTCondition;
	private JButton btnOTTAdd, btnOTTDelete, btnOTTExit;
	
	private JTable table;
	
	private Vector title, vData;
	private DefaultTableModel dtm;
	
	private DefaultTableCellRenderer dtcr;
	private TableColumnModel tcm;
	
	OTTDAO dao = new OTTDAO();
	
	int res = 0;
	
	public OTT_ListSearch(String ottName) {
		super(ottName + "");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBackground(new Color(255, 255, 255));
		pn1.setBounds(0, 1, 784, 78);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		String ottImage = "";
		if(ottName.equals("Coupang Play")) ottImage = "Coupang200.jpg";
		else if(ottName.equals("Disney Plus")) ottImage = "Disney100.jpg";
		else if(ottName.equals("Netflix")) ottImage = "Netflix180.jpg";
		else ottImage = "Tving250.jpg";
		
		JLabel lblOTT = new JLabel("");
		lblOTT.setIcon(new ImageIcon("images/"+ottImage));
		lblOTT.setHorizontalAlignment(SwingConstants.CENTER);
		lblOTT.setBackground(Color.WHITE);
		lblOTT.setBounds(0, 0, 784, 78);
		pn1.add(lblOTT);
		
		JPanel pn2 = new JPanel();
		pn2.setBackground(Color.WHITE);
		pn2.setBounds(0, 80, 784, 78);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		cbOTTCondition = new JComboBox();
		cbOTTCondition.setModel(new DefaultComboBoxModel(new String[] {"제     목", "장     르", "개봉년도"}));
		cbOTTCondition.setForeground(new Color(0, 0, 0));
		cbOTTCondition.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 25));
		cbOTTCondition.setBackground(Color.WHITE);
		cbOTTCondition.setBounds(18, 10, 130, 58);
		pn2.add(cbOTTCondition);
		
		txtOTTCondition = new JTextField();
		txtOTTCondition.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 25));
		txtOTTCondition.setColumns(10);
		txtOTTCondition.setBounds(166, 10, 300, 58);
		pn2.add(txtOTTCondition);
		
		btnOTTSearch = new JButton("검     색");
		btnOTTSearch.setForeground(new Color(0, 0, 0));
		btnOTTSearch.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 25));
		btnOTTSearch.setBackground(new Color(255, 255, 255));
		btnOTTSearch.setBounds(484, 10, 130, 58);
		pn2.add(btnOTTSearch);
		
		btnOTTList = new JButton("전 체 검 색");
		btnOTTList.setForeground(new Color(0, 0, 0));
		btnOTTList.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 22));
		btnOTTList.setBackground(new Color(255, 255, 255));
		btnOTTList.setBounds(632, 10, 130, 58);
		pn2.add(btnOTTList);
		
		JPanel pn3 = new JPanel();
		pn3.setBackground(Color.WHITE);
		pn3.setBounds(0, 157, 784, 329);
		getContentPane().add(pn3);
		pn3.setLayout(null);
		
		JLabel lblOTTImage = new JLabel("");
		lblOTTImage.setBounds(392, 10, 380, 303);
		pn3.add(lblOTTImage);
		
		JPanel pn4 = new JPanel();
		pn4.setBackground(Color.WHITE);
		pn4.setLayout(null);
		pn4.setBounds(0, 483, 784, 78);
		getContentPane().add(pn4);
		
		btnOTTExit = new JButton("메 인 으 로");
		btnOTTExit.setForeground(new Color(0, 0, 0));
		btnOTTExit.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 25));
		btnOTTExit.setBackground(new Color(255, 255, 255));
		btnOTTExit.setBounds(622, 10, 150, 58);
		pn4.add(btnOTTExit);
		
		btnOTTAdd = new JButton("작 품 등 록");
		btnOTTAdd.setForeground(new Color(0, 0, 0));
		btnOTTAdd.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 25));
		btnOTTAdd.setBackground(Color.WHITE);
		btnOTTAdd.setBounds(12, 10, 150, 58);
		pn4.add(btnOTTAdd);
		
		btnOTTDelete = new JButton("작 품 삭 제");
		btnOTTDelete.setForeground(new Color(0, 0, 0));
		btnOTTDelete.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 25));
		btnOTTDelete.setBackground(Color.WHITE);
		btnOTTDelete.setBounds(317, 10, 150, 58);
		pn4.add(btnOTTDelete);
		
		//JTable 설계 -- 해당 OTT 메인 전체보기
		title = new Vector<>();
		title.add("번호");
		title.add("제목");
		title.add("OTT");
		title.add("장르");
		title.add("개봉년도");
		
		vData = dao.getOTTList(ottName); //해당 ott 메인 전체보기 getOTTtotalMain(String ottName)
		dtm = new DefaultTableModel(vData, title);
		
		table = new JTable(dtm);
		table.setRowSorter(new TableRowSorter(dtm));
		
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 10, 380, 303);
		
		pn3.add(scrollPane);
		
		/* JTable 속성 제어하기 */
		// table의 컬럼크기/크기고정/셀의 위치고정 설정
		table.getColumnModel().getColumn(0).setMaxWidth(50);			// 컬럼의 최대크기 지정
		table.getColumnModel().getColumn(1).setMaxWidth(200);			
		table.getColumnModel().getColumn(2).setMaxWidth(100);
		table.getColumnModel().getColumn(3).setMaxWidth(100);
		table.getColumnModel().getColumn(0).setResizable(false);	// 컬럼 크기 변경불가
		table.getColumnModel().getColumn(2).setResizable(false);	
		table.getColumnModel().getColumn(3).setResizable(false);	
		table.getTableHeader().setReorderingAllowed(false);				// 컬럼 고정
		
		// 테이블 셀안의 내용 수평정렬하기
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = table.getColumnModel();
		movieFormAlign(tcm, dtcr); //테이블 안 가운데 정렬 메소드
		
		
		// Jtable 클릭시 그림파일의 정보를 레이블에 뿌려주기(그림 보여주기)
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				String name = table.getValueAt(row, 1).toString();
				
				// 작품명에 해당하는 그림을 DB에서 가져온다.
				OTTVO vo = dao.getNameSearchOTT(name);
				String image = "OTT_Poster/" + vo.getImg();
				
				lblOTTImage.setIcon(new ImageIcon(image));
				
				//이미지 사진 딱 맞게 출력
				ImageIcon icon = new ImageIcon(image);
				Image img = icon.getImage();
				Image updateImg = img.getScaledInstance(380, 303, Image.SCALE_SMOOTH);
				
				ImageIcon updateIcon = new ImageIcon(updateImg); // 변경된 크기의 이미지로 다시 생성 
				
				lblOTTImage.setIcon(updateIcon); // 생성된 이미지를 레이블에 아이콘으로 등록후 뿌려준다.(setText())
				//lblImage.setText(image);
			}
		});
		
		
		//검색 버튼 마우스 클릭시
		btnOTTSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String cbCondi = cbOTTCondition.getSelectedItem().toString();
				String txtCondi = txtOTTCondition.getText();
				
				if(txtCondi.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "검색할 내용을 입력하세요!");
					txtOTTCondition.requestFocus();
					return;
				}
				if(cbCondi.equals("제     목")) {
					vData = dao.getOTTConditionSearch("name", txtCondi, ottName);
					if(vData.size() != 0) {
						System.out.println("vData : " + vData);
						System.out.println("검색자료 출력");
					}
					else {
						JOptionPane.showMessageDialog(null, "해당 제목의 작품은 없습니다. 다시 확인해주세요.");
					}
				}
				else if(cbCondi.equals("O  T  T")) {
					vData = dao.getOTTConditionSearch("ott", txtCondi, ottName);
					System.out.println("vData : " + vData);
					if(vData.size() != 0) {
						System.out.println("검색자료 출력");
					}
					else {
						JOptionPane.showMessageDialog(null, "해당 OTT는 없습니다. 다시 확인해주세요.");
					}			
				}
				else if(cbCondi.equals("장     르")) {
					vData = dao.getOTTConditionSearch("genre", txtCondi, ottName);
					System.out.println("vData : " + vData);
					if(vData.size() != 0) {
						System.out.println("검색자료 출력");
					}
					else {
						JOptionPane.showMessageDialog(null, "해당 장르는 없습나다. 다시 확인해주세요.");
					}			
				}
				else if(cbCondi.equals("개봉년도")) {
					if(!Pattern.matches("^[0-9]+$", txtCondi)) {
						JOptionPane.showMessageDialog(null, "개봉년도는 숫자만 입력해주세요.");
						txtOTTCondition.requestFocus();
					}
					else vData = dao.getOTTConditionSearch("open", txtCondi, ottName);
				}
				dtm.setDataVector(vData,title);
				movieFormAlign(tcm, dtcr);
			}
		});

		//전체 검색 버튼 마우스로 클릭시 //dao 전체 보기 같은 메소드
		btnOTTList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vData = dao.getOTTList(ottName);
				dtm.setDataVector(vData, title);
				movieFormAlign(tcm, dtcr);
			}
		});
		

		// 작품 등록 버튼 --완료
		btnOTTAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new OTT_Input(ottName);
			}
		});
		
		
		// 삭제 버튼 마우스로 클릭시
		btnOTTDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtOTTCondition.getText();
				
				int ans = JOptionPane.showConfirmDialog(null, name + " 작품을 삭제하겠습니까?");
				if(ans == 0) {
					res = dao.setOTTDelete(name);
					if(res != 0) {
						JOptionPane.showMessageDialog(null, name + " 작품 삭제를 완료했습니다.");
						dispose();
						new OTT_ListSearch(ottName);
					}
					else JOptionPane.showMessageDialog(null, name + " 작품 삭제를 실패했습니다.");
				}
				else JOptionPane.showMessageDialog(null, name + " 작품 삭제를 취소했습니다.");
			}
		});

		
		//메인으로 버튼 마우스로 클릭시 --완료
		btnOTTExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new OTT_Main();
			}
		});
		
		
	//=========================================================================
		setVisible(true);
	//=========================================================================
		
	}	

	//테이블안의 내용 가운데정렬하기
	private void movieFormAlign(TableColumnModel tcm, DefaultTableCellRenderer dtcr) {
		for(int i=0; i<tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(dtcr);
		}
	}

//	public static void main(String[] args) {
//		new OTTList("");
//	}
}
