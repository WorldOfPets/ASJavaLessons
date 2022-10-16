package com.drinkertea.lesson1;

public class People {
    private String name;
    private int age;

    public People(String name, int age){
        this.setName(name);
        this.setAge(age);
    }

    public void sayHello(){
        System.out.println("Hello, my name is " + this.getName() + "\n" + "My age is " + this.getAge());
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age - 2;
    }

    public void setAge(int age) {
        if (age > 0 && age < 150){
            this.age = age;
        } else{
            System.out.println("Неправильный возраст");
        }
    }
}
