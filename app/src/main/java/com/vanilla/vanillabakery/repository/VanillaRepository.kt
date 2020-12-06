package com.vanilla.vanillabakery.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase

typealias Cakes = List<CakeDto>

class VanillaRepository {

    private val db = Firebase.firestore
    private val cakeRef = db.collectionGroup("cakes")

    fun getCakesByCategory(cat: String) = cakeRef.get().asLiveData<CakeDto>()

}

inline fun <reified T : Any> Task<QuerySnapshot>.asLiveData() = MutableLiveData<Result<List<T>>>().apply {
    addOnSuccessListener { documents ->
        value = documents.map { it.toObject<T>() }.let {
            Result.success(it)
        }
    }.addOnFailureListener {
        value = Result.failure(it)
    }

}

data class CakeDto(
    val id: String = "",
    val icing: String = "",
    val imgUrl: String = "",
    val price: Long = 0
)