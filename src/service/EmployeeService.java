package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import bean.EmployeeDispBean;
import bean.EmployeeListDispBean;
import dao.Dao;
import dao.EmployeesDao;



public class EmployeeService
{

	public EmployeeListDispBean findAll()
	{
		EmployeeListDispBean bean = new EmployeeListDispBean();

		//オートクローズ
		try( Connection con= Dao.getConnection() )
		{
			EmployeesDao dao = new EmployeesDao(con);

			List<EmployeeDispBean> eList = dao.findAll();

			bean.setEmpList(eList);

		}
		catch( SQLException | ClassNotFoundException e )
		{
			e.printStackTrace();
			throw new RuntimeException( e );
		}

		return bean;
	}

	//--------------------------------------------
	public EmployeeDispBean findByKey(String strId)
	{

		EmployeeDispBean emp = null;
		try( Connection con = Dao.getConnection() )
		{

			int id= Integer.parseInt( strId );

			EmployeesDao dao = new EmployeesDao(con);

			emp =  dao.findByKey(id);


		}
		catch( SQLException | ClassNotFoundException e1 )
		{
			e1.printStackTrace();
			throw new RuntimeException( e1 );
		}

		return emp;
	}


}
