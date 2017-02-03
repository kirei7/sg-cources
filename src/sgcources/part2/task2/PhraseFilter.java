package sgcources.part2.task2;

import sgcources.part2.task2.program.Filter;
import sgcources.part2.task2.program.QuakeEntry;

public class PhraseFilter implements Filter {

    //I bet it should be Enum
    private final String requestType;
    private final String phrase;

    public PhraseFilter(String requestType, String phrase) {
        this.requestType = requestType;
        this.phrase = phrase;
    }
    public String getRequestType() {
        return requestType;
    }
    public String getPhrase() {
        return phrase;
    }

    @Override
    public boolean satisfies(QuakeEntry qe) {
        switch (getRequestType()) {
            case "start":
                    if (qe.getInfo().startsWith(getPhrase()))
                        return true;
            case "end":
                    if (qe.getInfo().endsWith(getPhrase()))
                        return true;
            case "any":
                    if (qe.getInfo().contains(getPhrase()))
                        return true;
        }
        return false;
    }
}
