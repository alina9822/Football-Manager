package projectClasses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class searchPlayer {
    public static List<Player> byPlayerName(List<Player> playerList,String name)
    {
        List<Player> players = new ArrayList();
        for (int i = 0; i < playerList.size(); i++) {
            Player t = playerList.get(i);
            if (t.getName().equalsIgnoreCase(name)) {
                players.add(t);
            }
        }
            return players;
    }
    public static List<Player> byCountry(List<Player> playerList,String country)
    {
        List<Player> players = new ArrayList();
        for (int i = 0; i < playerList.size(); i++) {
            Player t = playerList.get(i);
            if (t.getCountry().equalsIgnoreCase(country)) {
                players.add(t);
            }
        }
        return players;
    }
    public static List<Player> byPosition(List<Player> playerList,String position)
    {
        List<Player> players = new ArrayList();
        for (int i = 0; i < playerList.size(); i++) {
            Player t = playerList.get(i);
            if (t.getPosition().equalsIgnoreCase(position)) {
                players.add(t);
            }
        }
        return players;
    }
    public static List<Player> bySalaryRange(List<Player> playerList,double upper,double lower)
    {
        List<Player> players = new ArrayList();
        for (int i = 0; i < playerList.size(); i++) {
            Player t = playerList.get(i);
            if (t.getWeeklySalary()<=upper && t.getWeeklySalary()>=lower) {
                players.add(t);
            }
        }
        return players;
    }
    public static HashMap<String,Integer> countryWisePlayerCount(List<Player> playerList)
    {
        List<String> countries = new ArrayList();
        HashMap<String,Integer> map = new HashMap< String,Integer>();

        for(Player p : playerList)
        {
            if(!countries.contains(p.getCountry()))
            {
                countries.add(p.getCountry());
            }
        }

        int[] numOfPlayers = new int[countries.size()];
        int i = 0;
        for (String c : countries)
        {
            for (Player p:playerList)
            {
                if(c.equalsIgnoreCase(p.getCountry()))
                {
                    numOfPlayers[i]++;
                }
            }
            i++;
        }

        int j = 0;
        for (String s : countries)
        {
            //System.out.println(s + ": " + numOfPlayers[j]);
            map.put(s,numOfPlayers[j]);
            j++;
        }
        return map;
    }
}
