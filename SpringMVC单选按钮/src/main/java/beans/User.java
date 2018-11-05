package beans;

public class User {
    private String username;
    private String password;
    private String address;
    private String gender;

    private Boolean recivepaper;
    private String[] favorites;
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public String[] getFavorites() {
        return favorites;
    }

    public void setFavorites(String[] favorites) {
        this.favorites = favorites;
    }

    public Boolean getRecivepaper() {
        return recivepaper;
    }

    public void setRecivepaper(Boolean recivepaper) {
        this.recivepaper = recivepaper;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
