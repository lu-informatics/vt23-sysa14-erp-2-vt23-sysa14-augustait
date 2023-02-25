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

	/**
	 * Create the frame.
	 */
	public GUI() {
		testFrame = new JFrame();
		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		testFrame.setBounds(100, 100, 726, 399);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		textFieldID = new JTextField();
		textFieldID.setBounds(20, 208, 96, 19);
		contentPane.add(textFieldID);
		textFieldID.setColumns(10);

		textFieldFirstName = new JTextField();
		textFieldFirstName.setBounds(144, 208, 96, 19);
		contentPane.add(textFieldFirstName);
		textFieldFirstName.setColumns(10);

		textFieldLastName = new JTextField();
		textFieldLastName.setBounds(279, 208, 96, 19);
		contentPane.add(textFieldLastName);
		textFieldLastName.setColumns(10);

		textFieldJobTitle = new JTextField();
		textFieldJobTitle.setBounds(426, 208, 96, 19);
		contentPane.add(textFieldJobTitle);
		textFieldJobTitle.setColumns(10);

		textFieldCity = new JTextField();
		textFieldCity.setBounds(579, 208, 96, 19);
		contentPane.add(textFieldCity);
		textFieldCity.setColumns(10);

		JTextPane textPane = new JTextPane();
		textPane.setBounds(25, 10, 676, 175);
		contentPane.add(textPane);

		JButton btnCreate = new JButton("Create");
		btnCreate.setBounds(20, 237, 85, 21);
		contentPane.add(btnCreate);

		JButton btnFind = new JButton("Find");
		btnFind.setBounds(20, 268, 85, 21);
		contentPane.add(btnFind);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(20, 299, 85, 21);
		contentPane.add(btnUpdate);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(20, 331, 85, 21);
		contentPane.add(btnDelete);

		JButton btnNamesOfAllColumns = new JButton("Names Of All Columns");
		btnNamesOfAllColumns.setBounds(137, 331, 140, 21);
		contentPane.add(btnNamesOfAllColumns);

		JButton btnTotalNumberOfTables = new JButton("Total Number Of Tables");
		btnTotalNumberOfTables.setBounds(287, 331, 140, 21);
		contentPane.add(btnTotalNumberOfTables);

		JButton btnTotalNumberOfColumns = new JButton("Total Number Of Columns");
		btnTotalNumberOfColumns.setBounds(437, 331, 150, 21);
		contentPane.add(btnTotalNumberOfColumns);

		JButton btnAllPrimaryKeys = new JButton("All Primary Keys");
		btnAllPrimaryKeys.setBounds(597, 331, 109, 21);
		contentPane.add(btnAllPrimaryKeys);
		
		

		JScrollPane scrollPane = new JScrollPane(contentPane);
		scrollPane.setBounds(0, 0, 710, 360);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		testFrame.getContentPane().add(scrollPane);

		testFrame.setVisible(true);

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
	
	

}
