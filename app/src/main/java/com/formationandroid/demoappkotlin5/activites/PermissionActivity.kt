package com.formationandroid.demoappkotlin5.activites

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.formationandroid.demoappkotlin5.R
import com.formationandroid.demoappkotlin5.metier.dao.ContactDao


class PermissionActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permission)

        val permission = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)
        if (permission == PackageManager.PERMISSION_GRANTED) {

            //lire les contacts :
            lireContacts()
        }
        else
        {
            // Affichage de la popup de de demande de permission:
            ActivityCompat.requestPermissions(
                this,arrayOf(Manifest.permission.READ_CONTACTS),
                248)
        }

    }
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray)
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 248) {
            if (grantResults.isNotEmpty()) {
                // permission accordée on peut accéder aux contacts sans risque
                lireContacts()
            }
            else
            {
                // permission refusée, on ne peut pas accéder aux contacts
                Toast.makeText(this, "Autorisation refusée !", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun lireContacts()
    {
        // remonter la liste de contacts:
        val listeContact = ContactDao.getListeContacts(this)

        val textViewContacts: TextView = findViewById(R.id.contacts)
        val stringBuilder = StringBuilder()

        // afiicher liste contact dans TextView
        for(contact in listeContact)
        {
            stringBuilder.append(contact.nom).append(":").append(contact.numero).append("\n")
        }
        textViewContacts.text = stringBuilder.toString()

        //Toast.makeText(this, "accès aux contacts", Toast.LENGTH_LONG).show()
    }
}