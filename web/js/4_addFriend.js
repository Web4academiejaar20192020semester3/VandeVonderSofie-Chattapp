var addFriendRequest = new XMLHttpRequest();

function addFriend() {


        var email = document.getElementById("emailInput").value;
        var friend = "friend=" + encodeURIComponent(email);

        addFriendRequest.open("POST", "Controller?action=AddFriend", true);
        addFriendRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        addFriendRequest.send(friend);

}




