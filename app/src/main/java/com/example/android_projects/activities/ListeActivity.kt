package com.example.android_projects.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.widget.EditText
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_projects.R
import com.example.android_projects.adapters.NoteAdapter
import com.example.android_projects.bo.Notes

class ListeActivity : AppCompatActivity() {

    private lateinit var notesAdapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_liste)

        // etape 6
        // liste:
        val recyclerView: RecyclerView = findViewById(R.id.liste_notes)

        // à ajouter pour de meilleures performances :
        recyclerView.setHasFixedSize(true) // la vue à l'écran sera toujours la même

        // layout manager, décrivant comment les items sont disposés :
        recyclerView.layoutManager = LinearLayoutManager(this)

        // on crée une liste d'objets en dur
        // contenu de test :
        val listeNotes: MutableList<Notes> = ArrayList()
        for (a in 1..40)
        {
           listeNotes.add(Notes("Memo $a", 1))
        }

        // adapter :
        notesAdapter = NoteAdapter(listeNotes)
        recyclerView.adapter = notesAdapter

        // listener bouton OK :
        val boutonOK: AppCompatButton = findViewById(R.id.bouton_valider)
        boutonOK.setOnClickListener(this)
    }

    override fun onClick(view: View)
    {
        // On récupère la saisie de l'utilisateur pour créer une nouvelle note :
        // récupère le champ de saisie
        val editTextNote: EditText = findViewById(R.id.note)

        // récupère la saisie
        val saisie  = editTextNote.text.toString()

        // on crée une note
        val note = Notes(saisie, false)

        notesAdapter.ajoutNote(note)

        // finalisation
        editTextNote.setText("")
        recyclerView.smoothScrollToPosition(0)
    }


}