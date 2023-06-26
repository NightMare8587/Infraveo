package com.example.infraveotest.Model

import android.provider.ContactsContract.Data
import com.google.gson.annotations.SerializedName

data class InfraveoItem (
          val username : String,
          val email : String,
          val profile : String
        )