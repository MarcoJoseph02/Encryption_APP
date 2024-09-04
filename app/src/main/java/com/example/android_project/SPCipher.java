package com.example.android_project;

public class SPCipher
{
    SubstitutionCipher subs;
    PermutationCipher permutation;

    public SPCipher() {
        subs=new SubstitutionCipher();
        permutation =new PermutationCipher();
    }

    public String encryptionSP(String plainText)
    {
        String round1=subs.encryptionSubstitution(plainText);
        String round2=permutation.encryptionPermutation(round1);
        return round2;
    }

    public String decryptionSP(String cipherText)
    {
        String round1=permutation.decryptionPermutation(cipherText);
        String round2= subs.decryptionSubstitution(round1);
        return round2;
    }
}
