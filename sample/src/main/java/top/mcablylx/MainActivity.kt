package top.mcablylx

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import top.mcablylx.R.id.contentTextView
import top.mcablylx.common.coroutine.runSuspend
import top.mcablylx.common.coroutine.startCoroutine
import top.mcablylx.common.ext.pref
import top.mcablylx.common.ext.show
import top.mcablylx.common.initialization
import top.mcablylx.common.utils.StatusBarUtil

class MainActivity : AppCompatActivity() {

    var name by pref("333")

//    val rlv by lazy {
//        findViewById<ListView>(R.id.lv)
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initialization(this)
        show(name)
        Log.d("FUCK", "当前的线程ID: ${android.os.Process.myTid()}")
        name = "33333333333"
        try {
            startCoroutine {
                Log.d("FUCK", "当前的线程ID: ${android.os.Process.myTid()}")
                val yyyy = runSuspend {
                    Log.d("FUCK", "当前的线程ID: ${android.os.Process.myTid()}")
                    Thread.sleep(3000)
                    "7777777"
                }
                Log.d("FUCK", "当前的线程ID: ${android.os.Process.myTid()}")
                Log.d("FUCK", yyyy)
                show(yyyy)
            }
        } catch (e: Exception) {
            Log.d("FUCK", "当前的线程ID: ${android.os.Process.myTid()}")
            e.printStackTrace()
        }
       // StatusBarUtil.setTranslucentStatus(this)
        if (!StatusBarUtil.setStatusBarDarkTheme(this, true)) {
            //如果不支持设置深色风格 为了兼容总不能让状态栏白白的看不清, 于是设置一个状态栏颜色为半透明,
            //这样半透明+白=灰, 状态栏的文字能看得清
            StatusBarUtil.setStatusBarColor(this,0x55000000)
        }
      //  rlv.adapter = ListAdapter(this)

    }

}

class ListAdapter(val context: Context) : BaseAdapter() {
    val list = MutableList(50){
        false
    }
    override fun getItem(p0: Int) = p0
    override fun getItemId(p0: Int) = p0.toLong()
    override fun getCount() = 50
    override fun getView(position: Int, view: View?, p: ViewGroup?): View {
        val inflate = LayoutInflater.from(context).inflate(R.layout.aa, null, false) as ExpandableTextView
        inflate.contentTextView.text = "第${position}"+ inflate.contentTextView.text.toString()
        inflate.adapter = this
        inflate.poistion = position
        list[position] = inflate.flag
        return inflate
    }


}
