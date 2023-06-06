package com.example.nasaapp.ui.mainFragment

import android.content.res.Resources
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nasaapp.R
import com.example.nasaapp.models.nasamodels.Item
import com.example.nasaapp.repository.Repository
import kotlinx.coroutines.launch

class MainFragmentViewModel(
    private val repository: Repository,
    private val resources: Resources
) : ViewModel() {

    companion object {
        const val SEARCH_PARAM = "Apollo 11"
        const val SEARCH_DESCRIPTION = "Moon landing"
        const val SEARCH_MEDIA_TYPE = "image"
        const val NUM_OF_ITEMS = 10
    }

    var items = MutableLiveData<List<Item>>()
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
            val response = repository.getCollection(
                searchQuery = SEARCH_PARAM,
                description = SEARCH_DESCRIPTION,
                mediaType = SEARCH_MEDIA_TYPE
            )
            response.responseCollection?.let {
                val responseItems = it.nasaCollection?.items
                responseItems?.let { itemsList ->
                    if (itemsList.isNotEmpty()) {
                        items.value = getFirstItems(NUM_OF_ITEMS, itemsList)
                    } else {
                        displayErrorMessage()
                    }
                } ?: displayErrorMessage()
            } ?: displayErrorMessage()
        }
    }

    private fun displayErrorMessage() {
        errorMessage.value = resources.getString(R.string.no_data_message)
    }

    private fun getFirstItems(numOfItems: Int, itemList: List<Item>): List<Item> {
        val list = mutableListOf<Item>()
        for (i in 1..numOfItems) {
            val item = itemList[i]
            list.add(item)
        }
        return list
    }
}