package Project;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;
import javax.swing.ImageIcon;

public class CoupangList extends JFrame{
	private JTextField txtCoupangCondition;
	private JButton btnCoupangSearch, btnCoupangList;
	private JScrollPane scrollPane;
	
	private JTable table;
	private Vector title, vData;
	private DefaultTableModel dtm;
	
	OTTDAO dao = new OTTDAO();
	
	public CoupangList() {
		super("Coupang Play");
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
		
		JLabel lblCoupang = new JLabel("");
		lblCoupang.setIcon(new ImageIcon(CoupangList.class.getResource("/images/Coupang200.jpg")));
		lblCoupang.setHorizontalAlignment(SwingConstants.CENTER);
		lblCoupang.setBackground(Color.WHITE);
		lblCoupang.setBounds(0, 0, 784, 78);
		pn1.add(lblCoupang);
		
		JPanel pn2 = new JPanel();
		pn2.setBackground(Color.WHITE);
		pn2.setBounds(0, 80, 784, 78);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		JComboBox cbCoupangCondition = new JComboBox();
		cbCoupangCondition.setModel(new DefaultComboBoxModel(new String[] {"제     목", "장     르", "개봉년도"}));
		cbCoupangCondition.setForeground(new Color(12, 192, 255));
		cbCoupangCondition.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 25));
		cbCoupangCondition.setBackground(Color.WHITE);
		cbCoupangCondition.setBounds(18, 10, 130, 58);
		pn2.add(cbCoupangCondition);
		
		txtCoupangCondition = new JTextField();
		txtCoupangCondition.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 25));
		txtCoupangCondition.setColumns(10);
		txtCoupangCondition.setBounds(166, 10, 300, 58);
		pn2.add(txtCoupangCondition);
		
		btnCoupangSearch = new JButton("검     색");
		btnCoupangSearch.setForeground(new Color(12, 192, 255));
		btnCoupangSearch.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 25));
		btnCoupangSearch.setBackground(new Color(255, 255, 255));
		btnCoupangSearch.setBounds(484, 10, 130, 58);
		pn2.add(btnCoupangSearch);
		
		btnCoupangList = new JButton("전 체 검 색");
		btnCoupangList.setForeground(new Color(12, 192, 255));
		btnCoupangList.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 22));
		btnCoupangList.setBackground(new Color(255, 255, 255));
		btnCoupangList.setBounds(632, 10, 130, 58);
		pn2.add(btnCoupangList);
		
		JPanel pn3 = new JPanel();
		pn3.setBackground(Color.WHITE);
		pn3.setBounds(0, 157, 784, 329);
		getContentPane().add(pn3);
		pn3.setLayout(null);
		
		
		JLabel lblImage = new JLabel("");
		lblImage.setBounds(392, 10, 380, 303);
		pn3.add(lblImage);
		
		JPanel pn4 = new JPanel();
		pn4.setBackground(Color.WHITE);
		pn4.setLayout(null);
		pn4.setBounds(0, 483, 784, 78);
		getContentPane().add(pn4);
		
		JButton btnCoupangExit = new JButton("메 인 으 로");
		btnCoupangExit.setForeground(new Color(12, 192, 255));
		btnCoupangExit.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 25));
		btnCoupangExit.setBackground(new Color(255, 255, 255));
		btnCoupangExit.setBounds(622, 10, 150, 58);
		pn4.add(btnCoupangExit);
		
		//JTable 설계
		title = new Vector<>();
		title.add("번호");
		title.add("제목");
		title.add("장르");
		title.add("개봉년도");
		
		vData = dao.getCoupangList("","");
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
		
		// 전체셀 가운데 정렬
		for(int i=0; i<tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(dtcr);
		}
		
		// Jtable 클릭시 그림파일의 정보를 레이블에 뿌려주기(그림 보여주기)
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
//				int col = table.getSelectedColumn();
				String name = table.getValueAt(row, 1).toString();
				
				// 작품명에 해당하는 그림을 DB에서 가져온다.
				OTTVO vo = dao.getNameSearch(name);
				String image = "movieImage/" + vo.getImg();
				
				lblImage.setIcon(new ImageIcon(image));
				
				//이미지 사진 딱 맞게 출력
				ImageIcon icon = new ImageIcon(image);
				Image img = icon.getImage();
				Image updateImg = img.getScaledInstance(349, 234, Image.SCALE_SMOOTH);
				
				ImageIcon updateIcon = new ImageIcon(updateImg);	// 변경된 크기의 이미지로 다시 생성..
				
				lblImage.setIcon(updateIcon);		// 생성된 이미지를 레이블에 아이콘으로 등록후 뿌려준다.(setText())
				//lblImage.setText(image);
			}
		});
		
		
		//쿠팡 검색 버튼 마우스로 클릭시
		btnCoupangSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		//쿠팡 전체 검색 버튼 마우스로 클릭시
		btnCoupangList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		//메인으로 버튼 마우스로 클릭시
		btnCoupangExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new OTTMain();
			}
		});
		
	//=========================================================================
		setVisible(true);
	//=========================================================================
		
		
		
		
		
		
		
		
	}
	
	public static void main(String[] args) {
		new CoupangList();
	}
}
