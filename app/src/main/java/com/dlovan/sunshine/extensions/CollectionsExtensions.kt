package com.dlovan.sunshine.extensions

/**
 * ee
 * Created by dlovan on 1/30/18.
 */

fun <K, V : Any> Map<K, V?>.toVarargArray(): Array<out Pair<K, V>> =
        map({ Pair(it.key, it.value!!) }).toTypedArray()