package com.example.android_project;

public class AffineCipher extends DataInfo
{
    public AffineCipher()
    {
        super();
    }
    public String encryptionAffine(String plainText ,int a ,int b)// c=a*m+b
    {
        String cipherText="";
        char tempChar;
        int charCode;
        if(getInverse(a,94)!=-1)
        {
            for (int i = 0; i <plainText.length() ; i++) {
                tempChar=plainText.charAt(i);
                if(super.checkCharacter(tempChar))
                {
                    charCode=((super.getIndex(tempChar)*a)+b)%94;
                    if(charCode<0)
                    {
                        charCode+=94;
                    }
                    tempChar=characters[charCode];
                }
                cipherText+=tempChar;
            }
        }
        return cipherText;
    }
    public String decryptionAffine(String cipherText ,int a ,int b)// m=(c-b)*inverse(a)
    {
        String plainText="";
        char tempChar;
        int charCode;
        if(getInverse(a,94)!=-1)
        {
            for (int i = 0; i <cipherText.length() ; i++) {
                tempChar=cipherText.charAt(i);
                if(super.checkCharacter(tempChar))
                {
                    charCode=( (super.getIndex(tempChar)-b)*super.getInverse(a,94) )%94;
                    if(charCode<0)
                    {
                        charCode+=94;
                    }
                    tempChar=characters[charCode];
                }
                plainText+=tempChar;
            }
        }
        return plainText;
    }
}
