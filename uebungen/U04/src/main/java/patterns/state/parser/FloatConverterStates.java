package patterns.state.parser;

public enum FloatConverterStates implements FloatConverterState {
    Error,
    S0 {
        @Override
        public FloatConverterState handleDigit(FloatConverterContext context, int value) {
            context.setM(value);
            return S1;
        }

        @Override
        public FloatConverterState onDot(FloatConverterContext context) {
            return S2;
        }
    },
    S1 {
        @Override
        public FloatConverterState handleDigit(FloatConverterContext context, int value) {
            context.setM(10 * context.getM() + value);
            return S1;
        }

        @Override
        public FloatConverterState onDot(FloatConverterContext context) {
            return S3;
        }

        @Override
        public FloatConverterState one(FloatConverterContext context) {
            return S4;
        }

        @Override
        public FloatConverterState onE(FloatConverterContext context) {
            return S4;
        }
    }, S2 {
        @Override
        public FloatConverterState handleDigit(FloatConverterContext context, int value) {
            context.setM(context.getM() + value / context.getQuo());
            context.setQuo(context.getQuo() * 10);
            return S3;
        }
    }, S3 {
        @Override
        public FloatConverterState handleDigit(FloatConverterContext context, int value) {
            context.setM(context.getM() + value / context.getQuo());
            context.setQuo(context.getQuo() * 10);
            return S3;
        }

        @Override
        public FloatConverterState one(FloatConverterContext context) {
            return S4;
        }

        @Override
        public FloatConverterState onE(FloatConverterContext context) {
            return S4;
        }
    }, S4 {
        @Override
        public FloatConverterState onPlus(FloatConverterContext context) {
            return S5;
        }

        @Override
        public FloatConverterState onMinus(FloatConverterContext context) {
            context.setExp_sign(-1);
            return S5;
        }

        @Override
        public FloatConverterState handleDigit(FloatConverterContext context, int value) {
            context.setExp(value);
            return S6;
        }
    }, S5 {
        @Override
        public FloatConverterState handleDigit(FloatConverterContext context, int value) {
            context.setExp(value);
            return S6;
        }
    }, S6 {
        @Override
        public FloatConverterState handleDigit(FloatConverterContext context, int value) {
            context.setExp(10 * context.getExp() + value);
            return S6;
        }
    };

    @Override
    public FloatConverterState handleDigit(FloatConverterContext context, int value) {
        return Error;
    }

    @Override
    public FloatConverterState onDot(FloatConverterContext context) {
        return Error;
    }

    @Override
    public FloatConverterState one(FloatConverterContext context) {
        return Error;
    }

    @Override
    public FloatConverterState onE(FloatConverterContext context) {
        return Error;
    }

    @Override
    public FloatConverterState onPlus(FloatConverterContext context) {
        return Error;
    }

    @Override
    public FloatConverterState onMinus(FloatConverterContext context) {
        return Error;
    }
}
