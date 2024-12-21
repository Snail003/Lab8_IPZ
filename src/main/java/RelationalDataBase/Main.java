package RelationalDataBase;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ExperimentTable experiments = new ExperimentTable();
        ExperimentMembersTable members = new ExperimentMembersTable();
        ExperimentElement experiment = new ExperimentElementBuilder()
                .setDescription("Testee intelligence test")
                .setMember_number(3)
                .setDate("12.04.2010")
                .build();
        ExperimentElement experiment2 = new ExperimentElementBuilder()
                .setDescription("Transplant parts of controllers brain to human one")
                .setMember_number(0)
                .setDate("25.07.2011")
                .build();
        experiments.add(experiment);
        experiments.add(experiment2);
        ExperimentMember member1 = new ExperimentMemberBuilder()
                .setName("Faust")
                .setSurname("Unknown")
                .setWeight(75)
                .setAge(50)
                .setBirthday("12.05.1961")
                .build();
        ExperimentMember member2 = new ExperimentMemberBuilder()
                .setName("Borzoi")
                .setSurname("Unknown")
                .setWeight(63)
                .setAge(45)
                .setBirthday("12.05.1966")
                .build();
        members.add(member1);
        members.add(member2);
        experiments.showTable();
        members.showTable();
        experiments.remove(0);
        experiments.showTable();
        ExperimentMembersTable projectionMembers = new ExperimentMembersProjectionBuilder()
                .setBaseTable(members)
                .addAttribute("NAME")
                .addAttribute("SURNAME")
                .addAttribute("WEIGHT")
                .build();
        projectionMembers.showTable();
    }
}