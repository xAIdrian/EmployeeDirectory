package com.amohnacs.squareemployeedirectory.domain

import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class EmployeeRepository @Inject constructor(
        private val retrofitService: RetrofitService
) {
    fun fetchEmployees() = retrofitService.getEmployeeResponse().subscribeOn(Schedulers.io())
    fun fetchMalformedOrEmpty(shouldFetchMalformed: Boolean = false) =
            if (shouldFetchMalformed) {
                retrofitService.getMalformed()
            } else {
                retrofitService.getEmptyEmployees()
            }
}