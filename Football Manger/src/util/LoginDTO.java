package util;

import projectClasses.*;

import java.io.Serializable;
import java.util.List;

public class LoginDTO implements Serializable {

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Player> getClubPlayers() {
        return clubPlayers;
    }

    public void setClubPlayers(List<Player> clubPlayers) {
        this.clubPlayers = clubPlayers;
    }

    private String userName;
    private String password;
    private List<Player> clubPlayers;
    private boolean status;
}
