package net.ankur.spring3.xmlparsing;

import java.io.FileInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;

import net.ankur.spring3.dao.CourseDAO;
import net.ankur.spring3.dao.ProfessorLoginDAO;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;



public class CourseInfoParser {

	
	public static void main(String args[]){
		String fileName = "C:/FALL_SCHED.xls";
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
		String course_no ="";
		String course_name ="";
		int course_section = 0;
		String course_type="";
		String course_time="";
		String course_venue="";
		String course_days="";
		String course_professor="";
		
		
		//ProfessorLoginDAO.truncateProfTable();
		
		CourseDAO courseDao = new CourseDAO();
		for (int i = 0; i < dataHolder.size(); i++) {
			Vector cellStoreVector = (Vector) dataHolder.elementAt(i);
			for (int j = 0; j < cellStoreVector.size(); j++) {
				HSSFCell myCell = (HSSFCell) cellStoreVector.elementAt(j);
				String stringCellValue = myCell.toString();
				if(course_no.equals(""))
				{
					course_no = stringCellValue;
				}else if(course_name.equals("")){
					course_name = stringCellValue;
				}
				else if(course_name.equals("")){
					course_name = stringCellValue;
				}
				else if(course_section==0){
					course_section =  Integer.parseInt(stringCellValue.replaceAll("([0-9])\\.0+([^0-9]|$)", "$1$2"));
				}
				else if(course_time.equals("")){
					course_time = stringCellValue;
				}
				else if(course_type.equals("")){
					course_type = stringCellValue;
				}
				else if(course_days.equals("")){
					course_days = stringCellValue;
				}
				else if(course_venue.equals("")){
					course_venue = stringCellValue;
				}
				else{
					course_professor = stringCellValue;
				}
				//System.out.print(username + "-----"+password);
			}
			
			
			//handle time
			
			//Date updatedCourseTime= handleTime(course_time);
			
			courseDao.saveCourseInfo(course_no, course_name, course_section, course_time, course_type, course_days, course_venue, course_professor);
			course_no="";
			course_name="";
			course_section=0;
			course_type="";
			course_time= "";
			course_days="";
			course_venue="";
			course_professor="";
		}
		
	}
		
		/*public static Date handleTime(String course_time){
			
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");	
			
			String temp[]= course_time.split("-");
			Date startTime = new Date();
			try {
				startTime = df.parse(temp[0]);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return startTime;
			
			
		}*/
		
		
		
		
	

}	
	
	
	
	
	

