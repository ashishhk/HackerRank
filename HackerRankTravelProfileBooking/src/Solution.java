import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class Hotel implements Comparable<Hotel>{
    int id;
    int price;
    List<String> amenities;
    public int compareTo(Hotel otherHotel) {
	
	if (this.amenities.size() < otherHotel.amenities.size()) {
	    return 1;
	} 
	else if (this.amenities.size() == otherHotel.amenities.size()) {
	    if (this.price > otherHotel.price) {
		return 1;
	    } 
	    else if (this.price == otherHotel.price) {
		if (this.id > otherHotel.id) {
		    return 1;
		}
		else if(this.id == otherHotel.id){
		    return 0;
		}
	    }
	}
	return -1;
    }
}

class Person {
    int price;
    List<String> amenities;
}

public class Solution {

    public static void main(String[] args) {
	StringBuilder str;
	String input = "4\n1 70 wifi pool restaurant bathtub kitchenette\n2 80 pool spa restaurant air-conditioning bathtub wifi\n3 60 restaurant air-conditioning wifi\n4 50 kitchenette\n4\n65 wifi\n50 wifi\n100 pool restaurant\n80 kitchenette";
	Scanner scanner = new Scanner(input);
	int hotelCounts = scanner.nextInt();
	//Hotel[] hotels = new Hotel[hotelCounts];
	List<Hotel> hotels= new ArrayList<Hotel>();
	for (int i = 0; i < hotelCounts; i++) {
	    Hotel hotel = new Hotel();
	    hotel.id = scanner.nextInt();
	    hotel.price = scanner.nextInt();
	    String nextLine = scanner.nextLine();
	    hotel.amenities = Arrays.asList(nextLine.trim().split(" "));
	    hotels.add(hotel);
	}
	Collections.sort(hotels);
	int personCounts = scanner.nextInt();
	Person[] persons = new Person[personCounts];
	for (int i = 0; i < personCounts; i++) {
	    persons[i] = new Person();
	    persons[i].price = scanner.nextInt();
	    String nextLine = scanner.nextLine();
	    persons[i].amenities = Arrays.asList(nextLine.trim().split(" "));
	    StringBuilder qualifiedHotels = new StringBuilder();
	    for (Hotel hotel : getHotelsForPrice(hotels, persons[i].price)) {
		if (hasRequiredAmenities(persons[i].amenities, hotel.amenities)) {
		    qualifiedHotels.append(hotel.id);
		    qualifiedHotels.append(" ");
		}
	    }
	    System.out.print(qualifiedHotels);
	    if (i + 1 < personCounts) {
		System.out.print("\n");
	    }
	}
    }

    private static List<Hotel> getHotelsForPrice(List<Hotel> hotels, int requiredPrice) {
	List<Hotel> budgetHotels= new ArrayList<Hotel>(hotels);
	Iterator<Hotel> iter=budgetHotels.iterator();
	while(iter.hasNext())
	    {
	    Hotel hotel=iter.next();
	    if (hotel.price > requiredPrice) {
		iter.remove();
	    }
	}
	return budgetHotels;
    }

    private static boolean hasRequiredAmenities(List<String> amenities,List<String> amenities2) {
	for (String amenity : amenities) {
	    if (!amenities2.contains(amenity)) {
		return false;
	    }
	}
	return true;
    }
}