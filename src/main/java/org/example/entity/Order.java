package org.example.entity;

import java.time.LocalDateTime;

public class Order {
    String id;
    LocalDateTime orderTime;
    String destinationAddress;
    Users user;
    boolean completed;

    public Order(String id, LocalDateTime orderTime, String destinationAddress, Users user, boolean completed) {
        this.id = id;
        this.orderTime = orderTime;
        this.destinationAddress = destinationAddress;
        this.user = user;
        this.completed = completed;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
