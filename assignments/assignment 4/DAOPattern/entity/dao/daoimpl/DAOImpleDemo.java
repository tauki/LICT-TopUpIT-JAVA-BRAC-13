package entity.dao.daoimpl;
import entity.dao.*;
import java.sql.*;
import java.util.*;
import entity.Stu;
public class DAOImpleDemo implements DAOInterface
{
	Connection con=null;

	public DAOImpleDemo(Connection con)
	{
		this.con=con;
	}
	public void insert(Stu st)throws Exception
	{
		PreparedStatement ps=con.prepareStatement("insert into student(Stu_ID, Stu_name, Stu_dept, Stu_CGPA) values(?,?,?,?)");
		ps.setInt(1,st.getSid());
		ps.setFloat(4,st.getScgpa());
		ps.setString(2,st.getSname());
		ps.setString(3,st.getSdept());
		ps.execute();
	}

	public List showAll() throws Exception
	{
		Statement stmt = con.createStatement();
		String qry = "select * from student";
		ResultSet rs = stmt.executeQuery(qry);

		List<Stu> arr = new ArrayList<Stu>();
		while(rs.next()){
			int id = rs.getInt(1);
			String name = rs.getString(2);
			String dept = rs.getString(3);
			float cgpa = rs.getFloat(4);

			arr.add(new Stu(id, name, dept, cgpa));
		}
		return arr;
	}

	public List showByID(int id) throws Exception
	{
		String qry = "select * from student where Stu_ID=" + id;
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(qry);
		List<Stu> arr = new ArrayList<Stu>();
		rs.next();
		id = rs.getInt(1);
		String name = rs.getString(2);
		String dept = rs.getString(3);
		float cgpa = rs.getFloat(4);
		arr.add(new Stu(id, name, dept, cgpa));
		return arr;
	}
	public int updateByID(int id) throws Exception
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter name:");
		String name = keyboard.nextLine();
		System.out.println("Enter dept:");
		String dept = keyboard.nextLine();
		System.out.println("Enter cgpa:");
		float cgpa = keyboard.nextFloat();

		String qry = "update student set Stu_name=?, Stu_dept=?, Stu_CGPA=? where Stu_ID=?";
				//"Stu_name=" + name + ", " +
				//"Stu_dept=" + dept + ", " +
				//"Stu_CGPA=" + cgpa +
				//"where Stu_ID=" + id;

		PreparedStatement ps = con.prepareStatement(qry);
		ps.setString(1, name);
		ps.setString(2, dept);
		ps.setFloat(3, cgpa);
		ps.setInt(4, id);
		int rs = ps.executeUpdate();
		return rs;
	}
	public int deleteByID(int id) throws Exception
	{
		String qry = "delete from student where Stu_ID=" + id;
		Statement stmt = con.createStatement();
		int rs = stmt.executeUpdate(qry);
		return rs;
	}
}