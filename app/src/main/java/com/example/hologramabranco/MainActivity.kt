package com.example.hologramabranco

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.graphics.Color
import android.view.Gravity

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val layout = LinearLayout(this).apply { orientation = LinearLayout.VERTICAL; gravity = Gravity.CENTER; setPadding(32,32,32,32); setBackgroundColor(Color.rgb(8,12,20)) }
        val title = TextView(this).apply { text = "HOLOGRAMA BRANCO"; textSize = 25f; setTextColor(Color.WHITE); gravity = Gravity.CENTER }
        val info = TextView(this).apply { text = "Interface visual decorativa. Não identifica personagens nem altera o jogo."; textSize = 15f; setTextColor(Color.LTGRAY); gravity = Gravity.CENTER; setPadding(0,24,0,24) }
        val permission = Button(this).apply { text = "Permitir sobreposição"; setOnClickListener { if (!Settings.canDrawOverlays(this@MainActivity)) startActivity(Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:$packageName"))) } }
        val start = Button(this).apply { text = "Mostrar holograma"; setOnClickListener { if (Settings.canDrawOverlays(this@MainActivity)) startService(Intent(this@MainActivity, OverlayService::class.java)) else startActivity(Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:$packageName"))) } }
        val stop = Button(this).apply { text = "Fechar holograma"; setOnClickListener { stopService(Intent(this@MainActivity, OverlayService::class.java)) } }
        layout.addView(title); layout.addView(info); layout.addView(permission); layout.addView(start); layout.addView(stop)
        setContentView(layout)
    }
}
