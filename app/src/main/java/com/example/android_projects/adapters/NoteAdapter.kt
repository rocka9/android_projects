package com.example.android_projects.adapters

import android.app.assist.AssistStructure
import android.provider.ContactsContract
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.SwitchCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.android_projects.R
import com.example.android_projects.bo.Notes


// etape 4 et 5:
class NoteAdapter ( private var listeNotes: MutableList<Notes>) :RecyclerView.Adapter<NoteAdapter.NoteViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder
    // onCreateViewholder va créer autant d'items que nécéssaires dans la liste
    {
        val viewNotes = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_note, parent, false)
        return NoteViewHolder(viewNotes)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int)
    {
        holder.textViewLibelleNote.text = listeNotes[position].libelle
        holder.switchVuNote.isChecked = listeNotes[position].vu
    }

    override fun getItemCount(): Int
    {
        return listeNotes.size
    }

    // ajout de la note
    fun ajoutNote(note: Notes)
    {
        listeNotes.add(0, note)

        // notification ajout note dans la liste
        notifyItemInserted(0)

    }

    // ViewHolder :
    inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    // NoteviewHolder sert à optimiser les performances lorsque l'on scrolle le recylcerView
    // vers le haut ou le bas
    {
        val textViewLibelleNote: TextView = itemView.findViewById(R.id.libelle_note)
        val switchVuNote: SwitchCompat = itemView.findViewById(R.id.vu_note)

        init
        {
            itemView.setOnClickListener{
                val note = listeNotes[adapterPosition]
                Log.i("TAG", "note: $note")
            }
        }
    }


}