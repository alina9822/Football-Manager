package projectClasses;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;


public class PlayerDatabase {
    private static final String INPUT_FILE_NAME = "players.txt";
    private static final String OUTPUT_FILE_NAME = "out.txt";
    public static List<Player> playerList = new ArrayList();
    // public static List<Clubs> clubList = new ArrayList();

    public static List<Player> readFromFile() throws Exception {

        // var studentList = new ArrayList();
        BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME));
        // var br = new BufferedReader(new FileReader(INPUT_FILE_NAME));
        while (true) {
            String line = br.readLine();
            if (line == null) break;
            String[] tokens = line.split(",");
            Player p = new Player();
            p.setName(tokens[0]);
            p.setCountry(tokens[1]);
            p.setAge(Integer.parseInt(tokens[2]));
            p.setHeight(Double.parseDouble(tokens[3]));
            p.setClub(tokens[4]);
            p.setPosition(tokens[5]);
            p.setNumber(Integer.parseInt(tokens[6]));
            p.setWeeklySalary(Double.parseDouble(tokens[7]));
            playerList.add(p);
            // p.printPlayerInfo();
        }
        br.close();
        return playerList;
    }
    public static void writeToFile(List<Player> playerList) throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME));
        //  BufferedWriter bw1 = new BufferedWriter(new FileWriter(INPUT_FILE_NAME));

        //var bw = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME));
        for (Player p : playerList) {
            bw.write(p.getName() + "," + p.getCountry() + "," + p.getAge() + "," + p.getHeight()+","+p.getClub()+","+p.getPosition()+","+p.getNumber()+","+p.getWeeklySalary());
            bw.write("\n");
           /*  bw1.write(p.getName() + "," + p.getCountry() + "," + p.getAge() + "," + p.getHeight()+","+p.getClub()+","+p.getPosition()+","+p.getNumber()+","+p.getWeeklySalary());
            bw1.write("\n");*/
        }
        bw.close();
        // bw1.close();

    }
}
