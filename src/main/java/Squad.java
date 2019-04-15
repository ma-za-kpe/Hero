import java.util.ArrayList;

public class Squad {

    private String name;
    private String cause;
    private static ArrayList<Squad> instances = new ArrayList<>(); // I’m new. When do I get created?
    private int id;
    private ArrayList<Hero> heroes;

    public Squad(String name, String cause) {
        this.name = name;
        this.cause = cause;
        instances.add(this);
        this.id = instances.size();
        heroes = new ArrayList<Hero>();
    }

    public String getName() {
        return name;
    }

    //return all heroes
    public static ArrayList<Squad> getAllSquad(){
        return instances;
    }

    public String getCause() {
        return cause;
    }

    public static void clearAllSquad(){
        instances.clear();
    }

    public int getId() {
        return id;
    }

    public static Squad findById(int id){
        return instances.get(id-1); //why minus 1? See if you can figure it out.
        //id-1 stands for the index of the element in the arraylist while id is the element in the array(the instance.size())
    }

    public ArrayList<Hero> getHeroes() {
        return heroes;
    }

    public void addHero(Hero hero) {
        heroes.add(hero);
    }

    public void update(String name, String cause) {
        this.name = name;
        this.cause = cause;
    }

    public void deleteSquad(){
        instances.remove(id-1); //same reason
    }

}
