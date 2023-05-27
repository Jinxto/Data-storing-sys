package org.acme;

import java.util.logging.Logger;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;

@ApplicationScoped
public class AppLifecycleBean {
 @Inject
 dataConnectorService serv;

 private static final Logger LOGGER = Logger.getLogger("ListenerBean");
 
 void onStart(@Observes StartupEvent ev) {
	String user_id = "1234";
	Double spending = 369.90;
	calendar cal = new calendar();
	String[] user_items = { "car", "motor", "bike"};
	Double[] item_price = { 123.0 , 123.4, 124.5};
    Json_creator json = new Json_creator();
    cal.refreshDate();
	String filepath = json.create_json_spending(user_id, "bob", cal, spending, item_price, user_items);
	//System.out.println(serv.findPortfolio(user_id));
	serv.listUserYearlySpending(user_id);
	if(!filepath.equals("error")) {
	 serv.AutoTransact(user_id, spending, cal, filepath);
	}
 
	System.out.println(serv.findPortfolio(user_id));


	 LOGGER.info("Bot is starting");
	 
 }
 void onStop(@Observes ShutdownEvent ev) {
	 LOGGER.info("Bot is Closing");
	
	 
 }
}

