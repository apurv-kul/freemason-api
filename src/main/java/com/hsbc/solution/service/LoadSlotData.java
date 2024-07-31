package com.hsbc.solution.service;

import com.hsbc.solution.model.MapData;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class LoadSlotData {

    public static Map<String, MapData> hMap = new HashMap();

    public static Map<String, MapData> sMap = new HashMap();


    @EventListener
    public static void loadData(ContextRefreshedEvent event) {
        SimpleDateFormat simpleDateFormat =  new SimpleDateFormat("dd-mm-YYYY HH:mm:ss");

        ClassPathResource resource = new ClassPathResource("Simulation_data.xlsx");


        //File file = new File("./Simulation_data.xlsx");
        try{
            //FileInputStream stream = new FileInputStream(file);
            InputStream stream =  resource.getInputStream();
            Workbook workbook = new XSSFWorkbook(stream);
            Sheet sheet = workbook.getSheet("HatchBack");
            int firstRow = sheet.getFirstRowNum();
            int lastRow = sheet.getLastRowNum();
            for (int index = firstRow + 1; index <= lastRow; index++) {
                Row row = sheet.getRow(index);

                Cell cellDate = row.getCell(0);
                String date = simpleDateFormat.format(cellDate.getDateCellValue());
                Cell cellSlots = row.getCell(1);
                long slots = (long) cellSlots.getNumericCellValue();
                //System.out.println("Slot data is " + slots);

                Cell cellTarget = row.getCell(2);
                double target = (double) cellTarget.getNumericCellValue();
                hMap.put(date,new MapData(date,target+"",slots,719));


            }



            Sheet suvsheet = workbook.getSheet("suv");
            firstRow = suvsheet.getFirstRowNum();
            lastRow = suvsheet.getLastRowNum();
            for (int sindex = firstRow + 1; sindex <= lastRow; sindex++) {
                Row srow = suvsheet.getRow(sindex);

                Cell scellDate = srow.getCell(0);
                String sdate = simpleDateFormat.format(scellDate.getDateCellValue());

                Cell scellSlots = srow.getCell(1);
                long sslots = (long) scellSlots.getNumericCellValue();

                Cell scellTarget = srow.getCell(2);
                double starget = (double) scellTarget.getNumericCellValue();
                sMap.put(sdate, new MapData(sdate,starget+"",sslots,300));


            }


        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
