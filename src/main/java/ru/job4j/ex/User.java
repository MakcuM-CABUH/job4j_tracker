package ru.job4j.ex;

public class User {
    private String userName;
    private boolean valid;

    public User(String userName, boolean valid) {
        this.userName = userName;
        this.valid = valid;
    }

    public String getUserName() {
        return userName;
    }

    public boolean isValid() {
        String user = getUserName();
        int i = user.length();
        if (i < 4) {
            return false;
        }
        return valid;
    }
}
