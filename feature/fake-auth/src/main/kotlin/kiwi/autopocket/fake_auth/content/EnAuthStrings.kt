package kiwi.autopocket.fake_auth.content

import cafe.adriel.lyricist.LyricistStrings
import kiwi.autopocket.content.EnCommonStrings
import kiwi.autopocket.content.Locales

@LyricistStrings(languageTag = Locales.EN, default = true)
internal val enAuthStrings = AuthStrings(
    common = EnCommonStrings(),
    login = "Login",
    togglePasswordVisibility = "Toggle password visibility",
    password = "Password",
    username = "Username",
)