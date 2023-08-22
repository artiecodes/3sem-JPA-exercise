package org.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.BatchSize;


@Table(name = "unicorn")
@Entity
public class Unicorn {
    //JPA needs empty constructor
    public Unicorn() {}
    public Unicorn(String name, int age, int powerStrength) {
        this.name = name;
        this.age = age;
        this. powerStrength = powerStrength;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "powerStrength")
    private int powerStrength;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPowerStrength() {
        return powerStrength;
    }

    public void setPowerStrength(int powerStrength) {
        this.powerStrength = powerStrength;
    }

    @Override
    public String toString() {
        return "Unicorn with ID:"+id+" and name:"+name+", age:"+age+" and POWERLEVEL"+powerStrength;
    }
}
