package com.example.multiplerecycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.multiplerecycler.adapter.FolderAdapter
import com.example.multiplerecycler.databinding.ActivityFileBinding
import com.example.multiplerecycler.models.FolderModel

class FileActivity : AppCompatActivity() {
    private var binding : ActivityFileBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFileBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        var folderList : ArrayList<FolderModel>? = null
        if(intent.hasExtra(MainActivity.FILE_DETAILS)){
            folderList = intent.getSerializableExtra(MainActivity.FILE_DETAILS) as ArrayList<FolderModel>

            setUpFileRecyclerView(folderList)
        }


    }

    private fun setUpFileRecyclerView(list: ArrayList<FolderModel>){
        binding?.rvFileDetails?.layoutManager = LinearLayoutManager(this)
        val fileAdapter = FolderAdapter(this,list, FILE_DETAILS)

        binding?.rvFileDetails?.adapter = fileAdapter
        binding?.rvFileDetails?.setHasFixedSize(true)


    }

    companion object{
        val FILE_DETAILS = "file details"
    }
}