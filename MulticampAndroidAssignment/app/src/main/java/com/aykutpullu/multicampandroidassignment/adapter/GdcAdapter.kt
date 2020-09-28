package com.aykutpullu.multicampandroidassignment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.aykutpullu.multicampandroidassignment.R
import com.aykutpullu.multicampandroidassignment.model.DeveloperGroup
import com.aykutpullu.multicampandroidassignment.model.downloadImage
import com.aykutpullu.multicampandroidassignment.view.CommunityFragmentDirections
import kotlinx.android.synthetic.main.community_list_item.view.*
import kotlinx.android.synthetic.main.fragment_detail_community.view.*

class GdcAdapter(val gdcList : ArrayList<DeveloperGroup>) : RecyclerView.Adapter<GdcAdapter.GdcViewHolder>() {

    class GdcViewHolder(var view : View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GdcAdapter.GdcViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.community_list_item,parent,false)
        return GdcViewHolder(view)

    }

    override fun onBindViewHolder(holder: GdcAdapter.GdcViewHolder, position: Int) {

        gdcList[position].gdcBanner?.let {
            holder.view.listGdcImageView.downloadImage(it)


            holder.view.setOnClickListener {
                val action = CommunityFragmentDirections.actionCommunityFragmentToDetailCommunityFragment(
                    gdcList[position].gdcLeader!!.leaderName!!,
                    gdcList[position].gdcLeader!!.leaderPhoto!!,
                    gdcList[position].gdcLinks!!.instagramLink!!,
                    gdcList[position].gdcLinks!!.twitterLink!!,
                    gdcList[position].gdcLinks!!.youtubeLink!!,
                    gdcList[position].gdcLinks!!.participationLink!!,
                    gdcList[position].gdcDescription!!,
                    gdcList[position].gdcBanner!!)

                Navigation.findNavController(it).navigate(action)
            }

        }



    }

    override fun getItemCount(): Int {
        return gdcList.size

    }

    fun updateGdcList (newGdcList : List<DeveloperGroup>) {
        gdcList.clear()
        gdcList.addAll(newGdcList)
        notifyDataSetChanged()

    }





}