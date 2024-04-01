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

public class DisneyList extends JFrame{
	private JTextField txtDisneyCondition;
	private JButton btnDisneySearch, btnDisneyList;
	private JScrollPane scrollPane;
	
	private JTable table;
	private Vector title, vData;
	private DefaultTableModel dtm;
	
	OTTDAO dao = new OTTDAO();
	
	public DisneyList() {
		super("Disney Plus");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBackground(new Color(1, 9, 71));
		pn1.setBounds(0, 1, 784, 78);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		JLabel lblDisney = new JLabel("");
		lblDisney.setBackground(new Color(255, 255, 255));
		lblDisney.setHorizontalAlignment(SwingConstants.CENTER);
		lblDisney.setIcon(new ImageIcon(DisneyList.class.getResource("/images/Disney100.jpg")));
		lblDisney.setBounds(0, 0, 784, 78);
		pn1.add(lblDisney);
		
		JPanel pn2 = new JPanel();
		pn2.setBackground(new Color(1, 9, 71));
		pn2.setBounds(0, 80, 784, 78);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		JComboBox cbDisneyCondition = new JComboBox();
		cbDisneyCondition.setModel(new DefaultComboBoxModel(new String[] {"제     목", "장     르", "개봉년도"}));
		cbDisneyCondition.setForeground(new Color(255, 255, 255));
		cbDisneyCondition.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 25));
		cbDisneyCondition.setBackground(new Color(1, 9, 71));
		cbDisneyCondition.setBounds(18, 10, 130, 58);
		pn2.add(cbDisneyCondition);
		
		txtDisneyCondition = new JTextField();
		txtDisneyCondition.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 25));
		txtDisneyCondition.setColumns(10);
		txtDisneyCondition.setBounds(166, 10, 300, 58);
		pn2.add(txtDisneyCondition);
		
		btnDisneySearch = new JButton("검     색");
		btnDisneySearch.setForeground(new Color(255, 255, 255));
		btnDisneySearch.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 25));
		btnDisneySearch.setBackground(new Color(1, 9, 71));
		btnDisneySearch.setBounds(484, 10, 130, 58);
		pn2.add(btnDisneySearch);
		
		btnDisneyList = new JButton("전 체 검 색");
		btnDisneyList.setForeground(new Color(255, 255, 255));
		btnDisneyList.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 22));
		btnDisneyList.setBackground(new Color(1, 9, 71));
		btnDisneyList.setBounds(632, 10, 130, 58);
		pn2.add(btnDisneyList);
		
		JPanel pn3 = new JPanel();
		pn3.setBackground(new Color(1, 9, 71));
		pn3.setBounds(0, 153, 784, 329);
		getContentPane().add(pn3);
		pn3.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("images");
		lblNewLabel.setBounds(392, 10, 380, 303);
		pn3.add(lblNewLabel);
		
		JPanel pn4 = new JPanel();
		pn4.setBackground(new Color(1, 9, 71));
		pn4.setLayout(null);
		pn4.setBounds(0, 483, 784, 78);
		getContentPane().add(pn4);
		
		JButton btnDisneyExit = new JButton("메 인 으 로");
		btnDisneyExit.setForeground(new Color(255, 255, 255));
		btnDisneyExit.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 25));
		btnDisneyExit.setBackground(new Color(1, 9, 71));
		btnDisneyExit.setBounds(622, 10, 150, 58);
		pn4.add(btnDisneyExit);
		
		//JTable 설계
		title = new Vector<>();
		title.add("번호");
		title.add("제목");
		title.add("장르");
		title.add("개봉년도");
		
		vData = dao.getDisneyList("","");
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
		btnDisneyExit.addActionListener(new ActionListener() {
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
		new DisneyList();
	}
}
