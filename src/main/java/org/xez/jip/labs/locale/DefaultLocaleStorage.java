package org.xez.jip.labs.locale;

import java.util.*;

/**
 * Default implementation of {@link org.xez.jip.labs.locale.LocaleStorage LocaleStorage} interface <p>
 *     This class is for providing access to Resource Bundles for LocaleProviders
 */
class DefaultLocaleStorage implements LocaleStorage {

    /** Resource Bundles path */
    static final String LOCALE_RESOURCES_PATH = "locale/ui";
    /** Default Locale Instance. Used if all browser locale preferences doesn't supported*/
    static final Locale DEFAULT_LOCALE = Locale.ENGLISH;

    /** Store all supported locales of server. MUST contain all Resource Bundles */
    private final static Locale[] supportedLocales = new Locale[] {
            DEFAULT_LOCALE,             // English en
            Locale.forLanguageTag("ru"),
            Locale.forLanguageTag("de")
    };

    /** Store all Resource Bundles in RunTime by Locale */
    private static final Map<Locale, ResourceBundle> uiBundles = new HashMap<>();

    DefaultLocaleStorage(){
        for (Locale locale: supportedLocales) {
            uiBundles.put(locale, ResourceBundle.getBundle(LOCALE_RESOURCES_PATH, locale));
        }

        if(uiBundles.isEmpty())
            throw new NullPointerException("There is no locale resource bundles");
    }

    /**
     * @param locales Enumeration of browser locale preferences
     * @return Locale Resource Bundle for locales or Default Local Bundle, if no one browser locale preferences supported
     */
    @Override
    public ResourceBundle getResourceBundle(Enumeration<Locale> locales) {
        ResourceBundle resourceBundle;
        while (locales.hasMoreElements()){
            resourceBundle = uiBundles.get(locales.nextElement());

            if(resourceBundle != null)
                return resourceBundle;
        }
        return uiBundles.get(DEFAULT_LOCALE);
    }

    /**
     * @return copy of Array of Server supported locales.
     */
    @Override
    public Locale[] getSupportedLocales(){
        return supportedLocales.clone();
    }
}
