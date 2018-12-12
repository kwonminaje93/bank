package money;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;


import javax.swing.JTextField;


public class BankManager extends JFrame implements ActionListener{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	BankDAO dao = new BankDAO();
	BankDTO dto = new BankDTO();
	public BankManager() {
		setTitle("은행");
		setSize(300, 300);
		
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("아이디");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(37, 46, 57, 15);
		getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("이름");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(37, 80, 57, 15);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("나이");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(37, 110, 57, 15);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\uC804\uD654\uBC88\uD638");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(37, 138, 57, 15);
		getContentPane().add(label_2);
		
		textField = new JTextField();
		textField.setBounds(106, 43, 116, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(106, 75, 116, 21);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(106, 105, 116, 21);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(106, 135, 116, 21);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("등록");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					BankDAO dao = new BankDAO();
					BankDTO dto = new BankDTO();
					dto.setId(textField.getText());
					dto.setName(textField_1.getText());
					dto.setAge(textField_2.getText());
					dto.setTel(textField_3.getText());
					
					dao.insert(dto);
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "등록완료");
			}
		});
		btnNewButton.setBounds(37, 197, 97, 23);
		getContentPane().add(btnNewButton);
		
		JButton button = new JButton("검색");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					BankDAO dao = new BankDAO();
					System.out.println("아이디 \t 이름 \t 나이 \t 전화번호 \t");
					ArrayList dto = dao.selectAll();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		button.setBounds(146, 197, 97, 23);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("수정");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					BankDAO dao = new BankDAO();
					BankDTO dto = new BankDTO();
					
					dao.update(JOptionPane.showInputDialog(null, "수정할 아이디를 입력하세요."), JOptionPane.showInputDialog(null, "수정할 전화번호를 입력하세요."));
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "수정완료");
			}
		});
		button_1.setBounds(37, 230, 97, 23);
		getContentPane().add(button_1);
		
		JButton button_2 = new JButton("탈퇴");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					BankDAO dao = new BankDAO();
					BankDTO dto = new BankDTO();
					dto.setId(JOptionPane.showInputDialog(null, "탈퇴하고자하는 아이디를 입력하세요."));
					
					dao.delete(dto.getId());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "탈퇴완료");
			}
		});
		button_2.setBounds(146, 230, 97, 23);
		getContentPane().add(button_2);
		setVisible(true);
	}
	public static void main(String[] args) throws Exception {
		new BankManager();	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}