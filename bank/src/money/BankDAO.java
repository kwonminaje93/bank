package money;


import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class BankDAO {


	//정보 입력
	public void insert(BankDTO dto) throws Exception {
		String url = "jdbc:mysql://localhost:3306/bank?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "1234";

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "insert into member value(?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, dto.getId());
		ps.setString(2, dto.getName());
		ps.setString(3, dto.getAge());
		ps.setString(4, dto.getTel());

		ps.executeUpdate();

		con.close();
		ps.close();
	}	
	
	//전체검색
	public ArrayList<BankDTO> selectAll() throws Exception {
		String url = "jdbc:mysql://localhost:3306/bank";
		String user = "root";
		String password = "1234";

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "select * from member ";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		ArrayList<BankDTO> list = new ArrayList<BankDTO>();
		BankDTO dto;
		while (rs.next()) {
			dto = new BankDTO();
			dto.setId(rs.getString(1));
			dto.setName(rs.getString(2));
			dto.setAge(rs.getString(3));
			dto.setTel(rs.getString(4));
			list.add(dto);
		}
		for (int i = 0; i < list.size(); i++) {
	         dto = list.get(i);
	         System.out.println("  " + dto.getId() + "\t  " + dto.getName() + "\t  " + dto.getAge() + "\t  " + dto.getTel());
	      }
		con.close();
		ps.close();
		rs.close();

		return list;
	}
	//회원 탈퇴 - 아이디로 검색
	public void delete(String id) throws Exception {
		String url = "jdbc:mysql://localhost:3306/bank";
		String user = "root";
		String password = "1234";

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "delete from member where id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ps.executeUpdate();
		con.close();
		ps.close();
	}
	
	//아이디 찾아서 전화번호 변경
	public void update(String id, String tel) throws Exception {
		String url = "jdbc:mysql://localhost:3306/bank?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "1234";

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "update member set tel = ? where id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, tel);
		ps.setString(2, id);

		ps.executeUpdate();

		con.close();
		ps.close();
	}

	
	
}