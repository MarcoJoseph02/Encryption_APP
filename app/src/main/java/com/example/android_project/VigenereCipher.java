package com.example.android_project;

public class VigenereCipher extends DataInfo
{
    VigenereCipher()
    {
        super();
    }

    public  String encryptionVigenere(String plaintext, String keyword)
    {
        String cipherText="";
        char tempChar;
        int charCode;
        int keywordCounter=-1;
        for (int i = 0; i <plaintext.length() ; i++) {
            tempChar=plaintext.charAt(i);
            if(super.checkCharacter(tempChar))
            {
                keywordCounter++;
                if(keywordCounter>=keyword.length())
                {
                    keywordCounter=0;
                }
                charCode=(super.getIndex(keyword.charAt(keywordCounter))+super.getIndex(tempChar))%94;
                if(charCode<0)
                {
                    charCode+=94;
                }
                tempChar=characters[charCode];

            }
            cipherText+=tempChar;
        }
        return cipherText;
    }
    public  String decryptionVigenere(String cipherText, String keyword)
    {
        String plainText="";
        char tempChar;
        int charCode;
        int keywordCounter=-1;
        for (int i = 0; i <cipherText.length() ; i++) {
            tempChar=cipherText.charAt(i);
            if(super.checkCharacter(tempChar))
            {
                keywordCounter++;
                if(keywordCounter>=keyword.length())
                {
                    keywordCounter=0;
                }
                charCode=(super.getIndex(tempChar)-super.getIndex(keyword.charAt(keywordCounter)))%94;
                if(charCode<0)
                {
                    charCode+=94;
                }
                tempChar=characters[charCode];
            }
            plainText+=tempChar;
        }
        return plainText;
    }
}
