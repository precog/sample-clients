package com.reportgrid;

import com.reportgrid.api.*;
import com.reportgrid.api.json.gson.GsonToJson;
import com.reportgrid.api.json.ToJson;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.Date;

public class ReportGridGsonSample {
		private static class TestData {
			private final int testInt = 42;	
			private final String testStr = "Hello World";
		}

    public static void main(String[] argv) {
      try {
        ToJson<Object> toJson = new GsonToJson();
        TrackingClient testClient = new TrackingClient(Service.ProductionHttp, TrackingClient.TEST_TOKEN);

        Event<TestData> testEvent = new Event<TestData>(new Date(), "test", new TestData(), 1);
        testClient.track(new Path("/test"), testEvent, false, toJson);
      } catch (IOException ex) {
        ex.printStackTrace(); 
      }
    }
}
