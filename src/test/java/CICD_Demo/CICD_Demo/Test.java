package CICD_Demo.CICD_Demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test {

    public static void main(String[] args) {
        File inputFile = new File("C:/Users/Admin/Downloads/importData.csv");
        File externalFile = new File("C:\\Users\\Admin\\Downloads\\externalData.csv");
        File outputFile = new File("C:\\Users\\Admin\\Downloads\\importData - Copy.csv");
        
        String sheetName = "Sheet1"; // Adjust the sheet name as necessary

        try (FileInputStream inputFileStream = new FileInputStream(inputFile);
             XSSFWorkbook workbook = new XSSFWorkbook(inputFileStream)) {

            XSSFSheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                System.out.println("Sheet not found: " + sheetName);
                return;
            }

            // Read data from the external file
            try (FileInputStream externalFileStream = new FileInputStream(externalFile);
                 XSSFWorkbook externalWorkbook = new XSSFWorkbook(externalFileStream)) {

                XSSFSheet externalSheet = externalWorkbook.getSheetAt(0);
                if (externalSheet == null) {
                    System.out.println("External sheet not found.");
                    return;
                }

                // Read data from the first row of the external sheet
                Row externalRow = externalSheet.getRow(0);
                if (externalRow == null) {
                    System.out.println("First row in external file is empty.");
                    return;
                }

                // Get or create the second row in the target sheet
                Row targetRow = sheet.getRow(1);
                if (targetRow == null) {
                    targetRow = sheet.createRow(1);
                }

                // Iterate through the cells of the first row in the external sheet
                for (Cell externalCell : externalRow) {
                    int columnIndex = externalCell.getColumnIndex();

                    // Get the value from the external file cell
                    String cellValue = "";
                    if (externalCell.getCellType() == CellType.STRING) {
                        cellValue = externalCell.getStringCellValue();
                    } else if (externalCell.getCellType() == CellType.NUMERIC) {
                        cellValue = String.valueOf(externalCell.getNumericCellValue());
                    } else if (externalCell.getCellType() == CellType.BOOLEAN) {
                        cellValue = String.valueOf(externalCell.getBooleanCellValue());
                    } else if (externalCell.getCellType() == CellType.FORMULA) {
                        cellValue = externalCell.getCellFormula();
                    }

                    // Write this value to the corresponding cell in the second row
                    Cell targetCell = targetRow.createCell(columnIndex);
                    targetCell.setCellValue(cellValue);
                }
            }

            // Save the modified workbook to the output file
            try (FileOutputStream fileOutputStream = new FileOutputStream(outputFile)) {
                workbook.write(fileOutputStream);
            }

            System.out.println("Data copied successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
