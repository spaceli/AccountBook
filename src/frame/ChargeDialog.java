/*
 * ChargeDialog.java
 *
 * Created on __DATE__, __TIME__
 */

package frame;

import java.awt.Component;
import java.awt.Frame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ComboBoxEditor;
import javax.swing.plaf.metal.MetalComboBoxEditor;

import model.Person;

/**
 * 
 * @author __USER__
 */
public class ChargeDialog extends javax.swing.JDialog {
	private ArrayList<Person> personList;
	private Person currentPerson;
	private MainFrame mainFrame;

	public ChargeDialog(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();
		this.setLocation(400, 300);

		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				dispose();
			}
		});

	}

	public ChargeDialog(MainFrame parent, ArrayList<Person> personList) {
		this(null, true);
		this.mainFrame = parent;
		this.personList = personList;
		for (Person p : personList) {
			nameCombox.addItem(p.name);
		}

	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		nameCombox = new javax.swing.JComboBox();
		jLabel3 = new javax.swing.JLabel();
		okButton = new javax.swing.JButton();
		cancleButton = new javax.swing.JButton();
		chargeCombox = new javax.swing.JComboBox();
		restLabel = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		jLabel1.setText("\u59d3    \u540d");

		nameCombox.setEditable(true);
		nameCombox.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				nameComboxItemStateChanged(evt);
			}
		});

		jLabel3.setText("\u5145\u503c\u91d1\u989d");

		okButton.setText("\u786e\u5b9a");
		okButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				okButtonActionPerformed(evt);
			}
		});

		cancleButton.setText("\u53d6\u6d88");
		cancleButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cancleButtonActionPerformed(evt);
			}
		});

		chargeCombox.setEditable(true);
		chargeCombox.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "10", "20", "50", "100", "0" }));
		chargeCombox.setSelectedIndex(4);

		restLabel.setText("\u4f59\u989d");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout
				.setHorizontalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGap(0, 269, Short.MAX_VALUE)
						.addGroup(
								layout
										.createSequentialGroup()
										.addGap(31, 31, 31)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jLabel1)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(
																				nameCombox,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				141,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel3)
																		.addGap(
																				26,
																				26,
																				26)
																		.addGroup(
																				layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING)
																						.addGroup(
																								layout
																										.createSequentialGroup()
																										.addComponent(
																												okButton)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												cancleButton))
																						.addComponent(
																								chargeCombox,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								141,
																								javax.swing.GroupLayout.PREFERRED_SIZE))))
										.addContainerGap(23, Short.MAX_VALUE))
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								layout.createSequentialGroup().addContainerGap(
										135, Short.MAX_VALUE).addComponent(
										restLabel,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										78,
										javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(56, 56, 56)));
		layout
				.setVerticalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGap(0, 144, Short.MAX_VALUE)
						.addGroup(
								layout
										.createSequentialGroup()
										.addContainerGap(24, Short.MAX_VALUE)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel1)
														.addComponent(
																nameCombox,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(restLabel)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel3)
														.addComponent(
																chargeCombox,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(okButton)
														.addComponent(
																cancleButton))
										.addContainerGap()));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	/**
	 * ȡ��
	 */
	private void cancleButtonActionPerformed(java.awt.event.ActionEvent evt) {
		dispose();
	}

	/**
	 * ȷ��
	 * @param evt
	 */
	private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {
		currentPerson = null;
		String name = (String) nameCombox.getSelectedItem();
		for (Person p : personList) {
			if (p.name.equals(name)) {
				currentPerson = p;
				break;
			}
		}
		double money = Double.valueOf((String) chargeCombox.getSelectedItem());
		if(money<0){
			dispose();
			return;
		}
		if (currentPerson == null) {
			currentPerson = new Person(name, money);
		} else {
			currentPerson.money += money;
		}
		mainFrame.savePersonCharge(currentPerson,"+充值"+money+"元");
		
		dispose();
	}

	private void nameComboxItemStateChanged(java.awt.event.ItemEvent evt) {
		currentPerson = null;
		for (Person p : personList) {
			if (p.name.equals(nameCombox.getSelectedItem())) {
				currentPerson = p;
				break;
			}
		}
		if (currentPerson == null) {
			restLabel.setText("无记录");
		} else {
			restLabel.setText("余额:" + currentPerson.money + "元");
		}
		System.out.println(nameCombox.getSelectedItem());
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton cancleButton;
	private javax.swing.JComboBox chargeCombox;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JComboBox nameCombox;
	private javax.swing.JButton okButton;
	private javax.swing.JLabel restLabel;
	// End of variables declaration//GEN-END:variables

}