/*
var getFriendsRequest = new XMLHttpRequest();


function getFriends(){
    getFriendsRequest.open("GET", "Controller?action=getFriends", true);
    getFriendsRequest.onreadystatechange = getFriendsData;
    getFriendsRequest.send(null);



}

function getFriendsData(){

if(getFriendsRequest.status === 200){
    if(getFriendsRequest.readyState ===4){



        var serverResponse = JSON.parse(getFriendsRequest.responseText);


        makeFriendsDiv(serverResponse);
        setTimeout(getFriendsData, 1000);



    }
}

}

function makeFriendsDiv(Json){
    var friendsDiv = document.getElementById("friends");

    if(friendsDiv.getElementsByClassName("friend") != null){
        while(friendsDiv.firstChild){
            friendsDiv.removeChild(friendsDiv.firstChild);
        }
    }
    Json.forEach(function(value){

        friendsDiv.insertAdjacentHTML("beforeend", "<p class='friend'>" + "* "+value.firstName + " - " + value.status +" </p>")

        }


    )
}



*/
