
public class User {
    String user = "";
    String password = "";
    public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	String status = "";
    User(String user,String password,String status){
    	this.user = user;
    	this.password = password;
    	this.status = status;
    }
}
