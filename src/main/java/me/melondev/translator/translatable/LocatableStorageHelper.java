package me.melondev.translator.translatable;

import me.melondev.translator.TranslatorPlugin;
import me.melondev.translator.locale.Language;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.stream.Stream;

/**
 * //
 *
 * @author MelonDev
 * @since 1.0.0
 */
public final class LocatableStorageHelper implements ILocatableStorageHelper {
    private TranslatorPlugin translatorPlugin;

    public LocatableStorageHelper(final TranslatorPlugin translatorPlugin) {
        this.translatorPlugin = translatorPlugin;

        setupFiles();
    }

    @Override
    public void setupFiles() {
        Stream.of(Language.values()).parallel().forEach(this::generateYaml);
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Override
    public void generateYaml(final Language language) {
        final File langFile = new File(translatorPlugin.getDataFolder(), language.getDisplay() + ".yml");

        if (!translatorPlugin.getDataFolder().exists()) translatorPlugin.getDataFolder().mkdir();
        if (!langFile.exists()) {
            try {
                langFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                translatorPlugin.getLogger().log(Level.SEVERE, "An error has ocurred while creating yaml file for " + language.getDisplay() + ".yml");
            }
        }

        translatorPlugin.getLogger().log(Level.SEVERE, "Created yaml file for " + language.getDisplay() + ": " + langFile.getName());
    }
}
