public abstract class Monarchy extends State {


    private String monarchName;

    Monarchy(String name, String founded, String monarchName) {
        super(name, founded);
        this.monarchName = monarchName;
    }


    public void nextMonarch(String monarchName) {
        this.monarchName = monarchName;
    }


    public String returnMonarchName() {
        return monarchName;
    }
}
