package RelationalDataBase;

public class ExperimentElementBuilder {
    private String description;
    private int member_number;
    private String date;

    public ExperimentElementBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public ExperimentElementBuilder setMember_number(int member_number) {
        this.member_number = member_number;
        return this;
    }

    public ExperimentElementBuilder setDate(String date) {
        this.date = date;
        return this;
    }

    public ExperimentElement build() {
        return new ExperimentElement(description,member_number,date);
    }
}
