package utillities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
    private  DriverFactory() {
        //do Nothing
        }
        //creating an instance object from this class

        private static final utillities.DriverFactory instance = new utillities.DriverFactory();

        public static utillities.DriverFactory getInstance() {
            return instance;
        }

        ThreadLocal<WebDriver> driver = ThreadLocal.withInitial(()-> {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        });

        public WebDriver getDriver() {
            return driver.get();
        }

        public void removeDriver() {
            driver.get().quit();
            driver.remove();
        }


    }

