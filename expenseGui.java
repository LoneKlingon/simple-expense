import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

import java.awt.BorderLayout;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JTextArea;


public class expenseGui {

	private JFrame frame;
	private JTextField incomeName; 
	private JTextField incomeValue;
	private JTextField expenseName;
	private JTextField expenseValue;
	private JTextField fixedIncomeName;
	private JTextField fixedIncomeValue;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	
	static private final String newline = "\n";
	
	
	Expense meth = new Expense();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					expenseGui window = new expenseGui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public expenseGui() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(400, 400, 564, 527);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblIncomeName = new JLabel("Income Name");
		lblIncomeName.setBounds(18, 40, 94, 16);
		frame.getContentPane().add(lblIncomeName);
		
		JLabel label = new JLabel("Income Value");
		label.setBounds(18, 82, 94, 16);
		frame.getContentPane().add(label);
		
		JButton btnInsertIncome = new JButton("Insert Income");
		btnInsertIncome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (meth.isDouble(incomeValue.getText())){
					meth.insertI(incomeName.getText(), Double.parseDouble((incomeValue.getText())));
					incomeName.setText("");
					incomeValue.setText("");
				}
			}
		});
		btnInsertIncome.setBounds(49, 119, 117, 29);
		frame.getContentPane().add(btnInsertIncome);
		
		incomeName = new JTextField();
		incomeName.setBounds(125, 34, 78, 28);
		frame.getContentPane().add(incomeName);
		incomeName.setColumns(10);
		
		incomeValue = new JTextField();
		incomeValue.setBounds(124, 76, 79, 28);
		frame.getContentPane().add(incomeValue);
		incomeValue.setColumns(10);
		
		JLabel label_1 = new JLabel("Expense Name");
		label_1.setBounds(301, 34, 94, 16);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Expense Value");
		label_2.setBounds(301, 82, 94, 16);
		frame.getContentPane().add(label_2);
		
		expenseName = new JTextField();
		expenseName.setColumns(10);
		expenseName.setBounds(422, 34, 78, 28);
		frame.getContentPane().add(expenseName);
		
		expenseValue = new JTextField();
		expenseValue.setColumns(10);
		expenseValue.setBounds(422, 76, 78, 28);
		frame.getContentPane().add(expenseValue);
		
		JButton button = new JButton("Insert Expense");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (meth.isDouble(expenseValue.getText())){
					
					meth.insertE(expenseName.getText(), Double.parseDouble(expenseValue.getText()) );
				}
				
			}
		});
		button.setBounds(336, 119, 117, 29);
		frame.getContentPane().add(button);
		
		JLabel lblRegularIncomeexpense = new JLabel("Regular Income/Expense");
		lblRegularIncomeexpense.setBounds(189, 6, 173, 16);
		frame.getContentPane().add(lblRegularIncomeexpense);
		
		JLabel lblFixedIncomeexpense = new JLabel("Fixed Income/Expense");
		lblFixedIncomeexpense.setBounds(189, 157, 150, 16);
		frame.getContentPane().add(lblFixedIncomeexpense);
		
		JLabel lblFixedIncomeName = new JLabel("Fixed Income Name");
		lblFixedIncomeName.setBounds(29, 184, 137, 16);
		frame.getContentPane().add(lblFixedIncomeName);
		
		fixedIncomeName = new JTextField();
		fixedIncomeName.setColumns(10);
		fixedIncomeName.setBounds(165, 185, 78, 28);
		frame.getContentPane().add(fixedIncomeName);
		
		JLabel label_3 = new JLabel("Fixed Income Value");
		label_3.setBounds(29, 234, 137, 16);
		frame.getContentPane().add(label_3);
		
		fixedIncomeValue = new JTextField();
		fixedIncomeValue.setColumns(10);
		fixedIncomeValue.setBounds(165, 228, 78, 28);
		frame.getContentPane().add(fixedIncomeValue);
		
		JLabel label_4 = new JLabel("Fixed Expense Name");
		label_4.setBounds(273, 191, 137, 16);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("Fixed Expense Value");
		label_5.setBounds(273, 234, 137, 16);
		frame.getContentPane().add(label_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(422, 185, 78, 28);
		frame.getContentPane().add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(422, 228, 78, 28);
		frame.getContentPane().add(textField_7);
		
		JButton button_1 = new JButton("Insert Fixed Income");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				meth.addFixedIncome(fixedIncomeName.getText(), Double.parseDouble(fixedIncomeValue.getText()));
			}
		});
		button_1.setBounds(49, 273, 168, 29);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("Insert Fixed Expense");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_2.setBounds(301, 273, 168, 29);
		frame.getContentPane().add(button_2);
		
		JLabel lblRemoveFixedIncomeexpense = new JLabel("Remove Fixed Income/Expense");
		lblRemoveFixedIncomeexpense.setBounds(189, 325, 206, 16);
		frame.getContentPane().add(lblRemoveFixedIncomeexpense);
		
		JLabel lblFixedIncomeName_1 = new JLabel("Fixed Income Name");
		lblFixedIncomeName_1.setBounds(34, 361, 144, 16);
		frame.getContentPane().add(lblFixedIncomeName_1);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(165, 353, 78, 28);
		frame.getContentPane().add(textField_8);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setBounds(86, 389, 117, 29);
		frame.getContentPane().add(btnRemove);
		
		JLabel label_6 = new JLabel("Fixed Expense Name");
		label_6.setBounds(266, 361, 144, 16);
		frame.getContentPane().add(label_6);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(422, 355, 78, 28);
		frame.getContentPane().add(textField_9);
		
		JButton button_3 = new JButton("Remove");
		button_3.setBounds(318, 389, 117, 29);
		frame.getContentPane().add(button_3);
		
		final JLabel lblMoneyLeft = new JLabel("Money Left");
		lblMoneyLeft.setBounds(212, 475, 94, 16);
		frame.getContentPane().add(lblMoneyLeft);
		
		JButton btnCalculate = new JButton("Calculate ");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblMoneyLeft.setText(Double.toString(meth.moneyLeft()));
			}
		});
		btnCalculate.setBounds(29, 470, 117, 29);
		frame.getContentPane().add(btnCalculate);
		
		
		final JTextArea log = new JTextArea();
		log.setBounds(242, 424, 168, 16);
		frame.getContentPane().add(log);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				int returnVal = fc.showSaveDialog(frame);
			      if (returnVal == JFileChooser.APPROVE_OPTION) {
			        File file = fc.getSelectedFile();
			        try {
						PrintWriter output = new PrintWriter(file);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			        //This is where a real application would save the file.
			        log.append("Saving: " + file.getName() + newline);
			      } else {
			        log.append("Save command cancelled by user." + newline);
			      }
			}
		});
		btnSave.setBounds(366, 470, 78, 29);
		frame.getContentPane().add(btnSave);
		
	    
		final JFileChooser fileDialog = new JFileChooser();
		final JLabel statusLabel;
		
	    statusLabel = new JLabel("",JLabel.CENTER);    

		
	    statusLabel.setSize(350,100);


		JButton button_4 = new JButton("Load");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int returnVal = fileDialog.showOpenDialog(frame);
	            if (returnVal == JFileChooser.APPROVE_OPTION) {
	               java.io.File income = fileDialog.getSelectedFile();
	               statusLabel.setText("File Selected :" 
	               + income.getName());
	            }
	            else{
	               statusLabel.setText("Open command cancelled by user." );           
	            }      
				
				
			}
		});
		button_4.setBounds(444, 470, 78, 29);
		frame.getContentPane().add(button_4);
		
		JLabel lblLoadsaveStatus = new JLabel("Load/Save Status");
		lblLoadsaveStatus.setBounds(405, 443, 137, 16);
		frame.getContentPane().add(lblLoadsaveStatus);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(521, 402, 1, 16);
		frame.getContentPane().add(textArea);
		
		
	}
}
