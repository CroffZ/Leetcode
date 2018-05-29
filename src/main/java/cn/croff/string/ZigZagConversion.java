package cn.croff.string;

/**
 * 6. ZigZag Conversion
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * string convert(string s, int numRows);
 * <p>
 * Example 1:
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 */
public class ZigZagConversion {

    public String convert(String s, int numRows) {
        if (numRows > 1) {
            int cycle = (numRows - 1) * 2;
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < numRows; i++) {
                if (i == 0) {
                    // 第一行
                    for (int j = 0; j < s.length(); j += cycle) {
                        result.append(s.charAt(j));
                    }
                } else if (i == numRows - 1) {
                    // 最后一行
                    for (int j = cycle / 2; j < s.length(); j += cycle) {
                        result.append(s.charAt(j));
                    }
                } else {
                    // 其他
                    for (int j = 0; j < s.length(); j += cycle) {
                        int index1 = j + i, index2 = j + cycle - i;
                        if (index1 < s.length()) {
                            result.append(s.charAt(index1));
                        }
                        if (index2 < s.length()) {
                            result.append(s.charAt(index2));
                        }
                    }
                }
            }
            return result.toString();
        } else {
            return s;
        }
    }
}
