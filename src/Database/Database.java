package Database;

import Model.Account;

import java.util.Objects;

public class Database {
    public Account[] accounts;

    public Account[] getAccounts() {
        return this.accounts;
    }

    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }

    public boolean isEmpty(){
        if(this.accounts == null){
            return true;
        }else{
            return false;
        }
    }
}
