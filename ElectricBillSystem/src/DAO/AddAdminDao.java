package DAO;

import java.util.List;

import POJO.Admin;

public interface AddAdminDao {
	boolean AddAdmin(Admin a);

	boolean DeleteAdmin(String emailId);

	boolean UpdateAdmin(Admin a1);

	Admin searchByEmailId(String emailId);

	List<Admin> getAllAdmin();
}
