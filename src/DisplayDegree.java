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

public class DisplayDegree extends JFrame {

	private JPanel contentPane;
	private Degree[] degreeArray;
	JTable table = new JTable();
	DefaultTableModel model = new DefaultTableModel();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayDegree frame = new DisplayDegree(null,null);
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
	public DisplayDegree(final Degree[] degreeArr, final String[] args) {
		degreeArray = degreeArr;
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
				model.addRow(new Object[]{"{Code}","{Name}"});
				
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
					Degree degree = new Degree();
					degree.setDegreeCode((String)table.getModel().getValueAt(row, 0));
					degree.setDegreeName((String)table.getModel().getValueAt(row, 1));
					
					degreeArray[row+1] = degree;
					
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
					int selectedOption = JOptionPane.showConfirmDialog(parent, "Are you sure you want to delete the Degree: "+
								(String)table.getModel().getValueAt(row, 0)+" ?");
					
					if(selectedOption==JOptionPane.CANCEL_OPTION){
						parent.dispose();
					}else if(selectedOption == JOptionPane.NO_OPTION){
						parent.dispose();
					}else if(selectedOption == JOptionPane.OK_OPTION){
						
						Degree[] degree = new Degree[degreeArray.length-1];
						
						for(int i=0;i<=row;i++){
							degree[i]=degreeArray[i];
						}
						
						String degreeDeleted = degreeArray[row+1].getDegreeCode();
						
						for(int i = row+1;i<degreeArray.length-1;i++){
							degree[i] = degreeArray[i+1];
						}
						degreeArray = degree;
						
						JFrame parent1 = new JFrame();
						JOptionPane.showMessageDialog(parent1, "Degree "+ degreeDeleted+" deleted succesfully");
						
						new DisplayDegree(degreeArray,args).setVisible(true);
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
					new Home(args).setDegreeArray(degreeArray);
					new Home(args);
					dispose();
				}
				
			}
		});
		
		JButton btnSave = new JButton("Save Changes");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Degree[] degrees = new Degree[table.getRowCount()+1];
				for(int row=0;row<table.getRowCount();row++){
					Degree degree = new Degree();
					degree.setDegreeCode((String)table.getModel().getValueAt(row, 0));
					degree.setDegreeName((String)table.getModel().getValueAt(row, 1));
					
					degrees[row+1]=degree;
				}
				
				degreeArray = degrees;
				degreeArray[0]=degreeArr[0];
				
				JFrame parent = new JFrame();
		        JOptionPane.showMessageDialog(parent,"Changes Saved succesfully.");
				
				new DisplayDegree(degreeArray,args).setVisible(true);
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
		
		String[] header = new String[2];
		
		header[0] = (degreeArr[0].getDegreeCode());
		header[1] = (degreeArr[0].getDegreeName());
		
		String[][] obj = new String[degreeArr.length-1][9];
		for(int i=0;i<degreeArr.length-1;i++){
			obj[i][0] = (degreeArr[i+1].getDegreeCode());
			obj[i][1] = (degreeArr[i+1].getDegreeName());
		}
		
		table.setModel(new DefaultTableModel(obj,header));
		//table.setModel(model);
		//table.getColumnModel().getColumn(3).setResizable(false);
		scrollPane.setViewportView(table);
		
		contentPane.setLayout(gl_contentPane);
		//contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnGenerate, btnTest, lblNewLabel, lblNewLabel_1}));
		
	}

}
