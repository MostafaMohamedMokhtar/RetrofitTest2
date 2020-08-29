package com.example.retrofittest2

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var textShow: TextView = findViewById(R.id.textView)
        try {

            var retrofit: Retrofit = Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val apiInterface: ApiInterface = retrofit.create(ApiInterface::class.java)

            // using post
          //  val post:Post = Post(5 , "codingWithMokh" , " hi , from the other side ")
            val map: HashMap<Any, Any> = HashMap()
            map["title"] = " Mostafa Mokhtar "
            map["body"] = " this is the second post "
            map["userId"] = 6
            val call: Call<Post> = apiInterface.storePost(map)
            call.enqueue(object : Callback<Post>{
                override fun onFailure(call: Call<Post>, t: Throwable) {
                    textShow.setText(t.message)
                }

                override fun onResponse(call: Call<Post>, response: Response<Post>) {
                    textShow.setText(response.body()?.title)
                }

            })
            // using get
        /*    val call: Call<List<Post?>>? = apiInterface.getPost("1")

            call!!.enqueue(object : Callback<List<Post?>> {
                override fun onFailure(call: Call<List<Post?>>, t: Throwable) {
                    textShow.setText(t.message)
                }

                override fun onResponse(call: Call<List<Post?>>, response: Response<List<Post?>>) {
                    textShow.setText(response.body()?.get(0)?.title)
                }


            }) */
        }
        catch (e:Exception){
            Toast.makeText(this , e.localizedMessage , Toast.LENGTH_LONG).show()
        }
    }
}

