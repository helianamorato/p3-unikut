package Model;

import Database.Database;
import View.Menu;

import java.util.Objects;
import java.util.Scanner;

public class Interactions {

    public static void addFriend(int positionUser, String nameFriend, Database database) {
        Scanner sc = new Scanner(System.in);
        int indiceFriend = 0;
        if(database.accounts[positionUser].getInvitations() == null) {
            String[] listInvite = new String[1];
            listInvite[0] = nameFriend;
            database.accounts[positionUser].setInvitations(listInvite);
            System.out.println("Solicitação de amizade enviada a "+nameFriend);
            System.out.println("Aguarde resposta para interagir");
            System.out.println(" ");
            for (int i = 0; i < database.accounts.length; i++) {
                if(Objects.equals(database.accounts[i].getLogin(), nameFriend)) {
                    indiceFriend = i;
                }
            }
            if(database.accounts[indiceFriend].getInvited() == null) {
                String[] listInvited = new String[1];
                listInvited[0] = database.accounts[positionUser].getLogin();
                database.accounts[indiceFriend].setInvited(listInvited);
            } else {
                String[] listInvited = new String[database.accounts[indiceFriend].getInvited().length + 1];
                for (int i = 0; i < database.accounts[indiceFriend].getInvited().length; i++) {
                    listInvited[i] = database.accounts[indiceFriend].getInvited()[i];
                }
                listInvited[database.accounts[indiceFriend].getInvited().length] = database.accounts[positionUser].getLogin();
                database.accounts[indiceFriend].setInvited(listInvited);
            }

        } else {
            String[] listInvite = new String[database.accounts[positionUser].getInvitations().length + 1];
            for (int i = 0; i < database.accounts[positionUser].getInvitations().length; i++) {
                listInvite[i] = database.accounts[positionUser].getInvitations()[i];
            }
            listInvite[database.accounts[positionUser].getInvitations().length] = nameFriend;
            database.accounts[positionUser].setInvitations(listInvite);
            System.out.println("Solicitação de amizade enviada a " + nameFriend);
            System.out.println("Aguarde resposta para interagir");
            System.out.println(" ");
            for (int i = 0; i < database.accounts.length; i++) {
                if(Objects.equals(database.accounts[i].getLogin(), nameFriend)) {
                    indiceFriend = i;
                }
            }
            if(database.accounts[indiceFriend].getInvited() == null) {
                String[] listInvited = new String[1];
                listInvited[0] = database.accounts[positionUser].getLogin();
                database.accounts[indiceFriend].setInvited(listInvited);
            } else {
                String[] listInvited = new String[database.accounts[indiceFriend].getInvited().length + 1];
                for (int i = 0; i < database.accounts[indiceFriend].getInvited().length; i++) {
                    listInvited[i] = database.accounts[indiceFriend].getInvited()[i];
                }
                listInvited[database.accounts[indiceFriend].getInvited().length] = database.accounts[positionUser].getLogin();
                database.accounts[indiceFriend].setInvited(listInvited);
            }
        }
    }

