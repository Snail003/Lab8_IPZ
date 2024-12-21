package RelationalDataBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Class that represents a table with data about experiments.
 */

public class ExperimentTable implements RelationalTable <ExperimentElement> {
    private HashMap<Integer, ExperimentElement> experimentList = new HashMap<>();
    private List<String> attributes = new ArrayList<>(List.of("NUMBER","DESCRIPTION", "TESTEE NUMBER", "DATE"));
    private final List<String> allowedAttributes = List.of("NUMBER","DESCRIPTION", "TESTEE NUMBER", "DATE");

    private int count = 0;

    public ExperimentTable () {
    }

    private ExperimentTable (ExperimentTable prototype) {
        this.experimentList = prototype.experimentList;
        this.attributes = prototype.attributes;
        this.count = prototype.count;
    }

    /**
     * Method to add data about experiment to table.
     */

    @Override
    public void add(ExperimentElement element) {
        experimentList.put(count++, element);
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
     * Method to remove data about experiment from table.
     */

    @Override
    public void remove(int number) {
        experimentList.remove(number);
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
     * Method to get data about certain experiment by its number.
     */

    @Override
    public ExperimentElement getElement(int number) {
        return experimentList.getOrDefault(number, null);
    }

    /**
     * Method to print out table to client.
     */

    @Override
    public void showTable() {
        List<List<String>> rows = new ArrayList<>();
        rows.add(attributes);
        for (HashMap.Entry<Integer, ExperimentElement> entry : experimentList.entrySet()) {
            List<String> row = new ArrayList<>(List.of());
            if (attributes.contains("NUMBER")) {
                row.add(entry.getKey().toString());
            }
            if (attributes.contains("DESCRIPTION")) {
                row.add(entry.getValue().getDescription());
            }
            if (attributes.contains("TESTEE NUMBER")) {
                row.add(String.valueOf(entry.getValue().getMember_number()));
            }
            if (attributes.contains("DATE")) {
                row.add(entry.getValue().getDate());
            }
            rows.add(row);
        }
        System.out.println(formatAsTable(rows));
    }

    /**
     * Method to clone this class.
     */

    @Override
    public RelationalTable<ExperimentElement> clone() {
        return new ExperimentTable(this);
    }
}
