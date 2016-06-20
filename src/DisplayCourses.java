import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import org.omg.CORBA.PUBLIC_MEMBER;

import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.util.Vector;

public class DisplayCourses extends JFrame {

		private Course[] courseArray;
		
		JTable table = new JTable();
		DefaultTableModel model = new DefaultTableModel();
		
	
	/**
	 * 
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Course[] crs = new Course[1];
					DisplayCourses frame = new DisplayCourses(crs,null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param args 
	 * @param courseArray 
	 */
	public DisplayCourses(final Course[] courseArr, final String[] args) {
		courseArray = courseArr;
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
				model.addRow(new Object[]{"Code","Name","Description","hours","Capacity","Fall?","Spring?","Summer?","prereq"});
				
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
					Course crs = new Course();
					crs.setCoursenum((String)table.getModel().getValueAt(row, 0));
					crs.setCoursename((String)table.getModel().getValueAt(row, 1));
					crs.setDescrip((String)table.getModel().getValueAt(row, 2));
					crs.setCredithr((String)table.getModel().getValueAt(row, 3));
					crs.setCapacity((String)table.getModel().getValueAt(row, 4));
					crs.setFall((String)table.getModel().getValueAt(row, 5));
					crs.setSpring((String)table.getModel().getValueAt(row, 6));
					crs.setSummer((String)table.getModel().getValueAt(row, 7));
					crs.setPrecourse((String)table.getModel().getValueAt(row, 8));
					
					courseArray[row+1] = crs;
					
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
					int selectedOption = JOptionPane.showConfirmDialog(parent, "Are you sure you want to delete the Course: "+
								(String)table.getModel().getValueAt(row, 0)+" ?");
					
					if(selectedOption==JOptionPane.CANCEL_OPTION){
						parent.dispose();
					}else if(selectedOption == JOptionPane.NO_OPTION){
						parent.dispose();
					}else if(selectedOption == JOptionPane.OK_OPTION){
						
						Course[] crs = new Course[courseArray.length-1];
						
						for(int i=0;i<=row;i++){
							crs[i]=courseArray[i];
						}
						
						String courseDeleted = courseArray[row+1].getCoursenum();
						
						for(int i = row+1;i<courseArray.length-1;i++){
							crs[i] = courseArray[i+1];
						}
						courseArray = crs;
						
						JFrame parent1 = new JFrame();
						JOptionPane.showMessageDialog(parent1, "Course "+ courseDeleted+" deleted succesfully");
						
						new DisplayCourses(courseArray,args).setVisible(true);
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
					new Home(args).setCourseArray(courseArray);
					new Home(args);
					dispose();
				}
				
			}
		});
		
		JButton btnSave = new JButton("Save Changes");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Course[] courses = new Course[table.getRowCount()+1];
				for(int row=0;row<table.getRowCount();row++){
					Course crs = new Course();
					
					crs.setCoursenum((String)table.getModel().getValueAt(row, 0));
					crs.setCoursename((String)table.getModel().getValueAt(row, 1));
					crs.setDescrip((String)table.getModel().getValueAt(row, 2));
					crs.setCredithr((String)table.getModel().getValueAt(row, 3));
					crs.setCapacity((String)table.getModel().getValueAt(row, 4));
					crs.setFall((String)table.getModel().getValueAt(row, 5));
					crs.setSpring((String)table.getModel().getValueAt(row, 6));
					crs.setSummer((String)table.getModel().getValueAt(row, 7));
					crs.setPrecourse((String)table.getModel().getValueAt(row, 8));
					
					courses[row+1]=crs;
				}
				
				courseArray = courses;
				courseArray[0]=courseArr[0];
				
				JFrame parent = new JFrame();
		        JOptionPane.showMessageDialog(parent,"Changes Saved succesfully.");
				
				new DisplayCourses(courseArray,args).setVisible(true);
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
		
		header[0] = (courseArr[0].getCoursenum());
		header[1] = (courseArr[0].getCoursename());
		header[2] = (courseArr[0].getDescrip());
		header[3] = (courseArr[0].getCredithr());
		header[4] = (courseArr[0].getCapacity());
		header[5] = (courseArr[0].getFall());
		header[6] = (courseArr[0].getSpring());
		header[7] = (courseArr[0].getSummer());
		header[8] = (courseArr[0].getPrecourse());
		
		String[][] obj = new String[courseArr.length-1][9];
		for(int i=0;i<courseArr.length-1;i++){
			obj[i][0] = (courseArr[i+1].getCoursenum());
			obj[i][1] = (courseArr[i+1].getCoursename());
			obj[i][2] = (courseArr[i+1].getDescrip());
			obj[i][3] = (courseArr[i+1].getCredithr());
			obj[i][4] = (courseArr[i+1].getCapacity());
			obj[i][5] = (courseArr[i+1].getFall());
			obj[i][6] = (courseArr[i+1].getSpring());
			obj[i][7] = (courseArr[i+1].getSummer());
			obj[i][8] = (courseArr[i+1].getPrecourse());
		}
		
		table.setModel(new DefaultTableModel(obj,header));
		//table.setModel(model);
		table.getColumnModel().getColumn(3).setResizable(false);
		scrollPane.setViewportView(table);
		
		contentPane.setLayout(gl_contentPane);
		//contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnGenerate, btnTest, lblNewLabel, lblNewLabel_1}));
	
		
		
	}
	
	
}
