package top.mcablylx

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import top.mcablylx.common.coroutine.runSuspend
import top.mcablylx.common.coroutine.startCoroutine
import top.mcablylx.common.ext.pref
import top.mcablylx.common.ext.show
import top.mcablylx.common.initialization

class MainActivity : AppCompatActivity() {

    var name by pref("333")

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


    }
}
