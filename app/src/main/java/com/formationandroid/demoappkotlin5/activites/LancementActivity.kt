package com.formationandroid.demoappkotlin5.activites

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.formationandroid.demoappkotlin5.R
import com.formationandroid.demoappkotlin5.bo.Contact

class LancementActivity : AppCompatActivity()
{
	override fun onCreate(savedInstanceState: Bundle?)
	{
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_lancement)

		val boutonExplicite: Button = findViewById(R.id.bouton_explicite)
		boutonExplicite.setOnClickListener {

			val intent = Intent(this, DetailActivity::class.java)
			intent.putExtra(
				DetailActivity.CLE_PARAMETRE,
				Contact("John Doe", "0677887788"))
			startActivity(intent)
		}

		val boutonImplicite: Button = findViewById(R.id.bouton_implicite)
		boutonImplicite.setOnClickListener {

			// création du message :
			val intent = Intent(Intent.ACTION_SEND)
			intent.putExtra(Intent.EXTRA_TEXT, "message")
			intent.type = "text/plain"

			// demande et personnalisation de la boîte de dialogue :
			val chooser = Intent.createChooser(intent, "Envoyer à")

			// vérification et envoi :
			if (intent.resolveActivity(packageManager) != null)
			{
				startActivity(chooser)
			}
		}
	}
}
