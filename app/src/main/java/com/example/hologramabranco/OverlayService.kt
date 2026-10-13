package com.example.hologramabranco

import android.app.Service
import android.content.Intent
import android.graphics.Color
import android.graphics.PixelFormat
import android.graphics.Typeface
import android.os.IBinder
import android.view.Gravity
import android.view.WindowManager
import android.widget.TextView

class OverlayService : Service() {
    private var wm: WindowManager? = null
    private var overlay: TextView? = null
    override fun onCreate() {
        super.onCreate()
        wm = getSystemService(WINDOW_SERVICE) as WindowManager
        overlay = TextView(this).apply {
            text = "＋   ◉   HOLO WHITE\n━━━━━━━━━━━━\nHUD DECORATIVO"
            setTextColor(Color.WHITE); textSize = 15f
            typeface = Typeface.create("sans-serif-medium", Typeface.BOLD)
            gravity = Gravity.CENTER; setPadding(22,16,22,16)
            setBackgroundColor(Color.argb(70,15,25,35)); alpha = 0.88f
        }
        val type = if (android.os.Build.VERSION.SDK_INT >= 26) WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY else @Suppress("DEPRECATION") WindowManager.LayoutParams.TYPE_PHONE
        val params = WindowManager.LayoutParams(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT, type, WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL or WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN, PixelFormat.TRANSLUCENT).apply { gravity = Gravity.TOP or Gravity.CENTER_HORIZONTAL; y = 110 }
        wm?.addView(overlay, params)
    }
    override fun onDestroy() { overlay?.let { wm?.removeView(it) }; overlay = null; super.onDestroy() }
    override fun onBind(intent: Intent?): IBinder? = null
}
