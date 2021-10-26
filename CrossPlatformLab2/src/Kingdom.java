public class Kingdom extends Monarchy {

    String[] vassals;
    String master;

    Kingdom(String name, String founded, String monarchName, String master, String ... vassals) {
        super(name, founded, monarchName);
        this.master = master;
        this.vassals = vassals;
    }


    public void showVassals() {
        for (String vassal: vassals) {
            System.out.print(vassal + " ");
        }
        System.out.println();
    }
}
