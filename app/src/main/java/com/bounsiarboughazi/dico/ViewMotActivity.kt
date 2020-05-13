package com.bounsiarboughazi.dico

import android.media.MediaPlayer
import android.net.Uri
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import android.widget.VideoView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_view_mot.*

class ViewMotActivity : AppCompatActivity() {


    private var mp: MediaPlayer? = null
    private var mc: MediaController? = null
    private var resId:Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_mot)

        val mot = intent.getParcelableExtra<Mot>("mot")
        mot_view_tv.text = mot.nom
        desc_tv.text = mot.definition
        image_view.setImageResource(mot.image)
        resId = mot.son
        if (mot.video!=null){
            videoView.visibility = View.VISIBLE
            lireVideo(mot.video)
        }

    }


    fun speak(view: View) {
        if (mp == null) {        //set up MediaPlayer
            mp = MediaPlayer.create(this, resId)

            try {
                mp!!.prepare()

            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
        if (!mp!!.isPlaying)
            mp!!.start()
        else
            mp!!.pause()

    }
    private fun lireVideo(resId: Int) {
        val vv = videoView
        if (mc == null) {

            mc = MediaController(this)
            vv.setMediaController(mc)
            val video = Uri.parse("android.resource://" + this?.packageName + "/"
                    + resId) //do not add any extension
            vv.setVideoURI(video)
            vv.start()
        } else {
            if (!vv.isPlaying) {
                vv.start()

            } else {
                vv.pause()
            }
        }
    }
}
