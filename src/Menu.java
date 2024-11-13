import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Menu {

    static Scanner scanner = new Scanner(System.in);
    static UserManager userManager = new UserManager();
    static EventManager eventManager = new EventManager();

    public static void main(String[] args) {


        do {
            System.out.println("Velkommen til dit event system");
            System.out.println("1. Login som bruger");
            System.out.println("2. Registrer dig som bruger");
            System.out.println("3. Login som admin");
            System.out.println("4. Luk programmet");
            System.out.println("Vælg en af ovenstående muligheder");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    handleUserLogin();
                    LocalDateTime now = LocalDateTime.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                    String currentDateTime = now.format(formatter);

                    System.out.println("Du er nu logget ind til event systemet: " + currentDateTime);
                    userMenu();
                    break;

                    case 2:
                        userManager.opretUser();
                        System.out.println("Du har nu registreret din konto, login med dine oprettede informationer");
                        break;

                        case 3:
                            handleUserLogin();
                            System.out.println("Du har nu logget ind som admin til event systemet");
                            break;

                            case 4:
                                System.out.println("Lukker programmet...");
                                System.exit(0);
                                break;

                                default:
                                    System.out.println("Vælg et rigtigt tal");
            }
        }while (true);
    }

    public static void handleUserLogin() {
        System.out.println("Hvad er din e-mail");
        String thisEmail = scanner.next();
        System.out.println("Hvad er dit password");
        String thisPassword = scanner.next();

        if (userManager.userLogin(thisEmail, thisPassword))
            userMenu();
    }
    public static void opretBruger(){
        System.out.println("Indtast event titel: ");
        String thisTitle = scanner.next().toLowerCase();
        System.out.println("Indtast event beskrivelse: ");
        String thisTescription = scanner.next().toLowerCase();
        System.out.println("Indtast dato: ");
        String thisDate = scanner.next().toLowerCase();
        System.out.println("Indtast lokation: ");
        String thisLokation = scanner.next().toLowerCase();

        Event thisEvent = new Event();
        thisEvent.setTitle(thisTitle);
        thisEvent.setDescription(thisTescription);
        thisEvent.setDate(thisDate);
        thisEvent.setLocation(thisLokation);

        eventManager.opretEvent(thisEvent);
    }


        public static void userMenu(){
        do {
            System.out.println("Brugermenu:");
            System.out.println("1. Opret Event");
            System.out.println("2. Slet event");
            System.out.println("3. Se profil");
            System.out.println("4. Luk programmet");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    opretBruger();
                    break;

                    case 2:
                        eventManager.sletEvent();
                        break;

                        case 3:
                            seProfil();
                            break;

                            case 4:
                                System.out.println("Lukker programmet...");
                                System.exit(0);
                                break;

                                default:
                                    System.out.println("Du har ikke valgt en valgmulighed");

            }
        }while (true);
    }


    public static void adminMenu(){
        do {
            System.out.println("Admin Menu:");
            System.out.println("1. Slet et event");
            System.out.println("2. Slet bruger");
            System.out.println("3. Luk programmet");


        } while (true);
    }
    public static void seProfil(){

        System.out.println("Din mail er: ");
        System.out.println("Dit brugernavn er: ");


    }
}