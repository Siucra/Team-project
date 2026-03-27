package application;

public class UsersInfo {
	private String email;
    private String password;
    

    public UsersInfo(String email, String password) {
        this.email = email;
        this.password = password;
    }
    
    public String getEmail() {
    	return email; 
   }
    public String getPassword() { 
    	return password; 
    	}
}


