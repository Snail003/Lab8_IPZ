package RelationalDataBase;

public class ExperimentMember {
    private String name;
    private String surname;
    private float weight;
    private int age;
    private String birthday;

    public ExperimentMember(String name, String surname, float weight, int age, String birthday) {
        this.name = name;
        this.surname = surname;
        this.weight = weight;
        this.age = age;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public float getWeight() {
        return weight;
    }

    public int getAge() {
        return age;
    }

    public String getBirthday() {
        return birthday;
    }
}
