package com.formationandroid.demoappkotlin5.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.formationandroid.demoappkotlin5.R
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException

class FichierActivity : AppCompatActivity()
{
	companion object
	{
		private const val FICHIER = "hello_file.txt"
	}

	override fun onCreate(savedInstanceState: Bundle?)
	{
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_fichier)
	}

	fun clicLireFichier(view: View)
	{
		// initialisation :
		try
		{
			val stream: FileInputStream = openFileInput(FICHIER)
			val stringBuilder = StringBuilder()
			val buffer = ByteArray(1024)

			// lecture :
			while (stream.read(buffer) != -1)
			{
				stringBuilder.append(String(buffer))
			}
			stream.close()

			// affichage :
			Toast.makeText(this, stringBuilder.toString(), Toast.LENGTH_LONG).show()
		}
		catch (exception: IOException)
		{
			Toast.makeText(this, "Aucun fichier !", Toast.LENGTH_LONG).show()
		}
	}

	fun clicEnregistrerFichier(view: View)
	{
		// contenu :
		val contenu = "hello world!"

		// écriture (utiliser MODE_APPEND si écriture à la suite) :
		val stream: FileOutputStream = openFileOutput(FICHIER, MODE_PRIVATE)
		stream.write(contenu.toByteArray())
		stream.close()
	}
}