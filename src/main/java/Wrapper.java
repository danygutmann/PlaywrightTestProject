import Helpers.FileHelper;
import com.microsoft.playwright.*;

import javax.xml.namespace.QName;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;

public class Wrapper {
    private static final Wrapper OBJ = new Wrapper();
    private Playwright playwright;
    private Browser browser;
    private Page page;
    private Logger Log = Logger.getInstance();
    private Wrapper() {
        Log.Info("Init");
        Reset();
    }
    public static Wrapper Instance() {
        return OBJ;
    }
    public boolean Reset(){
        Log.Debug("Method call");
        try {
            playwright = Playwright.create();
            browser = playwright.chromium().launch();
            page = browser.newPage();
            Log.Debug("res -> OK");
            return true;
        }
        catch(Exception e) {
            Log.Debug("res -> NOK -> " + e.getMessage());
            return false;
        }
    }
    public boolean Refresh(){
        Log.Debug("Refresh() start");
        try {

            Log.Debug("Refresh() -> OK");
            return true;
        }
        catch(Exception e) {
            Log.Debug("Refresh() -> NOK -> " + e.getMessage());
            return false;
        }
    }
    public boolean Navigate(String url){
        Log.Debug("Method call");
        Log.Debug("url -> "+url);
        try {
            page = browser.newPage();
            page.navigate(url);
            Log.Debug("Navigate() -> OK");
            return true;
        }
        catch(Exception e) {
            Log.Debug("Navigate() -> NOK -> " + e.getMessage());
            return false;
        }
    }
    public String GetContent(){
        Log.Debug("GetContent() start");
        try {
            Log.Debug("GetContent() -> OK, length: " + page.content().length());
            return page.content();
        }
        catch(Exception e) {
            Log.Debug("GetContent() -> NOK -> " + e.getMessage());
            return "";
        }
    }
    public boolean Close(){
        Log.Debug("Close() start");
        try {
            browser.close();
            Log.Debug("Close() -> OK");
            return true;
        }
        catch(Exception e) {
            Log.Debug("Close() -> NOK -> " + e.getMessage());
            return false;
        }
    }

    public Locator GetLocator(String querySelector){
        Log.Debug("GetLocator("+querySelector+") start");
        try {
            Log.Debug("GetLocator() -> Found");
            return page.locator(querySelector);
        }
        catch(Exception e) {
            Log.Debug("GetLocator() -> NOK -> " + e.getMessage());
            return null;
            }
    }

    public boolean Click(Locator locator){
        Log.Debug("Click() start");
        try {
            locator.click();
            Log.Debug("Click() -> OK");
            return true;
        }
        catch(Exception e) {
            Log.Debug("Click() -> NOK -> " + e.getMessage());
            return false;
        }
    }
    public boolean LogConsoleMessages(){
        Log.Debug("LogConsoleMessages() start");
        try {
            page.onConsoleMessage(msg -> {
                if ("error".equals(msg.type()))
                    Log.Debug("page.console: " + msg.text());
            });
            Log.Debug("LogConsoleMessages() -> OK");
            return true;
        }
        catch(Exception e) {
            Log.Debug("CLogConsoleMessageslick() -> NOK -> " + e.getMessage());
            return false;
        }
    }



    public boolean SetText(Locator locator, String text){
        Log.Debug("SetText( locator, "+text+")");
        try {
            locator.fill(text);
            Log.Debug("SetText() -> OK");
            return true;
        }
        catch(Exception e) {
            Log.Debug("SetText() -> NOK -> " + e.getMessage());
            return false;
        }
    }
    public boolean Screenshot(){
        Log.Debug("Screenshot() start");
        try {
            Page.ScreenshotOptions opt = new Page.ScreenshotOptions();
            opt.setPath(FileHelper.GetFilePathFromString(Helpers.FileHelper.GetFilenameWithTimestamp(FileHelper.GetUserDirectoryPath().toString(),"_Screenshot.png")));
            Log.Debug("Screenshot() -> path -> " + opt.path.toString());
            page.screenshot(opt);
            Log.Debug("Screenshot() -> OK");
            return true;
        }
        catch(Exception e) {
            Log.Debug("Screenshot() -> NOK -> " + e.getMessage());
            return false;
        }
    }

    private void SomeUslessCVode(){
        page.keyboard().type("Hello World!");
        page.keyboard().press("ArrowLeft");
        page.keyboard().down("Shift");
        for (int i = 0; i < " World".length(); i++)
            page.keyboard().press("ArrowLeft");
        page.keyboard().up("Shift");
        page.keyboard().press("Backspace");
        page.keyboard().press("Shift+KeyA");
// or
        page.keyboard().press("Shift+A");

        page.mouse().move(0, 0);
        page.mouse().down();
        page.mouse().move(0, 100);
        page.mouse().move(100, 100);
        page.mouse().move(100, 0);
        page.mouse().move(0, 0);
        page.mouse().up();


    }
}
