package com.bookstore.pojo;

public class Manager {
    private Integer id;
    private String name;
    private String password;

    public Manager(Integer id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
    public Manager() {}
    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
