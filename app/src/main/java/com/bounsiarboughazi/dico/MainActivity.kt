package com.bounsiarboughazi.dico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: ListViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mots = arrayListOf<Mot>(Mot("Key","a small piece of shaped metal with incisions cut to fit the wards of a particular lock, which is inserted into a lock and turned to open or close it.\n",R.drawable.key, R.raw.key),
            Mot("Volcano","a mountain or hill, typically conical, having a crater or vent through which lava, rock fragments, hot vapour, and gas are or have been erupted from the earth's crust.\n",R.drawable.volcano,R.raw.volcano),
            Mot("Pet","a domestic or tamed animal kept for companionship or pleasure.",R.drawable.pet,R.raw.pet),
            Mot("Space","the dimensions of height, depth, and width within which all things exist and move.",R.drawable.space,R.raw.space,R.raw.spacevid),
            Mot("Rifle","a gun, especially one fired from shoulder level, having a long spirally grooved barrel intended to make a bullet spin and thereby have greater accuracy over a long distance.",R.drawable.rifle,R.raw.rifle)
        )
        adapter = ListViewAdapter(this,mots)
        list_view.adapter = adapter
        list_view.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, ViewMotActivity::class.java)
            intent.putExtra("mot",mots[position])
            startActivity(intent)
        }
    }
}
