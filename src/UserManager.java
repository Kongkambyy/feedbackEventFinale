import java.util.Scanner;

public class UserManager {

    private User [] users = new User[100];
    Scanner scanner = new Scanner(System.in);

    public void opretUser(){


        System.out.println("Opret din brugerprofil");
        System.out.println("Indtast dit brugernavn");
        String username = scanner.next();
        System.out.println("Indtast din email: ");
        String email = scanner.next();
        System.out.println("Indtast dit password: ");
        String password = scanner.next();
        User thisUser = new User(username, email, password);
        addUserTooArray(thisUser);
    }
    public void addUserTooArray(User u){
        for (int i = 0; i < 100; i++){
            if (users[i] == null){
                users[i] = u;
            }
        }
    }

    boolean userLogin(String username, String password){
        boolean userLogin = false;
        String userPassword = "";
        String userEmail = "";
        String userName = "";
        if (userName.equals(username) && password.equals(userPassword)){
            userLogin = true;
        }
        return userLogin;
    }

     boolean auth(String email, String user, String pass){
        boolean auth = false;
        String adminPassword = "admin";
        String adminEmail = "email@email.com";
        String adminPass = "Admin";
        if (email.equals(adminEmail) && user.equals(adminPassword) && pass.equals(adminPass)){
            auth = true;
        }
        return auth;
}
    public void handleAdminLogin(){
        System.out.println("Indtast admin email: ");
        String email = scanner.next().toLowerCase();
        System.out.println("Indtast navn:");
        String navn = scanner.next().toLowerCase();
        System.out.println("Indtast Password");
        String password = scanner.next();
        if (auth(email,navn, password)){
            Menu.adminMenu();
        } else {
            System.out.println("Nægtet adgang. Du er ikke admin.");
        }
    }

    public User[] getUser() {
        return users;
    }

    public void setUser(User[] user) {
        this.users = user;
    }
}