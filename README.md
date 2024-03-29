# Translator
Multi language plugin for Minecraft Server 1.8.8

Demostration project.

## API Usage
### Translated field without Player data
```
TranslatorAPI.getTranslatedField(Language.ENGLISH, "languageFileField");
```

### Translated field using Player data
```
TranslatorAPI.getPlayerTranslatedField(Player, Language.ENGLISH, "languageFileField");
```

### Custom placeholder support
For custom placeholder support you must create an custom [FieldPlaceholder.java](https://github.com/veir1/Translator/blob/master/src/main/java/me/melondev/translator/provider/placeholder/FieldPlaceholder.java) object & implement it using [TranslatorAPI.java](https://github.com/veir1/Translator/blob/master/src/main/java/me/melondev/translator/TranslatorAPI.java)
```
final FieldPlaceholder testPlaceholder = new FieldPlaceholder("placeholder", "replacement");

TranslatorAPI.getPlaceholderTranslatedField(Language.ENGLISH, testPlaceholder, "languageFileField");
```

## Author

* **Jeremías Aubriot** - *Main work* - [veir1](https://github.com/veir1)

## License

This project is licensed under the MIT License. - [LICENSE.md](https://github.com/veir1/Translator/blob/master/LICENSE.md)