    public static void acceptFriendship(int positionUser, String nameFriend, Database database) {

        Scanner sc = new Scanner(System.in);
        int indiceFriend = 0;
        if(database.accounts[positionUser].getFriends() == null) {
            String[] listFriends = new String[1];
            listFriends[0] = nameFriend;
            for (int i = 0; i < database.accounts.length; i++) {
                if(Objects.equals(database.accounts[i].getLogin(), nameFriend)) {
                    indiceFriend = i;
                }
            }
            database.accounts[positionUser].setFriends(listFriends);
            System.out.println(nameFriend+" foi aceito como amigo.");
            System.out.println("Agora vocês podem interagir! O que deseja fazer agora?");
            Menu.printMenuFriend();
            int selected = sc.nextInt();
            if (selected == 1) {
                sendMessage(positionUser, nameFriend, database);
            }
            if(database.accounts[indiceFriend].getFriends() == null) {
                String[] listFriendship = new String[1];
                listFriendship[0] = database.accounts[positionUser].getLogin();
                database.accounts[indiceFriend].setFriends(listFriendship);
            } else {
                String[] listFriendship = new String[database.accounts[indiceFriend].getFriends().length + 1];
                for (int i = 0; i < database.accounts[indiceFriend].getFriends().length; i++) {
                    listFriendship[i] = database.accounts[indiceFriend].getFriends()[i];
                }
                listFriendship[database.accounts[indiceFriend].getFriends().length] = database.accounts[positionUser].getLogin();
                database.accounts[indiceFriend].setFriends(listFriendship);
            }
            for (int j = 0; j < database.accounts[positionUser].getInvited().length; j++) {
                if(Objects.equals(database.accounts[positionUser].getInvited()[j], database.accounts[indiceFriend].getLogin())){
                    database.accounts[positionUser].getInvited()[j] = null;
                }
            }
            for (int k = 0; k < database.accounts[indiceFriend].getInvitations().length; k++) {
                if(Objects.equals(database.accounts[indiceFriend].getInvitations()[k], database.accounts[positionUser].getLogin())){
                    database.accounts[indiceFriend].getInvitations()[k] = null;
                }
            }

        } else {
            String[] listFriends = new String[database.accounts[positionUser].getFriends().length + 1];
            for (int i = 0; i < database.accounts[positionUser].getFriends().length; i++) {
                listFriends[i] = database.accounts[positionUser].getFriends()[i];
            }
            listFriends[database.accounts[positionUser].getFriends().length] = nameFriend;
            database.accounts[positionUser].setFriends(listFriends);
            System.out.println(nameFriend+" foi aceito como amigo.");
            System.out.println("Agora vocês podem interagir! O que deseja fazer agora?");
            Menu.printMenuFriend();
            int selected = sc.nextInt();
            if (selected == 1) {
                sendMessage(positionUser, nameFriend, database);
            }
            for (int i = 0; i < database.accounts.length; i++) {
                if(Objects.equals(database.accounts[i].getLogin(), nameFriend)) {
                    indiceFriend = i;
                }
            }
            if(database.accounts[indiceFriend].getFriends() == null) {
                String[] listFriendship = new String[1];
                listFriendship[0] = database.accounts[positionUser].getLogin();
                database.accounts[indiceFriend].setFriends(listFriendship);
            } else {
                String[] listFriendship = new String[database.accounts[indiceFriend].getFriends().length + 1];
                for (int i = 0; i < database.accounts[indiceFriend].getFriends().length; i++) {
                    listFriendship[i] = database.accounts[indiceFriend].getFriends()[i];
                }
                listFriendship[database.accounts[indiceFriend].getFriends().length] = database.accounts[positionUser].getLogin();
                database.accounts[indiceFriend].setFriends(listFriendship);
            }
            for (int j = 0; j < database.accounts[positionUser].getInvited().length; j++) {
                if(Objects.equals(database.accounts[positionUser].getInvited()[j], database.accounts[indiceFriend].getLogin())){
                    database.accounts[positionUser].getInvited()[j] = null;
                }
            }
            for (int k = 0; k < database.accounts[indiceFriend].getInvitations().length; k++) {
                if(Objects.equals(database.accounts[indiceFriend].getInvitations()[k], database.accounts[positionUser].getLogin())){
                    database.accounts[indiceFriend].getInvitations()[k] = null;
                }
            }
        }

    }

    public static void sendMessage(int positionUser, String nameFriend, Database database){
        Scanner sc = new Scanner(System.in);
        int indiceFriend = 0;
        System.out.println("-- Escreva a mensagem que deseja enviar a "+nameFriend);
        String message = sc.nextLine();
        for (int j = 0; j < database.accounts.length; j++) {
            if(Objects.equals(database.accounts[j].getLogin(), nameFriend)) {
                indiceFriend = j;
            }
        }
        if(database.accounts[indiceFriend].getMessageList() == null) {
            String[] listMessages = new String[1];
            String[] listWriters = new String[1];
            listMessages[0] = message;
            listWriters[0] = database.accounts[positionUser].getName();
            database.accounts[indiceFriend].setMessageList(listMessages);
            database.accounts[indiceFriend].setMessageWriters(listWriters);
            System.out.println("- Mensagem enviada a "+nameFriend+" -");
            System.out.println(" ");
        } else {
            String[] listMessages = new String[database.accounts[indiceFriend].getMessageList().length + 1];
            String[] listWriters = new String[database.accounts[indiceFriend].getMessageWriters().length + 1];
            for (int i = 0; i < database.accounts[indiceFriend].getMessageList().length; i++) {
                listMessages[i] = database.accounts[indiceFriend].getMessageList()[i];
                listWriters[i] = database.accounts[indiceFriend].getMessageWriters()[i];
            }
            listMessages[database.accounts[indiceFriend].getMessageList().length] = message;
            listWriters[database.accounts[indiceFriend].getMessageWriters().length] = database.accounts[positionUser].getName();
            database.accounts[indiceFriend].setMessageList(listMessages);
            database.accounts[indiceFriend].setMessageWriters(listWriters);
            System.out.println("- Mensagem enviada a "+nameFriend+" -");
            System.out.println(" ");
        }
    }
}
