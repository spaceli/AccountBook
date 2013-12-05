/*
 * MainFrame.java
 *
 * Created on __DATE__, __TIME__
 */

package frame;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;
import javax.swing.table.DefaultTableModel;

import action.FileAction;

import model.Log;
import model.Person;

/**
 *
 * @author  __USER__
 */
public class MainFrame extends javax.swing.JFrame {

	private DefaultListModel model = new DefaultListModel();
	private DefaultTableModel tableMode = new DefaultTableModel();
	private ArrayList<Person> pList;
	private ArrayList<Log> lList;

	public static void main(String args[]) {
		
		String password = JOptionPane.showInputDialog("input password");
		SimpleDateFormat format = new SimpleDateFormat("HHmm");
		System.out.println(format.format(new Date()));
		if(password.equals(format.format(new Date()))){
			java.awt.EventQueue.invokeLater(new Runnable() {
				public void run() {
					new MainFrame().setVisible(true);
				}
			});
		}
		
	}

	public MainFrame() {
		initComponents();
		this.setLocation(300, 200);

		personList.setModel(model);
		logTable.setModel(tableMode);
		tableMode.addColumn("时间");
		tableMode.addColumn("事件");
		tableMode.addColumn("参与者");
		logTable.getColumnModel().getColumn(0).setPreferredWidth(15);
		logTable.getColumnModel().getColumn(1).setPreferredWidth(110);
		logTable.getColumnModel().getColumn(2).setPreferredWidth(150);
		this.loadData();
	}

