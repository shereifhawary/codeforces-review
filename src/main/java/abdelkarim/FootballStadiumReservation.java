package football;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;

import java.util.Vector;

public class FootballStadiumReservation {
    
    void PrintFile(String path, Vector<String> Text){
        try{
            FileWriter fileWriter = new FileWriter(path);
            BufferedWriter bufferedWriter =  new BufferedWriter(fileWriter);
            for(int i=0;i<Text.size();i++)
                bufferedWriter.write(Text.get(i)+"\n");
            bufferedWriter.close();
        }catch(Exception exp){}
    }
    
    Vector<String> ReadFile(String path){
        Vector<String> ret = new Vector<String>();
        FileInputStream in = null;
        String line;
        try {
            FileReader fileReader =  new FileReader(path);
            BufferedReader bufferedReader =  new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null) {
               ret.add(line);
            } 
            bufferedReader.close();
        }catch(Exception exp){}
        return ret;
    }
    
    boolean isValidClientName(String  clientName){
        return clientName.length() > 0;
    }
    boolean allAreDigits(String Number){
//        System.out.println(":"+Number+":");
        for(int i=0;i<Number.length();i++){
            if('0' > Number.charAt(i) || Number.charAt(i) > '9')
                return false;
        }
        return true;
    }
    boolean allAreNumbers(String arr[]){
        for(int i=0;i<arr.length;i++)
            if(!allAreDigits(arr[i]))return false;
        return true;
    }
    boolean isValidClientNumber(String clientNumber){
        return clientNumber.length() > 0 && allAreDigits(clientNumber);
    }
    boolean isValidDate(String date){
        String dateElements [] =   date.split("/");
        if(dateElements.length != 3)return false;
        if(!allAreNumbers(dateElements))return false;
        System.out.println("test");
        int year = Integer.parseInt(dateElements[0]);
        if(year < 2016)return false;
        int month = Integer.parseInt(dateElements[1]);
        if(month < 1 || month > 12)return false;
        int day = Integer.parseInt(dateElements[2]);
        if(day <1 || day > 31)return false;
        return true;
    }
    boolean isValidTime(String time){
        String timeElements [] = time.split(":");
        if(timeElements.length != 2)return false;
        if(!allAreNumbers(timeElements))return false;
        int hour = Integer.parseInt(timeElements[0]);
        if(hour < 1 || hour > 23)return false;
        int minute = Integer.parseInt(timeElements[1]);
        if(minute < 0 || minute > 59)return false;
        return true;
    }
    boolean isFileExist(String path){
        File f = new File(path);
        if(f.isFile()){
            return true;
        }
//        if(f.exists() && !f.isDirectory()) { 
//            return true;
//        }
        return false;
    }
    
    void markInterval(boolean aDay[], int start,int end){
        for(int i=start;i<=end;i++){
            aDay[i] = true;
        }
    }
    boolean checkInterval(boolean aDay[], int start, int end){
        for(int i=start;i<=end;i++){
            if(aDay[i])return false;
        }
        return true;
    }
    boolean isGoodDateToReserve(Vector<Integer> OldstartTime, Vector<Integer> OldendTime, int newStartTime, int newEndTime ){
        boolean aDay[] = new boolean [60*24+123];
        for(int i=0;i<OldstartTime.size();i++){
            markInterval(aDay, OldstartTime.get(i), OldendTime.get(i));
//            System.out.print(aDay[i]);
        }
//        System.out.println();
        return checkInterval(aDay, newStartTime, newEndTime);
    }
    
    int toMinutes(String time){
        String arr[] = time.split(":");
        int h = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);
        return h*60+m;
    }
    
    int extractStartTime(String date){
        String arr [] = date.split("#");
        return  toMinutes(arr[0]);
    }
    int extractEndTime(String date){
        String arr [] = date.split("#");
        return  toMinutes(arr[1]);
    }    
    boolean isGoodDateToReserve(Vector<String> dates, String newDate){
        Vector<Integer> OldstartTime = new Vector<Integer>();
        Vector<Integer> OldendTime = new Vector<Integer>();
        int newStartTime = extractStartTime(newDate);
        int newEndTime   = extractEndTime(newDate);
        for(int i=0;i<dates.size();i++){
            OldstartTime.add(extractStartTime(dates.get(i)));
            OldendTime.add(extractEndTime(dates.get(i)));
        }
        return isGoodDateToReserve(OldstartTime, OldendTime, newStartTime, newEndTime);
    }
    
}
