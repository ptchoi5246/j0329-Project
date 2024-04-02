package Project;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Vector;
import java.util.regex.Pattern;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
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

public class Main_ListSearch extends JFrame {
	
	private JComboBox cbCondition;
	private JTextField txtCondition;
	private JButton btnSearch, btnList, btnExit;
	private JScrollPane scrollPane;
	private JTable table;
	
	private Vector title, vData;
	private DefaultTableModel dtm;
	
	private DefaultTableCellRenderer dtcr;
	private TableColumnModel tcm;
	
	OTTDAO dao = new OTTDAO();

	public Main_ListSearch(String ottName) {
		super("전 체 보 기 & 검    색");
		setSize(800,600);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBackground(Color.WHITE);
		pn1.setBounds(0, 1, 784, 78);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		cbCondition = new JComboBox();
		cbCondition.setForeground(new Color(0, 0, 0));
		cbCondition.setBackground(Color.WHITE);
		cbCondition.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 25));
		cbCondition.setModel(new DefaultComboBoxModel(new String[] {"제      목", "O  T  T", "장      르", "개봉년도"}));
		cbCondition.setBounds(18, 10, 130, 58);
		pn1.add(cbCondition);
		
		txtCondition = new JTextField();
		txtCondition.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 25));
		txtCondition.setBounds(166, 10, 300, 58);
		pn1.add(txtCondition);
		txtCondition.setColumns(10);
		
		btnSearch = new JButton("검     색");
		btnSearch.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 25));
		btnSearch.setBounds(484, 10, 130, 58);
		btnSearch.setBackground(Color.LIGHT_GRAY);
		pn1.add(btnSearch);
		
		btnList = new JButton("전 체 보 기");
		btnList.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 22));
		btnList.setBounds(631, 10, 130, 58);
		btnList.setBackground(Color.LIGHT_GRAY);
		pn1.add(btnList);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(0, 80, 784, 400);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
//		scrollPane = new JScrollPane();
//		scrollPane.setBounds(0, 0, 784, 400);
//		pn2.add(scrollPane);
		
		JPanel pn3 = new JPanel();
		pn3.setBackground(Color.WHITE);
		pn3.setBounds(0, 481, 784, 78);
		getContentPane().add(pn3);
		pn3.setLayout(null);
		
		btnExit = new JButton("메 인 으 로");
		btnExit.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 22));
		btnExit.setBackground(Color.LIGHT_GRAY);
		btnExit.setBounds(642, 10, 130, 58);
		pn3.add(btnExit);
		
		//Jtable 설계
		title = new Vector<>();
		title.add("번호");
		title.add("제목");
		title.add("OTT");
		title.add("장르");
		title.add("개봉년도");
		
		vData = dao.getTotalList(); //메인 - 전체 보기 & 검색 getTotalList()
		dtm = new DefaultTableModel(vData, title);
		
		table = new JTable(dtm);
		table.setRowSorter(new TableRowSorter(dtm));
		
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 784, 400);
		
		pn2.add(scrollPane);
			
		/* JTable 속성 제어하기 */
		// table의 컬럼크기/크기고정/셀의 위치고정 설정
		table.getColumnModel().getColumn(0).setMaxWidth(100);			// 컬럼의 최대크기 지정
		table.getColumnModel().getColumn(1).setMaxWidth(400);			
		table.getColumnModel().getColumn(2).setMaxWidth(200);
		table.getColumnModel().getColumn(3).setMaxWidth(200);
		table.getColumnModel().getColumn(4).setMaxWidth(200);
		table.getColumnModel().getColumn(0).setResizable(false);	// 컬럼 크기 변경불가
		table.getColumnModel().getColumn(2).setResizable(false);	
		table.getColumnModel().getColumn(3).setResizable(false);	
		table.getColumnModel().getColumn(4).setResizable(false);	
		table.getTableHeader().setReorderingAllowed(false);				// 컬럼 고정
		
		// 테이블 셀안의 내용 수평정렬하기
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = table.getColumnModel();
		movieFormAlign(tcm, dtcr); //테이블 안 가운데 정렬 메소드
		
		
		//검색 버튼 마우스 클릭시
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String cbCondi = cbCondition.getSelectedItem().toString();
				String txtCondi = txtCondition.getText();
				
				if(txtCondi.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "검색할 내용을 입력하세요!");
					txtCondition.requestFocus();
					return;
				}
				if(cbCondi.equals("제      목")) {
					vData = dao.getConditionSearch("name", txtCondi);
					if(vData.size() != 0) {
						System.out.println("vData : " + vData);
						System.out.println("검색자료 출력");
					}
					else {
						JOptionPane.showMessageDialog(null, "해당 제목의 작품은 없습니다. 다시 확인해주세요.");
					}
				}
				else if(cbCondi.equals("O  T  T")) {
					vData = dao.getConditionSearch("ott", txtCondi);
					System.out.println("vData : " + vData);
					if(vData.size() != 0) {
						System.out.println("검색자료 출력");
					}
					else {
						JOptionPane.showMessageDialog(null, "해당 OTT는 없습니다. 다시 확인해주세요.");
					}			
				}
				else if(cbCondi.equals("장      르")) {
					vData = dao.getConditionSearch("genre", txtCondi);
					System.out.println("vData : " + vData);
					if(vData.size() != 0) {
						System.out.println("검색자료 출력");
					}
					else {
						JOptionPane.showMessageDialog(null, "해당 장르는 없습니다. 다시 확인해주세요.");
					}			
				}
				else if(cbCondi.equals("개봉년도")) {
					if(!Pattern.matches("^[0-9]+$", txtCondi)) {
						JOptionPane.showMessageDialog(null, "개봉년도는 숫자만 입력해주세요.");
						txtCondition.requestFocus();
					}
					else vData = dao.getConditionSearch("open", txtCondi);
				}
				dtm.setDataVector(vData,title);
				movieFormAlign(tcm, dtcr);
			}
		});

		
		// 전체검색 버튼 마우스 클릭시
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vData = dao.getTotalList();
				dtm.setDataVector(vData, title);
				movieFormAlign(tcm, dtcr);
			}
		});

		
		// 메인으로 버튼 마우스로 클릭시
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new OTT_Main();
			}
		});

		
	//==============================================================	
		setVisible(true);
	//==============================================================
		
	}	
		
	// 테이블안의 내용 가운데정렬하기 메소드
	private void movieFormAlign(TableColumnModel tcm, DefaultTableCellRenderer dtcr) {
		for(int i=0; i<tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(dtcr);
		}
	}

//	public static void main(String[] args) {
//		new OTTListandSearch();
//	}
}
