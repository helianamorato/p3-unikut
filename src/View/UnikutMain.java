package View;

import java.util.Scanner;
import Controller.AccountController;
import Database.Database;
import Model.Account;
import Services.Network;
import useCases.EmailAlreadyExistsUseCase;
import useCases.VerifyPasswordEqualsUseCase;


public class UnikutMain {
    public static void main(String[] args) {
        Database database = new Database();
        try (Scanner read = new Scanner(System.in)) {
            System.out.println("**** Bem vindo(a) ao Unikut! ****");
            do {
                Menu.printMenuSignInAndSignUp();

                int selected = read.nextInt();

                if (selected == 1) {
                    boolean verifyPass;
                    int verifyLogin;
                    String loginSession;
                    String login;
                    do {
                        System.out.println("-------------------");
                        System.out.print("Digite o seu login: ");
                        login = read.next();
                        loginSession = login;
                        verifyLogin = VerifyPasswordEqualsUseCase.verifyLogin(login, database);

                    } while (verifyLogin == -1);

                    do {
                        System.out.println("-------------------");
                        System.out.print("Digite sua senha: ");
                        String password = read.next();
                        verifyPass = VerifyPasswordEqualsUseCase.verify(password, database, verifyLogin);
                    } while (!verifyPass);

                    System.out.println(" ");
                    System.out.println("Bem vindo(a), "+database.accounts[verifyLogin].getName()+"!");

                    boolean session = true;
                    do {
                        Menu.printMenuSignIn();
                        int selectedOptionSignIn = read.nextInt();
                        String nameFriend;
                        switch (selectedOptionSignIn) {
                            case 1 -> {
                                System.out.println("-----------------------");
                                System.out.print("Digite seu novo nome: ");
                                String newName = read.next();
                                System.out.println("-----------------------");
                                AccountController.updateName(newName, loginSession, database);
                            }
                            case 2 -> {
                                System.out.println("-------------------------");
                                System.out.println("Digite sua nova senha: ");
                                String newPassword = read.next();
                                System.out.println("--------------------------");
                                AccountController.updatePassword(newPassword, loginSession, database);
                            }
                            case 3 -> {
                                boolean verify;
                                do {
                                    System.out.println("---------------------");
                                    System.out.println("Digite o login do usuário a ser encontrado: ");
                                    nameFriend = read.next();
                                    verify = EmailAlreadyExistsUseCase.verifyUserFriend(login, nameFriend, database);
                                    if(verify) {
                                        Network.verifyInvited(verifyLogin, nameFriend, database);
                                    }
                                    System.out.println(" ");
                                } while (!verify);
                            }
                            case 4 ->
                                Network.listingFriends(verifyLogin, database);

                            case 5 ->
                                Network.verifyPendingInv(verifyLogin, database);

                            case 6 ->
                                Network.listingMessages(verifyLogin, database);

                            case 7 -> session = false;
                        }
                    } while (session);
                } else if (selected == 2) {
                    boolean verifyTwo;
                    String login;
                    do {
                        System.out.println("-----------------------");
                        System.out.println("Crie seu login: ");
                        login = read.next();

                        verifyTwo = EmailAlreadyExistsUseCase.verify(login, database);

                    } while (verifyTwo);

                    System.out.println("------------------------");
                    System.out.print("Digite seu nome: ");
                    String name = read.next();

                    if (name.trim().equals("")) {
                        name = "Convidado";
                    }

                    System.out.println("----------------------");
                    System.out.print("Crie uma senha: ");
                    String password = read.next();

                    Account user = new Account(login, name, password);
                    AccountController.createNewAccount(user, database);
                } else if (selected == 3) {
                    System.out.println(" ");
                    System.out.println("Até a próxima!");
                    System.out.println("*** Sessão encerrada! ***");
                    break;
                } else {
                    System.out.println(" ");
                    System.out.println("Opção incorreta, digite novamente.");
                }

            } while (true);
        }
    }
}