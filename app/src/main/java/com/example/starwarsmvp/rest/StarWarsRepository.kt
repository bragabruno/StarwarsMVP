package com.example.starwarsmvp.rest

import com.example.starwarsmvp.utils.DataType
import com.example.starwarsmvp.utils.UIState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

interface StarWarsRepository {
    val people: StateFlow<UIState>
    fun getData(dataType: DataType, uid: String? = null)
}

class StarWarsRepositoryImpl @Inject constructor(
    // Constructor injection a manual way to do Dependency injection
    private val ioDispatcher: CoroutineDispatcher,
    // Passing parameters to the constructor allows to have better testability,
    // since you can control all the objects passed to the TEST CLASS
    private val coroutineScope: CoroutineScope,
    private val serviceAPI: StarWarsAPI
) : StarWarsRepository {

    private val _people: MutableStateFlow<UIState> = MutableStateFlow(UIState.LOADING)
    override val people: StateFlow<UIState> get() = _people

    override fun getData(dataType: DataType, uid: String?) {
        when(dataType) {
            DataType.PEOPLE -> {
                getSWPeople(uid)
            }
            DataType.PLANETS -> {}
            DataType.STARSHIPS -> {}
        }
    }

    private fun getSWPeople(uid: String?) {
        _people.value = UIState.LOADING

        coroutineScope.launch {
            try {
                val response = serviceAPI.getPeople(uid)
                if (response.isSuccessful) {
                    response.body()?.let {
                        _people.value = UIState.SUCCESS(it)
                    } ?: throw Exception()
                } else {
                    throw Exception()
                }
            } catch (e: Exception) {
                _people.value = UIState.ERROR(e)
            }
        }
    }

}