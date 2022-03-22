package com.solvd.practiceqa.util;

import com.qaprosoft.carina.core.foundation.commons.SpecialKeywords;
import com.qaprosoft.carina.core.foundation.crypto.CryptoTool;

import java.util.regex.Pattern;

public class CryptoUtil {

    public static String encryptValue(String value) {
        CryptoTool cryptoTool = new CryptoTool("src/main/resources/crypto.key");
        Pattern CRYPTO_PATTERN = Pattern.compile(SpecialKeywords.CRYPT);
        return cryptoTool.encryptByPattern(value, CRYPTO_PATTERN);
    }

    public static String decryptValue(String value) {
        CryptoTool cryptoTool = new CryptoTool("src/main/resources/crypto.key");
        Pattern CRYPTO_PATTERN = Pattern.compile(SpecialKeywords.CRYPT);
        return cryptoTool.decryptByPattern(value, CRYPTO_PATTERN);
    }
}
