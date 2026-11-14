package app.ombra.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp

/**
 * The phone's own fonts, like the official Obscura app (its web UI uses the system font stack:
 * Roboto on Android, Segoe UI on Windows). No font ships in the APK.
 */
val SystemSans: FontFamily = FontFamily.SansSerif

/** The system monospace font: account numbers, keys and IP addresses. */
val SystemMono: FontFamily = FontFamily.Monospace

/** Tabular figures, so changing numbers do not shift the layout. */
private const val TABULAR = "tnum"

/**
 * Each paragraph takes its direction from its first strong letter, as a TextView does. With an
 * RTL system language the layout mirrors, and the English texts still read left to right ("10 of
 * 20 digits", not "of 20 digits 10").
 */
val OmbraTypography: Typography = Typography().run {
    fun TextStyle.styled(weight: FontWeight, tracking: Float = 0f) =
        copy(fontFamily = SystemSans, fontWeight = weight, letterSpacing = tracking.em, textDirection = TextDirection.Content)
    copy(
        displayLarge = displayLarge.styled(FontWeight.SemiBold, -0.02f),
        displayMedium = displayMedium.styled(FontWeight.SemiBold, -0.02f),
        displaySmall = displaySmall.styled(FontWeight.SemiBold, -0.015f),
        headlineLarge = headlineLarge.styled(FontWeight.SemiBold, -0.015f),
        headlineMedium = headlineMedium.styled(FontWeight.SemiBold, -0.01f),
        headlineSmall = headlineSmall.styled(FontWeight.SemiBold, -0.005f),
        titleLarge = titleLarge.styled(FontWeight.SemiBold),
        titleMedium = titleMedium.styled(FontWeight.SemiBold),
        titleSmall = titleSmall.styled(FontWeight.SemiBold),
        bodyLarge = bodyLarge.styled(FontWeight.Normal),
        bodyMedium = bodyMedium.styled(FontWeight.Normal),
        bodySmall = bodySmall.styled(FontWeight.Medium),
        labelLarge = labelLarge.styled(FontWeight.SemiBold),
        labelMedium = labelMedium.styled(FontWeight.SemiBold),
        labelSmall = labelSmall.styled(FontWeight.SemiBold, 0.02f),
    )
}

/** Styles outside the Material scale. */
object OmbraTextStyles {
    /** A live figure (rates, latency, session time). */
    val stat = TextStyle(
        fontFamily = SystemSans,
        fontWeight = FontWeight.SemiBold,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        fontFeatureSettings = TABULAR,
        textDirection = TextDirection.Content,
    )

    /** A small live figure. */
    val statSmall = TextStyle(
        fontFamily = SystemSans,
        fontWeight = FontWeight.SemiBold,
        fontSize = 15.sp,
        lineHeight = 20.sp,
        fontFeatureSettings = TABULAR,
        textDirection = TextDirection.Content,
    )

    /**
     * Account numbers, keys, IP addresses. Always left to right: in an RTL paragraph the groups of
     * an account number would swap places and the padding of a key would move to its start.
     */
    val mono = TextStyle(fontFamily = SystemMono, fontSize = 14.sp, lineHeight = 20.sp, textDirection = TextDirection.Ltr)

    /** The account number as the hero of a screen. */
    val monoLarge = mono.copy(fontSize = 22.sp, lineHeight = 30.sp)
}
