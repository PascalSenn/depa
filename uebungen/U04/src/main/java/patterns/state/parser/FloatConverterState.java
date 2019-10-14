package patterns.state.parser;

import java.awt.image.renderable.ContextualRenderedImageFactory;

public interface FloatConverterState {
    FloatConverterState handleDigit(FloatConverterContext context, int value);

    FloatConverterState onDot(FloatConverterContext context);

    FloatConverterState one(FloatConverterContext context);

    FloatConverterState onE(FloatConverterContext context);

    FloatConverterState onPlus(FloatConverterContext context);

    FloatConverterState onMinus(FloatConverterContext context);
}

