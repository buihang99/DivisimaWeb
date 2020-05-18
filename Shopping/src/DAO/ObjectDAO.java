package DAO;

public interface ObjectDAO {
	
	public boolean addUser(Object obj);
	
	public boolean checkUser(String username);

	public boolean login(String name_user, String pass);
}
