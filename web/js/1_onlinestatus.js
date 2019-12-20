var getStatusRequest = new XMLHttpRequest();

function getStatus() {
    getStatusRequest.open("GET", "Controller?action=Status");
    getStatusRequest.onreadystatechange = getData;
    getStatusRequest.send(null);
}

function getData() {

    if (getStatusRequest.status == 200) {
        if (getStatusRequest.readyState == 4) {
            var div = document.getElementById("currentStatus");
            var p = document.createElement('p');
            var text = document.createTextNode(getStatusRequest.responseText);
            p.appendChild(text);
            div.appendChild(p);
        }
    }
}
//   <p className="opgave">opdracht 1 SYNCHROON: Zorg ervoor dat je default status op online staat wanneer je
//                     ingelogd bent</p>