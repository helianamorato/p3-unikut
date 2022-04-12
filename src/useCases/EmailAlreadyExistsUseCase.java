package useCases;

import Database.Database;
import Model.Account;

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

    public static boolean verifyUser(String login, Database database) {
        for(int i = 0; i < database.getAccounts().length; i++) {
            if(Objects.equals(database.accounts[i].getLogin(), login)) {
                System.out.println(database.accounts[i].getName());
                return true;
            }
        }
        System.out.println("Usuário não encontrado!");
        return false;
    }
}