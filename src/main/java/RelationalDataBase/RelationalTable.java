package RelationalDataBase;

import java.util.List;

/**
 * An interface for relational tables.
 */

public interface RelationalTable <T> {
    void add(T element);
    void addAttribute(String attribute);
    void remove(int number);
    void removeAttribute(String attribute);
    T getElement(int number);
    void showTable();
    RelationalTable <T> clone ();
    void clearAttributes();

    /**
     * Formats output as table.
     */

    default String formatAsTable(List<List<String>> rows)
    {
        int[] maxLengths = new int[rows.get(0).size()];
        for (List<String> row : rows)
        {
            for (int i = 0; i < row.size(); i++)
            {
                maxLengths[i] = Math.max(maxLengths[i], row.get(i).length());
            }
        }

        StringBuilder formatBuilder = new StringBuilder();
        for (int maxLength : maxLengths)
        {
            formatBuilder.append("%-").append(maxLength + 2).append("s").append("| ");
        }
        String format = formatBuilder.toString();

        StringBuilder result = new StringBuilder();
        for (List<String> row : rows)
        {
            result.append(String.format(format, (Object[]) row.toArray(new String[0]))).append("\n");
        }
        return result.toString();
    }
}
