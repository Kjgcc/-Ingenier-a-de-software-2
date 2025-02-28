package co.edu.poli.ejemplo1.test;

import java.io.InputStream;
import java.util.Properties;

public class TestProperties {
    public static void main(String[] args) {
        try (InputStream input = TestProperties.class.getClassLoader().getResourceAsStream("database.properties")) {
            if (input == null) {
                System.out.println("❌ ERROR: No se encontró database.properties");
                return;
            }
            Properties prop = new Properties();
            prop.load(input);
            System.out.println("✅ Archivo database.properties encontrado!");
            System.out.println("🔍 db.url: " + prop.getProperty("db.url"));
            System.out.println("🔍 db.user: " + prop.getProperty("db.user"));
        } catch (Exception e) {
            System.out.println("❌ ERROR al cargar database.properties: " + e.getMessage());
        }
    }
}

