package com.pleoexpenseschallenge.infrastructure.request

import com.google.gson.annotations.SerializedName

class CommentBody(@SerializedName("comment") val comment: String)
