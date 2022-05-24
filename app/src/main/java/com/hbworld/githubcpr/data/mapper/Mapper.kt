package com.hbworld.githubcpr.data.mapper

interface Mapper<I, O> {
    fun map(input: I): O
}