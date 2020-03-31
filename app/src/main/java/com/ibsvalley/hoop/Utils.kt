package com.ibsvalley.hoop

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.util.Patterns


object Utils {
    // Validate email address
    fun validateEmail(mail: String): Boolean {
        return if (mail == "") {
            false
        } else {
            Patterns.EMAIL_ADDRESS.matcher(mail).matches()
        }
    }

    // Validate password
    fun validatePassword(password: String): Boolean {
        return if (password.isNotEmpty()) {
            return password.length >= 6
        } else {
            false
        }
    }

    // Validate username
    fun validateName(name: String): Boolean {
        return if (name.isNotEmpty()) {
            return name.length in 5..40
        } else {
            false
        }
    }

    // Validate phone number
    fun validatePhone(phone: String): Boolean {
        return if (phone.isNotEmpty()) {

            val counter = phone.length

            return if (counter in 10..20) {

                Patterns.PHONE.matcher(phone).matches()
            } else

                false
        } else {
            false
        }
    }


    class SharedPreference(val context: Context) {
        private val PREFS_NAME = "kotlincodes"
        val sharedPref: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

        @SuppressLint("CommitPrefEdits")
        fun save(KEY_NAME: String, text: String) {

            val editor: SharedPreferences.Editor = sharedPref.edit()

            editor.putString(KEY_NAME, text)

            editor.apply()
        }

        fun save(KEY_NAME: String, value: Int) {
            val editor: SharedPreferences.Editor = sharedPref.edit()

            editor.putInt(KEY_NAME, value)

            editor.apply()
        }

        fun save(KEY_NAME: String, status: Boolean) {

            val editor: SharedPreferences.Editor = sharedPref.edit()

            editor.putBoolean(KEY_NAME, status)

            editor.apply()
        }

        fun getValueString(KEY_NAME: String): String? {

            return sharedPref.getString(KEY_NAME, null)


        }

        fun getValueInt(KEY_NAME: String): Int {

            return sharedPref.getInt(KEY_NAME, 0)
        }

        fun getValueBoolien(KEY_NAME: String, defaultValue: Boolean): Boolean {

            return sharedPref.getBoolean(KEY_NAME, defaultValue)

        }

        fun clearSharedPreference() {

            val editor: SharedPreferences.Editor = sharedPref.edit()

            //sharedPref = PreferenceManager.getDefaultSharedPreferences(context);

            editor.clear()
            editor.apply()
        }

        fun removeValue(KEY_NAME: String) {

            val editor: SharedPreferences.Editor = sharedPref.edit()

            editor.remove(KEY_NAME)
            editor.apply()
        }
    }

}