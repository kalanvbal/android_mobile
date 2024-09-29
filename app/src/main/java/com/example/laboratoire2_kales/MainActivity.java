package com.example.laboratoire2_kales;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import android.util.Log;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    EditText motDePasse;
    EditText motDePasse2;
    CheckBox afficherMDP;
    CheckBox afficherMDP2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        afficherMDP = findViewById(R.id.cb_afficherMDP);
        afficherMDP2 = findViewById(R.id.cb_afficherConfirmationMDP);
        motDePasse = findViewById(R.id.et_MDP);
        motDePasse2 = findViewById(R.id.et_confirmationMDP);
    }

    public void onClick_afficher(View view) {
        if (afficherMDP.isChecked()) {
            motDePasse.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
        } else {
            motDePasse.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        }

        motDePasse.setSelection(motDePasse.getText().length());
    }

    public void onClick_afficher2(View view) {
        if (afficherMDP2.isChecked()) {
            motDePasse2.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
        } else {
            motDePasse2.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        }

        motDePasse2.setSelection(motDePasse2.getText().length());
    }

    public void onClick_sauvegarder(View view) {
        Toast.makeText(this, "Le profil est sauvegardé", Toast.LENGTH_LONG).show();
    }

    public void onClick_quitter(View view) {
        AlertDialog.Builder alerteDialogueBuilderQuitter = new AlertDialog.Builder(this);
        alerteDialogueBuilderQuitter.setMessage("Êtes-vous sûr de vouloir quitter l'application?");

        alerteDialogueBuilderQuitter.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                finish();
            }
        });

        alerteDialogueBuilderQuitter.setNegativeButton("Non", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                Toast.makeText(MainActivity.this, "Vous avez cliqué le bouton non", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alertDialog = alerteDialogueBuilderQuitter.create();
        alertDialog.show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "L’activité est passée par la méthode <onStart>");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "L’activité est passée par la méthode <onResume>");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "L’activité est passée par la méthode <onPause>");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "L’activité est passée par la méthode <onStop>");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "L’activité est passée par la méthode <onDestroy>");
    }

}