package com.example.sikl

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.sikl.ui.home.Popular
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    companion object{
       const val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    private  val  CHANNEL_ID = "channel_id"
    private val  notifactionId = 101

    @SuppressLint("MissingInflatedId", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        val detail = intent.getParcelableExtra<Popular>(INTENT_PARCELABLE)
        val imgPopular = findViewById<ImageView>(R.id.img_detail)
        val titlePopular = findViewById<TextView>(R.id.tv_titledetail)
        val descPopular = findViewById<TextView>(R.id.tv_descdetail)

            imgPopular.setImageResource(detail?.imgPopular!!)
            titlePopular.text = detail.titlePopular
            descPopular.text = detail.descPopular

        back.setOnClickListener {
            val intent = Intent(this,HomeActivity::class.java)
            startActivity(intent)
        }

        createNotificationChannel()
        checkout.setOnClickListener {
//            sendNotification()
            val intent = Intent(this,Success::class.java)
            startActivity(intent)
            finish()
        }

    }

    private fun createNotificationChannel(){

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val name ="Notification Title"
            val descriptionText = "Notification Desc"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID,name,importance).apply {
                description=descriptionText
            }
            val notificationManager : NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
    private fun sendNotification(){
        val intent = Intent(this, Success::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        startActivity(intent)
        finish()
        val pendingIntent: PendingIntent = PendingIntent.getActivity(this,0,intent,0)
        val  bitmapLargeIcon = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.sikl)
        val builder = NotificationCompat.Builder(this,CHANNEL_ID)
            .setSmallIcon(R.drawable.sikl)
            .setContentTitle("Title")
            .setContentText("Desc")
            .setLargeIcon(bitmapLargeIcon)
            .setStyle(NotificationCompat.BigTextStyle().bigText("Text"))
            .setContentIntent(pendingIntent)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        with(NotificationManagerCompat.from(this)){
            notify(notifactionId, builder.build())
        }
    }
}