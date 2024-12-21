package RelationalDataBase;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that builds a projection of testee table.
 */

public class ExperimentMembersProjectionBuilder {
    private ExperimentMembersTable baseTable;
    private List<String> attributes =new ArrayList<>();
    private final List<String> allowedAttributes = List.of("TESTEE NUMBER","NAME", "SURNAME", "WEIGHT", "AGE", "BIRTHDAY");

    public ExperimentMembersProjectionBuilder addAttribute(String attribute) {
        if (!attributes.contains(attribute) && allowedAttributes.contains(attribute)) {
            attributes.add(attribute);
        }
        return this;
    }
    public ExperimentMembersProjectionBuilder removeAttribute(String attribute) {
        attributes.remove(attribute);
        return this;
    }
    public ExperimentMembersProjectionBuilder setBaseTable(ExperimentMembersTable table) {
        this.baseTable = table;
        return this;
    }

    public ExperimentMembersTable build(){
        ExperimentMembersTable product = (ExperimentMembersTable) baseTable.clone();
        product.clearAttributes();
        for (String attribute : attributes) {
            product.addAttribute(attribute);
        }
        return product;
    }
}
