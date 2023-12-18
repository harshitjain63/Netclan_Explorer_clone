package com.example.myapplication;

import java.util.ArrayList;

public class Constants {
    // ArrayList and return the ArrayList
    public static ArrayList<Employee> getEmployeeData()
    {
        // create an ArrayList of type Employee class
        ArrayList<Employee> employeeList
                = new ArrayList<Employee>();
        Employee emp1 = new Employee("Chinmaya Mohapatra",
                "Lakhimpur | Student","+ INVITE","Within 27.2 km","Coffee | Business | friendship","Hii Community! I am open to new Connections",R.drawable.img_1);
        employeeList.add(emp1);
        Employee emp2
                = new Employee("Ram prakash", "Lakhimpur | Student","+ INVITE","Within 27.2 km","Coffee | Business | friendship","Hii Community! I am open to new Connections",R.drawable.img_12);
        employeeList.add(emp2);
        Employee emp3 = new Employee("OMM Meheta",
                "Lakhimpur | Student","+ INVITE","Within 27.2 km","Coffee | Business | friendship","Hii Community! I am open to new Connections",R.drawable.img_2);
        employeeList.add(emp3);
        Employee emp4 = new Employee("Hari Mohapatra",
                "Lakhimpur | Student","+ INVITE","Within 27.2 km","Coffee | Business | friendship","Hii Community! I am open to new Connections",R.drawable.baseline_add_24);
        employeeList.add(emp4);
        Employee emp5 = new Employee(
                "Abhisek Mishra", "Lakhimpur | Student","+ INVITE","Within 27.2 km","Coffee | Business | friendship","Hii Community! I am open to new Connections",R.drawable.baseline_punch_clock_24);
        employeeList.add(emp5);
        Employee emp6 = new Employee("Sindhu Malhotra",
                "Lakhimpur | Student","+ INVITE","Within 27.2 km","Coffee | Business | friendship","Hii Community! I am open to new Connections",R.drawable.baseline_search_24);
        employeeList.add(emp6);
        Employee emp7 = new Employee("Anil sidhu",
                "Lakhimpur | Student","+ INVITE","Within 27.2 km","Coffee | Business | friendship","Hii Community! I am open to new Connections",R.drawable.baseline_person_24);
        employeeList.add(emp7);
        Employee emp8 = new Employee("Sachin sinha",
                "Lakhimpur | Student","+ INVITE","Within 27.2 km","Coffee | Business | friendship","Hii Community! I am open to new Connections",R.drawable.img_1);
        employeeList.add(emp8);
        Employee emp9 = new Employee("Amit sahoo",
                "sLakhimpur | Student","+ INVITE","Within 27.2 km","Coffee | Business | friendship","Hii Community! I am open to new Connections",R.drawable.baseline_person_24);
        employeeList.add(emp9);
        Employee emp10 = new Employee("Raj kumar",
                "Lakhimpur | Student","+ INVITE","Within 27.2 km","Coffee | Business | friendship","Hii Community! I am open to new Connections",R.drawable.baseline_heart_broken_24);
        employeeList.add(emp10);

        return employeeList;
    }
}
