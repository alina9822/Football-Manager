package server;


import projectClasses.*;
import util.LoginDTO;
import util.NetworkUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReadThreadServer implements Runnable {

    public static List<Player> playerList;
    public static List<Clubs> clubList = new ArrayList();

    private final Thread thr;
    private final NetworkUtil networkUtil;
    public HashMap<String, String> userMap;


    public ReadThreadServer(HashMap<String, String> map, NetworkUtil networkUtil) {
        this.userMap = map;
        this.networkUtil = networkUtil;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {
            playerList = PlayerDatabase.readFromFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        InitializeClubs();
        try {
            while (true) {
                Object o = networkUtil.read();
                if (o != null) {
                    if (o instanceof LoginDTO) {
                        LoginDTO loginDTO = (LoginDTO) o;
                        String password = userMap.get(loginDTO.getUserName());
                        loginDTO.setStatus(loginDTO.getPassword().equals(password));
                        if (loginDTO.isStatus())
                        {
                            for (Clubs c: clubList)
                                if(loginDTO.getUserName().equals(c.getName()))
                                    loginDTO.setClubPlayers(c.getPlayers());
                        }
                        networkUtil.write(loginDTO);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                networkUtil.closeConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private static void InitializeClubs() {
        List<String> clubNameList = new ArrayList();

        for (Player p: playerList)
        {
            if(!clubNameList.contains(p.getClub()))
            {
                clubNameList.add(p.getClub());
            }
        }

        for (String s : clubNameList)
        {
            Clubs club = new Clubs();
            club.setName(s);
            clubList.add(club);
        }

        for (Player p : playerList)
            for (Clubs c : clubList) {
                if (c.getName().equalsIgnoreCase(p.getClub())) {
                    clubList.get(clubList.indexOf(c)).addPlayers(p);
                }
            }
    }
}



