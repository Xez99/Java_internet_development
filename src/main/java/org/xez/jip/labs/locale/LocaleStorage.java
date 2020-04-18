package org.xez.jip.labs.locale;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Interface for Locale Resource Bundle storage classes<p>
 *     Default realisation is {@link org.xez.jip.labs.locale.DefaultLocaleStorage DefaultLocaleStorage}
 */
interface LocaleStorage {
    /**
     * @param locales Enumeration of browser locale preferences
     * @return Locale Resource Bundle for locales or Default Local Bundle, if no one browser locale preferences supported
     */
    ResourceBundle getResourceBundle(Enumeration<Locale> locales);

    /**
     * @return copy of Array of Server supported locales.
     */
    Locale[] getSupportedLocales();
}
