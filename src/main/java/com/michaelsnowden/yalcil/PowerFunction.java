package com.michaelsnowden.yalcil;

import org.apfloat.Apfloat;
import org.apfloat.ApfloatMath;

import java.math.BigDecimal;
import java.util.List;

import static com.michaelsnowden.yalcil.RuntimeType.DECIMAL;
import static com.michaelsnowden.yalcil.RuntimeType.INT;

/**
 * Created by michael.snowden on 5/7/16.
 */
public class PowerFunction extends AbstractFunction {
    public static final PowerFunction INSTANCE = new PowerFunction();

    @Override
    public RuntimeObject computeResult(StackFrame lookup, List<RuntimeObject> args) {
        if (args.size() != 2) {
            throw new RuntimeException("Power is a two argument function: " + args);
        }

        RuntimeObject a = args.get(0);
        RuntimeObject b = args.get(1);

        RuntimeType at = a.getType();
        RuntimeType bt = b.getType();
        if (at == INT && bt == INT) {
            return new IntObject(a.asInt(lookup).pow(b.asInt(lookup).intValue()));
        } else if (at == INT && bt == DECIMAL) {
            final Apfloat z = new Apfloat(a.asInt(lookup).intValue());
            final Apfloat w = new Apfloat(b.asDecimal(lookup).doubleValue());
            final Apfloat pow = ApfloatMath.pow(z, w);
            final BigDecimal bigDecimal = new BigDecimal(pow.toString());
            return new DecimalObject(bigDecimal);
        } else if (at == DECIMAL && bt == INT) {
            final Apfloat z = new Apfloat(a.asDecimal(lookup).doubleValue());
            final Apfloat w = new Apfloat(b.asInt(lookup).intValue());
            final Apfloat pow = ApfloatMath.pow(z, w);
            final BigDecimal bigDecimal = new BigDecimal(pow.toString());
            return new DecimalObject(bigDecimal);
        } else if (at == DECIMAL && bt == DECIMAL) {
            final Apfloat z = new Apfloat(a.asDecimal(lookup).doubleValue());
            final Apfloat w = new Apfloat(b.asDecimal(lookup).doubleValue());
            final Apfloat pow = ApfloatMath.pow(z, w);
            final BigDecimal bigDecimal = new BigDecimal(pow.toString());
            return new DecimalObject(bigDecimal);
        } else {
            throw new UnsupportedOperationException(String.format("Cannot multiply types %s and %s", at, bt));
        }
    }
}
