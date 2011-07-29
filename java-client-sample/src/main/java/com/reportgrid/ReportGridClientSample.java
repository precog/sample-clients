package com.reportgrid;

import com.reportgrid.api.*;
import com.reportgrid.api.json.gson.GsonToJson;
import com.google.gson.Gson;
import com.reportgrid.api.json.ToJson;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReportGridClientSample {
		private static class TestData {
			private final int testInt = 42;	
			private final String testStr = "Hello World";
		}

		public static final Service Local = new Service() {
			@Override public URL serviceUrl() {
				try {
					return new URL("http", "api.reportgrid.com", 80, "/services/analytics/v0/");
				} catch (MalformedURLException ex) {
					Logger.getLogger(Service.class.getName()).log(Level.SEVERE, "Invalid client URL", ex);
				}

				return null;
			}
		};

    public static void main(String[] argv) {
      try {
        ToJson<Object> toJson = new GsonToJson();
        TrackingClient testClient = new TrackingClient(Local, TrackingClient.TEST_TOKEN);

        Event<TestData> testEvent = new Event<TestData>(new Date(), "test", new TestData(), 1);
        testClient.track(new Path("/test"), testEvent, false, toJson);
      } catch (IOException ex) {
        ex.printStackTrace(); 
      }
    }
}
