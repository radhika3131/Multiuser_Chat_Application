package com.radhika.chatapp.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.radhika.chatapp.dao.UserDAO;
import com.radhika.chatapp.dto.UserDTO;
import com.radhika.chatapp.utils.UserInfo;

@SuppressWarnings("serial")
public class UserScreen extends JFrame {
	private final JLabel lblNewLabel = new JLabel("LOGIN");
	private JPasswordField passwordField;
	private JTextField useridtxt;
	
	
	public static void main(String[] args) {
		
	@SuppressWarnings("unused")
	UserScreen window = new UserScreen();
					
	}
	
	UserDAO userDAO = new UserDAO();
	private void doLogin()
	{
		String userid = useridtxt.getText();
		char []password = passwordField.getPassword();
		//UserDAO userDAO = new UserDAO();
		UserDTO userDTO = new UserDTO(userid , password);
		
		try {
			String message = "";
			if(userDAO.isLogin(userDTO))
			{
				message = "Welcome "+userid;
				UserInfo.USER_NAME = userid;
				JOptionPane.showMessageDialog(this, message);
				setVisible(false);
				dispose();
				DashBoard dashBoard = new DashBoard(message);
				dashBoard.setVisible(true);
			}
			else
			{
				message = "Invalid Userid or Password";
				JOptionPane.showMessageDialog(this, message);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(SQLException e)
		{
			// TODO Auto-generated catch block
						e.printStackTrace();
		} catch(Exception e)
		{
			// TODO Auto-generated catch block
						e.printStackTrace();
		}
	}
	
	private void register() throws ClassNotFoundException, SQLException
	{
		String userid = useridtxt.getText();
		char []password = passwordField.getPassword();
		//UserDAO userDAO = new UserDAO();
		UserDTO userDTO = new UserDTO(userid , password);
		try {
		int result = userDAO.add(userDTO);
		if(result >0)
		{
			JOptionPane.showMessageDialog(this, "Register SuccessFully");
			//System.out.println("Record Added...");
		}
		else
		{
			JOptionPane.showMessageDialog(this, "Register Fail");
			//System.out.println("Record not Added...");
		}
		}
		catch(ClassNotFoundException | SQLException ex)
		{
			System.out.println("DB Issue ...");
			ex.printStackTrace();
		}
		catch(Exception ex)// Exception is a parent class of all class
		{
			System.out.println("Some Generic exception raised ...");
			ex.printStackTrace(); // where is the exception
		}
		System.out.println("userid  " +  userid  +" Password"+ password);
		// it is going to print password in hexadecimal form ..className@HashCode(Hexa)
	}

	/**
	 * Create the application.
	 */
	public UserScreen() {
		setResizable(false);
		getContentPane().setBackground(new Color(255, 255, 255));
		setTitle("Login");
		setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 37));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(182, 11, 134, 49);
		getContentPane().add(lblNewLabel);
		
		JLabel useridlbl = new JLabel("UserId");
		useridlbl.setFont(new Font("Tahoma", Font.PLAIN, 17));
		useridlbl.setHorizontalAlignment(SwingConstants.CENTER);
		useridlbl.setBounds(111, 88, 79, 29);
		getContentPane().add(useridlbl);
		
		JLabel pwdlbl = new JLabel("Password");
		pwdlbl.setHorizontalAlignment(SwingConstants.CENTER);
		pwdlbl.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pwdlbl.setBounds(121, 148, 79, 26);
		getContentPane().add(pwdlbl);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(261, 148, 182, 29);
		getContentPane().add(passwordField);
		
		useridtxt = new JTextField();
		useridtxt.setBounds(261, 88, 182, 29);
		getContentPane().add(useridtxt);
		useridtxt.setColumns(10);
		
		JButton loginbt = new JButton("Login");
		loginbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doLogin();
			}
		});
		loginbt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		loginbt.setBounds(175, 218, 89, 23);
		getContentPane().add(loginbt);
		
		JButton registerbt = new JButton("Register");
		
		registerbt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					register();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		registerbt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		registerbt.setBounds(308, 218, 104, 23);
		getContentPane().add(registerbt);
		setSize(568, 376);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
}
