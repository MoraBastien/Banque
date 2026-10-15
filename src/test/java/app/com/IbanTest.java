package app.com;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


class IbanTest {

    @Nested
    class Creation {
        @Test
        void accepts_valid_luxembourg_iban() {
            assertDoesNotThrow(() -> new Iban("LU280019400644750000"));
        }

        @Test
        void reject_null_iban() {
            assertThrows(NullPointerException.class, () -> new Iban(null));
        }
    }

    @Nested
    class Normalization {

        @Test
        void accepts_iban_with_spaces(){
            Iban i1 = new Iban("LU280019400644750000");
            Iban i2 = new Iban("LU28 0019 4006 4475 0000");
            assertEquals(i1.value(),i2.value());
        }

        @Test
        void accepts_iban_with_lowercase(){
            Iban i1 = new Iban("lu280019400644750000");
            Iban i2 = new Iban("LU280019400644750000");
            assertEquals(i1.value(),i2.value());
        }

        @Test
        void two_formatted_ibans_are_equal(){
            Iban i1 = new Iban("LU28 0019 4006 4475 0000");
            Iban i2 = new Iban("lu280019400644750000");
            assertEquals(i1.value(),i2.value());
        }
    }

    @Nested
    class Validation {
        @Test
        void reject_empty_iban() {
            assertThrows(IllegalArgumentException.class, () -> new Iban(""));
        }

    }
}
