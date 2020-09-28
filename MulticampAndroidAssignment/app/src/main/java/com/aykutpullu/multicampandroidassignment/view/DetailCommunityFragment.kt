package com.aykutpullu.multicampandroidassignment.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aykutpullu.multicampandroidassignment.R
import com.aykutpullu.multicampandroidassignment.model.downloadImage
import com.aykutpullu.multicampandroidassignment.model.downloadImageCircular
import kotlinx.android.synthetic.main.fragment_detail_community.*


class DetailCommunityFragment : Fragment() {

    private lateinit var groupBanner : String
    private lateinit var leaderName : String
    private lateinit var leaderPhoto : String
    private lateinit var description : String
    private lateinit var instagramLink : String
    private lateinit var twitterLink : String
    private lateinit var youtubeLink : String
    private lateinit var meetupLink : String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_community, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {

            groupBanner = DetailCommunityFragmentArgs.fromBundle(it).banner
            leaderName = DetailCommunityFragmentArgs.fromBundle(it).leaderName
            leaderPhoto = DetailCommunityFragmentArgs.fromBundle(it).leaderPhoto
            description = DetailCommunityFragmentArgs.fromBundle(it).description
            instagramLink = DetailCommunityFragmentArgs.fromBundle(it).instaLink
            twitterLink = DetailCommunityFragmentArgs.fromBundle(it).twitterLink
            youtubeLink = DetailCommunityFragmentArgs.fromBundle(it).youtubeLink
            meetupLink = DetailCommunityFragmentArgs.fromBundle(it).meetupLink

            detailFragmentBannerImage.downloadImage(groupBanner)
            leaderNameText.text = leaderName
            leaderImage.downloadImageCircular(leaderPhoto)
            descriptionText.text=description

            ButtonInstaImage.setOnClickListener {
                gotoUrl(instagramLink)
            }

            ButtonTwitterImage.setOnClickListener {
                gotoUrl(twitterLink)
            }

            ButtonYtImage.setOnClickListener {
                gotoUrl(youtubeLink)
            }

            ButtonMeetupImage.setOnClickListener {
                gotoUrl(meetupLink)
            }






        }


    }

    fun gotoUrl (url : String) {

        var uri = Uri.parse(url)
        startActivity(Intent(Intent.ACTION_VIEW,uri))
    }
}