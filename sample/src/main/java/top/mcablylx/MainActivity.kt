package top.mcablylx

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.gif.GifDrawable
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import kotlinx.android.synthetic.main.activity_main.*
import top.mcablylx.common.coroutine.runSuspend
import top.mcablylx.common.coroutine.startCoroutine
import top.mcablylx.common.ext.pref
import top.mcablylx.common.ext.show
import top.mcablylx.common.initialization
import top.mcablylx.common.utils.StatusBarUtil


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
        StatusBarUtil.setRootViewFitsSystemWindows(this, false)


        Glide.with(this).asGif().load(R.mipmap.praise_ani).listener(object : RequestListener<GifDrawable> {
            override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<GifDrawable>?, isFirstResource: Boolean): Boolean {

                return false
            }

            override fun onResourceReady(resource: GifDrawable, model: Any?, target: Target<GifDrawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                resource.startFromFirstFrame()
                resource.setLoopCount(1)
                resource.stop()
                return false
            }
        }).into(ivIcon)


    }
/*
    @Permission(...要申请的权限....)
    fun preOk(Permissions){
        //权限申请成功
    }
    @Permission()
    fun preUnOk(Permissions){
        //权限申请不成功
    }*/

}

