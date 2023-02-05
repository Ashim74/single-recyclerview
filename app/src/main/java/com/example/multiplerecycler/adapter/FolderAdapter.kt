package com.example.multiplerecycler.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.multiplerecycler.MainActivity
import com.example.multiplerecycler.databinding.FileItemBinding
import com.example.multiplerecycler.databinding.FolderItemBinding
import com.example.multiplerecycler.models.FolderModel

open class FolderAdapter (
    private val context: Context,
    private var list:ArrayList<FolderModel>,
    private var CHOSEN_ADAPTER: String)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    private var onClickListener:OnClickListener? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(CHOSEN_ADAPTER == MainActivity.FOLDER_DETAIL){
            return MyFolderViewHolder(FolderItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
        }else{
            return MyFileViewHolder(FileItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val model = list[position]
        if(holder is MyFolderViewHolder){
            holder.folderName.text = list[position].name
            holder.itemView.setOnClickListener{
                onClickListener!!.onclick(position, model)
            }
        }
        if(holder is MyFileViewHolder){
            holder.fileName.text = list[position].fileName
            holder.fileNumber.text = list[position].size.toString()
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    //----------------------------------------------------------------------------

    class MyFolderViewHolder (private val binding: FolderItemBinding):RecyclerView.ViewHolder(binding.root){
        var folderName = binding.tvFolderName
    }
    class MyFileViewHolder (private val binding: FileItemBinding):RecyclerView.ViewHolder(binding.root){
        var fileName = binding.tvFileName
        var fileNumber = binding.tvFileNumber
    }

    fun setOnClickListener(onClickListener: OnClickListener){
        this.onClickListener = onClickListener
    }

    interface OnClickListener{

        fun onclick(position: Int ,model: FolderModel)
    }



}
