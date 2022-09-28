package LoanSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;
import java.math.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Loan_System {

	private JFrame frame;
	private JTextField textInterestRate;
	private JTextField textNoOfYear;
	private JTextField textLoanAmount;
	private JTextField textMonthlyPay;
	private JTextField textTotalPay;
	private JTextArea textReciptArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loan_System window = new Loan_System();
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
	public Loan_System() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Dialog", Font.BOLD, 14));
		frame.setBounds(100, 100, 822, 408);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel labelHeading = new JLabel("Loan Assistant System");
		labelHeading.setFont(new Font("Baskerville Old Face", Font.BOLD, 30));
		labelHeading.setBounds(10, 11, 395, 69);
		frame.getContentPane().add(labelHeading);
		
		JLabel lblNewLabel = new JLabel("Interest Rate");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 102, 175, 28);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("No Of Years");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 141, 175, 28);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Loan Amount");
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 180, 175, 28);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Monthly Payment");
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_3.setBounds(10, 219, 175, 28);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Total Payment");
		lblNewLabel_4.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_4.setBounds(10, 258, 175, 28);
		frame.getContentPane().add(lblNewLabel_4);
		
		textInterestRate = new JTextField();
		textInterestRate.setBounds(195, 91, 175, 38);
		frame.getContentPane().add(textInterestRate);
		textInterestRate.setColumns(10);
		
		textNoOfYear = new JTextField();
		textNoOfYear.setColumns(10);
		textNoOfYear.setBounds(195, 134, 175, 38);
		frame.getContentPane().add(textNoOfYear);
		
		textLoanAmount = new JTextField();
		textLoanAmount.setColumns(10);
		textLoanAmount.setBounds(195, 173, 175, 38);
		frame.getContentPane().add(textLoanAmount);
		
		textMonthlyPay = new JTextField();
		textMonthlyPay.setColumns(10);
		textMonthlyPay.setBounds(195, 213, 175, 38);
		frame.getContentPane().add(textMonthlyPay);
		
		textTotalPay = new JTextField();
		textTotalPay.setColumns(10);
		textTotalPay.setBounds(195, 252, 175, 38);
		frame.getContentPane().add(textTotalPay);
		
		textReciptArea = new JTextArea();
		textReciptArea.setBounds(415, 72, 368, 214);
		frame.getContentPane().add(textReciptArea);
		
		JLabel label5 = new JLabel("Loan Analysis : ");
		label5.setFont(new Font("DialogInput", Font.BOLD, 12));
		label5.setBounds(415, 35, 233, 28);
		frame.getContentPane().add(label5);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 302, 773, 56);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton JButton1 = new JButton("Loan Calculate");
		JButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				double InterestRate = Double.parseDouble(textInterestRate.getText());
				double MonthlyInterestRate = InterestRate/1200;
				int NoOfYear = Integer.parseInt(textNoOfYear.getText());
				double LoanAmount = Double.parseDouble(textLoanAmount.getText());
				//==============================================================
				double monthlypay = LoanAmount * MonthlyInterestRate /(1-1 /Math.pow(1+MonthlyInterestRate , NoOfYear*12));
				String iMonthlyPay ;
				iMonthlyPay= Double.toString(monthlypay);
				iMonthlyPay= String.format("% .2f",monthlypay);
				textMonthlyPay.setText(iMonthlyPay);
				//==============================================================
				double TotalPay = monthlypay * NoOfYear * 12;
				String iTotalPay ;
				iTotalPay= String.format("% .2f", TotalPay);
				textTotalPay.setText(iTotalPay);
			}
		});
		JButton1.setFont(new Font("Tahoma", Font.BOLD, 12));
		JButton1.setBounds(10, 7, 156, 38);
		panel.add(JButton1);
		
		JButton JButton2 = new JButton("Generate Recipt");
		JButton2.setFont(new Font("Tahoma", Font.BOLD, 12));
		JButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String InterestRate = String.format(textInterestRate.getText());
				String NoOfYear = String.format(textNoOfYear.getText());
				String LoanAcount = String.format(textLoanAmount.getText());
				String MonthlyPay = String.format(textMonthlyPay.getText());
				String TotalPay = String.format(textTotalPay.getText());
				//============================================================
				int refs = 1325 + (int)(Math.random()*4238);
				//============================================================
				Calendar timer = Calendar.getInstance();
				timer.getTime();
				SimpleDateFormat Time= new SimpleDateFormat("HH:mm:ss");
				SimpleDateFormat date= new SimpleDateFormat("dd-MMM-yyyy");
				Time.format(timer.getTime());
				date.format(timer.getTime());
				//============================================================
				textReciptArea.append("\t Consumer Loan Assistant System \n"+
						"\n===================================================\t"+
				"\n Refernce : \t\t\t "+refs+ 
				       "\n===================================================\t"+
				"\n Interest Rate : \t\t\t "+InterestRate+" % "+
				"\n RePayment Years : \t\t "+NoOfYear+" Years "+
				"\n Amount Of Loan : \t\t "+" $ "+LoanAcount+
				"\n Monthly Payment:\t\t "+" $ "+MonthlyPay+
				"\n Total Payment : \t\t "+" $ "+TotalPay+
				
						"\n===================================================\t"+ 
						"\n Date : "+date.format(timer.getTime())+
						"\t\t Time : "+Time.format(timer.getTime())+
						"\n\n\t\t Thank You \n");
			}
		});
		JButton2.setBounds(192, 7, 156, 38);
		panel.add(JButton2);
		
		JButton JButton3 = new JButton("Reset ");
		JButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textInterestRate.setText(null);
				textNoOfYear.setText(null);
				textLoanAmount.setText(null);
				textMonthlyPay.setText(null);
				textTotalPay.setText(null);
			}
		});
		JButton3.setFont(new Font("Tahoma", Font.BOLD, 12));
		JButton3.setBounds(371, 7, 156, 38);
		panel.add(JButton3);
		
		JButton JButton4 = new JButton("Exit ");
		JButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit ","Loan Managment System", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		JButton4.setFont(new Font("Tahoma", Font.BOLD, 12));
		JButton4.setBounds(556, 7, 156, 38);
		panel.add(JButton4);
	}
}
