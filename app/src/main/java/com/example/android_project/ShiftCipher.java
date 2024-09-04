package com.example.android_project;

public class ShiftCipher extends DataInfo
{
    public ShiftCipher()
    {
        super();
    }
    public String encryptionShift(String plainText,int key)
    {
        String cipherText="";
        char tempChar;
        int charCode;
        for (int i = 0; i <plainText.length() ; i++) {
            tempChar=plainText.charAt(i);
            if(super.checkCharacter(tempChar))
            {
                charCode=(super.getIndex(tempChar)+key)%94;
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

    public String decryptionShift(String cipherText,int key)
    {
        //the encryption of the shift is the (-1)*(key) of the decryption
        return this.encryptionShift(cipherText,-key);
    }
}
