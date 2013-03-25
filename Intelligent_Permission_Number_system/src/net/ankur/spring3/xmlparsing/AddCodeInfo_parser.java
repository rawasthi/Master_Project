package net.ankur.spring3.xmlparsing;

import java.io.FileInputStream;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Vector;

import net.ankur.spring3.dao.AddCodeInfoDAO;
import net.ankur.spring3.dao.ProfessorLoginDAO;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class AddCodeInfo_parser {

	public AddCodeInfo_parser(){
		String fileName = "/Users/ankuraggarwal/Desktop/AddCodeInfo.xls";
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
		String courseNo = "";
		String courseName = ""; 
		int courseSection  = 0; 
		String waitlistName = "";  
		String waitlistId = ""; 
		String addcode = ""; 
		String addCodeStatus = ""; 

		AddCodeInfoDAO addCodeInfodao = new AddCodeInfoDAO();
		for (int i = 0; i < dataHolder.size(); i++) {
			Vector cellStoreVector = (Vector) dataHolder.elementAt(i);
			for (int j = 0; j < cellStoreVector.size(); j++) {
				HSSFCell myCell = (HSSFCell) cellStoreVector.elementAt(j);
				String stringCellValue = myCell.toString();
				if(courseNo.equals(""))
				{
					courseNo = stringCellValue;
				}else if(courseName.equals("")){
					courseName = stringCellValue;
				}else if(courseSection == 0){
					courseSection = Integer.parseInt(stringCellValue.replaceAll("([0-9])\\.0+([^0-9]|$)", "$1$2"));
				}else if(waitlistName.equals("")){
					waitlistName = stringCellValue;
				}else if(waitlistId.equals("")){
					waitlistId = stringCellValue.replaceAll("([0-9])\\.0+([^0-9]|$)", "$1$2");
				}else if(addcode.equals("")){
					addcode = stringCellValue;
				}else if(addCodeStatus.equals("")){
					addCodeStatus = stringCellValue;
				}
			}
			addCodeInfodao.saveAddCodeInfo(courseNo, courseName, courseSection, waitlistName, waitlistId, addcode, addCodeStatus);
			courseNo = "";
			courseName = ""; 
			courseSection  = 0; 
			waitlistName = "";  
			waitlistId = ""; 
			addcode = ""; 
			addCodeStatus = ""; 
		}
	}
}