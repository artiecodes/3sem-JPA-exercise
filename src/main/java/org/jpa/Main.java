package org.jpa;

import org.entities.Unicorn;
import org.entities.UnicornDAO;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UnicornDAO uDao = new UnicornDAO();

        // CREATE and test
        Unicorn initialUnicorn = new Unicorn("Jerry", 29, 100);
        Unicorn savedUnicorn = uDao.save(initialUnicorn);
        System.out.println("Saved unicorn: " + savedUnicorn.getName());

        // READ and test
        Unicorn foundUnicorn = uDao.findById(savedUnicorn.getId());
        System.out.println("Name registered: " + foundUnicorn.getName());

        // UPDATE and test
        foundUnicorn.setName("BetterJerry");
        Unicorn updatedUnicorn = uDao.update(foundUnicorn);
        System.out.println("New name: " + updatedUnicorn.getName());

        // PRINT all unicorns
        List<Unicorn> unicornList = uDao.findAll();
        System.out.println(unicornList.toString());

        // !!DELETE!! //
        //uDao.delete(updatedUnicorn.getId());
    }
}