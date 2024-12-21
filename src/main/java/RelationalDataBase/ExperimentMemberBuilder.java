package RelationalDataBase;

/**
 * A class that builds a testee data class.
 */

public class ExperimentMemberBuilder {
    private String name;
    private String surname;
    private float weight;
    private int age;
    private String birthday;


    public ExperimentMemberBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ExperimentMemberBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public ExperimentMemberBuilder setWeight(float weight) {
        this.weight = weight;
        return this;
    }

    public ExperimentMemberBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public ExperimentMemberBuilder setBirthday(String birthday) {
        this.birthday = birthday;
        return this;
    }

    public ExperimentMember build(){
        return new ExperimentMember(name,surname,weight,age,birthday);
    }
}
