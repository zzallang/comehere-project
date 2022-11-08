
      function loadSigu() {
        region_sigu = document.getElementById("region_sigu").value;
        
        $.ajax({
            type: "GET",
            url: "/app/party/listparam",
            data: {si: region_sido, doo: region_sigu},
            success: function(result) {
              console.log(result);
              for(let i=0; i<result.length; i++) {
                console.log(result[i]);
                console.log(result[i].title);
                $(".temper_text_party").html(result[i].title);
              }
            }
        });
        
      }