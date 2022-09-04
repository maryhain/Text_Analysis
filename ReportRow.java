package MobyDickNovel;

public class ReportRow {
    private String word;
    private Long count;
	private int max;

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
     
    public int getMaxOccurrence () {
    	return max ;
    
    }
    public void print() {
        System.out.println("Count: [" + getCount() + "] for Word: [" + getWord() + "]");
    }
}

