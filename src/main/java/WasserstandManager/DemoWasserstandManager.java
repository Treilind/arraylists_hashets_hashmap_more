package WasserstandManager;

public class DemoWasserstandManager {
    public static void main(String[] args) {

        WasserstandManager manager = new WasserstandManager();

        Wasserstand eins = new Wasserstand(1, "Mur", 50, 70, 86400);
        Wasserstand zwei = new Wasserstand(2, "Donau", 100, 110, 86400);
        Wasserstand drei = new Wasserstand(3, "Safen", 3, 20, 86400);
        Wasserstand vier = new Wasserstand(4, "Safen", 2, 20, 172800);

        manager.add(eins);
        manager.add(zwei);
        manager.add(drei);
        manager.add(vier);
        manager.add(new Wasserstand(5, "Safen", 21, 20, 51840000));

        manager.print();

        System.out.println("manager.findByID(2) = " + manager.findByID(2));

        System.out.println("manager.findAllByGewaesser(\"Safen\") = " + manager.findAllByGewaesser("Safen"));

        System.out.println("manager.findLastWasserstand(\"Safen\") = " + manager.findLastWasserstand("Safen"));

        System.out.println("manager.findForAlamierung() = " + manager.findForAlamierung());

        System.out.println("manager.calcMittlererWasserstand(\"Safen\") = " + manager.calcMittlererWasserstand("Safen"));

        System.out.println("manager.findByZeitpunkt(0, 1000000000, \"Safen\") = " + manager.findByZeitpunkt(0, 1000000000, "Safen"));




    }
}
