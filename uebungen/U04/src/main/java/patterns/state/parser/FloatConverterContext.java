package patterns.state.parser;

public class FloatConverterContext {
    private double m =0;
    private int exp =0;
    private int exp_sign = -1;
    private double quo = 0;

    public double getM() {
        return m;
    }

    public void setM(double m) {
        this.m = m;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getExp_sign() {
        return exp_sign;
    }

    public void setExp_sign(int exp_sign) {
        this.exp_sign = exp_sign;
    }

    public double getQuo() {
        return quo;
    }

    public void setQuo(double quo) {
        this.quo = quo;
    }
}
