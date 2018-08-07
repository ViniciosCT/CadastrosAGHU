package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditarMaterial {

    private static WebDriver driver;

    public EditarMaterial(WebDriver driver) {
        this.driver = driver;
    }

    public void checkTermolabil(){
        WebElement checkbox = driver.findElement( By.xpath("/html/body/form[3]/fieldset/div/div[8]/div[7]/div[2]/div/div[2]/span") );
        if( !isCheckedTermolabil() ){
            checkbox.click();
        }
    }

    public void notCheckTermolabil() {
        WebElement checkbox = driver.findElement( By.xpath("/html/body/form[3]/fieldset/div/div[8]/div[7]/div[2]/div/div[2]/span") );
        if( isCheckedTermolabil() ){
            checkbox.click();
        }
    }

    public boolean isCheckedTermolabil(){
        WebElement checkboxVerificavel = driver.findElement( By.xpath("/html/body/form[3]/fieldset/div/div[8]/div[7]/div[2]/div/div[2]") );
        return checkboxVerificavel.getAttribute("class")
                .equals("ui-chkbox-box ui-widget ui-corner-all ui-state-default ui-state-active");
    }

    public void setTemperatura(String temperaturaS){
        WebElement temperatura = driver.findElement( By.id("temperatura:temperatura:inputId") );
        temperatura.clear();
        temperatura.sendKeys(temperaturaS);
    }

    public String finalizar(){
        WebElement botaoGravar = driver.findElement( By.id("bt_gravar:button") );
        botaoGravar.click();

        WebElement mensagem = driver.findElement( By.xpath("/html/body/div[5]/div[2]/div/div/ul/li/span") );
        String mensagemRetorno = mensagem.getText();

        WebElement botaoVoltar = driver.findElement( By.id("bt_voltar:button") );
        botaoVoltar.click();

        return mensagemRetorno;
    }

}
