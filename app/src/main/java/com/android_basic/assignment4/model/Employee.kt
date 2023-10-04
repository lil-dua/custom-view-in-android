package com.android_basic.assignment4.model

/***
 * Created by HoangRyan aka LilDua on 10/4/2023.
 */
data class Employee(
    val id: String,
    val avatar: Int,
    val name: String,
    var isSelected: Boolean = true
)
