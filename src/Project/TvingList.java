package Project;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class TvingList extends JFrame{
	private JTextField txtTvingCondition;
	private JButton btnTvingSearch, btnTvingList;
	private JScrollPane scrollPane;
	
	private JTable table;
	private Vector title, vData;
	private DefaultTableModel dtm;
	
	OTTDAO dao = new OTTDAO();
	
	public TvingList() {
		super("Tving");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBackground(new Color(255, 20, 61));
		pn1.setBounds(0, 1, 784, 78);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		JLabel lblTving = new JLabel("");
		lblTving.setForeground(new Color(255, 20, 61));
		lblTving.setHorizontalAlignment(SwingConstants.CENTER);
		lblTving.setIcon(new ImageIcon(TvingList.class.getResource("/images/Tving250.jpg")));
		lblTving.setBounds(0, 0, 784, 78);
		pn1.add(lblTving);
		
		JPanel pn2 = new JPanel();
		pn2.setBackground(new Color(255, 20, 61));
		pn2.setBounds(0, 80, 784, 78);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		JComboBox cbTvingCondition = new JComboBox();
		cbTvingCondition.setModel(new DefaultComboBoxModel(new String[] {"제     목", "장     르", "개봉년도"}));
		cbTvingCondition.setForeground(new Color(255, 255, 255));
		cbTvingCondition.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 25));
		cbTvingCondition.setBackground(new Color(255, 20, 61));
		cbTvingCondition.setBounds(18, 10, 130, 58);
		pn2.add(cbTvingCondition);
		
		txtTvingCondition = new JTextField();
		txtTvingCondition.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 25));
		txtTvingCondition.setColumns(10);
		txtTvingCondition.setBounds(166, 10, 300, 58);
		pn2.add(txtTvingCondition);
		
		btnTvingSearch = new JButton("검     색");
		btnTvingSearch.setForeground(new Color(255, 255, 255));
		btnTvingSearch.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 25));
		btnTvingSearch.setBackground(new Color(255, 20, 61));
		btnTvingSearch.setBounds(484, 10, 130, 58);
		pn2.add(btnTvingSearch);
		
		btnTvingList = new JButton("전 체 검 색");
		btnTvingList.setForeground(new Color(255, 255, 255));
		btnTvingList.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 22));
		btnTvingList.setBackground(new Color(255, 20, 61));
		btnTvingList.setBounds(632, 10, 130, 58);
		pn2.add(btnTvingList);
		
		JPanel pn3 = new JPanel();
		pn3.setBackground(new Color(255, 20, 61));
		pn3.setBounds(0, 157, 784, 329);
		getContentPane().add(pn3);
		pn3.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("images");
		lblNewLabel.setBounds(392, 10, 380, 303);
		pn3.add(lblNewLabel);
		
		JPanel pn4 = new JPanel();
		pn4.setBackground(new Color(255, 20, 61));
		pn4.setLayout(null);
		pn4.setBounds(0, 483, 784, 78);
		getContentPane().add(pn4);
		
		JButton btnTvingExit = new JButton("메 인 으 로");
		btnTvingExit.setForeground(new Color(255, 255, 255));
		btnTvingExit.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 25));
		btnTvingExit.setBackground(new Color(255, 20, 61));
		btnTvingExit.setBounds(622, 10, 150, 58);
		pn4.add(btnTvingExit);
		
		//JTable 설계
		title = new Vector<>();
		title.add("번호");
		title.add("제목");
		title.add("장르");
		title.add("개봉년도");
		
		vData = dao.getTvingList("","");
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
		
	
		
		
		
		
		
		//메인으로 버튼 마우스로 클릭시
		btnTvingExit.addActionListener(new ActionListener() {
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
		new TvingList();
	}
}
