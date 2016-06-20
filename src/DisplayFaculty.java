import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class DisplayFaculty extends JFrame {

	private JPanel contentPane;
	private Faculty[] facultyArray;
	JTable table = new JTable();
	DefaultTableModel model = new DefaultTableModel();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayFaculty frame = new DisplayFaculty(null,null);
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
	public DisplayFaculty(final Faculty[] facultyArr, final String[] args) {
		facultyArray = facultyArr;
		setTitle("Display Results");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 768, 480);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		//private JTable table;
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setForeground(Color.GRAY);
		scrollPane.setBackground(Color.GRAY);
		scrollPane.setAutoscrolls(true);
		scrollPane.setToolTipText("");
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[]{"{LastName}","{FirstName}","{GradSchool}","{Degree}","{Title}","{DayToTeach}","{MaxFallLoad}","{MaxSringLoad}","{MaxSummerLoad}"});
				
				JFrame parent = new JFrame();
		        JOptionPane.showMessageDialog(parent,"New Row added at the bottom. Please fill the values and Save.");
				
			}
		});
		
		
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				
				if(row== -1){
					JFrame parent = new JFrame();
			        JOptionPane.showMessageDialog(parent,"Please select a row and edit by double-click.");
				}else{
					Faculty faculty = new Faculty();
					
					faculty.setLastname((String)table.getModel().getValueAt(row, 0));
					faculty.setFirstname((String)table.getModel().getValueAt(row, 1));
					faculty.setGradschool((String)table.getModel().getValueAt(row, 2));
					faculty.setDegree((String)table.getModel().getValueAt(row, 3));
					faculty.setTitle((String)table.getModel().getValueAt(row, 4));
					faculty.setDay((String)table.getModel().getValueAt(row, 5));
					faculty.setMaxfall((String)table.getModel().getValueAt(row, 6));
					faculty.setMaxspring((String)table.getModel().getValueAt(row, 7));
					faculty.setMaxsummer((String)table.getModel().getValueAt(row, 8));
					
					facultyArray[row+1] = faculty;
					
					JFrame parent = new JFrame();
			        JOptionPane.showMessageDialog(parent,"Changes Updated succesfully.");
				}
				
			}
		});
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				
				if(row == -1){
					JFrame parent = new JFrame();
					JOptionPane.showMessageDialog(parent, "Please select a row to delete.");
				} else {
					JFrame parent = new JFrame();
					int selectedOption = JOptionPane.showConfirmDialog(parent, "Are you sure you want to delete the Faculty: "+
								(String)table.getModel().getValueAt(row, 1)+" "+(String)table.getModel().getValueAt(row, 0)+" ?");
					
					if(selectedOption==JOptionPane.CANCEL_OPTION){
						parent.dispose();
					}else if(selectedOption == JOptionPane.NO_OPTION){
						parent.dispose();
					}else if(selectedOption == JOptionPane.OK_OPTION){
						
						Faculty[] faculty = new Faculty[facultyArray.length-1];
						
						for(int i=0;i<=row;i++){
							faculty[i]=facultyArray[i];
						}
						
						String facultyDeleted = facultyArray[row+1].getFirstname()+" "+facultyArray[row+1].getLastname();
						
						for(int i = row+1;i<facultyArray.length-1;i++){
							faculty[i] = facultyArray[i+1];
						}
						facultyArray = faculty;
						
						JFrame parent1 = new JFrame();
						JOptionPane.showMessageDialog(parent1, "Faculty "+ facultyDeleted+" deleted succesfully");
						
						new DisplayFaculty(facultyArray,args).setVisible(true);
						setVisible(false);
						dispose();
					}
				}
					
			}
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFrame parent = new JFrame();
				int selectedOption = JOptionPane.showConfirmDialog(parent, "Any unsaved changes will be lost. Are you sure?");
				
				if(selectedOption==JOptionPane.CANCEL_OPTION){
					parent.dispose();
				}else if(selectedOption == JOptionPane.NO_OPTION){
					parent.dispose();
				}else if(selectedOption == JOptionPane.OK_OPTION){
					args[0]="0";
					new Home(args).setVisible(true);
					new Home(args).setFacultyArray(facultyArray);
					new Home(args);
					dispose();
				}
				
			}
		});
		
		JButton btnSave = new JButton("Save Changes");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Faculty[] faculties = new Faculty[table.getRowCount()+1];
				for(int row=0;row<table.getRowCount();row++){
					Faculty faculty = new Faculty();
					
					faculty.setLastname((String)table.getModel().getValueAt(row, 0));
					faculty.setFirstname((String)table.getModel().getValueAt(row, 1));
					faculty.setGradschool((String)table.getModel().getValueAt(row, 2));
					faculty.setDegree((String)table.getModel().getValueAt(row, 3));
					faculty.setTitle((String)table.getModel().getValueAt(row, 4));
					faculty.setDay((String)table.getModel().getValueAt(row, 5));
					faculty.setMaxfall((String)table.getModel().getValueAt(row, 6));
					faculty.setMaxspring((String)table.getModel().getValueAt(row, 7));
					faculty.setMaxsummer((String)table.getModel().getValueAt(row, 8));
					
					faculties[row+1]=faculty;
				}
				
				facultyArray = faculties;
				facultyArray[0]=facultyArr[0];
				
				JFrame parent = new JFrame();
		        JOptionPane.showMessageDialog(parent,"Changes Saved succesfully.");
				
				new DisplayFaculty(facultyArray,args).setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(31)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 711, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(140)
					.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnSave)
					.addContainerGap(139, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(12, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAdd)
						.addComponent(btnUpdate)
						.addComponent(btnDelete)
						.addComponent(btnBack)
						.addComponent(btnSave))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 367, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setRowSelectionAllowed(true);
		table.setForeground(Color.BLACK);
		table.setFillsViewportHeight(true);
		table.setBackground(SystemColor.control);
		table.setName("table");
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getGridColor();
		table.getTableHeader().getBackground().getBlue();
		table.setAutoCreateRowSorter(true);
		
		String[] header = new String[9];
		
		header[0] = (facultyArr[0].getLastname());
		header[1] = (facultyArr[0].getFirstname());
		header[2] = (facultyArr[0].getGradschool());
		header[3] = (facultyArr[0].getDegree());
		header[4] = (facultyArr[0].getTitle());
		header[5] = (facultyArr[0].getDay());
		header[6] = (facultyArr[0].getMaxfall());
		header[7] = (facultyArr[0].getMaxspring());
		header[8] = (facultyArr[0].getMaxsummer());
		
		String[][] obj = new String[facultyArr.length-1][9];
		for(int i=0;i<facultyArr.length-1;i++){
			obj[i][0] = (facultyArr[i+1].getLastname());
			obj[i][1] = (facultyArr[i+1].getFirstname());
			obj[i][2] = (facultyArr[i+1].getGradschool());
			obj[i][3] = (facultyArr[i+1].getDegree());
			obj[i][4] = (facultyArr[i+1].getTitle());
			obj[i][5] = (facultyArr[i+1].getDay());
			obj[i][6] = (facultyArr[i+1].getMaxfall());
			obj[i][7] = (facultyArr[i+1].getMaxspring());
			obj[i][8] = (facultyArr[i+1].getMaxsummer());
		}
		
		table.setModel(new DefaultTableModel(obj,header));
		//table.setModel(model);
		table.getColumnModel().getColumn(3).setResizable(false);
		scrollPane.setViewportView(table);
		
		contentPane.setLayout(gl_contentPane);
		//contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnGenerate, btnTest, lblNewLabel, lblNewLabel_1}));
		
	}

}
