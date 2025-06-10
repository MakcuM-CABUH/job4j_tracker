package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {

        for (User user : users) {
            if (user.getUserName().equals(login)) {
                return user;
            }
            throw new UserNotFoundException("User not found");
        }
        return null;
    }

    public static boolean validate(User user) throws UserInvalidException {

        if (user.isValid()) {
            return true;
        }
        throw new UserInvalidException("Username cannot be less than 4 characters");
    }

    public static void main(String[] args) throws UserNotFoundException {

        User[] users = {
                new User("Petr Arsentev", true)
        };
        try {
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException w) {
            w.printStackTrace();
        } catch (UserNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
