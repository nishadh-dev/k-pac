let kpac_grid = new dhx.Grid("kpac-grid", {
    columns: [
        {
            id: "id",
            header: [{ text: "ID" }],
        },
        {
            id: "title",
            header: [{ text: "Title" }, { content: "inputFilter" }],
        },
        {
            id: "description",
            header: [{ text: "Description" }],
        },
        {
            id: "creationDate",
            header: [{ text: "Creation Date" }],
        },
        {
            id: "action",
            header: [{ text: "Action" }],
            htmlEnable: true,
        }
    ],
    keyNavigation: true,
    selection: "row",
    autoWidth:true,
    editable: false,
    sortable: true,
    tooltip: false
});

function addKPac() {

    const title = document.getElementById("title").value;
    const description = document.getElementById("description").value;
    if(title && description) {
        const xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState === 4 && this.status === 200) {
                document.getElementById("title").value = "";
                document.getElementById("description").value = "";
                kPacs();
            } else {
                console.log("Error in Add KPAC api call");
            }
        };
        xhttp.open("POST", "/k-pac/api/kpac", true);
        xhttp.setRequestHeader("Content-type", "application/json");
        xhttp.setRequestHeader("Accept", "application/json");
        xhttp.send(JSON.stringify({
            "title" : title,
            "description" : description
        }));
    }

}

function kPacs() {
    const xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            kpac_grid.data.parse(this.responseText);
        } else {
            console.log("Error in KPACS api call");
        }
    };
    xhttp.open("GET", "/k-pac/api/kpacs", true);
    xhttp.send();
}

function deleteKPac(id) {
    const xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            kPacs();
        } else {
            console.log("Error in Delete KPACS api call");
        }
    };
    xhttp.open("DELETE", "/k-pac/api/kpac/"+id, true);
    xhttp.send();
}


