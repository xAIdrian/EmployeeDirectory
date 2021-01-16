package com.amohnacs.squareemployeedirectory.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.amohnacs.squareemployeedirectory.domain.EmployeeRepository
import com.amohnacs.squareemployeedirectory.model.Employee
import com.amohnacs.squareemployeedirectory.common.SingleLiveEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MainViewModel @Inject constructor(
        private val repository: EmployeeRepository
) : ViewModel() {

    private val disposable = CompositeDisposable()
    val employees = MutableLiveData<List<Employee>>()
    val errorLiveEvent = SingleLiveEvent<String>()
    val loadingEvent = SingleLiveEvent<Boolean>()

    fun getEmployees() {
        loadingEvent.value = true
        disposable.add(
                repository.fetchEmployees()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                { response ->
                                    loadingEvent.value = false
                                    if (response.employees?.isEmpty() == false) {
                                        employees.value = response.employees
                                    } else {
                                        errorLiveEvent.value = "Empty employees.\nClick here to retry"
                                    }
                                },
                                {
                                    loadingEvent.value = false
                                    errorLiveEvent.value = "Error making request.\nClick here to retry"
                                }
                        )
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}