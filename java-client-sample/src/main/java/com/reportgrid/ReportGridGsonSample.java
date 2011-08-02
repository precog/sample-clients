package com.reportgrid;

import com.reportgrid.api.*;
import com.reportgrid.api.json.gson.GsonToJson;
import com.reportgrid.api.json.gson.RawJson;
import com.reportgrid.api.json.ToJson;

import com.google.gson.annotations.SerializedName;
import java.io.IOException;
import java.util.Date;

public class ReportGridGsonSample {
    private static class TestData {
      private final int testInt = 42; 
      private final String testStr = "Hello World";

      @SerializedName("~raw")
      public final RawJson testRaw = new RawJson("{\"test\":[{\"v\":1},{\"v\":2}]}");
    }

    public static void main(String[] argv) {
      try {
        ToJson<Object> toJson = new GsonToJson();
        TrackingClient testClient = new TrackingClient(Service.ProductionHttp, TrackingClient.TEST_TOKEN);

        Event<TestData> testEvent = new Event<TestData>(new Date(), "test", new TestData(), 1);

        System.out.println(testEvent.buildRequestBody(toJson));
        testClient.track(new Path("/test"), testEvent, false, toJson);
      } catch (IOException ex) {
        ex.printStackTrace(); 
      }
    }
}
