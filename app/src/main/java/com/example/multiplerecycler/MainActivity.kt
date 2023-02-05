package com.example.multiplerecycler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.multiplerecycler.adapter.FolderAdapter
import com.example.multiplerecycler.databinding.ActivityMainBinding
import com.example.multiplerecycler.models.FolderModel

class MainActivity : AppCompatActivity() {
    private var binding : ActivityMainBinding? = null
    private val folderList : ArrayList<FolderModel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        folderDetail()
        Log.e("myTag folderlist",folderList?.size.toString())
        setUpRecyclerView(folderList)
    }

    private fun folderDetail(){
        folderList.add(FolderModel("folder 1", "file 1",1.0f))
        folderList.add(FolderModel("folder 2", "file 2",2.0f))
        folderList.add(FolderModel("folder 3", "file 3",3.0f))
        folderList.add(FolderModel("folder 4", "file 4",4.0f))
    }

    private fun setUpRecyclerView(list: ArrayList<FolderModel>){
        binding?.rvFolder?.layoutManager = LinearLayoutManager(this)

        val folderAdapter = FolderAdapter(this,list, FOLDER_DETAIL)
        binding?.rvFolder?.adapter = folderAdapter
        binding?.rvFolder?.setHasFixedSize(true)

        folderAdapter.setOnClickListener(object : FolderAdapter.OnClickListener{
            override fun onclick(position: Int, model: FolderModel) {
                val intent : Intent = Intent(this@MainActivity,FileActivity::class.java)
                intent.putExtra(FILE_DETAILS,folderList)
                startActivity(intent)
            }

        })


    }
    companion object{
        var FILE_DETAILS = "file detail"
        var FOLDER_DETAIL = "folder details"
    }
}