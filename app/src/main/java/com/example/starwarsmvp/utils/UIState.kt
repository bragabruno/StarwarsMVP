package com.example.starwarsmvp.utils

import com.example.starwarsmvp.model.GeneralResponse

sealed class UIState {
    object LOADING : UIState()
    data class SUCCESS(val response: GeneralResponse) : UIState()
    class ERROR(val e: Exception) : UIState()
}
