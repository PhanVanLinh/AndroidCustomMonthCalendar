package linh.vn.androidcustommonthcalendar

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val monthOfYear = findViewById<MonthOfYear>(R.id.month)
        monthOfYear.highlight(7)

        monthOfYear.setOnMonthSelectedListener {
            Toast.makeText(MainActivity@ this, "click " + it, Toast.LENGTH_LONG).show()
        }
    }
}
