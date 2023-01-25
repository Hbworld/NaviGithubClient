package com.hbworld.githubcpr.util

import java.text.SimpleDateFormat
import java.util.*

object DateUtil {

    fun formatDate(pattern: String, date: Date, locale: Locale): String {
        val formatter = SimpleDateFormat(pattern, locale)
        return formatter.format(date)
    }

    fun parseDate(pattern: String, dateString: String, locale: Locale): Date? {
        val parser = SimpleDateFormat(pattern, locale)
        return parser.parse(dateString)
    }

}