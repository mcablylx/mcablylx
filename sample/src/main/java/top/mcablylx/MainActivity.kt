package top.mcablylx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import top.mcablylx.common.ext.show
import top.mcablylx.common.initialization

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initialization(this)
        show("55555555555")
    }
}
