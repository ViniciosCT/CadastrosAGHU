package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.regex.Pattern;

public class Login {

    private static WebDriver driver;
    private static String linhaLogin;

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    private void logarInterface(String loginS, String senhaS){
        WebElement login = driver.findElement( By.id("username:username:inputId") );
        login.sendKeys(loginS);

        WebElement senha = driver.findElement( By.id("password:inputId") );
        senha.sendKeys(senhaS);

        WebElement botaoLogin = driver.findElement( By.id("entrar") );
        botaoLogin.click();
    }

    public void logar(){
        String[] dados = linhaLogin.split( Pattern.quote ("|") );
        this.logarInterface( dados[0], dados[1] );
    }

    public static String getLinhaLogin() {
        return linhaLogin;
    }

    public static void setLinhaLogin(String linhaLogin) {
        Login.linhaLogin = linhaLogin;
    }
}
