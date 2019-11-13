package com.example.praktikumpbm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import androidx.core.view.GestureDetectorCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

    var gDetector: GestureDetectorCompat? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.gDetector = GestureDetectorCompat(this, this);
        gDetector?.setOnDoubleTapListener(this);
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        this.gDetector?.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    override fun onDown(p0: MotionEvent?): Boolean {
        gesture.text = "this is onDown";
        return true;
    }

    override fun onFling(p0: MotionEvent?, p1: MotionEvent?, p2: Float, p3: Float): Boolean {
        gesture.text = "this is onFling";
        return true;
    }

    override fun onScroll(p0: MotionEvent?, p1: MotionEvent?, p2: Float, p3: Float): Boolean {
        gesture.text = "this is onScroll";
        return true
    }

    override fun onShowPress(p0: MotionEvent?) {
        gesture.text = "this is onShowPress";
    }

    override fun onSingleTapUp(p0: MotionEvent?): Boolean {
        gesture.text = "this is onSingleTapUp";
        return true
    }

    override fun onSingleTapConfirmed(p0: MotionEvent?): Boolean {
        gesture.text = "this is onSingleTapConfirmed";
        return true
    }

    override fun onDoubleTapEvent(p0: MotionEvent?): Boolean {
        gesture.text = "this is onDoubleTapEvent";
        return true
    }

    override fun onDoubleTap(p0: MotionEvent?): Boolean {
        gesture.text = "this is onDoubleTap";
        return true
    }

    override fun onLongPress(p0: MotionEvent?) {
        gesture.text = "this is onLongPress";
    }
}
