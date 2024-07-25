//package CICD_Demo.CICD_Demo;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.CellType;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//public class ExcelDemo {
//
//    public static void main(String[] args) {
//        File inputFile = new File("C:\\Users\\Admin\\Downloads\\importData.xlsx");
//        File outputFile = new File("C:\\Users\\Admin\\Downloads\\importData - Copy.xlsx");
//        String sheetName = "Sheet1"; // Adjust the sheet name as necessary
//
//        try (FileInputStream fileInputStream = new FileInputStream(inputFile);
//             XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream)) {
//
//            XSSFSheet sheet = workbook.getSheet(sheetName);
//            if (sheet == null) {
//                System.out.println("Sheet not found: " + sheetName);
//                return;
//            }
//
//            // Read the first row
//            Row firstRow = sheet.getRow(0);
//            if (firstRow == null) {
//                System.out.println("First row is empty");
//                return;
//            }
//
//            // Get or create the second row
//            Row secondRow = sheet.getRow(1);
//            if (secondRow == null) {
//                secondRow = sheet.createRow(1);
//            }
//
//            // Iterate through the first row cells
//            for (Cell firstRowCell : firstRow) {
//                if (firstRowCell.getCellType() != CellType.BLANK) {
//                    int columnIndex = firstRowCell.getColumnIndex();
//
//                    // Get the value from the first row cell
//                    String cellValue = firstRowCell.getStringCellValue();
//
//                    // Write this value to the corresponding cell in the second row
//                    Cell secondRowCell = secondRow.createCell(columnIndex);
//                   // secondRowCell.setCellValue(cellValue);
//                    
//                    
//                }
//            }
//
//    }
//}
//}