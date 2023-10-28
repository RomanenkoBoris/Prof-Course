package lesson44.dao;

public class Customer {
    private int cnum;
    private String city;
    private String cname;
    private int rating;
    private int snum;

    public Customer() {
    }

    public Customer(int cnum, String city, String cname, int rating, int snum) {
        this.cnum = cnum;
        this.city = city;
        this.cname = cname;
        this.rating = rating;
        this.snum = snum;
    }

    public int getCnum() {
        return cnum;
    }

    public void setCnum(int cnum) {
        this.cnum = cnum;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getSnum() {
        return snum;
    }

    public void setSnum(int snum) {
        this.snum = snum;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cnum=" + cnum +
                ", city='" + city + '\'' +
                ", cname='" + cname + '\'' +
                ", rating=" + rating +
                ", snum=" + snum +
                '}';
    }
}
