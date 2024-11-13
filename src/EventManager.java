import java.util.Scanner;

public class EventManager {
        Scanner scanner = new Scanner(System.in);
        public Event [] events = new Event[100];

        public EventManager() {
        }


        public void opretEvent(Event e) {

                for (int i = 0; i < events.length; i++) {
                        if (events[i] == null){
                                events[i] = e;
                                break;
                        }
                }
        }
        public void sletEvent() {

                for (int i = 0; i < 100; i++) {
                        if (events[i] != null){
                                events[i].displayTitle();
                        }if (events == null){
                                System.out.println("Ingen Events fundet");
                }
                }
                System.out.println("Hvilke event vil du slette");
                String title = scanner.nextLine().toLowerCase();

                for (int i = 0; i < 100; i++) {
                        if (events[i] != null && events[i].getTitle().equals(title)) {
                                System.out.println("Er du sikker på at du vil slette: " + events[i].getTitle()+ " (y/n)");

                                String userInput = scanner.next().toLowerCase();
                                if (userInput.equals("y")) {
                                        events[i] = null;
                                        return;
                                }else System.out.println("Eventet blev ikke fjernet");{


                                }
                        }
                }
        }
}