package com.example.android_project;

public class PermutationCipher
{
    public String encryptionPermutation(String plaintText)
    {
        // key is   1 2 3 4 5 6
        // key is   3 5 1 6 4 2

        String cipherText="";
        int permutationIndex=1;
        boolean notContainSpace=true;
        for (int i = 0; i <plaintText.length() ; i++) {
            if(plaintText.charAt(i)==' ')
            {
                notContainSpace=false;
                break;
            }
        }
        if(notContainSpace || plaintText.charAt(plaintText.length()-1)!=' ')
        {
            if(plaintText.length()!=0)
            {
                while(plaintText.length()<6 || plaintText.length()%6>0)
                {
                    plaintText+='~';
                }
            }
        }
        //marcom arco~~
        for (int i = 0; i < (plaintText.length()/6) ; i++) {
            for (int j = 0; j <6 ; j++) {
                switch (permutationIndex)//1
                {
                    case 1:
                        cipherText+=plaintText.charAt((i*6)+2);
                        permutationIndex++;
                        break;
                    case 2:
                        cipherText+=plaintText.charAt((i*6)+4);
                        permutationIndex++;
                        break;
                    case 3:
                        cipherText+=plaintText.charAt((i*6)+0);
                        permutationIndex++;
                        break;
                    case 4:
                        cipherText+=plaintText.charAt((i*6)+5);
                        permutationIndex++;
                        break;
                    case 5:
                        cipherText+=plaintText.charAt((i*6)+3);
                        permutationIndex++;
                        break;
                    case 6:
                        cipherText+=plaintText.charAt((i*6)+1);
                        permutationIndex++;
                        break;
                    case 7:
                        permutationIndex=1;
                        cipherText+=plaintText.charAt((i*6)+2);
                        permutationIndex++;
                        break;
                }
            }
        }
        return cipherText;
    }

    public String decryptionPermutation(String cipherText)
    {
        int permutationIndex=1;
        String plainText="";
        for (int i = 0; i < (cipherText.length()/6); i++) {
            for (int j = 0; j < 6; j++) {
                switch (permutationIndex)
                {
                    case 1:
                        plainText+=cipherText.charAt((i*6)+2);
                        permutationIndex++;
                        break;
                    case 2:
                        plainText+=cipherText.charAt((i*6)+5);
                        permutationIndex++;
                        break;
                    case 3:
                        plainText+=cipherText.charAt((i*6)+0);
                        permutationIndex++;
                        break;
                    case 4:
                        plainText+=cipherText.charAt((i*6)+4);
                        permutationIndex++;
                        break;
                    case 5:
                        plainText+=cipherText.charAt((i*6)+1);
                        permutationIndex++;
                        break;
                    case 6:
                        plainText+=cipherText.charAt((i*6)+3);
                        permutationIndex++;
                        break;
                    case 7:
                        permutationIndex=1;
                        plainText+=cipherText.charAt((i*6)+2);
                        permutationIndex++;
                        break;
                }
            }
        }
        String tempPlainText="";
        for (int i = 0; i <plainText.length(); i++) {
            if(!(plainText.charAt(i)=='~'))
            {
                tempPlainText+=plainText.charAt(i);
            }
        }
        return tempPlainText;
    }
}
