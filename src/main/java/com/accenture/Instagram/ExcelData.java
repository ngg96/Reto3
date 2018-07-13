package com.accenture.Instagram;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {
	
	
	public ExcelData() {
		
	}
	
	public ArrayList<Informacion> getData(String dataPath) throws IOException {
		
		ArrayList<Informacion> AllData = new ArrayList<>();
		
		FileInputStream file = new FileInputStream(new File(dataPath));
		XSSFWorkbook workbook = new XSSFWorkbook(file); //Se define ruta, file y pagina de la que se desea extraer la informacion
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		Iterator<Row> rowIterator = sheet.iterator(); //Se define la iteracion de las filas
		Row row;
		
		while (rowIterator.hasNext()){
			
			row = (Row) rowIterator.next();
			Informacion Data = new Informacion();
			Iterator<Cell> cellIterator = row.cellIterator(); //Se define la iteracion de las celdas
			Cell celda;
			
			int i = 0;
			
			while (cellIterator.hasNext()){
				
				celda = (Cell) cellIterator.next(); //Desplazamiento por celdas
				
				if(i ==0) {
					Data.setValue1( celda.getNumericCellValue()); //Se almacena la informacion de salida
				}
				if(i == 1) {
						
					Data.setOperation( celda.getStringCellValue());
				}
				if(i ==2) {
					Data.setValue2( celda.getNumericCellValue()); //Se almacena la informacion de salida
					//System.out.println(celda.getNumericCellValue());
				}
				
				i++;
			}
			
			AllData.add(Data);
				
		}
		//System.out.println("AllData Size en funcion excel= "+AllData.size());
		return AllData;
			
	}
}
