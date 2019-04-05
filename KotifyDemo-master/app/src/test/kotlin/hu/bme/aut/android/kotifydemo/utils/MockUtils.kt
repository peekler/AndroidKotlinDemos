package hu.bme.aut.android.kotifydemo.utils

import org.mockito.ArgumentCaptor
import org.mockito.MockSettings
import org.mockito.Mockito

/**
 * Based on mockito kotlin library: https://github.com/nhaarman/mockito-kotlin
 * Copyright (c) 2016 Niek Haarman
 * Copyright (c) 2007 Mockito contributors
 */


inline fun <reified T : Any> mock(): T = Mockito.mock(T::class.java)!!

inline fun <reified T : Any> mock(s: MockSettings): T = Mockito.mock(T::class.java, s)!!

inline fun <reified T : Any> argumentCaptor(): ArgumentCaptor<T> = ArgumentCaptor.forClass(T::class.java)
inline fun <reified T : Any> nullableArgumentCaptor(): ArgumentCaptor<T?> = ArgumentCaptor.forClass(T::class.java)
inline fun <reified T : Any> capture(captor: ArgumentCaptor<T>): T = captor.capture()
