package com.formationandroid.demoappkotlin5.metier.dao

import android.content.Context
import android.provider.ContactsContract
import com.formationandroid.demoappkotlin5.bo.Contact

object ContactDao
{
    fun getListeContacts(context: Context): MutableList<Contact>
    {

        // tri:
        val tri = ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + "ASC"

        // requête :
        val cursor = context.contentResolver.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI, // table requétée
            null, // colonnes à retourner
            null, // colonnes WHERE
            null, // valeurs WHERE
            tri) // ordre de tri

        val listeContacts: MutableList<Contact> = ArrayList()
        if(cursor !=null)
        {
            try
            {
                while (cursor.moveToNext())
                {
                    // conversion des données remontées en un objet métier:
                    listeContacts.add(Contact
                        (
                        cursor.getString(cursor.getColumnIndexOrThrow(
                            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)),
                        cursor.getString(cursor.getColumnIndexOrThrow(
                            ContactsContract.CommonDataKinds.Phone.NUMBER))
                        )
                    )
                }
            }
            catch(e:Exception)
            {
                e.printStackTrace()
            }
            finally {
                {
                    cursor.close()
                }
            }

        }
        return listeContacts
    }
}