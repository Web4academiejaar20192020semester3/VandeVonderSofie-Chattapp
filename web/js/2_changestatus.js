var newStatusRequest = new XMLHttpRequest();

function changeSelectedStatus() {

        let selected = document.getElementById("selectedStatus");
        let element = selected.options[selected.selectedIndex].text;
        //console.log(element);

        var status = "status=" + encodeURIComponent(element);
        newStatusRequest.open("POST", "Controller?action=ChangeStatus");
        newStatusRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        newStatusRequest.send(status);
        document.getElementById("currentStatus").innerText = element;
}

function changeStatus() {

        let input = document.getElementById("statusInput").value;
        let status = "status=" + encodeURIComponent(input); // special chars
        newStatusRequest.open("POST", "Controller?action=ChangeStatus");
        newStatusRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        newStatusRequest.send(status);
        document.getElementById("currentStatus").innerText = input;
}
