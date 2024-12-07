package utilities;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {
    XSSFWorkbook workbook;
    XSSFSheet sheet;

    public ExcelUtils(String excelPath) {
        try {
            FileInputStream file = new FileInputStream(excelPath);
            workbook = new XSSFWorkbook(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getCellData(String sheetName, int row, int col) {
        sheet = workbook.getSheet(sheetName);
        return sheet.getRow(row).getCell(col).toString();
    }
}
