package kiwi.manaloan.fake_auth.content

import cafe.adriel.lyricist.LyricistStrings
import kiwi.manaloan.content.EnCommonStrings
import kiwi.manaloan.content.Locales

@LyricistStrings(languageTag = Locales.EN, default = true)
internal val enAuthStrings = AuthStrings(
    common = EnCommonStrings(),
    login = "Login",
    togglePasswordVisibility = "Toggle password visibility",
    password = "Password",
    username = "Username",
)