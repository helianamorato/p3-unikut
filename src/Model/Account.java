package Model;

import java.util.Scanner;
public class Account {
    protected String login;
    protected String name;
    protected String password;
    protected String[] friends;
    protected String[] invitations;
    protected String[] invited;
    protected String[] messageList;
    protected String[] messageWriters;

    public Account (String login, String name, String password) {
        this.login = login;
        this.name = name;
        this.password = password;
    }

    public String[] getMessageList() { return this.messageList; }

    public void setMessageList(String[] messageList) { this.messageList = messageList; }

    public String[] getMessageWriters() { return this.messageWriters; }

    public void setMessageWriters(String[] messageWriters) { this.messageWriters = messageWriters; }

    public String[] getFriends() { return this.friends; }

    public void setFriends(String[] friends) { this.friends = friends; }

    public String[] getInvitations() {
        return this.invitations;
    }

    public void setInvitations(String[] invitations) {
        this.invitations = invitations;
    }

    public String[] getInvited() {
        return this.invited;
    }

    public void setInvited(String[] invited) {
        this.invited = invited;
    }

    public String getLogin() { return this.login; }

    public void setLogin(String login) { this.login = this.login; }

    public String getName() { return this.name; }

    public void setName(String name) { this.name = name; }

    public String getPassword() { return this.password; }

    public void setPassword(String password) { this.password = password; }

}