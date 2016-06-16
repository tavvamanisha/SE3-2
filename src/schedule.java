import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.ComponentOrientation;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.border.TitledBorder;
import javax.swing.DropMode;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.SystemColor;

public class schedule extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					schedule frame = new schedule();
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
	public schedule() {
		setTitle("Schedule");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 283);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		//private JTable table;
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
			
		});
		
		JButton btnTest = new JButton("Test");
		
		JLabel lblNewLabel = new JLabel("Generate Schedule");
		
		JLabel lblNewLabel_1 = new JLabel("Test Schedule");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setForeground(Color.GRAY);
		scrollPane.setBackground(Color.GRAY);
		scrollPane.setAutoscrolls(true);
		scrollPane.setToolTipText("");
		
		JButton btnPrint = new JButton("Print");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(31)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(47)
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(46)
									.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnTest, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnGenerate, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(314, Short.MAX_VALUE)
					.addComponent(btnPrint)
					.addGap(21))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(btnGenerate))
					.addGap(16)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(btnTest))
					.addGap(34)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnPrint)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.setRowSelectionAllowed(false);
		table.setForeground(Color.BLACK);
		table.setFillsViewportHeight(true);
		table.setEnabled(false);
		table.setBackground(SystemColor.control);
		table.setName("table");
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getGridColor();
		table.getTableHeader().getBackground().getBlue();
		table.setAutoCreateRowSorter(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"ENGR 5008", "Spring", "Bell", "1", "1", "9", "10"},
			},
			new String[] {
				"Course", "Semester", "Faculty", "Section No.", "Room No.", "Start Time", "End Time"
			}
		));
		table.getColumnModel().getColumn(3).setResizable(false);
		scrollPane.setViewportView(table);
		
		
		contentPane.setLayout(gl_contentPane);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnGenerate, btnTest, lblNewLabel, lblNewLabel_1}));
		
	}
}
