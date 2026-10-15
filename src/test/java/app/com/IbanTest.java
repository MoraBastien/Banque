package app.com;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


class IbanTest {
    String luxIban = "LU280019400644750000";
    @Nested
    class Creation {
        @Test
        void accepts_valid_luxembourg_iban() {
            assertEquals(luxIban, new Iban("LU280019400644750000").value());
        }

        @Test
        void rejects_null_iban() {
            assertThrows(NullPointerException.class, () -> new Iban(null));
        }
    }

    @Nested
    class Normalization {

        @Test
        void normalize_iban_with_spaces(){
            Iban i = new Iban("LU28 0019 4006 4475 0000");
            assertEquals(luxIban,i.value());
        }

        @Test
        void normalize_iban_with_lowercase(){
            Iban i = new Iban("LU280019400644750000");
            assertEquals(luxIban,i.value());
        }

        @Test
        void two_formatted_ibans_are_equal(){
            Iban i1 = new Iban("LU28 0019 4006 4475 0000");
            Iban i2 = new Iban("lu280019400644750000");
            assertEquals(i1,i2);
        }
    }

    @Nested
    class Validation {
        @Test
        void rejects_empty_iban() {
            assertThrows(IllegalArgumentException.class, () -> new Iban(""));
        }

    }
}
