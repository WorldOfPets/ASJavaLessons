package com.drinkertea.lesson1;

public class Policeman extends People{
    private String position;

    public Policeman(String name, int age, String position) {
        super(name, age);
        this.setPosition(position);
    }

    @Override
    public void sayHello() {
        System.out.println("My position is " + this.getPosition());
        super.sayHello();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        switch (position){
            case "Major":
                this.position = "Major";
                break;
            case "Admiral":
                this.position = "Admiral";
                break;
            default:
                this.position = "Efreytor";
                break;
        }
    }
}
