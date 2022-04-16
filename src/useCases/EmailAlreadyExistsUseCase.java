package useCases;

import Database.Database;
import java.util.Objects;

public class EmailAlreadyExistsUseCase {

    public static boolean verify(String login, Database database) {
        if(database.isEmpty()) {
            return false;
        } else {
            for(int i = 0; i < database.getAccounts().length; i++) {
                if(Objects.equals(database.accounts[i].getLogin(), login)) {
                    System.out.println("Login já existente. Tente novamente.");
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean verifyUserFriend(String login, String nameFriend, Database database) {
        if (Objects.equals(login, nameFriend)) {
            System.out.println("Este é o seu login.");
            return false;
        } else {
            for (int i = 0; i < database.getAccounts().length; i++) {
                if (Objects.equals(database.accounts[i].getLogin(), nameFriend)) {
                    System.out.println(database.accounts[i].getName());
                    return true;
                }
            }
        }
        System.out.println("Usuário não encontrado!");
        return false;
    }
}