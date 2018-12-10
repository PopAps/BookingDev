import java.util.ArrayList;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          ArrayList<Room> arr = new ArrayList<>();
          for(int i =0 ;i< 10;i++) {
        	  arr.add(new Room("50",i+" Nov "+(2009+i),""+(i+7)+":"+"00",""+(i+7)+":"+"00","ROOM"+i,"false"));
          }
          for(Room x : arr) {
        	  System.out.println(x.size + " " + x.date + " " + x.timeStart + " " + x.timeEnd);
          }
	}

}
