package com.dlovan.sunshine.domain.commands

/**
 * is the generic interface
 * Created by dlovan on 1/6/18.
 */

interface Command<out T> {
    fun execute(): T
}