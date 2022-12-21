package CommonMethod;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadDataExcel {

    // You can change the information of your data file here
    public static final String FILE_PATH = "data/testData.xls"; // File Path
    public static final String SHEET_NAME = "Data"; // Sheet name
    public static final String TABLE_NAME = "testData"; // Name of data table
    public static String[][] readData(String filePath, String sheetName) throws IOException {
        FileInputStream file = new FileInputStream(filePath);
        HSSFWorkbook workbook = new HSSFWorkbook(file);
        HSSFSheet sheet = workbook.getSheet(sheetName);
        int row = sheet.getLastRowNum();
        int cell = sheet.getRow(1).getLastCellNum();
        String[][] data = new String[row-1][cell-1];
        System.out.println(row);
        for(int i=1; i<sheet.getLastRowNum();i++){
            List<String> temp = new ArrayList<>();
            for(int j=1;j<sheet.getRow(i).getLastCellNum();j++){
                data[i-1][j-1] = sheet.getRow(i).getCell(j).getStringCellValue();
            }

        }
        return data;
    }


    public static void main(String[] args) throws IOException {
        String[][] data = readData(FILE_PATH,SHEET_NAME);
        for(int i=0; i< data.length;i++){
            for (int j=0;j<data[0].length;j++){
                System.out.print(data[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
