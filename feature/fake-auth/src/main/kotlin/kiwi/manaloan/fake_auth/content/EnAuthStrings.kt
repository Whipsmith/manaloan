package kiwi.manaLoan.fake_auth.content

import cafe.adriel.lyricist.LyricistStrings
import kiwi.manaLoan.content.EnCommonStrings
import kiwi.manaLoan.content.Locales

@LyricistStrings(languageTag = Locales.EN, default = true)
internal val enAuthStrings = AuthStrings(
    common = EnCommonStrings(),
    login = "Login",
    togglePasswordVisibility = "Toggle password visibility",
    password = "Password",
    username = "Username",
)