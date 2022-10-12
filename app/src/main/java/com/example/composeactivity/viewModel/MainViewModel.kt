package com.example.composeactivity.viewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeactivity.data.Receipe
import com.example.composeactivity.repository.ApiService
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    var receipeResponse: MutableState<List<Receipe>> = mutableStateOf(listOf())
    var error: String by mutableStateOf("")

    fun getReceipeList() {
        viewModelScope.launch {
            val apiService = ApiService.getInstance()
            try {
                val response = apiService.receipe("pizza")
                receipeResponse.value = response.body()?.receipes!!
            } catch (e: Exception) {
                error = e.message.toString()
            }
        }
    }


}