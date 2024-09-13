import java.util.Locale;
import java.util.ResourceBundle;

public class MultiLanguageSupport {
	
	private ResourceBundle bundle;

    // Constructor que carga los textos basados en el idioma
    public MultiLanguageSupport(String languageCode) {
        // Configurar el Locale basado en el código de idioma
        Locale locale = new Locale.Builder().setLanguage(languageCode).build();
        
        // Cargar el archivo de propiedades apropiado según el Locale
        bundle = ResourceBundle.getBundle("textos", locale);
    }

    // Método para obtener un texto basado en la clave
    public String getText(String key) {
        return bundle.getString(key);
    }

    // Método para cambiar de idioma dinámicamente
    public void setLanguage(String languageCode) {
        Locale locale = new Locale.Builder().setLanguage(languageCode).build();
        bundle = ResourceBundle.getBundle("textos", locale);
    }
}

