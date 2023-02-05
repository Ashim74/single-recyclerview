package com.example.multiplerecycler.models

import java.io.Serializable

data class FolderModel (
    val name: String,
    val fileName: String,
    val size : Float
        ): Serializable
