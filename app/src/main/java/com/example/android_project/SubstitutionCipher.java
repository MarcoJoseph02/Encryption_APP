package com.example.android_project;

public class SubstitutionCipher
{
 public String encryptionSubstitution(String plainText)
 {
    String cipherText="";
    char chars[]=plainText.toCharArray();
     for (int i = 0; i < plainText.length(); i++)
     {
        switch (chars[i])
        {
            case '!':cipherText += '2';break;
            case '\"':cipherText += '<';break;
            case '#':cipherText += 'F';break;
            case '$':cipherText += 'P';break;
            case '%': cipherText += 'Z';break;
            case '&':cipherText += 'd'; break;
            case '\'':cipherText += '('; break;
            case '(': cipherText += '-';break;
            case ')': cipherText += '7'; break;
            case '*':cipherText += 'A';break;
            case '+': cipherText += 'K'; break;
            case ',': cipherText += 'U';break;
            case '-': cipherText += '_'; break;
            case '.': cipherText += '#';break;
            case '/': cipherText += ')'; break;
            case '0': cipherText += '3';break;
            case '1': cipherText += '='; break;
            case '2':cipherText += 'G';break;
            case '3': cipherText += 'Q'; break;
            case '4':cipherText += '['; break;
            case '5': cipherText += '*';break;
            case '6': cipherText += '4';break;
            case '7':  cipherText += '>'; break;
            case '8': cipherText += 'H';break;
            case '9': cipherText += 'R'; break;
            case ':': cipherText += '\\'; break;
            case ';': cipherText += '!';break;
            case '<':cipherText += '+';break;
            case '=': cipherText += '5';break;
            case '>':cipherText += '?';break;
            case '?': cipherText += 'I';break;
            case '@':cipherText += 'S';break;
            case 'A': cipherText += ']';break;
            case 'B': cipherText += '"'; break;
            case 'C': cipherText += ','; break;
            case 'D':  cipherText += '6'; break;
            case 'E': cipherText += '@';break;
            case 'F':  cipherText += 'J';break;
            case 'G':cipherText += 'T'; break;
            case 'H': cipherText += '^';  break;
            case 'I': cipherText += '$';break;
            case 'J': cipherText += '.';break;
            case 'K':  cipherText += '8'; break;
            case 'L': cipherText += 'B';break;
            case 'M':cipherText += 'L';  break;
            case 'N':cipherText += 'V'; break;
            case 'O': cipherText += '`'; break;
            case 'P':cipherText += '%'; break;
            case 'Q': cipherText += '/'; break;
            case 'R':cipherText += '9'; break;
            case 'S': cipherText += 'C';break;
            case 'T': cipherText += 'M'; break;
            case 'U':cipherText += 'W';break;
            case 'V': cipherText += 'a'; break;
            case 'W':cipherText += '&'; break;
            case 'X': cipherText += '0';break;
            case 'Y': cipherText += ':'; break;
            case 'Z': cipherText += 'D';break;
            case '[':cipherText += 'N'; break;
            case '\\': cipherText += 'X'; break;
            case ']':cipherText += 'b';break;
            case '^': cipherText += '\'';break;
            case '_': cipherText += '1'; break;
            case '`': cipherText += ';';break;
            case 'a':cipherText += 'E'; break;
            case 'b':cipherText += 'O';break;
            case 'c': cipherText += 'Y';break;
            case 'd':cipherText += 'c';break;
            case 'e': cipherText += 'n';break;
            case 'f': cipherText += 'x';break;
            case 'g':cipherText += 'o';break;
            case 'h':cipherText += 's'; break;
            case 'i':cipherText += 'w';break;
            case 'j': cipherText += 'z'; break;
            case 'k': cipherText += '}'; break;
            case 'l':cipherText += '~'; break;
            case 'm':cipherText += '|';break;
            case 'n':cipherText += 'y';break;
            case 'o':cipherText += 'e';break;
            case 'p': cipherText += 'g';break;
            case 'q': cipherText += 'i'; break;
            case 'r': cipherText += 'l';break;
            case 's': cipherText += 'f';break;
            case 't': cipherText += 'h';break;
            case 'u':cipherText += 'j';break;
            case 'v':cipherText += 'm';break;
            case 'w':cipherText += 'k';break;
            case 'x':cipherText += 'q';break;
            case 'y':cipherText += 'r';break;
            case 'z':cipherText += 'u';break;
            case '{': cipherText += 'p'; break;
            case '|': cipherText += 't'; break;
            case '}': cipherText += 'v'; break;
            case '~':cipherText += '{'; break;
            case ' ': cipherText += ' ';break;
        }
     }
     return cipherText;
 }