	private void loadData() {
		model.removeAllElements();

		pList = FileAction.getPersonListFromFile();
		NumberFormat formatter = new DecimalFormat(".00");
		
		for (Person p : pList) {
			String everyS = formatter.format(p.money); 
			model.addElement(p.name + "    " + everyS);
		}

		for (int i = tableMode.getRowCount() - 1; i >= 0; i--) {
			tableMode.removeRow(i);
		}

		lList = FileAction.getLogListFromFile();
		for (Log l : lList) {
			tableMode
					.addRow(new Object[] { l.getTime(), l.event, l.getNames() });
		}
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jScrollPane1 = new javax.swing.JScrollPane();
		personList = new javax.swing.JList();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jScrollPane2 = new javax.swing.JScrollPane();
		logTable = new javax.swing.JTable();
		jMenuBar1 = new javax.swing.JMenuBar();
		jMenu1 = new javax.swing.JMenu();
		jMenu2 = new javax.swing.JMenu();
		jMenuBar2 = new javax.swing.JMenuBar();
		jMenu3 = new javax.swing.JMenu();
		jMenu4 = new javax.swing.JMenu();
		jScrollPane3 = new javax.swing.JScrollPane();
		detailLogArea = new javax.swing.JTextArea();
		jMenuBar3 = new javax.swing.JMenuBar();
		jMenu5 = new javax.swing.JMenu();
		jMenuItem1 = new javax.swing.JMenuItem();
		jMenuItem2 = new javax.swing.JMenuItem();
		jMenu6 = new javax.swing.JMenu();
		jMenuItem3 = new javax.swing.JMenuItem();
		jMenuItem4 = new javax.swing.JMenuItem();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jScrollPane1.setViewportView(personList);

		jButton1.setText("+");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton2.setText("-");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});
		jButton3.setText("<");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		logTable.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] {

				}, new String[] {

				}));
		logTable.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				logTableMouseClicked(evt);
			}
		});
		
		personList.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				personListMouseClicked(evt);
			}
		});
		jScrollPane2.setViewportView(logTable);

		jMenu1.setText("\u6587\u4ef6");
		jMenuBar1.add(jMenu1);

		jMenu2.setText("Edit");
		jMenuBar1.add(jMenu2);

		jMenu3.setText("\u6587\u4ef6");
		jMenuBar2.add(jMenu3);

		jMenu4.setText("Edit");
		jMenuBar2.add(jMenu4);

		detailLogArea.setColumns(20);
		detailLogArea.setRows(5);
		jScrollPane3.setViewportView(detailLogArea);

		jMenu5.setText("\u64cd\u4f5c");

		jMenuItem1.setText("\u5145\u503c");
		jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem1ActionPerformed(evt);
			}
		});
		jMenu5.add(jMenuItem1);

		jMenuItem2.setText("\u652f\u51fa");
		jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem2ActionPerformed(evt);
			}
		});
		jMenu5.add(jMenuItem2);

		jMenuBar3.add(jMenu5);

		jMenu6.setText("\u6587\u4ef6");

		jMenuItem3.setText("\u5bfc\u5165\u8d26\u6237\u6587\u4ef6");
		jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem3ActionPerformed(evt);
			}
		});
		jMenu6.add(jMenuItem3);

		jMenuItem4.setText("\u5bfc\u5165\u65e5\u5fd7\u6587\u4ef6");
		jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem4ActionPerformed(evt);
			}
		});
		jMenu6.add(jMenuItem4);

		jMenuBar3.add(jMenu6);

		setJMenuBar(jMenuBar3);

		org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout
				.setHorizontalGroup(layout
						.createParallelGroup(
								org.jdesktop.layout.GroupLayout.LEADING)
						.add(
								layout
										.createSequentialGroup()
										.add(
												layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.LEADING)
														.add(
																org.jdesktop.layout.GroupLayout.TRAILING,
																layout
																		.createSequentialGroup()
																		.addContainerGap()
																		.add(
																				jButton1)
																		.addPreferredGap(
																				org.jdesktop.layout.LayoutStyle.RELATED)
																		.add(
																				jButton2)
																		.addPreferredGap(
																				org.jdesktop.layout.LayoutStyle.RELATED)
																		.add(
																				jButton3))
														.add(
																jScrollPane1,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																165,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED)
										.add(
												layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.LEADING)
														.add(
																jScrollPane3,
																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																518,
																Short.MAX_VALUE)
														.add(
																jScrollPane2,
																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																518,
																Short.MAX_VALUE))));
		layout
				.setVerticalGroup(layout
						.createParallelGroup(
								org.jdesktop.layout.GroupLayout.LEADING)
						.add(
								layout
										.createSequentialGroup()
										.add(
												jScrollPane1,
												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
												334,
												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED)
										.add(
												layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.BASELINE)
														.add(jButton3).add(jButton2).add(
																jButton1)))
						.add(
								layout
										.createSequentialGroup()
										.add(
												jScrollPane2,
												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
												258,
												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED,
												org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.add(
												jScrollPane3,
												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
												106,
												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private File[] choseFiles(){
		JFileChooser fc = new JFileChooser();
		fc.setDialogTitle("请选择文件");
		fc.setCurrentDirectory(new File("/"));
		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		fc.setMultiSelectionEnabled(true);
		fc.setLocation(300, 200);
		fc.showOpenDialog(this);
		return fc.getSelectedFiles();
	}
	/**
	 * �����˻��ļ�
	 */
	private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {
		File[] files = choseFiles();
		if (files.length == 0)
			return;
		
		for(File f : files){
			if(f.getName().substring(f.getName().indexOf(".")+1).equals("per")){
				ArrayList<Person> tmpList = FileAction.getPersonListFromFile(f);
				
				for(Person p : tmpList){
					if(pList.contains(p)){
						Person op = pList.get(pList.indexOf(p));
						op.money += p.money;
					}else{
						pList.add(p);
					}
				}
			}
		}
		try {
			FileAction.savePersonList(pList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loadData();
	}

	/**
	 * ������־�ļ�
	 * @param evt
	 */
	private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {
		File[] files = choseFiles();
		if (files.length == 0)
			return;
		
		for(File f : files){
			if(f.getName().substring(f.getName().indexOf(".")+1).equals("log")){
				ArrayList<Log> tmpList = FileAction.getLogListFromFile(f);
				ArrayList<Log> newList = new ArrayList<Log>();

				int i=0,j=0;
				while(i<lList.size() || j<tmpList.size()){
					if(i == lList.size()){
						newList.add(0,tmpList.get(j));
						j++;
						continue;
					}
					if(j == tmpList.size()){
						newList.add(0,lList.get(i));
						i++;
						continue;
					}
					if(lList.get(i).olderThan(tmpList.get(j))){
						newList.add(0,lList.get(i));
						i++;
					}else {
						newList.add(0,tmpList.get(j));
						j++;
					}
				}
				lList = newList;
			}
		}
		try {
			FileAction.saveLogList(lList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loadData();
	}

	private void logTableMouseClicked(java.awt.event.MouseEvent evt) {
		int index = logTable.getSelectedRow();
		Log l = lList.get(index);

		detailLogArea.setText("事件: " + l.event + "\n" + "参与者: "
				+ l.getNames().toString());
	}
	private void personListMouseClicked(java.awt.event.MouseEvent evt) {
		int index = personList.getSelectedIndex();
		Person p = pList.get(index);
		
		for (int i = tableMode.getRowCount() - 1; i >= 0; i--) {
			tableMode.removeRow(i);
		}
		
		StringBuffer logSB = new StringBuffer();
		logSB.append(p.name + "  剩余金额: "+p.money+"\r\n\r\n");
		lList = FileAction.getLogListFromFile();
		for (Log l : lList) {
			if(l.incluePerson(p)){
				tableMode
				.addRow(new Object[] { l.getTime(), l.event, l.getNames() });
				
				logSB.append(l.getTime()+" : "+l.event+"\r\n参与者："+l.getNames()+"\r\n\r\n");
			}		
		}
		FileAction.logPerson(p, logSB.toString());
	}
	/**
	 * ��ֵ�˵�����
	 */
	private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {
		new ChargeDialog(this, pList).setVisible(true);
	}

	/**
	 * ֧���˵�����
	 */
	private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {
		new CostDialog(this, pList).setVisible(true);
	}

	/**
	 * remove��ť����
	 */
	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		int index = personList.getSelectedIndex();
		Person p = pList.get(index);
		int o = JOptionPane.showConfirmDialog(null, "删除账户："+p.name, "提醒",
				JOptionPane.YES_NO_OPTION);
		
		ArrayList<String> names = new ArrayList<String>();
		names.add(p.name);
		lList.add(0,new Log(new Date().getTime(), "删除账户  余额："+p.money, names));
		if(o == 0){
			pList.remove(p);
			try {
				FileAction.saveLogList(lList);
				FileAction.savePersonList(pList);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.loadData();
	}

	/**
	 * add��ť����
	 */
	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {

		new ChargeDialog(this, pList).setVisible(true);
	}
	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		for (int i = tableMode.getRowCount() - 1; i >= 0; i--) {
			tableMode.removeRow(i);
		}

		lList = FileAction.getLogListFromFile();
		for (Log l : lList) {
			tableMode
					.addRow(new Object[] { l.getTime(), l.event, l.getNames() });
		}
	}
	/**
	 * �����ֵ�¼�
	 * @param p ��ֵ�Ķ���
	 * @param message ��ֵ��Ϣ
	 */
	public void savePersonCharge(Person p, String message) {
		pList.remove(p);
		pList.add(0, p);

		ArrayList<String> names = new ArrayList<String>();
		names.add(p.name);
		lList.add(0,new Log(new Date().getTime(), message, names));

		try {
			FileAction.savePersonList(pList);
			FileAction.saveLogList(lList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loadData();
	}

	public void savePeopleCost(ArrayList<Person> pl, String message) {
		pList.removeAll(pl);
		pList.addAll(0, pl);

		ArrayList<String> names = new ArrayList<String>();
		for (Person p : pl) {
			names.add(p.name);
		}
		lList.add(0,new Log(new Date().getTime(), message, names));

		try {
			FileAction.savePersonList(pList);
			FileAction.saveLogList(lList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loadData();
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JTextArea detailLogArea;
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JMenu jMenu1;
	private javax.swing.JMenu jMenu2;
	private javax.swing.JMenu jMenu3;
	private javax.swing.JMenu jMenu4;
	private javax.swing.JMenu jMenu5;
	private javax.swing.JMenu jMenu6;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JMenuBar jMenuBar2;
	private javax.swing.JMenuBar jMenuBar3;
	private javax.swing.JMenuItem jMenuItem1;
	private javax.swing.JMenuItem jMenuItem2;
	private javax.swing.JMenuItem jMenuItem3;
	private javax.swing.JMenuItem jMenuItem4;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JTable logTable;
	private javax.swing.JList personList;
	// End of variables declaration//GEN-END:variables

}