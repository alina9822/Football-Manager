package projectClasses;
import java.util.ArrayList;
import java.util.List;

public class Clubs {
    String Name;
    //Player players[];
    List<Player> players;
    int playerCount;
    double averageSalary;

    public Clubs()
    {
        Name="";
        players=new ArrayList();
        playerCount=0;
    }
    public Clubs(String name)
    {
        Name=name;
        players=new ArrayList();
        playerCount=0;
    }

    public void setAverageSalary(double averageSalary) {
        this.averageSalary = averageSalary;
    }

    public double getAverageSalary() {
        return averageSalary;
    }

    public List<Player> getPlayers() {
        return players;
    }

    /*public void setPlayers(Player[] players) {
        this.players = players;
    }*/

    public int getPlayerCount() {
        return playerCount;
    }

    public void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }
    //  public
    public void addPlayers(Player player)
    {
        players.add(player);
        playerCount++;
    }

}
