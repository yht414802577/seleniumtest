package modle;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import logo.SelLogger;

import java.io.File;
import java.io.IOException;

public class FileExlce {
    private static final SelLogger logger = SelLogger.getLogger(FileExlce.class);
    public String userNaem(){
        try {
            String fileName = "./test.xls";
            File file = new File(fileName);
            Workbook wb = Workbook.getWorkbook(file);
            Sheet sheet = wb.getSheet(0);
            Cell cell = sheet.getCell(0,0);
            String username = cell.getContents();
            return username;
        }catch (BiffException a){
            a.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
    public String password(){
        try{
            String fileName = "./test.xls";
            File file = new File(fileName);
            Workbook wb = Workbook.getWorkbook(file);
            Sheet sheet = wb.getSheet(0);
            Cell cell = sheet.getCell(1 , 0);
            String password = cell.getContents();
            return password;
        }catch (BiffException a){
            a.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
