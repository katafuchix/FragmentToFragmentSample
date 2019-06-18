# FragmentToFragmentSample


## Custom Fragment Class
```
class XXXFragment : Fragment() {

    // ビュー生成
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? { // この中で初期化処理を行うイメージ

       // xmlから実体を生成
        val fragment = inflater.inflate(
            R.layout.fragment_xxx,
            container, false
        )
        // 引数を受け取る
        val bundle = arguments
        val param = bundle!!.getInt("param")

        // 画面表示やボタン動作などもここで定義する
        // 表示テキスト
        fragment.textview.setText("xxxxx")

        // ボタン処理 
        fragment.button.setOnClickListener {
        
        }
        
        // 最後に生成したビューを返す
        return fragment
  }
  
  // インスタンス生成
  // 他クラスから利用する場合にこのメソッドを呼ぶ
  // 引数は自由に定義できる
  companion object {
      fun newInstance(param: Int): Fragment01 {
            // Fragemnt インスタンス生成
            val fragment = XXXFragment()

            // Bundle にパラメータを設定
            val args = Bundle()
            args.putInt("param", param)
            fragment.setArguments(args)
            return fragment
      }
  }
}
```

### use Fragment in MainActivity
```
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()

            // BackStackを設定
            fragmentTransaction.addToBackStack(null)

            // paramをパラメータとして設定
            val param = 0
            // Fragmentのインスタンスを生成
            val fragment = XXXFragment.newInstance(count)

            // idがcontainerの領域にフラグメントを表示
            fragmentTransaction.replace(R.id.container, fragment)
            fragmentTransaction.commit()
        }
    }
}
```
