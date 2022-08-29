package ClassFactory;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class ClickFunctionality {
    public void DigitInput(String num, ArrayList<WebElement> elementsList) {
        int random ;
        for (int i = 0; i <num.length(); i++){
            Character split = num.charAt(i);
            int numeric = Character.getNumericValue(split);
            elementsList.get(numeric).click();
        }
    }

    public void SignInput(String sign,ArrayList<WebElement> elementSigns ) {
        for (int i = 0; i < sign.length(); i++){
            char split = sign.charAt(i);
            switch (split){
                case '/':
                    elementSigns.get(10).click();
                    break;
                case '*':
                    elementSigns.get(11).click();
                    break;
                case '-':
                    elementSigns.get(12).click();
                    break;
                case '+':
                    elementSigns.get(13).click();
                    break;
                case 'v':
                    elementSigns.get(14).click();
                    break;
            }

        }
    }
}
