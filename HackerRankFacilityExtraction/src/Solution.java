import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class Solution {

    public static void main(String[] args) {
	String abc="5\nwifi\nswimming pool\ngarden\nbeach\ntennis court\nOur hotel is a very luxurious one, we are committed to provide the best holiday, you can always relax on our private beach, we provide four amazing tennis courts. WIFI is available in all areas.";
        Scanner scanner= new Scanner(abc);
        int facilityCount=Integer.parseInt(scanner.nextLine().trim());
        List<String> facilityList=new ArrayList<String>();
        for(int i=0;i<facilityCount;i++){
            String nextLine = scanner.nextLine();
            facilityList.add(nextLine.trim());
        }
        StringBuilder description = new StringBuilder();
        while(scanner.hasNextLine()){
            description.append(scanner.nextLine().trim());
        }
        Iterator<String> itr = facilityList.iterator();
        while(itr.hasNext()){
            String facility=itr.next();
            if(!description.toString().matches("(?i:.*"+facility+".*)"))
            {
        	itr.remove();
            }
        }    
        Collections.sort(facilityList);
        for(String facility:facilityList){
            System.out.println(facility);    
        }
        
        
    }
}