package com.example.fragmenttofragmentsample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment02.view.*

class Fragment02 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragment02 = inflater.inflate(
            R.layout.fragment02,
            container, false
        )
        val bundle = arguments
        val count = bundle!!.getInt("Counter")
        val str = "Fragment02: " + count.toString()
        val cnt :Int   = count + 1

        fragment02.textview_02.setText(str)

        fragment02.button_02.setOnClickListener {
            val fragmentManager = fragmentManager
            val fragmentTransaction = fragmentManager?.beginTransaction()

            // BackStackを設定
            fragmentTransaction?.addToBackStack(null)
            fragmentTransaction?.replace(R.id.container, Fragment01.newInstance(cnt))
            fragmentTransaction?.commit()
        }

        //  ボタン処理 BackStackで１つ戻す
        fragment02.pop_02.setOnClickListener {
            val fragmentManager = fragmentManager
            fragmentManager?.popBackStack()
        }
        return fragment02
    }

    companion object {

        fun newInstance(count: Int): Fragment02 {
            // Fragemnt02 インスタンス生成
            val fragment02 = Fragment02()

            // Bundle にパラメータを設定
            val args = Bundle()
            args.putInt("Counter", count)
            fragment02.setArguments(args)

            return fragment02
        }
    }
}