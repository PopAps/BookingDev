
public class Booking {
	 String size="";
     String date,timeStart,timeEnd,room,status;
     
    
    public Booking(String size,String date,String timeS, String timeE,String room,String status) {
    	this.size = size;
    	this.date = date;
    	this.timeEnd = timeE;
    	this.timeStart = timeS;
    	this.room = room;
    	this.status = status;
    }


	public void setSize(String size) {
		this.size = size;
	}
	public String getData() {
		return date;
	}
	public void setData(String data) {
		this.date = date;
	}
	public String getTimeStart() {
		return timeStart;
	}
	public void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
	}
	public String getTimeEnd() {
		return timeEnd;
	}
	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
	}
}
