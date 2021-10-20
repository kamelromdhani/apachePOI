package com.example.apachePOI;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@SpringBootApplication
public class ApachePoiApplication implements CommandLineRunner {
	private static String[] columns = { "RollNo", "FirstName", "LastName", "Subject" };
	private static List<Student> studentInfo = new ArrayList<Student>();
	private static Logger LOG = LoggerFactory
			.getLogger(ApachePoiApplication.class);

	public static void main(String[] args) {
		LOG.info("STARTING THE APPLICATION");
		SpringApplication.run(ApachePoiApplication.class, args);
		LOG.info("APPLICATION FINISHED");

	}

	@Override
	public void run(String... args) {
		LOG.info("EXECUTING : command line runner");

		Student s1 = new Student(1, "Abhishek", "Kumar", "Maths");
		Student s2 = new Student(2, "Robin", "Singh", "Maths");
		Student s3 = new Student(3, "Prakash", "Soni", "Maths");
		Student s4 = new Student(4, "Ayushi", "Agarwal", "Maths");
		Student s5 = new Student(5, "Heena", "Verma", "Maths");

		studentInfo.add(s1);
		studentInfo.add(s2);
		studentInfo.add(s3);
		studentInfo.add(s4);
		studentInfo.add(s5);
		writeExcelData();
		readExcelData();
	}

	private static void writeExcelData() {
		// Create a workbook
		Workbook workbook = new XSSFWorkbook();
		// Create a Sheet
		Sheet sheet = workbook.createSheet("Studentinfo");

		// Create a Row
		Row headerRow = sheet.createRow(0);
		for (int i = 0; i < columns.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columns[i]);
		}

		// Create Other rows and cells with contacts data
		int rowNum = 1;

		for (Student student : studentInfo) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(student.getRollNo());
			row.createCell(1).setCellValue(student.getFirstName());
			row.createCell(2).setCellValue(student.getLastName());
			row.createCell(3).setCellValue(student.getSubject());
		}

		// Write the output to a file
		try (FileOutputStream fileOut = new FileOutputStream("studentinfo.xlsx")) {
			workbook.write(fileOut);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void readExcelData() {
		try {
			File file = new File("studentinfo.xlsx");
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheetAt(0);
			Iterator<Row> itr = sheet.iterator();
			while (itr.hasNext()) {
				Row row = itr.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					switch (cell.getCellType()) {
						case STRING: // field that represents string cell type
							System.out.print(cell.getStringCellValue() + "\t\t\t");
							break;
						case NUMERIC: // field that represents number cell type
							System.out.print(cell.getNumericCellValue() + "\t\t\t");
							break;
						case FORMULA: // field that represents formula cell type
							System.out.print(cell.getCellFormula() + "\t\t\t");
							break;
						case BOOLEAN: // field that represents boolean cell type
							System.out.print(cell.getBooleanCellValue() + "\t\t\t");
							break;
						case ERROR: // field that represents error cell type
							System.out.print(cell.getErrorCellValue() + "\t\t\t");
							break;
						default:
					}
				}
				System.out.println("");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
