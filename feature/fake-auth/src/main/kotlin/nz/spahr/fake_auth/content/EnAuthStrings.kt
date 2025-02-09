package nz.spahr.fake_auth.content

import cafe.adriel.lyricist.LyricistStrings
import nz.spahr.content.EnCommonStrings
import nz.spahr.content.Locales

@LyricistStrings(languageTag = Locales.EN, default = true)
internal val enAuthStrings = AuthStrings(
    common = EnCommonStrings(),
    login = "Login",
    togglePasswordVisibility = "Toggle password visibility",
    password = "Password",
    username = "Username",
)