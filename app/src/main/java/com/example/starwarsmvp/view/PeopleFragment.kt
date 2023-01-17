package com.example.starwarsmvp.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.starwarsmvp.databinding.FragmentGeneralBinding
import com.example.starwarsmvp.di.StarWarsApp
import com.example.starwarsmvp.model.GeneralResponse
import com.example.starwarsmvp.presenters.PeoplePresenterContract
import com.example.starwarsmvp.presenters.PeopleViewContract
import javax.inject.Inject

private const val TAG = "PeopleFragment"

class PeopleFragment : Fragment(), PeopleViewContract {

    private val binding by lazy {
        FragmentGeneralBinding.inflate(layoutInflater)
    }

    @Inject
    lateinit var presenter: PeoplePresenterContract

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StarWarsApp.starWarsComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        presenter.initPresenter(this)

        presenter.getPeopleData(lifecycleScope)

        return binding.root
    }

    override fun onStop() {
        super.onStop()
        presenter.destroyPresenter()
    }

    override fun loading() {
        // no-op
    }

    override fun success(response: GeneralResponse) {
        Log.d(TAG, "success: ${response.results}")
    }

    override fun error(e: Exception) {
        Log.e(TAG, "error: ${e.message}", e)
    }
}
