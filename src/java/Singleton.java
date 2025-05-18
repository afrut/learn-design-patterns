public class Singleton {

    // Reference to the single instance of the class
    private static Singleton instance;

    // Some data for this class
    private int id;
    private String name;

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    // the private constructor for this class
    private Singleton(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Method to get the single instance of the class
    public static Singleton getInstance(int id, String name) {
        if (instance == null) {
            instance = new Singleton(id, name);
        }
        return instance;
    }

    public static void main(String[] args) {
        Singleton x = Singleton.getInstance(1, "Singleton");
        Singleton y = Singleton.getInstance(2, "Singleton2");
        // Check to see if x and y refer to the same object
        System.out.println("x == y: " + (x == y));
        System.out.println("x.id == y.id: " + String.valueOf(x.getId() == y.getId()));
        System.out.println("x.name == y.name: " + String.valueOf(x.getName() == y.getName()));
    }
}