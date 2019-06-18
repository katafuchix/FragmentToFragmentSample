package com.example.fragmenttofragmentsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()

            // BackStackを設定
            fragmentTransaction.addToBackStack(null)

            // counterをパラメータとして設定
            val count = 0
            // Fragment01のインスタンスを生成
            val fragment01 = Fragment01.newInstance(count)

            // idがcontainerの領域にフラグメントを表示
            fragmentTransaction.replace(R.id.container, fragment01)
            fragmentTransaction.commit()
        }
    }
}
