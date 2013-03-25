package net.ankur.spring3.xmlparsing;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Vector;

import net.ankur.spring3.dao.ProfessorLoginDAO;
import net.ankur.spring3.dao.StudentLoginDAO;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class StudentLoginParser {


	public StudentLoginParser(){
		String fileName = "C:/Student_login_table.xls";
		Vector dataHolder = ReadCSV(fileName);
		printCellDataToConsole(dataHolder);
	}



	public static Vector ReadCSV(String fileName) {
		Vector cellVectorHolder = new Vector();

		try {
			FileInputStream myInput = new FileInputStream(fileName);

			POIFSFileSystem myFileSystem = new POIFSFileSystem(myInput);

			HSSFWorkbook myWorkBook = new HSSFWorkbook(myFileSystem);

			HSSFSheet mySheet = myWorkBook.getSheetAt(0);

			Iterator rowIter = mySheet.rowIterator();

			while (rowIter.hasNext()) {
				HSSFRow myRow = (HSSFRow) rowIter.next();
				Iterator cellIter = myRow.cellIterator();
				Vector cellStoreVector = new Vector();
				while (cellIter.hasNext()) {
					HSSFCell myCell = (HSSFCell) cellIter.next();
					cellStoreVector.addElement(myCell);
				}
				cellVectorHolder.addElement(cellStoreVector);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cellVectorHolder;
	}

	private static void printCellDataToConsole(Vector dataHolder) {
		String username ="";
		String password ="";
		StudentLoginDAO studentLoginData = new StudentLoginDAO();
		for (int i = 0; i < dataHolder.size(); i++) {
			Vector cellStoreVector = (Vector) dataHolder.elementAt(i);
			for (int j = 0; j < cellStoreVector.size(); j++) {
				HSSFCell myCell = (HSSFCell) cellStoreVector.elementAt(j);
				String stringCellValue = myCell.toString();
				if(username.equals(""))
				{
					username = stringCellValue;
				}else{
					password = stringCellValue;
				}
			}
			studentLoginData.insertRecord(username, password);
			username = "";
			password = "";
		}
	}
}
