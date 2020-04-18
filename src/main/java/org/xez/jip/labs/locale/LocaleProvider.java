package org.xez.jip.labs.locale;

/**
 * Interface for accessing localised Strings from Resource Bundles<p>
 *     Default realisation is {@link org.xez.jip.labs.locale.DefaultLocaleProvider DefaultLocaleProvider}
 */
public interface LocaleProvider {
    /**
     * @param key Resource Bundle key
     * @return localised String
     */
    String getUi(String key);
}
