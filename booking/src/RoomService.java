import java.text.DateFormat;

import java.util.ArrayList;
import java.util.Date;

import com.toedter.calendar.JDateChooser;

public class RoomService {
    public static ArrayList<Room> arr ;
    public static ArrayList<Room> arr2 ;
   public RoomService() {
	   arr = new ArrayList<>();
   }
	public static ArrayList<Room> getRoom(String size, Date date, String timeStart, String timeEnd,String room, String status){
		    
		    System.out.println("Service Process");
		    
		    RoomDao roomDao = new RoomDao();
            String dates = DateFormat.getDateInstance().format(date);
            
            
			arr.add(new Room(size,dates,timeStart,timeEnd,room,status));
			if(arr.isEmpty()) {
				return arr;
			}else {
				
			}
		    ArrayList<Room> result = roomDao.getRoomAll(arr);

		return result;
	}

	public static void insertBooking() {

		
	}
//	public static void updateBooking(ArrayList<Booking> arr2) {
//		
//		//arr2.add(new Room())
//	}

}