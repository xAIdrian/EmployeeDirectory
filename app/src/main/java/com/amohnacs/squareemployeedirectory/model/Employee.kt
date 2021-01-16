package com.amohnacs.squareemployeedirectory.model

import com.google.gson.annotations.SerializedName

data class Employee(
    val uuid: String,
    @SerializedName("full_name") val fullName: String,
    @SerializedName("phone_number")val phoneNumber: String? = null,
    @SerializedName("email_address") val emailAddress: String,
    val biography: String? = null,
    @SerializedName("photo_url_small")val photoUrlSmall: String? = null,
    @SerializedName("photo_url_large")val photoUrlLarge: String? = null,
    val team: String,
    @SerializedName("employee_type")val employeeType: EmployeeType? = null
)

enum class EmployeeType(val value: String) {
    @SerializedName("FULL_TIME") FULL_TIME("Full Time"),
    @SerializedName("PART_TIME") PART_TIME("Part Time"),
    @SerializedName("CONTRACTOR") CONTRACTOR("Contractor")
}