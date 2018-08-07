package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Inicio {

    private static WebDriver driver;

    public Inicio(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver selecionaListMateriais(){
        WebElement botaoFavorito = driver.findElement( By.id("panel_1474") );
        botaoFavorito.click();

        driver.switchTo().frame( "i_frame_cadastro" );

        return driver;
    }

}
