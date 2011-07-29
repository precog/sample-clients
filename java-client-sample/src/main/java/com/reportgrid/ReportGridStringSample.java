package com.reportgrid;

import com.reportgrid.api.*;
import com.reportgrid.api.json.ToJson;

import java.io.IOException;
import java.util.Date;

public class ReportGridStringSample {
    public static final ToJson<String> toJson = new ToJson<String>() {
      public String serialize(String string) {
        return string;
      }
    };

    public static void main(String[] argv) {
      try {
        TrackingClient testClient = new TrackingClient(Service.ProductionHttp, TrackingClient.TEST_TOKEN);
        Event<String> testEvent = new Event<String>(new Date(), "test", "{\"testInt\":42, \"testStr\":\"Hello World\"}", 1);
        testClient.track(new Path("/test"), testEvent, false, toJson);
      } catch (IOException ex) {
        ex.printStackTrace(); 
      }
    }
}
