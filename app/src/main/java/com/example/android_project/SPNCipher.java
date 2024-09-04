package com.example.android_project;

import java.util.ArrayList;

public class SPNCipher {
    private static final int[] substitutionBox = { 0xE, 0x4, 0xD, 0x1, 0x2, 0xF, 0xB, 0x8, 0x3, 0xA, 0x6, 0xC, 0x5, 0x9, 0x0, 0x7 };
    private static final int[] substitutionBoxInverse = { 0xE, 0x3, 0x4, 0x8, 0x1, 0xC, 0xA, 0xF, 0x7, 0xD, 0x9, 0x6, 0xB, 0x2, 0x0, 0x5 };
    private static final int[] permutationBox = { 0, 4, 8, 12, 1, 5, 9, 13, 2, 6, 10, 14, 3, 7, 11, 15 };

    static ArrayList<Integer> generateRoundKeys(int masterKey) {
        ArrayList<Integer> roundKeys = new ArrayList<>();
        for (int i = 0; i < 11; ++i) {
            masterKey = ((masterKey << 1) | (masterKey >> 15)) & 0xFFFF; // Circular left shift
            roundKeys.add(masterKey);
        }
        return roundKeys;
    }

    public static int convertStringToHexaDecimal(String inputString) {
        int output = 0;
        StringBuilder hexBuilder = new StringBuilder();
        for (char c : inputString.toCharArray()) {
            // Get the ASCII value of the character and convert it to hexadecimal
            String hexValue = Integer.toHexString(c);
            // Append the hexadecimal value to the StringBuilder
            hexBuilder.append(hexValue.toUpperCase().charAt(1));
        }
        try {
            output = Integer.parseInt(hexBuilder.toString(), 16);
            return output;
        } catch (Exception e) {
            // Handle the exception properly, if needed
        }
        return output;
    }

    public static String convertHexDecimalToString(String hexaDecimalString, String inputString) {

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < hexaDecimalString.length(); i++) {
            // Get each pair of hexadecimal characters
            String hexaDecimalPair;
            if (inputString.charAt(i) >= '@' && inputString.charAt(i) <= 'O')
                hexaDecimalPair = "4" + hexaDecimalString.charAt(i);
            else
                hexaDecimalPair = "5" + hexaDecimalString.charAt(i);
            // Convert the hexadecimal pair to integer
            int decimalValue = Integer.parseInt(hexaDecimalPair, 16);
            // Convert the integer to its corresponding character
            char c = (char) decimalValue;
            // Append the character to the StringBuilder
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    static String encrypt(String plainTextString, ArrayList<Integer> allRoundKeys) {
        int plaintext = convertStringToHexaDecimal(plainTextString);

        int x = plaintext;
        int y = 0;
        for (int k = 0; x != 0; k++) {
            plaintext ^= allRoundKeys.get(0);

            for (int i = 0; i < allRoundKeys.size() - 2; ++i) {
                // Substitution (S-box)
                int sBoxOutput = 0;
                for (int j = 0; j < 4; ++j) {
                    int nibble = (plaintext >> (j * 4)) & 0xF;
                    sBoxOutput |= substitutionBox[nibble] << (j * 4);
                }

                // Permutation (P-box)
                int pBoxOutput = 0;
                for (int j = 0; j < 16; j++) {
                    if ((sBoxOutput & (1 << j)) != 0) {
                        pBoxOutput |= (1 << permutationBox[j]);
                    }
                }

                // Key addition
                plaintext = pBoxOutput ^ allRoundKeys.get(i + 1);
            }

            int sBoxOutput = 0;
            for (int j = 0; j < 4; ++j) {
                int nibble = (plaintext >> (j * 4)) & 0xF;
                sBoxOutput |= substitutionBox[nibble] << (j * 4);
            }
            plaintext = sBoxOutput ^ allRoundKeys.get(allRoundKeys.size() - 1);

            y |= plaintext << (k * 16);
            x >>= 16;
        }

        return convertHexDecimalToString(Integer.toHexString(y), plainTextString);
    }

    static String decryptSPN(String cipherTextString, ArrayList<Integer> allRoundKeys) {
        int ciphertext = convertStringToHexaDecimal(cipherTextString);

        int x = ciphertext;
        int y = 0;
        for (int k = 0; x != 0; k++) {
            ciphertext ^= allRoundKeys.get(allRoundKeys.size() - 1);

            int sBoxOutput = 0;
            for (int j = 0; j < 4; ++j) {
                int nibble = (ciphertext >> (j * 4)) & 0xF;
                sBoxOutput |= substitutionBoxInverse[nibble] << (j * 4);
            }

            ciphertext = sBoxOutput;

            for (int i = allRoundKeys.size() - 2; i > 0; i--) {
                // Key addition
                ciphertext ^= allRoundKeys.get(i);

                // Inverse permutation (P-box)
                int pBoxOutput = 0;
                for (int j = 0; j < 16; ++j) {
                    if ((ciphertext & (1 << j)) != 0) {
                        pBoxOutput |= (1 << permutationBox[j]);
                    }
                }

                // Inverse substitution (S-box)
                sBoxOutput = 0;
                for (int j = 0; j < 4; ++j) {
                    int nibble = (pBoxOutput >> (j * 4)) & 0xF;
                    sBoxOutput |= substitutionBoxInverse[nibble] << (j * 4);
                }

                ciphertext = sBoxOutput;
            }
            ciphertext ^= allRoundKeys.get(0);

            y |= ciphertext << (k * 16);
            x >>= 16;
        }

        return convertHexDecimalToString(Integer.toHexString(y), cipherTextString);
    }

    private static int plainTextSize = 0;

    public static String encryptMessage(String plainText, int masterKey) {
        if (masterKey > 999999999)
            return "Out of Range";

        ArrayList<Integer> roundKeys = generateRoundKeys(masterKey);
        plainTextSize = plainText.length();
        plainText = plainText.toUpperCase();
        while (plainText.length() % 4 != 0)
            plainText += '_';

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < plainText.length(); i += 4) {
            String block = plainText.substring(i, i + 4);
            block = encrypt(block, roundKeys);
            builder.append(block);
        }

        return builder.toString();
    }
    public static String decryptMessage(String cipherText, int masterKey) {
        if (masterKey > 999999999)
            return "Out of Range";

        ArrayList<Integer> roundKeys = generateRoundKeys(masterKey);
        cipherText = cipherText.toUpperCase();
        while (cipherText.length() % 4 != 0)
            cipherText += '_';

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < cipherText.length(); i += 4) {
            String block = cipherText.substring(i, i + 4);
            block = decryptSPN(block, roundKeys);
            builder.append(block);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < plainTextSize; i++) {
            stringBuilder.append(builder.charAt(i));
        }
        return stringBuilder.toString();
    }
}