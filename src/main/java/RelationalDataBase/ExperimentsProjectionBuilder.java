package RelationalDataBase;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that builds a projection of experiments table.
 */

public class ExperimentsProjectionBuilder{
    private ExperimentTable baseTable;
    private List<String> attributes =new ArrayList<>();
    private final List<String> allowedAttributes = List.of("NUMBER","DESCRIPTION", "TESTEE NUMBER", "DATE");

    public ExperimentsProjectionBuilder addAttribute(String attribute) {
        if (!attributes.contains(attribute) && allowedAttributes.contains(attribute)) {
            attributes.add(attribute);
        }
        return this;
    }
    public ExperimentsProjectionBuilder removeAttribute(String attribute) {
        attributes.remove(attribute);
        return this;
    }
    public ExperimentsProjectionBuilder setBaseTable(ExperimentTable table) {
        this.baseTable = table;
        return this;
    }

    public ExperimentTable build(){
        ExperimentTable product = (ExperimentTable) baseTable.clone();
        product.clearAttributes();
        for (String attribute : attributes) {
            product.addAttribute(attribute);
        }
        return product;
    }
}
