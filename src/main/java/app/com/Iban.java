package app.com;

import java.math.BigInteger;


record Iban(String countryCode,int controleKey, BigInteger bban) {

}
