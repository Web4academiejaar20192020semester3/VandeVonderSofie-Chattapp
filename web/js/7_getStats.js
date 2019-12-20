var getStatisticsRequest = new XMLHttpRequest();

function getStatisticsFunction() {

    getStatisticsRequest.open("GET", "Controller?action=getStatistics", true);
    getStatisticsRequest.onreadystatechange = getStatisticsData;
    getStatisticsRequest.send(null);

}

function getStatisticsData() {


    if (getStatisticsRequest.status == 200) {
        if (getStatisticsRequest.readyState == 4) {


            var serverResponse = JSON.parse(getStatisticsRequest.responseText);
            //   console.log(serverResponse.online);

            var onlineDiv = document.getElementById("onlineDIV");
            var offlineDiv = document.getElementById("offlineDIV");

            var pOnline = document.getElementById("onlineP");
            var pOffline = document.getElementById("offlineP");

            if (pOnline == undefined) {
                console.log("ponline and poffline undefined");

                pOnline = document.createElement('p');
                pOnline.id = "onlineP";
                var nrOnline = document.createTextNode(serverResponse.online);
                pOnline.innerText = nrOnline;
                onlineDiv.appendChild(pOnline);

                pOffline = document.createElement('p');
                pOffline.id = "offlineP";
                var nrOffline = document.createTextNode(serverResponse.offline);
                pOffline.innerText = nrOffline;
                offlineDiv.appendChild(pOffline);

            } else {

                onlineDiv.removeChild(onlineDiv.lastChild);
                pOnline = document.createElement('p');
                pOnline.id = "onlineP";
                nrOnline = document.createTextNode(serverResponse.online);
                pOnline.appendChild(nrOnline);
                onlineDiv.appendChild(pOnline);

                offlineDiv.removeChild(offlineDiv.lastChild);
                pOffline = document.createElement('p');
                pOffline.id = "offlineP";
                nrOffline = document.createTextNode(serverResponse.offline);
                pOffline.appendChild(nrOffline);
                offlineDiv.appendChild(pOffline);
            }
        }
    }
    setTimeout(getStatisticsFunction, 3000);
}