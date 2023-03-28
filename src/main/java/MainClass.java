public class MainClass {

    public MainClass() {

    }

    public static void main(String[] args) {
        Wrapper pw = Wrapper.Instance();

        pw.Reset();
        pw.Navigate("https://bakery-flow.demo.vaadin.com/login");
        pw.LogConsoleMessages();
        pw.GetContent();
        pw.SetText( pw.GetLocator("xpath=//input[@name='username']"), "admin@vaadin.com");
        pw.SetText( pw.GetLocator("xpath=//input[@name='password']"), "admin");
        pw.Screenshot();
        pw.Click( pw.GetLocator("xpath=/html/body/vaadin-login-overlay-wrapper/vaadin-login-form/vaadin-login-form-wrapper/form/vaadin-button") );
        pw.GetContent();
        pw.Screenshot();
        pw.Click( pw.GetLocator("xpath=/html/body/vaadin-app-layout/vaadin-tabs/vaadin-tab[5]/a/iron-icon") );
        pw.Screenshot();

        Logger.getInstance().Info("Habe Fertig");
        System.exit(0);
    }
}
