package useCases;

import Database.Database;

import java.util.Objects;

public class VerifyPasswordEqualsUseCase {

    public static int verifyLogin (String login, Database database) {
        if (!database.isEmpty()) {
            for (int i = 0; i < database.accounts.length; i++) {
                if (Objects.equals(database.accounts[i].getLogin(), login)) {
                    return i;
                }
            }
        }
        System.out.println("Usuário não cadastrado");
        return -1;
    }

    public static boolean verify (String password, Database database, int position) {
        if (Objects.equals(database.accounts[position].getPassword(), password)) {
            return true;
        }
        System.out.println("Senha incorreta");
        return false;
    }
}