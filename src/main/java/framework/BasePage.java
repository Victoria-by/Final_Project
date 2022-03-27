package framework;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selenide.open;

public abstract class BasePage {

    public BasePage() {
        new SelenideWebDriverConfigurator().configure();
        Configuration.pageLoadTimeout = 200000;
        Configuration.startMaximized = true;
        open();
    }
}
