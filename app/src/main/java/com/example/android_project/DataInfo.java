package com.example.android_project;

public class DataInfo {
    public static char characters[]=new char[94];
    public static int charactersIndex[]=new int[94];

    public DataInfo()
    {
        int counter=0;
        for(int i=0;i<128;i++)//0->32,,127
        {
            if(!((0<=i && i<=32) ||(i==127) ))
            {
                charactersIndex[counter]=i;
                characters[counter]=(char)i;
                counter++;
            }
        }
    }

    public int gcd(int num1,int num2)
    {
        int temp =0;
        while(num2!=0)
        {
            temp = num2;//save the value of num2
            num2=num1%num2;//put the remainder in num2
            num1=temp;//assign the value of num2 to num1
        }
        return num1;
    }
    public int getIndex(char input)
    {
        for (int i = 0; i < characters.length; i++) {
            if(input==characters[i])
                return i;
        }
        return -1;//not found
    }

    public boolean checkCharacter(char input)
    {
        for (int i = 0; i < characters.length; i++) {
            if(input==characters[i])
                return true;
        }
        return false;//not found
    }

    int getInverse(int element ,int size)
    {
        if(gcd(element, size)==1)
        {
            for (int i = 1; i < size; i++)
            {
                if( (element*i)%size == 1 )
                    {
                        return i; //the inverse
                    }
            }
        }
         return -1; //the inverse does not exist
    }
}
