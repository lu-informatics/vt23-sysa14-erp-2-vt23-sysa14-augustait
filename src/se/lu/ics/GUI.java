package se.lu.ics;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;

public class GUI extends JFrame {

	private JFrame testFrame;
	private JPanel contentPane;
	private JTextField textFieldID;
	private JTextField textFieldFirstName;
	private JTextField textFieldLastName;
	private JTextField textFieldJobTitle;
	private JTextField textFieldCity;
	private JTextPane textPane;
	private JButton btnNamesOfAllColumns;
	private JButton btnTotalNumberOfTables;
	private JButton btnCreate;
	private JButton btnFind;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnTotalNumberOfColumns;
	private JButton btnAllPrimaryKeys;

	/**
	 * Create the frame.
	 */
	public GUI() {
		testFrame = new JFrame();
		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		testFrame.setBounds(100, 100, 857, 430);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		textFieldID = new JTextField();
		textFieldID.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textFieldID.setBounds(20, 208, 121, 19);
		contentPane.add(textFieldID);
		textFieldID.setColumns(10);

		textFieldFirstName = new JTextField();
		textFieldFirstName.setBounds(172, 208, 133, 19);
		contentPane.add(textFieldFirstName);
		textFieldFirstName.setColumns(10);

		textFieldLastName = new JTextField();
		textFieldLastName.setBounds(342, 208, 121, 19);
		contentPane.add(textFieldLastName);
		textFieldLastName.setColumns(10);

		textFieldJobTitle = new JTextField();
		textFieldJobTitle.setBounds(502, 208, 121, 19);
		contentPane.add(textFieldJobTitle);
		textFieldJobTitle.setColumns(10);

		textFieldCity = new JTextField();
		textFieldCity.setBounds(671, 208, 114, 19);
		contentPane.add(textFieldCity);
		textFieldCity.setColumns(10);

		textPane = new JTextPane();
		textPane.setBounds(25, 10, 760, 175);
		contentPane.add(textPane);
		
		btnCreate = new JButton("Create");
		btnCreate.setBounds(20, 237, 85, 21);
		contentPane.add(btnCreate);

		btnFind = new JButton("Find");
		btnFind.setBounds(20, 268, 85, 21);
		contentPane.add(btnFind);

		btnUpdate = new JButton("Update");
		btnUpdate.setBounds(20, 299, 85, 21);
		contentPane.add(btnUpdate);

		btnDelete = new JButton("Delete");
		btnDelete.setBounds(20, 331, 85, 21);
		contentPane.add(btnDelete);

		btnNamesOfAllColumns = new JButton("Names Of All Columns");
		btnNamesOfAllColumns.setBounds(128, 331, 165, 21);
		contentPane.add(btnNamesOfAllColumns);

		btnTotalNumberOfTables = new JButton("Total Number Of Tables");
		btnTotalNumberOfTables.setBounds(304, 331, 177, 21);
		contentPane.add(btnTotalNumberOfTables);

		btnTotalNumberOfColumns = new JButton("Total Number Of Columns");
		btnTotalNumberOfColumns.setBounds(491, 331, 189, 21);
		contentPane.add(btnTotalNumberOfColumns);

		btnAllPrimaryKeys = new JButton("All Primary Keys");
		btnAllPrimaryKeys.setBounds(690, 331, 134, 21);
		contentPane.add(btnAllPrimaryKeys);

		JScrollPane scrollPane = new JScrollPane(contentPane);
		
		JLabel lblID = new JLabel("ID:");
		lblID.setBounds(20, 195, 45, 13);
		contentPane.add(lblID);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(172, 195, 133, 13);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(342, 195, 68, 13);
		contentPane.add(lblLastName);
		
		JLabel lblJobTitle = new JLabel("Job Title:");
		lblJobTitle.setBounds(502, 195, 121, 13);
		contentPane.add(lblJobTitle);
		
		JLabel lblCity = new JLabel("City:");
		lblCity.setBounds(671, 195, 114, 13);
		contentPane.add(lblCity);
		scrollPane.setBounds(0, 0, 710, 360);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		testFrame.getContentPane().add(scrollPane);

		testFrame.setVisible(true);

	}

	public JButton getBtnCreate() {
		return btnCreate;
	}

	public void setBtnCreate(JButton btnCreate) {
		this.btnCreate = btnCreate;
	}

	public JButton getBtnFind() {
		return btnFind;
	}

	public void setBtnFind(JButton btnFind) {
		this.btnFind = btnFind;
	}

	public JButton getBtnUpdate() {
		return btnUpdate;
	}

	public void setBtnUpdate(JButton btnUpdate) {
		this.btnUpdate = btnUpdate;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public void setBtnDelete(JButton btnDelete) {
		this.btnDelete = btnDelete;
	}

	public JButton getBtnTotalNumberOfColumns() {
		return btnTotalNumberOfColumns;
	}

	public void setBtnTotalNumberOfColumns(JButton btnTotalNumberOfColumns) {
		this.btnTotalNumberOfColumns = btnTotalNumberOfColumns;
	}

	public JButton getBtnAllPrimaryKeys() {
		return btnAllPrimaryKeys;
	}

	public void setBtnAllPrimaryKeys(JButton btnAllPrimaryKeys) {
		this.btnAllPrimaryKeys = btnAllPrimaryKeys;
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public void setContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
	}

	public JTextField getTextFieldID() {
		return textFieldID;
	}

	public void setTextFieldID(JTextField textFieldID) {
		this.textFieldID = textFieldID;
	}

	public JTextField getTextFieldFirstName() {
		return textFieldFirstName;
	}

	public void setTextFieldFirstName(JTextField textFieldFirstName) {
		this.textFieldFirstName = textFieldFirstName;
	}

	public JTextField getTextFieldLastName() {
		return textFieldLastName;
	}

	public void setTextFieldLastName(JTextField textFieldLastName) {
		this.textFieldLastName = textFieldLastName;
	}

	public JTextField getTextFieldJobTitle() {
		return textFieldJobTitle;
	}

	public void setTextFieldJobTitle(JTextField textFieldJobTitle) {
		this.textFieldJobTitle = textFieldJobTitle;
	}

	public JTextField getTextFieldCity() {
		return textFieldCity;
	}

	public void setTextFieldCity(JTextField textFieldCity) {
		this.textFieldCity = textFieldCity;
	}

	public JTextPane getTextPane() {
		return textPane;
	}

	public void setTextPane(JTextPane textPane) {
		this.textPane = textPane;
	}

	public JButton getBtnNamesOfAllColumns() {
		return btnNamesOfAllColumns;
	}

	public void setBtnNamesOfAllColumns(JButton btnNamesOfAllColumns) {
		this.btnNamesOfAllColumns = btnNamesOfAllColumns;
	}

	public JFrame getTestFrame() {
		return testFrame;
	}

	public void setTestFrame(JFrame testFrame) {
		this.testFrame = testFrame;
	}

	public JButton getBtnTotalNumberOfTables() {
		return btnTotalNumberOfTables;
	}

	public void setBtnTotalNumberOfTables(JButton btnTotalNumberOfTables) {
		this.btnTotalNumberOfTables = btnTotalNumberOfTables;
	}
}
