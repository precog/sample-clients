          ReportGrid.track("/ads/" + $(this).attr("adId"), {
            hover : {
              age : randomAgeRange(),
              category: randomCategory(),
              gender: randomGender(),
              "#timestamp": randomTime(),
              "#location": randomLocation()
            }
          });

