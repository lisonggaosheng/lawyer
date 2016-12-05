package com.lawyer.tools;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class ExcelTools extends HibernateDaoSupport{
	static Log log = LogFactory.getLog(ExcelTools.class);
	// 获取Excel文档的路径
	public static String filePath = "E://公告161130.xls";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			// 创建对Excel工作簿文件的引用
			InputStream is = new FileInputStream(filePath);
			HSSFWorkbook workbook = new HSSFWorkbook(is);
			//在Excel文档中，第一张工作表的缺省索引是0
			HSSFSheet sheet = workbook.getSheetAt(0);
			// 获取到Excel文件中的所有行数
			int rows = sheet.getPhysicalNumberOfRows();
			// 遍历行
			for (int i = 1; i < rows; i++) {
				// 读取左上端单元格
				HSSFRow row = sheet.getRow(i);
				// 行不为空
				if (row != null) {
					// 获取到Excel文件中的所有的列
					int cells = row.getPhysicalNumberOfCells();
					String value = "";
					// 遍历列
					for (int j = 0; j < cells; j++) {
						// 获取到列的值
						HSSFCell cell = row.getCell(j);
						System.out.print(getValue(cell)+"===");
					}
					System.out.println();
				}
			}
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
     * 得到Excel表中的值
     * @param hssfCell
     *            Excel中的每一个格子
     * @return Excel中每一个格子中的值
     */

    @SuppressWarnings("static-access")

    public static String getValue(HSSFCell hssfCell) {
    	if(hssfCell == null){
    		return null;
    	}
        if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
            // 返回布尔类型的值
            return String.valueOf(hssfCell.getBooleanCellValue());
        } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
            // 返回数值类型的值
            return String.valueOf(hssfCell.getNumericCellValue());
        }else {
            // 返回字符串类型的值
            return String.valueOf(hssfCell.getStringCellValue());
        }
    }
    
    /***读取Excel*/  
    
    public static void readExcel(String filePath)   
  
    {   
  
        try  
  
        {   
  
            InputStream is = new FileInputStream(filePath);   
  
            Workbook rwb = Workbook.getWorkbook(is);   
  
            //这里有两种方法获取sheet表:名字和下标（从0开始）   
  
            //Sheet st = rwb.getSheet("original");   
  
            Sheet st = rwb.getSheet(0);   
            //Sheet的下标是从0开始   
  
            //获取第一张Sheet表   
  
            Sheet rst = rwb.getSheet(0);   
  
            //获取Sheet表中所包含的总列数   
  
            int rsColumns = rst.getColumns();   
  
            //获取Sheet表中所包含的总行数   
  
            int rsRows = rst.getRows();   
  
            //获取指定单元格的对象引用   
  
            for (int i = 0; i < rsRows; i++)   
  
            {   
  
                for (int j = 0; j < rsColumns; j++)   
  
                {   
  
                    Cell cell = rst.getCell(j, i);   
  
                    System.out.print(cell.getContents() + " ");   
  
                }   
  
                System.out.println();   
  
            }             
  
            //关闭   
  
            rwb.close();   
  
        }   
  
        catch(Exception e)   
  
        {   
  
            e.printStackTrace();   
  
        }   
  
    }  

}
