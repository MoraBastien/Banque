package app.com;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;


class IbanTest {

    @Nested
    class Creation {
        @Test
        void accepts_valid_luxembourg_iban() {
            Iban i = new Iban("LU", 23,new BigInteger("280019400644750000"));

        }

        @Test
        void refuse_null_attributes() {
            assertThrows(NullPointerException.class, () -> new Iban(null, 23,new BigInteger("280019400644750000")));
            assertThrows(NullPointerException.class, () -> new Iban(null, 23,null));
        }
    }

    @Nested
    class Normalization {

        @Test
        void accepts_iban_with_spaces(){
            assertDoesNotThrow(() -> new Iban("FR",76,new BigInteger("3000 6000 0112 3456 7890 189")));
        }

        @Test
        void accepts_lowercase_iban(){
            assertDoesNotThrow(() -> new Iban("fr",76,new BigInteger("30006000011234567890189")));
        }

        @Test
        void two_formatted_ibans_are_equal(){
            Iban i1 = new Iban("FR",76,new BigInteger("3000 6000 0112 3456 7890 189"));
            Iban i2 = new Iban("fr",76,new BigInteger("30006000011234567890189"));
            assertEquals(i1,i2);
        }
    }

    @Nested
    class Validation {

    }
}
