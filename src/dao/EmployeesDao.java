package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.EmployeeDispBean;



public class EmployeesDao {
	private Connection con;

	//-------------------------------
	private static final String DELETE_SQL = "DELETE "
			+ "FROM employees " +
			"WHERE "
			+ "EmployeeID = ?";

	//-------------------------------
	public EmployeesDao(Connection con) {
		super();
		this.con = con;
	}

	public void deleteEmployee(int id) throws SQLException {
		// 送信すべきSQLの雛形を作成
		PreparedStatement stmt = con.prepareStatement(DELETE_SQL);
		stmt.setInt(1, id);

		int r = stmt.executeUpdate();

		if (r != 1)
			throw new RuntimeException("削除に失敗しました。");
	}

	//-------------------------------
	private static final String FIND_BY_KEY_SQL = "SELECT `employees`.`EmployeeID`,\r\n"
			+ "    `employees`.`EmployeeName`,\r\n"
			+ "    `employees`.`Height`,\r\n"
			+ "    `employees`.`EMail`,\r\n"
			+ "    `employees`.`Weight`,\r\n"
			+ "    `employees`.`HireFiscalYear`,\r\n"
			+ "    `employees`.`Birthday`,\r\n"
			+ "    `employees`.`BloodType`\r\n"
			+ "FROM "
			+ "		`sqat_schema`.`employees`"
			+ "WHERE "
			+ "	EmployeeID = ?";
	//-------------------------------
	private static final String FIND_ALL_SQL = "SELECT "
			+ "* "
			+ "FROM "
			+ "employees";

	public EmployeeDispBean findByKey(int id) throws SQLException {
		EmployeeDispBean ret = new EmployeeDispBean();


		// 送信すべきSQLの雛形を作成
		PreparedStatement stmt = con.prepareStatement(FIND_BY_KEY_SQL);
		stmt.setInt(1, id);

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			ret.setEmployeeID(rs.getInt("EmployeeID"));
			ret.setEmployeeName(rs.getString("employeeName"));
			ret.setHeight(rs.getBigDecimal("height"));
			ret.seteMail(rs.getString("eMail"));
			ret.setWeight(rs.getBigDecimal("weight"));
			ret.setHireFiscalYear(rs.getInt("hireFiscalYear"));
			ret.setBirthday(rs.getDate("birthday").toLocalDate());
			ret.setBloodType(rs.getString("bloodType"));
		}
		return ret;
	}

	public List<EmployeeDispBean> findAll() throws SQLException {
		PreparedStatement stmt = con.prepareStatement(FIND_ALL_SQL);
		List<EmployeeDispBean> elist = new ArrayList<EmployeeDispBean>();
		ResultSet rs = stmt.executeQuery();
		EmployeeDispBean emp = null;

		while (rs.next()) {
			emp = new EmployeeDispBean();

			emp.setEmployeeID(rs.getInt("EmployeeID"));
			emp.setEmployeeName(rs.getString("employeeName"));
			emp.setHeight(rs.getBigDecimal("height"));
			emp.seteMail(rs.getString("eMail"));
			emp.setWeight(rs.getBigDecimal("weight"));
			emp.setHireFiscalYear(rs.getInt("hireFiscalYear"));
			emp.setBirthday(rs.getDate("birthday").toLocalDate());
			emp.setBloodType(rs.getString("bloodType"));

			elist.add(emp);
		}

		return elist;
	}

}
