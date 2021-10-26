import java.util.Random;

public class Republic extends State {

    private String presidentName;

    Republic(String name, String founded) {
        super(name, founded);
        elections();
    }


    public void elections() {
        Random rand = new Random();
        int index = rand.nextInt(3);
        String[] names = {"president1", "president2", "president3"};
        this.presidentName = names[index];
    }


    public String getPresidentName() {
        return presidentName;
    }
}
