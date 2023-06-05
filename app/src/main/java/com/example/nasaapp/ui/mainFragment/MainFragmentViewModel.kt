package com.example.nasaapp.ui.mainFragment

import android.content.res.Resources
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nasaapp.R
import com.example.nasaapp.repository.Repository
import kotlinx.coroutines.launch

class MainFragmentViewModel(
    private val repository: Repository,
    private val resources: Resources
) : ViewModel() {

    companion object {
        const val SEARCH_PARAM = "Apollo 11"
        const val SEARCH_MEDIA_TYPE = "image"
    }

    var title: MutableLiveData<String?> = MutableLiveData()
    var imageUrl: MutableLiveData<String?> = MutableLiveData()
    var description: MutableLiveData<String?> = MutableLiveData()
    var errorMessage: MutableLiveData<String?> = MutableLiveData()
    var hasInternet = false

    fun searchItems() {
        if (hasInternet) {
            requestData()
        } else {
            displayErrorMessage()
        }
    }

    private fun requestData() {
        errorMessage.value = null // clear error message
        viewModelScope.launch {
            val response = repository.getCollection(SEARCH_PARAM, SEARCH_MEDIA_TYPE)
            response.responseCollection?.let {
                val items = it.nasaCollection?.items
                items?.let { itemsList ->
                    if (itemsList.isNotEmpty()) {
                        title.value = items[0].data?.get(0)?.title
                        imageUrl.value = items[0].links?.get(0)?.href
                        description.value = items[0].data?.get(0)?.description
                    } else {
                        displayErrorMessage()
                    }
                }
            } ?: displayErrorMessage()
        }
    }

    private fun displayErrorMessage() {
        errorMessage.value = resources.getString(R.string.no_data_message)
    }
}