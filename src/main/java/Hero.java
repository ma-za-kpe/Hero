import java.util.ArrayList;

public class Hero {
    private String name;
    private String specialSkill;
    private String weakness;
    private int age = 0;
    private static ArrayList<Hero> instances = new ArrayList<>(); // I’m new. When do I get created?
    private int id;

    public Hero (String name, String specialSkill, String weakness, int age){
    this.name = name;
    this.specialSkill = specialSkill;
    this.weakness = weakness;
    this.age =age;
    instances.add(this);
    this.id = instances.size();
    }

    public String getName() {
        return name;
    }

    public String getSpecialSkill() {
        return specialSkill;
    }

    public String getWeakness() {
        return weakness;
    }

    public int getAge() {
        return age;
    }

    //return all heroes
    public static ArrayList<Hero> getAllHeroes(){
        return instances;
    }

    public static void clearAllHeroes(){
        instances.clear();
    }

    public int getId() {
        return id;
    }

    public static Hero findById(int id){
        return instances.get(id-1); //why minus 1? See if you can figure it out.
    //id-1 stands for the index of the element in the arraylist while id is the element in the array(the instance.size())
    }

}
