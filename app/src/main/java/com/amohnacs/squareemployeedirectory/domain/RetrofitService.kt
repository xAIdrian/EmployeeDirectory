package com.amohnacs.squareemployeedirectory.domain

import com.amohnacs.squareemployeedirectory.model.EmployeeResponse
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET

interface RetrofitService {

    @GET("sq-mobile-interview/employees.json")
    fun getEmployeeResponse(): Single<EmployeeResponse>

    @GET("sq-mobile-interview/employees_malformed.json")
    fun getMalformed(): Observable<EmployeeResponse>

    @GET("sq-mobile-interview/employees_empty.json")
    fun getEmptyEmployees(): Observable<EmployeeResponse>
}