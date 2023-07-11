/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author bravee06
 */
public class Tour {
    private int id;
    private String name;
    private String author;
    private double price;
    private String category;
    private String status;
    private String photo;
    private String user_email;

    public Tour() {
    }

    public Tour(int id, String name, String author, double price, String category, String status, String photo, String user_email) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
        this.category = category;
        this.status = status;
        this.photo = photo;
        this.user_email = user_email;
    }

    public Tour(String name, String author, double price, String category, String status, String photo, String user_email) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.category = category;
        this.status = status;
        this.photo = photo;
        this.user_email = user_email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    @Override
    public String toString() {
        return "Tour{" + "id=" + id + ", name=" + name + ", author=" + author + ", price=" + price + ", category=" + category + ", status=" + status + ", photo=" + photo + ", user_email=" + user_email + '}';
    }

    
    
}
