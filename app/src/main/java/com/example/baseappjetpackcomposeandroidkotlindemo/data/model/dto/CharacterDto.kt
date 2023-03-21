package com.example.baseappjetpackcomposeandroidkotlindemo.data.model.dto

import android.os.Parcelable
import com.example.baseappjetpackcomposeandroidkotlindemo.data.model.Status
import kotlinx.parcelize.Parcelize

@Parcelize
data class CharacterDto(
    val created: String?,
    val episode: List<String>?,
    val gender: String?,
    val id: Int?,
    val image: String?,
    val location: LocationDto?,
    val name: String?,
    val origin: LocationDto?,
    val species: String?,
    val status: Status?,
    val type: String?,
    val url: String?,
    var isFavorite: Boolean = false
) : Parcelable {
    companion object {
        fun init() = CharacterDto(
            url = null,
            status = Status.Alive,
            species = "Human",
            name = "Rick Sanchez",
            created = null,
            episode = null,
            gender = null,
            id = 1,
            image = null,
            isFavorite = false,
            location = null,
            origin = null,
            type = null
        )
    }
}