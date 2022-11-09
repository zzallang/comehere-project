let region_sido = "0";
let region_sigu = "0";
let sports = "0";
let partyDate = "0";
let partyTime = "0";
let searchText = "0";
let listStar = "0";
let listCreate = "0";
let listPartyDate = "0";


$("#region_sido").change(() => {
  loadList(getListConditions())
});

$("#region_sigu").change(() => {
  loadList(getListConditions())
});

$("#sports_name").change(() => {
  loadList(getListConditions())
});

$("#partyDate").change(() => {
  loadList(getListConditions())
});

$("#partyTime").change(() => {
  loadList(getListConditions())
});

$("#searchBtn").click(() => {
  loadList(getListConditions())
});

$("#list_reset").click(() => {
  listStar = "0";
  listCreate = "0";
  listPartyDate = "0";
  loadList(getListConditions())
});

$("#list_star").click(() => {
  listStar = "1";
  listCreate = "0";
  listPartyDate = "0";
  loadList(getListConditions())
});

$("#list_create").click(() => {
  listStar = "0";
  listCreate = "1";
  listPartyDate = "0";
    loadList(getListConditions())
});

$("#list_partyDate").click(() => {
  listStar = "0";
  listCreate = "0";
  listPartyDate = "1";
  loadList(getListConditions())
});

function getListConditions() {
  var params = {}
  if ($("#region_sido").val() != "0") {
    params.si = $("#region_sido").val();
  }
  if ($("#region_sigu").val() != "0") {
    params.gu = $("#region_sigu").val();
  }
  if ($("#sports_name").val() != "0") {
    params.sports = $("#sports_name").val();
  }
  if ($("#partyDate").val() != "") {
    params.partyDate = $("#partyDate").val();
  }
  if ($("#partyTime").val() != "") {
    params.partyTime = $("#partyTime").val();
  }
  if ($("#list_search").val() != "") {
    params.searchText = $("#list_search").val();
  }
  if ($("#list_star").val() != "") {
    params.listStar = listStar;
  }
  if ($("#list_create").val() != "") {
    params.listCreate = listCreate;
  }
  if ($("#list_partyDate").val() != "") {
     params.listPartyDate = listPartyDate;
 }
  return params;
}

function loadList(params) {
  
  console.log(params);
  
  $.ajax({
    type: "GET",
    url: "/app/party/list-ajax",
    data: params,
    success: function(result) {
        
      console.log(result);
      $('#partyList').html(result);

      }
  });

}