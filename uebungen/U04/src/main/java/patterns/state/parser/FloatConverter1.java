package patterns.state.parser;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FloatConverter1 {

    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String s = r.readLine();
        while (s != null && s.length() > 0) {
            try {
                double d = parseFloat(s);
                System.out.println(d);
            } catch (IllegalArgumentException e) {
                System.out.println("Illegal Format");
            }
            s = r.readLine();
        }
    }

    private static boolean isDigit(char ch) {
        return Character.isDigit(ch);
    }

    private static int getNumericValue(char ch) {
        return Character.getNumericValue(ch);
    }

    private static double parseFloat(String str) {
        FloatConverterContext context = new FloatConverterContext();
        FloatConverterState state = FloatConverterStates.S0;

        int position = 0;
        while (state != FloatConverterStates.Error && position < str.length()) {
            char ch = str.charAt(position++);
            if (ch == '+') {
                state = state.onPlus(context);
            } else if (ch == '-') {
                state = state.onMinus(context);
            } else if (isDigit(ch)) {
                state = state.handleDigit(context, getNumericValue(ch));
            } else if (ch == '.') {
                state = state.onDot(context);
            } else if (ch == 'e') {
                state = state.one(context);
            } else if (ch == 'E') {
                state = state.onE(context);
            } else {
                state = FloatConverterStates.Error;
            }
        }
        if (state == FloatConverterStates.S3 || state == FloatConverterStates.S6) {
            return context.getM() * Math.pow(10, context.getExp_sign() * context.getExp());
        } else {
            throw new IllegalArgumentException();
        }
    }

}
