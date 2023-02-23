package se.lu.ics;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JTextPane;
import javax.swing.JButton;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldID;
	private JTextField textFieldFirstName;
	private JTextField textFieldLastName;
	private JTextField textFieldJobTitle;
	private JTextField textFieldCity;

	/**
	 * Create the frame.
	 */
	public GUI() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 726, 399);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
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

	}

}