 public String decryptionSubstitution(String cipherText)
 {
     char chars[]=cipherText.toCharArray();
     String plainText="";
     for (int i = 0; i <cipherText.length() ; i++)
     {
         switch (chars[i])
         {
             case '2':
                 plainText += '!';
                 break;
             case '<':
                 plainText += '"';
                 break;
             case 'F':
                 plainText += '#';
                 break;
             case 'P':
                 plainText += '$';
                 break;
             case 'Z':
                 plainText += '%';
                 break;
             case 'd':
                 plainText += '&';
                 break;
             case '(':
                 plainText += '\'';
                 break;
             case '-':
                 plainText += '(';
                 break;
             case '7':
                 plainText += ')';
                 break;
             case 'A':
                 plainText += '*';
                 break;
             case 'K':
                 plainText += '+';
                 break;
             case 'U':
                 plainText += ',';
                 break;
             case '_':
                 plainText += '-';
                 break;
             case '#':
                 plainText += '.';
                 break;
             case ')':
                 plainText += '/';
                 break;
             case '3':
                 plainText += '0';
                 break;
             case '=':
                 plainText += '1';
                 break;
             case 'G':
                 plainText += '2';
                 break;
             case 'Q':
                 plainText += '3';
                 break;
             case '[':
                 plainText += '4';
                 break;
             case '*':
                 plainText += '5';
                 break;
             case '4':
                 plainText += '6';
                 break;
             case '>':
                 plainText += '7';
                 break;
             case 'H':
                 plainText += '8';
                 break;
             case 'R':
                 plainText += '9';
                 break;
             case '\\':
                 plainText += ':';
                 break;
             case '!':
                 plainText += ';';
                 break;
             case '+':
                 plainText += '<';
                 break;
             case '5':
                 plainText += '=';
                 break;
             case '?':
                 plainText += '>';
                 break;
             case 'I':
                 plainText += '?';
                 break;
             case 'S':
                 plainText += '@';
                 break;
             case ']':
                 plainText += 'A';
                 break;
             case '"':
                 plainText += 'B';
                 break;
             case ',':
                 plainText += 'C';
                 break;
             case '6':
                 plainText += 'D';
                 break;
             case '@':
                 plainText += 'E';
                 break;
             case 'J':
                 plainText += 'F';
                 break;
             case 'T':
                 plainText += 'G';
                 break;
             case '^':
                 plainText += 'H';
                 break;
             case '$':
                 plainText += 'I';
                 break;
             case '.':
                 plainText += 'J';
                 break;
             case '8':
                 plainText += 'K';
                 break;
             case 'B':
                 plainText += 'L';
                 break;
             case 'L':
                 plainText += 'M';
                 break;
             case 'V':
                 plainText += 'N';
                 break;
             case '`':
                 plainText += 'O';
                 break;
             case '%':
                 plainText += 'P';
                 break;
             case '/':
                 plainText += 'Q';
                 break;
             case '9':
                 plainText += 'R';
                 break;
             case 'C':
                 plainText += 'S';
                 break;
             case 'M':
                 plainText += 'T';
                 break;
             case 'W':
                 plainText += 'U';
                 break;
             case 'a':
                 plainText += 'V';
                 break;
             case '&':
                 plainText += 'W';
                 break;
             case '0':
                 plainText += 'X';
                 break;
             case ':':
                 plainText += 'Y';
                 break;
             case 'D':
                 plainText += 'Z';
                 break;
             case 'N':
                 plainText += '[';
                 break;
             case 'X':
                 plainText += '\\';
                 break;
             case 'b':
                 plainText += ']';
                 break;
             case '\'':
                 plainText += '^';
                 break;
             case '1':
                 plainText += '_';
                 break;
             case ';':
                 plainText += '`';
                 break;
             case 'E':
                 plainText += 'a';
                 break;
             case 'O':
                 plainText += 'b';
                 break;
             case 'Y':
                 plainText += 'c';
                 break;
             case 'c':
                 plainText += 'd';
                 break;
             case 'n':
                 plainText += 'e';
                 break;
             case 'x':
                 plainText += 'f';
                 break;
             case 'o':
                 plainText += 'g';
                 break;
             case 's':
                 plainText += 'h';
                 break;
             case 'w':
                 plainText += 'i';
                 break;
             case 'z':
                 plainText += 'j';
                 break;
             case '}':
                 plainText += 'k';
                 break;
             case '~':
                 plainText += 'l';
                 break;
             case '|':
                 plainText += 'm';
                 break;
             case 'y':
                 plainText += 'n';
                 break;
             case 'e':
                 plainText += 'o';
                 break;
             case 'g':
                 plainText += 'p';
                 break;
             case 'i':
                 plainText += 'q';
                 break;
             case 'l':
                 plainText += 'r';
                 break;
             case 'f':
                 plainText += 's';
                 break;
             case 'h':
                 plainText += 't';
                 break;
             case 'j':
                 plainText += 'u';
                 break;
             case 'm':
                 plainText += 'v';
                 break;
             case 'k':
                 plainText += 'w';
                 break;
             case 'q':
                 plainText += 'x';
                 break;
             case 'r':
                 plainText += 'y';
                 break;
             case 'u':
                 plainText += 'z';
                 break;
             case 'p':
                 plainText += '{';
                 break;
             case 't':
                 plainText += '|';
                 break;
             case 'v':
                 plainText += '}';
                 break;
             case '{':
                 plainText += '~';
                 break;
             case ' ':
                 plainText += ' ';
                 break;
         }
     }
     return plainText;
 }
}
