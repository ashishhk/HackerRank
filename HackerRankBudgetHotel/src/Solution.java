import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.Scanner;
    
    class City{
        List<Hotel> hotel;
        int cheapestPrice;
        float cheapestPriceHotelScore;
        City(){
            cheapestPrice=10000;
        }
    }
    
    class Hotel implements Comparable<Hotel>{
        int price;
        float score;
	public int compareTo(Hotel otherHotel) {
	    if(this.score<otherHotel.score)
	    {
		return 1;
	    }
	    else if(this.score==otherHotel.score){
		if(this.price>otherHotel.price){
		    return 1;
		}
		else{
		    return 0;
		}
	    }
	    return -1;
	}
        
    }
    
    public class Solution {
    
        public static void main(String[] args) {
            String abc="2 50\n3\n10 7.8\n15 6.4\n12 8.111\n3\n25 7.8\n19 6.4\n50 8.1";
            Scanner scanner=new Scanner(abc);
            String[] cityBudget=scanner.nextLine().trim().split(" ");
            int cityCount=Integer.parseInt(cityBudget[0]);
            int budget=Integer.parseInt(cityBudget[1]);
            
            List<City> cities=new ArrayList<City>();
            double cheapestBudget=0;
            double cheapestBudgetScore=0;
            double luxuryBudgetScore=0;
            double luxuryBudget=0;
            for(int j=0;j<cityCount;j++)
            {
                City city=new City();
                city.hotel=new ArrayList<Hotel>();
                int hotelCount=Integer.parseInt(scanner.nextLine().trim());
                for(int i=0;i<hotelCount;i++)
                {
                    Hotel hotel=new Hotel();
                    String[] priceScore=scanner.nextLine().trim().split(" ");
                    hotel.price=Integer.parseInt(priceScore[0]);
                    if(hotel.price<city.cheapestPrice){
                	city.cheapestPrice=hotel.price;
                	city.cheapestPriceHotelScore=hotel.score;
                    }
                    hotel.score=Float.parseFloat(priceScore[1]);
                    
                    city.hotel.add(hotel);
                }
                Collections.sort(city.hotel);
                luxuryBudgetScore+=city.hotel.get(0).score;
                luxuryBudget+=city.hotel.get(0).price;
                cheapestBudget+=city.cheapestPrice;
                cheapestBudgetScore+=city.cheapestPriceHotelScore;
                if(cheapestBudget>budget){
                    System.out.println("-1");
                    return;
                }
                cities.add(city);
            }
            optimize(budget, cities, cheapestBudget, cheapestBudgetScore,luxuryBudgetScore, luxuryBudget);            
        }

	private static void optimize(int budget, List<City> cities,
		double cheapestBudget, double cheapestBudgetScore,
		double luxuryBudgetScore, double luxuryBudget) {
	    if(cheapestBudget==budget){
                System.out.println(cheapestBudgetScore);
                return;
            }
            else if(luxuryBudget==budget){
        	System.out.println(luxuryBudgetScore);
                return;
            }
            /**rest cases goes below*/
            double overheadBudget=luxuryBudget-budget;
            double extraBudget=budget-cheapestBudget;
            if(extraBudget>overheadBudget){
        	//consider luxury budget and reduce budget per city by compromising best score hotel
            }
            else
            {
        	//consider cheapest budget and distribute budget per city for better score hotels
        	for(City city:cities){
        	    	
        	}
            }
	}
    }