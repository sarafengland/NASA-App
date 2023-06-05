package com.example.nasaapp.ui.mainFragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nasaapp.repository.Repository
import kotlinx.coroutines.launch

class MainFragmentViewModel(
    private val repository: Repository
) : ViewModel() {

    private val SEARCH_PARAM = "Apollo 11"
    private val SEARCH_MEDIA_TYPE = "image"

    var title: MutableLiveData<String?> = MutableLiveData("")
    var imageUrl: MutableLiveData<String?> = MutableLiveData()
    var description: MutableLiveData<String?> = MutableLiveData("")

    fun searchItems() {
        viewModelScope.launch {
            val response = repository.getCollection(SEARCH_PARAM, SEARCH_MEDIA_TYPE)
            response?.let {
                val items = it.nasaCollection?.items
                items?.let { itemsList ->
                    if (itemsList.isNotEmpty()) {
                        title.value = items[0].data?.get(0)?.title
                        imageUrl.value = items[0].links?.get(0)?.href
                        description.value = items[0].data?.get(0)?.description
                    }
                }

            }
        }
    }

}