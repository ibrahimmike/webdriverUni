package browserManager;

import com.microsoft.playwright.*;
import utils.ReadProperties;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;

import static java.util.Currency.getInstance;

public  class BrowserManager {
    private static final ThreadLocal<Playwright> playwrightThreadLocal = new ThreadLocal<>();
    private static final ThreadLocal<Browser> browserThreadLocal = new ThreadLocal<>();
    private static final ThreadLocal<BrowserContext> browserContextThreadLocal = new ThreadLocal<>();
    private static final ThreadLocal<Page> pageThreadLocal = new ThreadLocal<>();

    public  Playwright getPlaywright(){
        return playwrightThreadLocal.get();
    }
    private  void setPlaywright(Playwright playwright){
        playwrightThreadLocal.set(playwright);
    }
    public  Browser getBrowser(){
       return    browserThreadLocal.get();
    }
    private void setBrowser(Browser browser){
        browserThreadLocal.set(browser);
    }
    public  BrowserContext getBrowserContext(){
        return browserContextThreadLocal.get();
    }
    public  void setBrowserContext(BrowserContext bctx){
        browserContextThreadLocal.set(bctx);
    }
    public  Page getPage(){
        return pageThreadLocal.get();
    }
    public void setPage(Page page){
        pageThreadLocal.set(page);
    }
    public BrowserManager getSession(){
        return this;
    }



    private Properties properties;
    public BrowserManager(){
        setBrowserManager();
        properties = ReadProperties.getProperties();
    }


    public  void setBrowserManager(){

        try{
         setPlaywright(Playwright.create());
         String browser =   ReadProperties.getPropertyValue("browser");
         switch(browser){
             case "chrome":
                setBrowser(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome")));
                 break;
             case "safari":
                 setBrowser(getPlaywright().webkit().launch(new BrowserType.LaunchOptions().setHeadless(false)));
                 break;
             case "firefox":
                setBrowser(getPlaywright().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false)));
                 break;
             case "edge":
                setBrowser(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("msedge")));
                 break;
//             case "opera":
//                setBrowser(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("opera")));
//                break;
             default:
                setBrowser(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("opera")));
                break;
         }
         setBrowserContext(getBrowser().newContext());
         setPage(getBrowserContext().newPage());



        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }





    }
    public  void tearDown(){
        try {
           // logger.log(Level.SEVERE, "Tearing down playwright ...");
            if (pageThreadLocal.get() != null) pageThreadLocal.get().close();
            if (browserThreadLocal.get() != null) browserThreadLocal.get().close();
            if (playwrightThreadLocal.get() != null) playwrightThreadLocal.get().close();
        }catch (RuntimeException e){
          //  logger.log(Level.SEVERE, "Tearing down complete ....", e);
        }
        System.out.println("Tearing down the process complete ....");
    }





}
