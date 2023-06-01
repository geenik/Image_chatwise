package com.example.image_chatwise

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class image_activity : AppCompatActivity() {
    lateinit var  madapter:photoListAdapter
    lateinit var viewmodel:mainviewmodel
    lateinit var progressBar: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)
        val photoservice=retrofithelper.getinstace().create(photoapi::class.java)
        val repository=Repository(photoservice)
        progressBar=findViewById(R.id.progressbar)
         viewmodel= ViewModelProvider(this,MyViewModelFactory(repository)).get(mainviewmodel::class.java)
        val recyclerView=findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.layoutManager= LinearLayoutManager(this)
        madapter= photoListAdapter()
        recyclerView.adapter=madapter
        GlobalScope.launch(Dispatchers.Main) {
            progressBar.visibility=View.VISIBLE
           viewmodel.fetchphoto()
            madapter.update(viewmodel.photodata)
            progressBar.visibility=View.GONE
        }
    }

}