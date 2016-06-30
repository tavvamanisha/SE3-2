import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.DebugGraphics;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Degree_Report extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable table;
	static HashMap<String, Integer> degreeCountMapping = new HashMap();
	//static Degree[] degArr;
	static String[][] obj;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Degree_Report frame = new Degree_Report(null,null, null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

		
	
	/**
	 * Create the frame.
	 */
	public Degree_Report(final String[] args,Student[] studarray, Degree[] degreearray) {
		
		
		/*if(studarray == null){
			JFrame parent = new JFrame();
	        JOptionPane.showMessageDialog(parent,"Please import Student List first.");
	        new Home(args).setVisible(true);
			setVisible(false);
			dispose();
		} 
		else{*/
			
		
		for(int i=1;i<degreearray.length;i++){
			degreeCountMapping.put(degreearray[i].getDegreeCode(), 0);
		}
		
		for(int i=0;i<studarray.length;i++){
			for(int j=1; j<degreearray.length;j++){
				
				if((studarray[i].getDegree()).equals(degreearray[j].getDegreeCode())){
					
					int count = degreeCountMapping.get(degreearray[j].getDegreeCode());
					degreeCountMapping.put(degreearray[j].getDegreeCode(), count+1);
				}
			}
		}
		
		
		
		Set SOK = degreeCountMapping.keySet();
		Iterator it = SOK.iterator();
		while(it.hasNext()){
			String degreeCode = (String) it.next();
			int count = degreeCountMapping.get(degreeCode);
			
			System.out.println("Degree Code: "+degreeCode+" \tCount:"+count);
			
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 768, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		scrollPane = new JScrollPane();
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				args[0]="0";
				new Home(args).setVisible(true);
				//new Home(args).setFacultyArray(facultyArray);
				new Home(args);
				dispose();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnBack)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 699, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 334, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addComponent(btnBack)
					.addContainerGap(32, Short.MAX_VALUE))
		);
		
		table = new JTable();
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setRowSelectionAllowed(true);
		table.setForeground(Color.BLACK);
		table.setFillsViewportHeight(true);
		table.setBackground(SystemColor.control);
		table.setName("table");
		table.getGridColor();
		
		
		
		table.getTableHeader().getBackground().getBlue();
		table.setAutoCreateRowSorter(true);
		
		
		String[][] obj = new String[degreearray.length-1][2];
		for(int i=1;i<degreearray.length;i++){
			System.out.println(i);
			obj[i-1][0] = (degreearray[i].getDegreeCode());
			obj[i-1][1] = String.valueOf(degreeCountMapping.get(degreearray[i].getDegreeCode()));
		}
		
	
		
		table.setModel(new DefaultTableModel(
				obj,
				new String[] {
					"Degree Name", "Student Count"
				}
			));
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
		
		
	}
	//}
}
