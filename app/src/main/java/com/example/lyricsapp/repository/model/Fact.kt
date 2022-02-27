package com.example.lyricsapp.repository.model

import com.google.gson.annotations.SerializedName

class Fact {

    @SerializedName("_id")
    var id: String? = null

    @SerializedName("__v")
    var v: String? = null
    var text: String? = null

    @SerializedName("updatedAt")
    var updateAt: String? = null
    var deleted: Boolean? = null
    var source: String? = null
    var sentCount: Int? = null

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Fact) return false
        return id == other.id
                && (text == other.text || (text != null && text.equals(other.text)))
                && (updateAt == other.updateAt || (updateAt != null && updateAt.equals(other.updateAt)))
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

    override fun toString(): String {
        return "Fact(id=$id, v=$v, text=$text, updateAt=$updateAt, deleted=$deleted, source=$source, sentCount=$sentCount)"
    }

}
