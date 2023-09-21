package com.yurastico.mapsandroid

import com.google.android.gms.common.ConnectionResult

data class GoogleApiConnectionStatus(
    val success: Boolean,
    val connectionResult: ConnectionResult? = null
)