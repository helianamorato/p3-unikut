package Interfaces;

import Database.Database;
import Model.Account;

public interface IAccountController {
    static Account getAccount(String login, Database database) {
        return null;
    }

    static Account updateName(String name, String login, Database database) {
        return null;
    }

    static void createNewAccount(Account account, Database database) {
    }

    static Account updatePassword(String password, String login, Database database) {
        return null;
    }
}