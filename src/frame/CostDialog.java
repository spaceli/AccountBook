/*
 * CostDialog.java
 *
 * Created on __DATE__, __TIME__
 */

package frame;

import java.awt.event.WindowAdapter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.print.attribute.standard.JobMessageFromOperator;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import action.FileAction;

import model.Person;

/**
 *
 * @author  __USER__
 */
public class CostDialog extends javax.swing.JDialog {
	private ArrayList<Person> personList;
	private ArrayList<Person> selectPersonList = new ArrayList<Person>();
	private MainFrame mainframe;
	private DefaultListModel model = new DefaultListModel();

	/** Creates new form CostDialog */
	public CostDialog(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();
		this.setLocation(400, 300);

		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				dispose();
			}
		});
	}

	public CostDialog(MainFrame mainframe, ArrayList<Person> personList) {
		this(mainframe, true);
		this.mainframe = mainframe;
		this.personList = personList;

		pJlist.setModel(model);
		for (Person p : personList) {
			model.addElement("   " + p.name);
		}

		ArrayList<String> eventList = FileAction.getEventListFromFile();
		for (String s : eventList) {
			eventCombox.addItem(s);
		}
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jScrollPane1 = new javax.swing.JScrollPane();
		pJlist = new javax.swing.JList();
		eventCombox = new javax.swing.JComboBox();
		moneyTextField = new javax.swing.JTextField();
		jLabel1 = new javax.swing.JLabel();
		numberLabel = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		okButton = new javax.swing.JButton();
		cancelButton = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		pJlist.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				pJlistMouseClicked(evt);
			}
		});
		jScrollPane1.setViewportView(pJlist);

		eventCombox.setEditable(true);

		jLabel1.setText("\u53c2\u4e0e\u4eba\u6570");

		numberLabel.setText("0\u4eba");

		jLabel3.setText("\u4e8b\u4ef6");

		jLabel4.setText("\u603b\u989d");

		okButton.setText("\u786e\u5b9a");
		okButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				okButtonActionPerformed(evt);
			}
		});

		cancelButton.setText("\u53d6\u6d88");
		cancelButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cancelButtonActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout
				.setHorizontalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addComponent(
												jScrollPane1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												92,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addGap(
																				31,
																				31,
																				31)
																		.addGroup(
																				layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jLabel1)
																						.addGroup(
																								layout
																										.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.TRAILING)
																										.addComponent(
																												jLabel4)
																										.addComponent(
																												jLabel3)))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								eventCombox,
																								0,
																								160,
																								Short.MAX_VALUE)
																						.addComponent(
																								moneyTextField,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								160,
																								Short.MAX_VALUE)
																						.addComponent(
																								numberLabel,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								160,
																								Short.MAX_VALUE)))
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																layout
																		.createSequentialGroup()
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				okButton)
																		.addGap(
																				30,
																				30,
																				30)
																		.addComponent(
																				cancelButton)))
										.addContainerGap(
												20,
												javax.swing.GroupLayout.PREFERRED_SIZE)));
		layout
				.setVerticalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jScrollPane1,
								javax.swing.GroupLayout.DEFAULT_SIZE, 219,
								Short.MAX_VALUE)
						.addGroup(
								layout
										.createSequentialGroup()
										.addGap(23, 23, 23)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel1)
														.addComponent(
																numberLabel))
										.addGap(20, 20, 20)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel3)
														.addComponent(
																eventCombox,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel4)
														.addComponent(
																moneyTextField,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												49, Short.MAX_VALUE)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(okButton)
														.addComponent(
																cancelButton))
										.addGap(37, 37, 37)));

		pack();
	}// </editor-fold>

	/**
	 * 锟斤拷锟斤拷斜锟窖★拷说锟斤拷锟接�
	 * @param evt
	 */
	private void pJlistMouseClicked(java.awt.event.MouseEvent evt) {
		int index = pJlist.getSelectedIndex();
		Person p = personList.get(index);
		if (selectPersonList.contains(p)) {
			model.set(index, "   " + p.name);
			selectPersonList.remove(p);
		} else {
			model.set(index, " * " + p.name);
			selectPersonList.add(p);
		}
		numberLabel.setText(String.valueOf(selectPersonList.size()));
	}
	
	/**
	 * 取锟斤拷钮锟斤拷应
	 * @param evt
	 */
	private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {
		dispose();
	}

	/**
	 * 确锟斤拷锟斤拷钮锟斤拷应
	 * @param evt
	 */
	private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {
		double money = Double.valueOf(moneyTextField.getText());
		if(money == 0){
			JOptionPane.showConfirmDialog(null, "Wrong Input money", "Error",
					JOptionPane.YES_OPTION);
			return;
		}
		int num = selectPersonList.size();
		if(num == 0){
			JOptionPane.showConfirmDialog(null, "Please Choose People", "Error",
					JOptionPane.YES_OPTION);
			return;
		}
		
		double everyOne = money/num;
		NumberFormat formatter = new DecimalFormat(".00");
		String everyS = formatter.format(Math.abs(everyOne));  
		for(Person p : selectPersonList){
			p.money -= everyOne;
		}
		
		String message = null;
		if(everyOne < 0){
			message = "+ "+eventCombox.getSelectedItem()+","+ everyS+"元/人";
		}else {
			message = "- "+eventCombox.getSelectedItem()+","+everyS+"元/人";
		}
		
		mainframe.savePeopleCost(selectPersonList, message);
		dispose();
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton cancelButton;
	private javax.swing.JComboBox eventCombox;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextField moneyTextField;
	private javax.swing.JLabel numberLabel;
	private javax.swing.JButton okButton;
	private javax.swing.JList pJlist;
	// End of variables declaration//GEN-END:variables

}