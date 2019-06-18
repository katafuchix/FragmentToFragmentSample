package com.example.fragmenttofragmentsample

import android.os.Bundle
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment01.view.*

class Fragment01 : Fragment() {

    // ビュー生成
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? { // この中で初期化処理を行うイメージ

        // xmlから実態を生成
        val fragment01 = inflater.inflate(
            R.layout.fragment01,
            container, false
        )
        // 引数を受け取る
        val bundle = arguments
        val count = bundle!!.getInt("Counter")

        // 内部で利用する変数
        val str = "Fragment01: " + count.toString()
        val cnt :Int   = count + 1

        // 画面表示やボタン動作などもここで定義する
        // 表示テキスト
        fragment01.textview_01.setText(str)

        // ボタン処理 Fragment02へ
        fragment01.button_01.setOnClickListener {
            val fragmentManager = getFragmentManager()
            val fragmentTransaction = fragmentManager?.beginTransaction()
            // BackStackを設定
            fragmentTransaction?.addToBackStack(null)
            fragmentTransaction?.replace(R.id.container, Fragment02.newInstance(cnt))
            fragmentTransaction?.commit()
        }

        //  ボタン処理 BackStackで１つ戻す
        fragment01.pop_01.setOnClickListener {
            val fragmentManager = fragmentManager
            fragmentManager?.popBackStack()
        }

        // 最後に生成したビューを返す
        return fragment01
    }

    // インスタンス生成
    // 他クラスから利用する場合にこのメソッドを呼ぶ
    companion object {
        fun newInstance(count: Int): Fragment01 {
            // Fragemnt01 インスタンス生成
            val fragment01 = Fragment01()

            // Bundle にパラメータを設定
            val args = Bundle()
            args.putInt("Counter", count)
            fragment01.setArguments(args)

            return fragment01
        }
    }
}