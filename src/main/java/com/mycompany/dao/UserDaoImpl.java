package com.mycompany.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.management.RuntimeErrorException;
import com.mycompany.beans.User;
public class UserDaoImpl {
	private DaoFactory daofactory;
	
	public UserDaoImpl(DaoFactory daofactory) {
		this.daofactory = daofactory;
	}
	
	public User isValidLogin (String login, String password) {
			Connection connexion = null;
			PreparedStatement statement = null;
			password=HashClass.sha1(password);  // permet de hasher le mot de passe 
			
		try {
			connexion = daofactory.getConnection();
			statement = connexion.prepareStatement("SELECT * FROM connexion WHERE login=? AND password=?");
			statement.setString(1, login);
			statement.setString(2, password);
			ResultSet rs = statement.executeQuery();
			
			if(rs.next()) {
				return new User(rs.getInt("id"), rs.getString("login"),rs.getString("password"), rs.getInt("profil"));	
			}else{
				return null;
			}
			
		}catch(Exception exception){
			throw new RuntimeException(exception);	
		}	
	}
}