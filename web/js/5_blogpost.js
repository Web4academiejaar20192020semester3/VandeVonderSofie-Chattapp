var webSocket;
var postDiv;

function openSocket() {
    webSocket = new WebSocket("ws://localhost:8080/echo");


    // event listeners
    webSocket.onopen = function (event) {
        // writeResponse("connection opened")
    };

    webSocket.onmessage = function (event) {
        //writeResponse(event.data);

        if (event.data == null) {
            //alert('null????? :(');
        } else {
            // alert(event.toString());
            var nr = JSON.parse(event.data).number;


            // console.log(nr);
            var user = JSON.parse(event.data).user;
            //console.log(user);
            var rating = JSON.parse(event.data).rating;
            //console.log(rating);
            var comment = JSON.parse(event.data).comment;
            //console.log(comment);

            //var whichDiv = "post" + "" +nr;
            postDiv = document.getElementById("post" + nr);

            var commentDIV = document.createElement('div');

            var userP = document.createElement('p');
            userP.innerText = "User: " + user.toString();

            var ratingP = document.createElement('p');
            ratingP.innerText = "Rating: " + rating.toString();

            var commentP = document.createElement('p');
            commentP.innerText = ("Comment: " + comment);
            //commentP.style.textDecoration="underline";


            commentDIV.appendChild(userP);
            commentDIV.appendChild(ratingP);
            commentDIV.appendChild(commentP);
            commentDIV.style.margin="5%";
            postDiv.appendChild(commentDIV);
        }


    };

    webSocket.onclose = function (event) {
        // writeResponse("Connection closed");
    };
}


function closeSocket() {
    webSocket.close();
}

function addCommentForBlogNumber(number) {
    //openSocket();
    //console.log(webSocket.toString());

    //var blogNumber = number;

    //alert('help');

    var email = document.getElementById("user" + number).value;
    console.log(email);

    var comment = document.getElementById("comment" + number).value;
    console.log(comment);
    var rating = document.getElementById("rating" + number).value;
    console.log(rating);



   webSocket.send("{\"" + "number\": \"" + number + "\", \"user\": \"" + email + "\", \"comment\": \"" + comment + "\", \"rating\":\"" + rating + "\"}");


}