package kiwi.autopocket.fake_auth.content

import kiwi.autopocket.content.CommonStrings

internal data class AuthStrings(
    val common: CommonStrings,
    val login: String,
    val togglePasswordVisibility: String,
    val password: String,
    val username: String,
) : CommonStrings by common

