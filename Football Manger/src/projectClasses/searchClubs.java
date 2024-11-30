package projectClasses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class searchClubs {
    public static List<Player> maxSalaryInClub(List<Player> playerList)
    {
        List<Player> players = new ArrayList();

                double max = playerList.get(0).getWeeklySalary();

                for (int i = 1; i < playerList.size(); i++) {
                    if (max < playerList.get(i).getWeeklySalary()) {
                        max = playerList.get(i).getWeeklySalary();
                    }
                }
                for (int i = 0; i < playerList.size(); i++) {
                    if (max == playerList.get(i).getWeeklySalary()) {
                        players.add(playerList.get(i));
                    }
                }
        return players;
    }
    public static List<Player> maxAgeInClub(List<Player> playerList)
    {
        List<Player> players = new ArrayList();

                int max = playerList.get(0).getAge();

                for (int i = 1; i < playerList.size(); i++) {
                    if (max < playerList.get(i).getAge()) {
                        max = playerList.get(i).getAge();
                    }
                }
                for (int i = 0; i < playerList.size(); i++) {
                    if (max ==playerList.get(i).getAge()) {
                        players.add(playerList.get(i));
                        // c.getPlayers().get(i).printPlayerInfo();
                    }
                }

        return players;
    }
    public static List<Player> maxHeightInClub(List<Player> playerList)
    {
        List<Player> players = new ArrayList();
                double max =playerList.get(0).getHeight();
                for (int i = 1; i < playerList.size(); i++)
                {
                    if(max < playerList.get(i).getHeight())
                    {
                        max = playerList.get(i).getHeight();
                    }
                }
                for (int i = 0; i < playerList.size(); i++)
                {
                    if (max == playerList.get(i).getHeight())
                    {
                        players.add(playerList.get(i));
                    }
                }
        return players;
    }
    public static double TotalSalaryOfClub(List<Player> playerList)
    {
        HashMap<String,Double> map=new HashMap<String,Double>();
        double yearlySalary = 0;

                for (int i = 0; i < playerList.size(); i++)
                {
                    yearlySalary += (52 *playerList.get(i).getWeeklySalary());
                }

        return yearlySalary;
    }


}
