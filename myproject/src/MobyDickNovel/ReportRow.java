package MobyDickNovel;

public class ReportRow {
    private String word;
    private Long count;

    public ReportRow(String word, Long count) {
        this.word = word;
        this.count = count;
    }

    public Long getCount() {
        return count;
    }

    public String getWord() {
        return word;
    }

    public void print() {
        System.out.println("Count: [" + getCount() + "] for Word: [" + getWord() + "]");
    }
}

