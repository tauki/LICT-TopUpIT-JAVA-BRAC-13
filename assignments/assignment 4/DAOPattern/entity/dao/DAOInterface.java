package entity.dao;
import entity.Stu;
import java.util.*;
public interface DAOInterface
{
	public void insert(Stu st)throws Exception;
	public List showAll() throws Exception;
	public List showByID(int id) throws Exception;
	public int updateByID(int id) throws Exception;
	public int deleteByID(int id) throws Exception;
}