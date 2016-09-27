package com.niit.ShoppingCart.DAO;

import java.util.List;



import com.niit.ShoppingCart.model.Login;

public interface LoginDAO {

	
	public List<Login> list();
	
	public Login get(int id);
	
	public Login getSingleLogin(int id);
	
	public void save(Login login);
	
	public void update(Login login);
	
	public List getAlllogins();
	
	public void delete(int id);
}

