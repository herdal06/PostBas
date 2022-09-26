package com.herdal.postlist

import Versions

object Libs {

    object Gradle {
        const val androidGradlePlugin = "com.android.tools.build:gradle:7.0.0"
    }

    object AndroidX {
        const val core = "androidx.core:core-ktx:" + Versions.coreKtx
        const val appCompat = "androidx.appcompat:appcompat:" + Versions.appCompat
        const val constraintLayout =
            "androidx.constraintlayout:constraintlayout:" + Versions.constraint
        const val vmLifeCycle = "androidx.lifecycle:lifecycle-viewmodel-ktx:" + Versions.viewModel
        const val navigation = "androidx.navigation:navigation-fragment-ktx:" + Versions.navigation
        const val navigationUI = "androidx.navigation:navigation-ui-ktx:" + Versions.navigation
        const val preference = "androidx.preference:preference:" + Versions.preference
        const val nav_args_plugin =
            "androidx.navigation:navigation-safe-args-gradle-plugin:" + Versions.navigation
    }

    object Google {
        const val material = "com.google.android.material:material:" + Versions.material
        const val services = "com.google.gms:google-services:" + Versions.googleServices
    }

    object Hilt {
        const val android = "com.google.dagger:hilt-android:" + Versions.hilt
        const val compiler = "com.google.dagger:hilt-compiler:" + Versions.hilt
        const val plugin = "com.google.dagger:hilt-android-gradle-plugin:" + Versions.hilt
    }

    object Room {
        const val ktx = "androidx.room:room-ktx:" + Versions.room
        const val runtime = "androidx.room:room-runtime:" + Versions.room
        const val compiler = "androidx.room:room-compiler:" + Versions.room
    }

    object Network {
        const val gson: String = "com.google.code.gson:gson:" + Versions.gson
        const val retrofit = "com.squareup.retrofit2:retrofit:" + Versions.retrofit
        const val converter = "com.squareup.retrofit2:converter-gson:" + Versions.retrofit
        const val okhttp = "com.squareup.okhttp3:okhttp:" + Versions.ok_http
        const val interceptor = "com.squareup.okhttp3:logging-interceptor:" + Versions.ok_http
        const val rxJava = "com.squareup.retrofit2:adapter-rxjava2:" + Versions.rxJava
    }

    object Image {
        const val coil: String = "io.coil-kt:coil:" + Versions.coil
    }
}