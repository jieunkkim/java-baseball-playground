package study;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final Pattern numberPattern = Pattern.compile("^[0-9]*?");
    private static final Map<String, BinaryOperator<Integer>> functionByOperator = new HashMap<String,
            BinaryOperator<Integer>>() {{
        put("+", Integer::sum);
        put("-", (i, j) -> i - j);
        put("*", (i, j) -> i * j);
        put("/", (i, j) -> i / j);
    }};


    public int calculate(String request) {
        if (StringUtils.isEmpty(request)) {
            return 0;
        }

        String[] values = request.split(" ");
        checkValues(values);
        return operate(values);
    }

    private int operate(String[] values) {
        int result = Integer.parseInt(values[0]);
        for (int i = 1; i < values.length - 1; i++) {
            if (functionByOperator.containsKey(values[i])) {
                result = functionByOperator.get(values[i]).apply(result, Integer.valueOf(values[i + 1]));
            }
        }
        return result;
    }

    private void checkValues(String[] values) {
        boolean result = true;
        for (int i = 0; i < values.length; i++) {
            result = i % 2 == 0 ?
                    numberPattern.matcher(values[i]).matches()
                    : functionByOperator.containsKey(values[i]);
            if (!result) {
                throw new IllegalArgumentException();
            }
        }
    }
}
