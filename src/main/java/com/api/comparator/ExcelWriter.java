package com.api.comparator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javafx.scene.control.Cell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Hello world!
 *
 */
public class ExcelWriter {
	public static void writeData(String outputFile, Map<String, List<String>> data) {
		try {

			// writer

			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet1 = workbook.createSheet("Rosetta Comparision");

			Set<String> keyset = data.keySet();
			Row row = sheet1.createRow(0);
			int cellnum = 0;
			org.apache.poi.ss.usermodel.Cell cell = row.createCell(cellnum++);
			cell.setCellValue("Input String");
			cell = row.createCell(cellnum++);
			cell.setCellValue("New Rosetta Processed String");
			cell = row.createCell(cellnum++);
			cell.setCellValue("New Rosetta Latency");
			cell = row.createCell(cellnum++);
			cell.setCellValue("Old Rosetta Processed String");
			cell = row.createCell(cellnum++);
			cell.setCellValue("Old Rosetta Latency");
			int rownum = 1;
			for (String key : keyset) {
				row = sheet1.createRow(rownum++);
				List<String> objArr = data.get(key);
			    cellnum = 0;
				cell = row.createCell(cellnum++);
				cell.setCellValue(key);
				for (String obj : objArr) {
					cell = row.createCell(cellnum++);
					cell.setCellValue(obj);
				}
			}

			FileOutputStream out = new FileOutputStream(new File(outputFile));
			workbook.write(out);
			out.close();
			System.out.println("Excel written successfully..");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}