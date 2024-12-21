package RelationalDataBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExperimentMembersTable implements RelationalTable <ExperimentMember>{
    private HashMap<Integer, ExperimentMember> experimentMembers = new HashMap<>();
    private List<String> attributes = new ArrayList<>(List.of("TESTEE NUMBER","NAME", "SURNAME", "WEIGHT", "AGE", "BIRTHDAY"));
    final private List<String> allowedAttributes = List.of("TESTEE NUMBER","NAME", "SURNAME", "WEIGHT", "AGE", "BIRTHDAY");

    private int count = 0;

    public ExperimentMembersTable(){
    }

    private ExperimentMembersTable (ExperimentMembersTable prototype) {
        this.experimentMembers = prototype.experimentMembers;
        this.attributes = prototype.attributes;
        this.count = prototype.count;
    }

    @Override
    public void add(ExperimentMember element) {
        experimentMembers.put(count++, element);
    }

    @Override
    public void addAttribute(String attribute) {
        if (!attributes.contains(attribute) && allowedAttributes.contains(attribute)) {
            attributes.add(attribute);
        }
    }

    @Override
    public void remove(int number) {
        experimentMembers.remove(number);
    }

    @Override
    public void removeAttribute(String attribute) {
        if (attributes.contains(attribute) && allowedAttributes.contains(attribute)) {
            attributes.remove(attribute);
        }
    }

    @Override
    public void clearAttributes() {
        attributes.clear();
    }

    @Override
    public ExperimentMember getElement(int number) {
        return experimentMembers.getOrDefault(number, null);
    }

    @Override
    public void showTable() {
        List<List<String>> rows = new ArrayList<>();
        rows.add(attributes);
        for (HashMap.Entry<Integer, ExperimentMember> entry : experimentMembers.entrySet()) {
            List<String> row = new ArrayList<>();
            if (attributes.contains("TESTEE NUMBER")) {
                row.add(entry.getKey().toString());
            }
            if (attributes.contains("NAME")) {
                row.add(entry.getValue().getName());
            }
            if (attributes.contains("SURNAME")) {
                row.add(entry.getValue().getSurname());
            }
            if (attributes.contains("WEIGHT")) {
                row.add(String.valueOf(entry.getValue().getWeight()));
            }
            if (attributes.contains("AGE")) {
                row.add(String.valueOf(entry.getValue().getAge()));
            }
            if (attributes.contains("BIRTHDAY")) {
                row.add(entry.getValue().getBirthday());
            }
            rows.add(row);
        }
        System.out.println(formatAsTable(rows));
    }

    @Override
    public RelationalTable<ExperimentMember> clone() {
        return new ExperimentMembersTable(this);
    }
}
