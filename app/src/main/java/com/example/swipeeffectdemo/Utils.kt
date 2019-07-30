package com.example.swipeeffectdemo

import android.content.Context
import android.util.Log
import com.google.gson.GsonBuilder
import org.json.JSONArray
import java.io.IOException
import java.io.InputStream
import java.lang.Exception
import java.nio.charset.Charset

private const val TAG = "Utils"
object Utils {
    @JvmStatic
    fun loadProfiles(context: Context): List<Profile>? {
        try {
            val builder = GsonBuilder()
            val gson = builder.create()
            val array = JSONArray(loadJSONFromAsset(context, "profiles.json"))
            val profileList = ArrayList<Profile>()
            for (i in 0 until array.length()) {
                val profile = gson.fromJson<Profile>(array.getString(i), Profile::class.java)
                profileList.add(profile)
            }

            return profileList
        } catch (e: Exception) {
            e.printStackTrace()
            return null
        }
    }

    fun loadJSONFromAsset(context: Context, jsonFileName: String):  String? {
        var json: String? = null
        var inputStream: InputStream? = null
        try {
            var manager = context.assets
            Log.d(TAG, "path $jsonFileName")
            inputStream = manager.open(jsonFileName)
            var size = inputStream.available()
            var buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer, Charset.forName("UTF-8"))

        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }

        return json
    }

}