package com.example.einfachkochen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import de.syntaxinstitut.android_ww_template.data.remote.FactApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FactsViewModel(application: Application) : AndroidViewModel(application) {

    private val factsDatabase = getFactsDatabase(application)
    private val repository = AppRepository(FactApi, factsDatabase)

    val factsDataList: LiveData<List<FactsData>> = repository.getAll()

    val likedDataList :LiveData<List<FactsData>> = repository.getliked()

    val facts = repository.fact

    val factsDetail = repository.factsdetail

    private val _factsdetail = MutableLiveData<FactsData>()

    val factsdetail: MutableLiveData<FactsData>
        get() = _factsdetail

    init {
        loadData()
        repository.getAll()
    }

    fun loadData() {
        viewModelScope.launch {
            repository.getFacts()
        }
    }

    fun insertDataFromApi(itemData: FactsData) {
        viewModelScope.launch {
            repository.insertFactsFromApi(itemData)
        }
    }

    fun loadFactsDetail(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            val detail = repository.getFactDetail(id)

           factsDetail.postValue(detail)
        }
    }

    fun updateLikedStatusInDb(isLiked:FactsData){
        viewModelScope.launch (Dispatchers.IO){
            repository.updateLikeStatus(isLiked)
        }
    }

    fun loadLiked(){
        viewModelScope.launch {
        repository.getliked()
        }
    }
}
