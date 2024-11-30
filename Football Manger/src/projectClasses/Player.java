package projectClasses;
import java.io.Serializable;

public class Player implements Serializable{
    private String Name;
    private String Country;
    private int Age;
    private double Height;
    private String Club;
    private String Position;
    private int Number;
    private double WeeklySalary;

    public Player()
    {

    }
    public Player(Player p)
    {
        Name=p.Name;
        Country=p.Country;
        Age=p.Age;
        Height=p.Height;
        Club=p.Club;
        Position=p.Position;
        Number=p.Number;
        WeeklySalary=p.WeeklySalary;
    }

    public Player(String Name, String Country, int Age, double Height, String Club, String Position , int Number, double WeeklySalary)
    {

        this.Name=Name;
        this.Country=Country;
        this.Age=Age;
        this.Height=Height;
        this.Club=Club;
        this.Position=Position;
        this.Number=Number;
        this.WeeklySalary=WeeklySalary;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public void setAge(int age) {
        Age = age;
    }

    public void setHeight(double height) {
        Height = height;
    }

    public void setClub(String club) {
        Club = club;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public void setNumber(int number) {
        Number = number;
    }

    public void setWeeklySalary(double weeklySalary) {
        WeeklySalary = weeklySalary;
    }

    public String getName() {
        return Name;
    }

    public String getCountry() {
        return Country;
    }

    public int getAge() {
        return Age;
    }

    public double getHeight() {
        return Height;
    }

    public int getNumber() {
        return Number;
    }

    public String getClub() {
        return Club;
    }

    public double getWeeklySalary() {
        return WeeklySalary;
    }

    public String getPosition() {
        return Position;
    }

    /*@Override
    public String toString() {
        return "Player{" +
                "Name='" + Name + '\'' +
                ", Country='" + Country + '\'' +
                ", Age=" + Age +
                ", Height=" + Height +
                ", Club='" + Club + '\'' +
                ", Position='" + Position + '\'' +
                ", Number=" + Number +
                ", WeeklySalary=" + WeeklySalary +
                '}';
    }*/

    public void printPlayerInfo()
    {
        System.out.println("Name : " + Name);
        System.out.println("Country : " + Country);
        System.out.println("Age in years : " +Age);
        System.out.println("Height in meters : " + Height);
        System.out.println("Club : " + Club);
        System.out.println("Position : " + Position);
        System.out.println("Weekly Salary : " + WeeklySalary);
    }

}
