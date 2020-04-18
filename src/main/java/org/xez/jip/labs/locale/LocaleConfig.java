package org.xez.jip.labs.locale;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Locale;

/**
 * Class for accessing locale module functionality<p>
 */
public class LocaleConfig {
    /** Instance of Locale Resource Bundles storage class */
    private static LocaleStorage localeStorage = new DefaultLocaleStorage();

    /**
     * @param locales Enumeration of browser locale preferences
     * @return Instance of localised String access class
     * @throws IOException if there is no Locale Resource bundles
     */
    public static LocaleProvider getLocaleProvider(Enumeration<Locale> locales) throws IOException {
        return new DefaultLocaleProvider(localeStorage, locales);
    }
}
