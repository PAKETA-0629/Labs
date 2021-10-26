public record DBInstance<T>(T instance, int id) {

    public T getInstance() {
        return instance;
    }


    public int getId() {
        return id;
    }
}
