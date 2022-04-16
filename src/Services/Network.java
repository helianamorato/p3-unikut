package Services;

import Database.Database;
import View.Menu;

import java.util.Objects;
import java.util.Scanner;

public class Network {

    public static void verifyInvited(int positionUser, String nameFriend, Database database) {
        Scanner sc = new Scanner(System.in);
        int cont = 0;
        if(database.accounts[positionUser].getInvited() == null) {
            verifyInvitations(positionUser, nameFriend, database);
        } else {
            for (int i = 0; i < database.accounts[positionUser].getInvited().length; i++) {
                if (Objects.equals(database.accounts[positionUser].getInvited()[i], nameFriend)) {
                    System.out.println(nameFriend + " convidou você para serem amigos");
                    System.out.println(" ");
                    cont = 1;
                    Menu.printMenuAcceptFriend();
                    int select = sc.nextInt();
                    if (select == 1) {
                        Interactions.acceptFriendship(positionUser, nameFriend, database);
                    }
                }
            }
            if (cont < 1) {
                verifyInvitations(positionUser, nameFriend, database);
            }
        }
        cont = 0;
    }

    public static void verifyInvitations(int positionUser, String nameFriend, Database database) {
        int cont = 0;
        if(database.accounts[positionUser].getInvitations() == null) {
            verifyFriendship(positionUser, nameFriend, database);
        } else {
            for (int j = 0; j < database.accounts[positionUser].getInvitations().length; j++) {
                if (Objects.equals(database.accounts[positionUser].getInvitations()[j], nameFriend)) {
                    System.out.println("Status de amizade: PENDENTE");
                    System.out.println("Aguarde resposta");
                    System.out.println(" ");
                    cont = 1;
                }
            }
            if (cont < 1) {
                verifyFriendship(positionUser, nameFriend, database);
            }
        }
        cont = 0;
    }

    public static void verifyFriendship(int positionUser, String nameFriend, Database database) {
        Scanner sc = new Scanner(System.in);
        int cont = 0;
        if (database.accounts[positionUser].getFriends() == null) {
            System.out.println("Vocês não são amigos");
            System.out.println(" ");
            Menu.printMenuNoFriend();
            int select = sc.nextInt();
            if (select == 1) {
                Interactions.addFriend(positionUser, nameFriend, database);
            }
        } else {
            for (int k = 0; k < database.accounts[positionUser].getFriends().length; k++) {
                if (Objects.equals(database.accounts[positionUser].getFriends()[k], nameFriend)) {
                    System.out.println("Status de amizade: AMIGOS");
                    System.out.println(" ");
                    Menu.printMenuFriend();
                    int selected = sc.nextInt();
                    if(selected == 1) {
                        Interactions.sendMessage(positionUser, nameFriend, database);
                    }
                    cont = 1;
                }
            }
            if (cont < 1) {
                System.out.println("Vocês não são amigos");
                System.out.println(" ");
                Menu.printMenuNoFriend();
                int select = sc.nextInt();
                if (select == 1) {
                    Interactions.addFriend(positionUser, nameFriend, database);
                }
            }
        }
        cont = 0;
    }

    public static void verifyPendingInv(int positionUser, Database database) {
        Scanner sc = new Scanner(System.in);
        System.out.println(" ");
        System.out.println("Usuários que você solicitou amizade:");
        int cont = 0;
        if (database.accounts[positionUser].getInvitations() == null) {
            System.out.println("- Nenhum usuário -");
        } else {
            for (int i = 0; i < database.accounts[positionUser].getInvitations().length; i++) {
                if (database.accounts[positionUser].getInvitations()[i] != null) {
                    System.out.println(database.accounts[positionUser].getInvitations()[i]);
                    cont++;
                }
            }
            if (cont != 0) {
                System.out.println("Aguarde ele(a)(s) responder(em) sua solicitação para interagir!");
            } else {
                System.out.println("- Nenhum usuário -");
            }
        }
        System.out.println("---------------");
        System.out.println("Usuários que solicitaram sua amizade:");
        cont = 0;
        if (database.accounts[positionUser].getInvited() == null) {
            System.out.println("- Nenhum usuário -");
        } else {
            for (int i = 0; i < database.accounts[positionUser].getInvited().length; i++) {
                if (database.accounts[positionUser].getInvited()[i] != null) {
                    System.out.println(database.accounts[positionUser].getInvited()[i]);
                    cont++;
                }
            }
            if (cont != 0) {
                System.out.println("Deseja aceitar alguns deles como amigo?");
                Menu.printMenuAcceptFriend();
                int selected = sc.nextInt();
                if (selected == 1) {
                    System.out.println("Digite o nome do usuário:");
                    String nameUser = sc.next();
                    Interactions.acceptFriendship(positionUser, nameUser, database);
                }
            } else {
                System.out.println("- Nenhum usuário -");
            }
        }
        System.out.println("---------------");
    }
    public static void listingFriends(int positionUser, Database database) {
        System.out.println(" ");
        System.out.println("--- Seus amigos ---");
        if (database.accounts[positionUser].getFriends() == null) {
            System.out.println("Você ainda não tem amigos adicionados");
        } else {
            for (int i = 0; i < database.accounts[positionUser].getFriends().length; i++) {
                System.out.println(database.accounts[positionUser].getFriends()[i]);
            }
        }
        System.out.println("----------------");
    }
    public static void listingMessages(int positionUser, Database database) {
        if (database.accounts[positionUser].getMessageList() == null) {
            System.out.println(" ");
            System.out.println("Você não tem nenhuma mensagem");
        } else {
            for (int i = 0; i < database.accounts[positionUser].getMessageList().length; i++) {
                System.out.println("** Mensagem "+(i+1)+" **");
                System.out.println(database.accounts[positionUser].getMessageList()[i]);
                System.out.println("-- Enviada por: "+database.accounts[positionUser].getMessageWriters()[i]);
                System.out.println("---------------------------------------------");
            }
        }
    }
}
