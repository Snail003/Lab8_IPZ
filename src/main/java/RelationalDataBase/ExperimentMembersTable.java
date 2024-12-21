package RelationalDataBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Class that represents a table with data about testees.
 */

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

    /**
     * Method to add data about testee to table.
     */

    @Override
    public void add(ExperimentMember element) {
        experimentMembers.put(count++, element);
    }

    /**
     * Method to add attribute to table.
     */

    @Override
    public void addAttribute(String attribute) {
        if (!attributes.contains(attribute) && allowedAttributes.contains(attribute)) {
            attributes.add(attribute);
        }
    }

    /**
     * Method to remove data about testee from table.
     */

    @Override
    public void remove(int number) {
        experimentMembers.remove(number);
    }

    /**
     * Method to remove attribute from table.
     */

    @Override
    public void removeAttribute(String attribute) {
        if (attributes.contains(attribute) && allowedAttributes.contains(attribute)) {
            attributes.remove(attribute);
        }
    }

    /**
     * Method to clear all attributes.
     */

    @Override
    public void clearAttributes() {
        attributes.clear();
    }

    /**
     * Method to get data about certain testee by its number.
     */

    @Override
    public ExperimentMember getElement(int number) {
        return experimentMembers.getOrDefault(number, null);
    }

    /**
     * Method to print out table to client.
     */

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

    /**
     * Method to clone this class.
     */

    @Override
    public RelationalTable<ExperimentMember> clone() {
        return new ExperimentMembersTable(this);
    }
}
