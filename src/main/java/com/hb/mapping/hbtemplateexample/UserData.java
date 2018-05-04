package com.hb.mapping.hbtemplateexample;


import javax.persistence.*;

@Entity
@Table(name = "UserData")
public class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String address;

    public UserData()
    {
    }
    public UserData(Integer id, String name, String address)
    {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString()
    {
        return "User [address=" + address + ", id=" + id + ", name=" + name+ "]";
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
