import java.math.BigDecimal;

public class ArithmeticCoding {

    private LetterTable lt;
    private int lenText;
    private Interval[] intervals;

    public BigDecimal code(String text) {

        lenText = text.length();
        lt = new LetterTable(text);

        IntervalTable it = new IntervalTable() {
            @Override
            public Interval[] defineTable(char[] letters, BigDecimal[] values) {
                Interval[] intervals = new Interval[letters.length];
                BigDecimal l = new BigDecimal(0);
                for (int i = 0; i < intervals.length; i++) {
                    Interval interval = new Interval();
                    intervals[i] = interval;
                    intervals[i].left = l;
                    intervals[i].right = l.add(values[i]);
                    intervals[i].aChar = letters[i];
                    l = intervals[i].right;
                }
                return intervals;
            }
        };

        this.intervals = it.defineTable(lt.getLetters(), lt.getValues());
        BigDecimal left = new BigDecimal(0);
        BigDecimal right = new BigDecimal(1);

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            BigDecimal newRight = left.add((right.subtract(left)).multiply(intervals[searchLetterInIntervals(lt.getLetters(), ch)].right));
            BigDecimal newLeft = left.add((right.subtract(left)).multiply(intervals[searchLetterInIntervals(lt.getLetters(), ch)].left));
            right = newRight;
            left = newLeft;
        }
        return (left.add(right)).divide(new BigDecimal(2));
    }

    public String decode(BigDecimal code) {

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < lenText; i++) {
            for(int j = 0; j < intervals.length; j++) {
                if (code.equals(intervals[j].left.max(code)) && code.equals(intervals[j].right.min(code))) {
                    stringBuilder.append(intervals[j].aChar);
                    code = (code.subtract(intervals[j].left)).divide(intervals[j].right.subtract(intervals[j].left));
                    break;
                }
            }
        }

        return stringBuilder.toString();
    }

    private static int searchLetterInIntervals(char[] letters, char ch) {

        for (int i = 0; i < letters.length; i++) {
            if (letters[i] == ch) return i;
        }
        return -1;
    }
}

interface IntervalTable {

    Interval[] defineTable(char[] letters, BigDecimal[] values);
}

