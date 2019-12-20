$("#sendMessageButton").submit(function (sendmessage) {

    sendmessage.stopImmediatePropagation();

});

function sendMessage() {
    $receiver = document.getElementById("receiver").value;
    $messageContent = document.getElementById("messageContentInput").value;

    console.log("receiver=" + $receiver);
    console.log("message= " + $messageContent);


    /*    $.post("Controller?action=sendMessage", {receiver: $receiver,
           messageContent: $messageContent}, function (data) {
           alert(data);
          var newMessageLine = $('<p />').text(data);
           //alert(newMessageLine);
           $("#chatBox").append(newMessageLine);*/

    $.post("Controller?action=sendMessage", {receiver: $receiver, messageContent: $messageContent});
    //, function (data) {
    //  alert("result: " + data);
    //     var newMessageLine = $('<p />').text(data);
    //   $('#chatBox').append(newMessageLine);
    //});
    //alert("content: " + $messageContent);

}

function getMessage() {
    var conversation = "";
    $.get("Controller?action=getMessage", function (json) {

        for (i in json) {
            conversation += "<p class='content'>" + json[i].sender.firstName + ": " + json[i].content + "</p>";
            console.log(conversation);
           //console.log("convo: " + converstation);

        }
        $("#chatBox").html(conversation);

    });

    setTimeout(getMessage, 2000);
}


/*     for(i in json){
         var message = json[i];
         converstation = "<p>" + message.sender +": " + message.messageContent +"</p>";
     }

     $("#chatBox").html(converstation);*/

