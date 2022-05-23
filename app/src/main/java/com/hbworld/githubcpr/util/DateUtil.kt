package com.hbworld.githubcpr.util

import java.text.SimpleDateFormat
import java.util.*

object DateUtil {

    private const val GITHUB_DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ssXXX"
    private const val SIMPLE_DATE_PATTERN = "dd MMM yy hh:mm a"

    fun formatGithubDateToSimple(dateString: String) : String{
        val date = parseGithubDate(dateString)
        if(date!=null) return formatDate(SIMPLE_DATE_PATTERN, date, Locale.ENGLISH)
        return ""
    }

    private fun formatDate(pattern : String, date : Date, locale: Locale) : String{
        val formatter = SimpleDateFormat(pattern, locale)
        return formatter.format(date)
    }

    private fun parseGithubDate(dateString : String) : Date? {
        return parseDate(GITHUB_DATE_PATTERN, dateString, Locale.ENGLISH)
    }

    private fun parseDate(pattern : String, dateString : String, locale: Locale) : Date? {
        val parser = SimpleDateFormat(pattern, locale)
        return parser.parse(dateString)

    }


}