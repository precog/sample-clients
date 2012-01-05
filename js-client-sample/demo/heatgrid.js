        ReportGrid.heatGrid("#heatGrid", {
          axes : [
            { type : ".age" }, 
            { type : ".category" },
            { type : "count" }
          ],
          data: {
            src: [{
              path : "/ads/123",
              event : "hover",
              query: ".age * .category"
            }]
          },
          options: {
            color: "interpolated-#FFFFFF,#FF7F0E"
          }
        });

