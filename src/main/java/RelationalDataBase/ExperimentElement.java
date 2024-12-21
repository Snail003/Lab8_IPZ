package RelationalDataBase;

/**
 * A class that represents data about experiment.
 */

public class ExperimentElement {
    private String description;
    private int member_number;
    private String date;

    public ExperimentElement(String description, int member_number, String date) {
        this.description = description;
        this.member_number = member_number;
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public int getMember_number() {
        return member_number;
    }

    public String getDate() {
        return date;
    }
}
