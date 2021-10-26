public class Main {

    public static void main(String[] args) {

        Republic republic = new Republic("Ukraine", "1991.08.24");
        System.out.println(republic.getPresidentName());
        System.out.println();

        Kingdom kingdom = new Kingdom("Kingdom of Galicia and Volhynia", "1199.01.01", "Roman", "-", "vassal1", "vassal2", "vassal3");
        System.out.println(kingdom.returnMonarchName());
        kingdom.showVassals();
        kingdom.nextMonarch("Danulo");
        System.out.println(kingdom.returnMonarchName());

    }

}
