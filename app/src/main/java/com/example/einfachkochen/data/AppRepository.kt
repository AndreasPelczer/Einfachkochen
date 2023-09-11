package com.example.einfachkochen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import de.syntaxinstitut.android_ww_template.data.remote.FactApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


const val TAG = "RepositoryTAG"
class AppRepository(val api: FactApi, private val factsDatabase: FactsDataBase) {

    private val _fact = MutableLiveData<List<FactsData>>()

    val fact: LiveData<List<FactsData>>
        get() = _fact

    private val _factsdetail = MutableLiveData<FactsData>()
    val factsdetail: MutableLiveData<FactsData>
        get() = _factsdetail
    suspend fun getFacts() {
        try {
            val fact = api.retrofitservice.getFact()
            _fact.postValue(listOf(fact))
            insertFactsFromApi(fact)
            Log.d(TAG, "getFacts Data: $fact")
        } catch (e: Exception) {
            Log.e(TAG, "Error loading Data from API: $e")
        }
    }
    fun insertFactsFromApi(itemData: FactsData) {
        try {
            GlobalScope.launch {
                Log.d(TAG, "getItems Data: $itemData, $itemData")
                factsDatabase.dao.insertAll(itemData)
            }
        } catch (e: java.lang.Exception) {
            Log.d(TAG, "Error inserting facts from API into database: $e")
        }
    }
    fun getAll():LiveData<List<FactsData>> {
        return factsDatabase.dao.getAll()
    }

    fun getFactDetail(id:Long):FactsData{
        return factsDatabase.dao.getItemById(id)
    }


    fun updateLikeStatus(isLiked: FactsData) {
        try {
            GlobalScope.launch {
                factsDatabase.dao.updateItem(isLiked)
            }

        }catch (e:Exception){

        }

    }

    fun getliked():LiveData<List<FactsData>>{
        return factsDatabase.dao.getLiked()
    }
}


