package model;

public class Cart {
    private int cid;
    private int tid;
    private int userId;
    private String tourname;
    private String author;
    private double price;
    private double total;

    public Cart() {
    }

    public Cart(int cid, int tid, int userId, String tourname, String author, double price, double total) {
        this.cid = cid;
        this.tid = tid;
        this.userId = userId;
        this.tourname = tourname;
        this.author = author;
        this.price = price;
        this.total = total;
    }

    public Cart(int tid, int userId, String tourname, String author, double price, double total) {
        this.tid = tid;
        this.userId = userId;
        this.tourname = tourname;
        this.author = author;
        this.price = price;
        this.total = total;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTourname() {
        return tourname;
    }

    public void setTourname(String tourname) {
        this.tourname = tourname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    
    
}
