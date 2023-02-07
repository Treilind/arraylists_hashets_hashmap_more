package WasserstandManager;

import java.util.ArrayList;

public class WasserstandManager {

    private ArrayList<Wasserstand> wasserstands;

    public WasserstandManager() {
        this.wasserstands = new ArrayList<>();
    }

    public void add (Wasserstand newWasserstand){
        wasserstands.add(newWasserstand);
    }

    public void print (){
        for (Wasserstand w: wasserstands) {
            System.out.println("w.toString() = " + w.toString());
        }
    }

    public Wasserstand findByID (int id){
        for (Wasserstand w: wasserstands) {
            if (w.getId() == id)
                return w;
        }
        return null;
    }

    public ArrayList<Wasserstand> findAllByGewaesser (String geweasserName){
        ArrayList<Wasserstand> result = new ArrayList<>();

        for (Wasserstand w: wasserstands) {
            if (w.getGewaesserName().equals(geweasserName)){
                result.add(w);
            }
        }
        return result;
    }

    public Wasserstand findLastWasserstand (String geweasserName){
        int newestZeitpunkt = 0;
        Wasserstand newestWasserstand = null;

        for (Wasserstand w: wasserstands) {
            if (w.getGewaesserName().equals(geweasserName)){
                if (w.getZeitpunkt() > newestZeitpunkt){
                    newestZeitpunkt = w.getZeitpunkt();
                    newestWasserstand = w;
                }
                if (w.getZeitpunkt() < newestZeitpunkt){
                    return newestWasserstand;
                }
            }
        }
        return newestWasserstand;
    }

    public ArrayList<Wasserstand> findForAlamierung (){
        ArrayList<Wasserstand> alarm = new ArrayList<>();

        for (Wasserstand w: wasserstands) {
            if (w.getMessWert() >= w.getMessWertFuerAlamierung())
                alarm.add(w);
        }
        return alarm;
    }

    public double calcMittlererWasserstand (String geweasserName){
        double interimResult = 0;
        double result = 0;
        ArrayList<Wasserstand> geweasser = findAllByGewaesser(geweasserName);

        for (Wasserstand w: geweasser) {
            interimResult = interimResult + w.getMessWert();
        }
        result = interimResult / (geweasser.size());

        return result;
    }


    public ArrayList<Wasserstand> findByZeitpunkt (int von, int bis, String geweasserName){
        ArrayList<Wasserstand> wassterstaende = new ArrayList<>();

        for (Wasserstand w: wasserstands) {
            if (w.getGewaesserName().equals(geweasserName)){
                if (w.getZeitpunkt() >= von && w.getZeitpunkt() <= bis){
                    wassterstaende.add(w);
                }
            }
        }
        return wassterstaende;
    }

}
