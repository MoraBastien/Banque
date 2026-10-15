package app.com;

import java.math.BigInteger;
import java.util.Locale;
import java.util.Objects;


record Iban(String value) {
    Iban{
        Objects.requireNonNull(value, "Iban can't be null");
        if (value.isEmpty()) throw new IllegalArgumentException("The Iban is empty");
        value = value.replaceAll("\\h+", "");
        value = value.toUpperCase(Locale.ROOT);
    }
}
