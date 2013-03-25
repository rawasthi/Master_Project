package net.ankur.spring3.HibernateDBTest;

import net.ankur.spring3.dao.ProfessorLoginDAO;

public class TestProfLogin {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ProfessorLoginDAO profDAO = new ProfessorLoginDAO();

		int Id1 = profDAO.saveProfCredentials("a", "1");
		int Id2 = profDAO.saveProfCredentials("b", "2");
		int Id3 = profDAO.saveProfCredentials("c", "3");
		int Id4 = profDAO.saveProfCredentials("d", "4");

		profDAO.listRecords();

		profDAO.updateRecord(Id4, "e", "5");

		profDAO.deleteRecord(Id3);

		profDAO.listRecords();
		
		System.out.println(profDAO.findRecord("xiao", "su"));
	}
}
