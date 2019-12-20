var getFriendsRequest = new XMLHttpRequest();

// polling
function getFriends() {

        getFriendsRequest.open("GET", "Controller?action=getFriends", true);
        getFriendsRequest.onreadystatechange = getFriendsData;
        getFriendsRequest.send(null);
}

function getFriendsData() {

        if (getFriendsRequest.status == 200) {
                if (getFriendsRequest.readyState == 4) {

                        var friendsTable = document.getElementById("friends");

                        var serverResponse = JSON.parse(getFriendsRequest.responseText);
                        var serverResponseSize = serverResponse.length;
                        /*     for(var i = 0; i < serverResponseSize; i++) {
                                 console.log("getfriends serverresponse: " + serverResponse[i]);
                             }*/
                        for (i in serverResponse) {

                                var currentFriend = serverResponse[i];

                                var tr = document.getElementById(currentFriend.userId);
                                if (tr == null) {
                                        tr = document.createElement('tr');

                                        tr.id = currentFriend.userId;
                                        console.log(tr.id);


                                        var td;

                                        td = document.createElement('td');
                                        td.innerText = currentFriend.firstName;
                                        td.id = currentFriend.userId + '-firstName';
                                        tr.appendChild(td);

                                        td = document.createElement('td');
                                        td.innerText = currentFriend.status;
                                        td.id = currentFriend.userId + "-status";
                                        tr.appendChild(td);

                                        td = document.createElement('td');
                                        /*   chatButton = document.createElement('button');
                                           chatButton.innerText = "chat";
                                           chatButton.id = currentFriend.userId;
                                           chatButton.className = "chatButton";*/
                                        //   console.log(chatButton.id);

                                        //    td.appendChild(chatButton);


                                        tr.appendChild(td);

                                        friendsTable.appendChild(tr);

                                } else {

                                        var status = document.getElementById(currentFriend.userId + "-status");
                                        status.innerText = currentFriend.status;
                                        console.log(status.innerText);
                                        var firstName = document.getElementById(currentFriend.userId + "-firstName");
                                        firstName.innerText = currentFriend.firstName;
                                        console.log(firstName.innerText);
                                }
                        }
                }
        }
        setTimeout(getFriends, 3000);
}



