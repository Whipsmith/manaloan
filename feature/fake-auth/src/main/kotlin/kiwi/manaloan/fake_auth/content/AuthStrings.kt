package kiwi.manaloan.fake_auth.content

import kiwi.manaloan.content.CommonStrings

internal data class AuthStrings(
    val common: CommonStrings,
    val login: String,
    val togglePasswordVisibility: String,
    val password: String,
    val username: String,
) : CommonStrings by common

