package com.example.android_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CipherScreen extends AppCompatActivity {
    String [] ciphers = { "Shift", "Affine" , "Substitution", "Permutation","Vigenere", "SP","SP + Shift","SPN"};
    EditText shiftKey,affineKey1,affineKey2,vigenerKey,plainText,edText;
    AutoCompleteTextView choosenCipher;
    ArrayAdapter<String> cipherItems;
    Button encrypt,decrypt;

    String selectedItem="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cipher_screen);

        shiftKey =findViewById(R.id.shiftKey);
        affineKey1 =findViewById(R.id.affineKey1);
        affineKey2 =findViewById(R.id.affineKey2);
        vigenerKey =findViewById(R.id.vigenerKey);
        plainText =findViewById(R.id.plainText);
        edText =findViewById(R.id.edText);

        choosenCipher =findViewById(R.id.choosenCipher);
        encrypt=findViewById(R.id.encrypt);
        decrypt =findViewById(R.id.decrypt);

        cipherItems=new ArrayAdapter<>(this,R.layout.ciphers_list,ciphers);
        choosenCipher.setAdapter(cipherItems);

        choosenCipher.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 selectedItem=parent.getItemAtPosition(position).toString();
                if(selectedItem.equals("Shift"))
                {
                    shiftKey.setVisibility(View.VISIBLE);
                    affineKey1.setVisibility(View.GONE);
                    affineKey2.setVisibility(View.GONE);
                    vigenerKey.setVisibility(View.GONE);
                }
                else if(selectedItem.equals("Affine"))
                {
                    shiftKey.setVisibility(View.GONE);
                    affineKey1.setVisibility(View.VISIBLE);
                    affineKey2.setVisibility(View.VISIBLE);
                    vigenerKey.setVisibility(View.GONE);
                }
                else if(selectedItem.equals("Substitution"))
                {
                    shiftKey.setVisibility(View.GONE);
                    affineKey1.setVisibility(View.GONE);
                    affineKey2.setVisibility(View.GONE);
                    vigenerKey.setVisibility(View.GONE);
                }
                else if(selectedItem.equals("Permutation"))
                {
                    shiftKey.setVisibility(View.GONE);
                    affineKey1.setVisibility(View.GONE);
                    affineKey2.setVisibility(View.GONE);
                    vigenerKey.setVisibility(View.GONE);
                }
                else if(selectedItem.equals("Vigenere"))
                {
                    shiftKey.setVisibility(View.GONE);
                    affineKey1.setVisibility(View.GONE);
                    affineKey2.setVisibility(View.GONE);
                    vigenerKey.setVisibility(View.VISIBLE);
                }
                else if(selectedItem.equals("SP"))
                {
                    shiftKey.setVisibility(View.GONE);
                    affineKey1.setVisibility(View.GONE);
                    affineKey2.setVisibility(View.GONE);
                    vigenerKey.setVisibility(View.GONE);
                }
                else if(selectedItem.equals("SP + Shift"))
                {
                    shiftKey.setVisibility(View.VISIBLE);
                    affineKey1.setVisibility(View.GONE);
                    affineKey2.setVisibility(View.GONE);
                    vigenerKey.setVisibility(View.GONE);
                }
                else if(selectedItem.equals("SPN"))
                {
                    shiftKey.setVisibility(View.GONE);
                    affineKey1.setVisibility(View.GONE);
                    affineKey2.setVisibility(View.GONE);
                    vigenerKey.setVisibility(View.GONE);
                }
                else
                {
                    shiftKey.setVisibility(View.GONE);
                    affineKey1.setVisibility(View.GONE);
                    affineKey2.setVisibility(View.GONE);
                    vigenerKey.setVisibility(View.GONE);
                }
            }
        });

        //Encryption Button
        encrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String plainTxt = plainText.getText().toString();
                if (!plainTxt.isEmpty()) {
                    if (selectedItem.equals("Shift")) {
                        String shift_key=shiftKey.getText().toString();
                        if(shift_key.isEmpty())
                        {
                            Toast.makeText(CipherScreen.this, "key must not be empty", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            ShiftCipher shiftCipher =new ShiftCipher();
                            edText.setText(shiftCipher.encryptionShift(plainTxt,Integer.parseInt(shift_key)));
                        }
                    } else if (selectedItem.equals("Affine")) {
                        String affine_key1=affineKey1.getText().toString();
                        String affine_key2=affineKey2.getText().toString();
                        if(affine_key1.isEmpty() || affine_key2.isEmpty())
                        {
                            Toast.makeText(CipherScreen.this, "key1 and key2 must not be empty", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            DataInfo dataInfo =new DataInfo();
                            if(dataInfo.getInverse(Integer.parseInt(affine_key1),94)!=-1)
                            {
                                AffineCipher af =new AffineCipher();
                                String result =af.encryptionAffine(plainTxt,Integer.parseInt(affine_key1),Integer.parseInt(affine_key2));
                                edText.setText(result);
                            }
                            else
                            {
                                Toast.makeText(CipherScreen.this, affine_key1+" does not have inverse", Toast.LENGTH_SHORT).show();
                                edText.setText("ERROR");
                            }
                        }

                    } else if (selectedItem.equals("Substitution")) {
                        SubstitutionCipher substitutionCipher=new SubstitutionCipher();
                        edText.setText(substitutionCipher.encryptionSubstitution(plainTxt));
                    } else if (selectedItem.equals("Permutation")) {
                        PermutationCipher Permutation=new PermutationCipher();
                        edText.setText(Permutation.encryptionPermutation(plainTxt));
                    } else if (selectedItem.equals("Vigenere")) {
                        String vigenere_key =vigenerKey.getText().toString();
                        if(vigenere_key.isEmpty())
                        {
                            Toast.makeText(CipherScreen.this, "key must not be empty", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            VigenereCipher vigenereCipher =new VigenereCipher();
                            edText.setText(vigenereCipher.encryptionVigenere(plainTxt,vigenere_key));
                        }
                    } else if (selectedItem.equals("SP")) {
                        SPCipher spCipher= new SPCipher();
                        edText.setText(spCipher.encryptionSP(plainTxt));

                    } else if (selectedItem.equals("SP + Shift")) {

                        String shift_key=shiftKey.getText().toString();
                        if(shift_key.isEmpty())
                        {
                            Toast.makeText(CipherScreen.this, "key must not be empty", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            SPShiftCipher sPShiftCipher =new SPShiftCipher();
                            edText.setText(sPShiftCipher.encryptionSP_Shift(plainTxt,Integer.parseInt(shift_key)));
                        }
                    } else if (selectedItem.equals("SPN")) {
                        edText.setText(SPNCipher.encryptMessage(plainTxt,123456789));
                    } else {
                        Toast.makeText(CipherScreen.this, "Select Cipher method first", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(CipherScreen.this, "PlainText must not be empty", Toast.LENGTH_LONG).show();
                }
            }
        });

        decrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String plainTxt = plainText.getText().toString();
                if (!plainTxt.isEmpty()) {
                    if (selectedItem.equals("Shift")) {
                        String shift_key=shiftKey.getText().toString();
                        if(shift_key.isEmpty())
                        {
                            Toast.makeText(CipherScreen.this, "key must not be empty", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            ShiftCipher shiftCipher =new ShiftCipher();
                            edText.setText(shiftCipher.decryptionShift(plainTxt,Integer.parseInt(shift_key)));
                        }
                    } else if (selectedItem.equals("Affine")) {
                        String affine_key1=affineKey1.getText().toString();
                        String affine_key2=affineKey2.getText().toString();
                        if(affine_key1.isEmpty() || affine_key2.isEmpty())
                        {
                            Toast.makeText(CipherScreen.this, "key1 and key2 must not be empty", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            DataInfo dataInfo =new DataInfo();
                            if(dataInfo.getInverse(Integer.parseInt(affine_key1),94)!=-1)
                            {
                                AffineCipher af =new AffineCipher();
                                String result =af.decryptionAffine(plainTxt,Integer.parseInt(affine_key1),Integer.parseInt(affine_key2));
                                edText.setText(result);
                            }
                            else
                            {
                                Toast.makeText(CipherScreen.this, affine_key1+" does not have inverse", Toast.LENGTH_SHORT).show();
                                edText.setText("ERROR");
                            }
                        }

                    } else if (selectedItem.equals("Substitution")) {
                        SubstitutionCipher substitutionCipher=new SubstitutionCipher();
                        edText.setText(substitutionCipher.decryptionSubstitution(plainTxt));

                    } else if (selectedItem.equals("Permutation")) {
                        PermutationCipher Permutation=new PermutationCipher();
                        edText.setText(Permutation.decryptionPermutation(plainTxt));

                    } else if (selectedItem.equals("Vigenere")) {
                        String vigenere_key =vigenerKey.getText().toString();
                        if(vigenere_key.isEmpty())
                        {
                            Toast.makeText(CipherScreen.this, "key must not be empty", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            VigenereCipher vigenereCipher =new VigenereCipher();
                            edText.setText(vigenereCipher.decryptionVigenere(plainTxt,vigenere_key));
                        }
                    } else if (selectedItem.equals("SP")) {
                        SPCipher spCipher= new SPCipher();
                        edText.setText(spCipher.decryptionSP(plainTxt));

                    } else if (selectedItem.equals("SP + Shift")) {

                        String shift_key=shiftKey.getText().toString();
                        if(shift_key.isEmpty())
                        {
                            Toast.makeText(CipherScreen.this, "key must not be empty", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            SPShiftCipher sPShiftCipher =new SPShiftCipher();
                            edText.setText(sPShiftCipher.decryptionSP_Shift(plainTxt,Integer.parseInt(shift_key)));
                        }
                    } else if (selectedItem.equals("SPN")) {
                        edText.setText(SPNCipher.decryptMessage(plainTxt,123456789));
                    } else {
                        Toast.makeText(CipherScreen.this, "Select Cipher method first", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(CipherScreen.this, "PlainText must not be empty", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}