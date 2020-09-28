package com.aykutpullu.multicampandroidassignment.model

import com.google.gson.annotations.SerializedName

data class DeveloperGroup(

    @SerializedName("name")
    val gdcName:String?,

    @SerializedName("description")
    val gdcDescription: String? ,

    @SerializedName("banner")
    val gdcBanner: String? ,

    @SerializedName("leader")
    val gdcLeader : leaderModel?,

    @SerializedName("links")
    val gdcLinks : linksModel?

)

data class leaderModel(

    @SerializedName("name")
    val leaderName: String?,

    @SerializedName("photo")
    val leaderPhoto : String?,
)

data class linksModel (

    @SerializedName("instagram")
    val instagramLink:String?,

    @SerializedName("twitter")
    val twitterLink: String? ,

    @SerializedName("youtube")
    val youtubeLink : String?,

    @SerializedName("participation")
    val participationLink : String?

)