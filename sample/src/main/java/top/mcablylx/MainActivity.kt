package top.mcablylx

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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

        name = "33333333333"

    }
}
