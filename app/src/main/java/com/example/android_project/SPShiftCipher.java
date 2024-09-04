package com.example.android_project;

public class SPShiftCipher
{
    SPCipher sp;
    ShiftCipher shiftCipher;

    public SPShiftCipher()
    {
        sp =new SPCipher();
        shiftCipher =new ShiftCipher();
    }
    public String encryptionSP_Shift(String plainText ,int shiftCipherKey)
    {
        String round1=sp.encryptionSP(plainText);
        String round2=shiftCipher.encryptionShift(round1,shiftCipherKey);
        return round2;
    }
    public String decryptionSP_Shift(String cipherText ,int shiftCipherKey)
    {
        String round1=shiftCipher.decryptionShift(cipherText,shiftCipherKey);
        String round2=sp.decryptionSP(round1);
        return round2;
    }
}
