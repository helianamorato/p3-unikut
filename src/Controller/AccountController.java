package Controller;

import Database.Database;
import Model.Account;
import Interfaces.IAccountController;

import java.util.Objects;

public class AccountController implements IAccountController {

    public static void updateName(String name, String login, Database database) {
        if(!database.isEmpty()){
            for(int i = 0; i < database.accounts.length; i++) {
                if(Objects.equals(database.accounts[i].getLogin(), login)){
                    database.accounts[i].setName(name);
                    System.out.println("Nome alterado com sucesso!");
                    System.out.println("-------------------------");
                    return;
                }
            }
        }
    }

    public static void createNewAccount(Account account, Database database) {
        if(database.isEmpty()) {
            Account[] AccountsTemplate = new Account[1];
            AccountsTemplate[0] = account;
            database.setAccounts(AccountsTemplate);
            System.out.println("----------------------");
            System.out.println("Usuário criado com sucesso!");
            System.out.println("----------------------");
        } else {
            Account[] accountsTemplate = new Account[database.accounts.length + 1];
            System.arraycopy(database.accounts, 0, accountsTemplate, 0, database.accounts.length);
            accountsTemplate[database.accounts.length] = account;
            database.setAccounts(accountsTemplate);
            System.out.println("----------------------");
            System.out.println("Usuário criado com sucesso!");
            System.out.println("----------------------");
        }
    }

    public static void updatePassword(String password, String login, Database database) {
        for(int i = 0; i < database.accounts.length; i++){
            if(Objects.equals(database.accounts[i].getLogin(), login)){
                database.accounts[i].setPassword(password);
                System.out.println("Senha alterada com sucesso!");
                System.out.println("-------------------------");
                return;
            }
        }
    }
}