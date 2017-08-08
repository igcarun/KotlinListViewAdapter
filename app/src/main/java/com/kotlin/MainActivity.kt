package com.kotlin

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.kotlin.databinding.ActivityMainBinding
import com.kotlin.dto.User
import com.squareup.picasso.Picasso
import com.squareup.picasso.RequestCreator

class MainActivity : AppCompatActivity(), Presenter, HappyBirthday{
    override fun summaTest(view: View?) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        Toast.makeText(this@MainActivity, "Success on summa test", Toast.LENGTH_SHORT).show()
    }


    override fun onClick(view: View?, user: User?) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        Toast.makeText(this@MainActivity, "Success on click", Toast.LENGTH_SHORT).show()

    }


    private var value : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        val activity_binding: ActivityMainBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        val user = User("$value", 24, "Calibraint Technologies Pvt Ltd")
        activity_binding.users = user
        activity_binding.apple = this@MainActivity
        activity_binding.orange = this@MainActivity
        activity_binding.executePendingBindings()
        val mImageView = findViewById(R.id.activity_main_civ) as ImageView
        /* picasso.load("https://www.ussu.co.uk/ClubsSocieties/societies/People_and_Planet/PublishingImages/Go%20green%20sustainability%20society.png")
                .placeholder(R.drawable.imgpsh_fullsize)
                .resize(600, 600)
                .into(mImageView)*/
        (mImageView as ImageView).load("http://news.indiglamour.com/wp-content/uploads/2015/11/Some-Details-About-Captain-Vijayakanth%E2%80%99s-Tamilan-Endru-Sol.png") {
            requestCreator ->
            requestCreator.resize(600, 600).centerCrop()
        }
        /* val values : MainsActivity = MainsActivity(this)
        values.message()*/

        mImageView.setOnClickListener {
            val intent: Intent = Intent(this@MainActivity, KotlinListDataBindingActivity::class.java)
            startActivity(intent)
        }
    }

    fun ImageView.load(path: String, request: (RequestCreator) -> RequestCreator) {
        request(getContext().picasso.load(path)).into(this)
    }

    val Context.picasso: Picasso
        get() = Picasso.with(this)
}
