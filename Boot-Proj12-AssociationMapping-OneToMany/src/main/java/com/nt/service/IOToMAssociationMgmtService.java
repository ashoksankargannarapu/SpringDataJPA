package com.nt.service;

public interface IOToMAssociationMgmtService {
	public void saveDataUsingParent();
	public void saveDataUsingChild();
	public void loadDataUsingParent();
	public void deleteDataUsingParentById(int id);
	public void deleteAllChildsOfAParentById(int id);
	public void addNewChildToAParentById(int id);
	

}
