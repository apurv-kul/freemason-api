package com.hsbc.solution.service;

import com.hsbc.solution.model.Data;
import com.hsbc.solution.model.ResponseData;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Map;

@Service
public class ParkingService {


    public ResponseData getSlots(Data data){

        /*File file = new File("C:\\Users\\Apurv\\IdeaProjects\\hpark\\src\\main\\resources\\Simulation_data.xlsx");
        try{
            FileInputStream stream = new FileInputStream(file);
            Workbook workbook = new XSSFWorkbook(stream);
            Sheet sheet = workbook.getSheet(data.getCarType());
            int firstRow = sheet.getFirstRowNum();
            int lastRow = sheet.getLastRowNum();
            for (int index = firstRow + 1; index <= lastRow; index++) {
                Row row = sheet.getRow(index);

                Cell cellDate = row.getCell(1);
                Date date = cellDate.getDateCellValue();

                Cell cellSlots = row.getCell(2);
                long slots = (long) cellSlots.getNumericCellValue();


            }


        } catch (IOException e){
            e.printStackTrace();
        }*/

        ResponseData rdata = new ResponseData();

        if(data.getCarType().equals("suv")){
            rdata.setAvailableSlots(getValueForApproximateDate(LoadSlotData.sMap,data.getDateTime()));
            rdata.setTotalSlots(300);
        }else {
            rdata.setAvailableSlots(getValueForApproximateDate(LoadSlotData.hMap,data.getDateTime()));
            rdata.setTotalSlots(719);
        }


        return rdata;
    }



    // Custom method to get a value for an approximate date
    private static Long getValueForApproximateDate(Map<String, Long> map, String approximateDate) {
        // Iterate through the keys and find the closest date
        String closestDate = null;
        long minDifference = Long.MAX_VALUE;

        for (String date : map.keySet()) {
            long difference = Math.abs(getDateDifference(date, approximateDate));
            if (difference < minDifference) {
                minDifference = difference;
                closestDate = date;
            }
        }

        return map.get(closestDate);
    }

    // Custom method to calculate the difference between two dates (in milliseconds)
    private static long getDateDifference(String date1, String date2) {
        // You can use more sophisticated date parsing and comparison here
        // For simplicity, let's assume the dates are in the format "yyyy-MM-dd"
        // and convert them to milliseconds since epoch



        long millis1 = parseToLocalDateTime(date1).getTime();
        long millis2 = parseToLocalDateTime(date2).getTime();
        return Math.abs(millis1 - millis2);
    }


    private static Date parseToLocalDateTime(String dateString) {
        try {

            SimpleDateFormat simpleDateFormat =  new SimpleDateFormat("dd-mm-YYYY HH:mm:ss");

            return simpleDateFormat.parse(dateString);

            // Define the expected date format
            //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-mm-YYYY HH:mm:ss");
            // Parse the input string
            //return LocalDateTime.parse(dateString, formatter);
        } catch (DateTimeParseException | ParseException e ) {
            // Handle invalid date format
            return null;
        }
    }

}
