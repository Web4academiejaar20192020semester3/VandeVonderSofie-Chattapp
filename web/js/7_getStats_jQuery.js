$("#statsJQButton").click(getStatsjQuery);


function getStatsjQuery() {

    $('#hiddenDiv').show();
    //   alert("into function");
    $.ajax({
        type: "GET",
        url: "Controller?action=getStatistics",
        dataType: "json",
        success: function (json) {
            $("#onlineDIVJQ").html('<p>Online: ' + json.online + '</p>');
            $("#offlineDIVJQ").html('<p>Offline: ' + json.offline + '</p>');
            setTimeout(getStatsjQuery, 3000);
        },
        error: function () {
            alert(":(");
        }
    });


}

/*
$("#deleteStatsJQbutton").click(function () {

    $("#onlineDIVJQ").empty();
    $("#offlineDIVJQ").empty();


});*/
