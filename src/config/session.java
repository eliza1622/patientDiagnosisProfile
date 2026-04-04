package config;

public class session {
    
    private static session instance;
        
    private int uid;
    private int age;
    private String fname;
    private String lname;
    private String username;
    private String email;
    private String type;
    // --- ADDED THIS VARIABLE ---
    private String pic; 
        
    private session(){ 
    }    

    public static synchronized session getInstance() {
        if (instance == null){
            instance = new session();
        }
        return instance;   
    }

    public static boolean isInstanceEmpty () {
      return instance == null;   
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
    
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
      
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // --- ADDED THESE GETTER AND SETTER FOR THE IMAGE ---
    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}