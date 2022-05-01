package sg.edu.np.practical_2;

public class User {
    public String Name;
    public String Description;
    public int Id;
    public boolean Followed;

    public User(String n, String desc, int id, boolean f){
        Name = n;
        Description = desc;
        Id = id;
        Followed = f;
    }
}
