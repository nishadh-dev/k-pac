let set_grid = new dhx.Grid("set-grid", {
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

function addSet() {

    const title = document.getElementById("title").value;
    const options = document.getElementById("kpacs").selectedOptions;
    if(title && options.length > 0) {

        const kPacIds = [];
        for (const option of options) {
            kPacIds.push(option.value);
        }
        const xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState === 4 && this.status === 200) {
                document.getElementById("title").value = "";
                document.getElementById("kpacs").value = "";
                sets();
            } else {
                console.log("Error in Add Set api call");
            }
        };
        xhttp.open("POST", "/k-pac/api/set", true);
        xhttp.setRequestHeader("Content-type", "application/json");
        xhttp.setRequestHeader("Accept", "application/json");
        xhttp.send(JSON.stringify({
            "title" : title,
            "kPacIds" : kPacIds
        }));
    }

}

function sets() {
    const xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            set_grid.data.parse(this.responseText);
        } else {
            console.log("Error in SETS api call");
        }
    };
    xhttp.open("GET", "/k-pac/api/sets", true);
    xhttp.send();
}

function deleteSet(id) {
    const xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            sets();
        } else {
            console.log("Error in Delete Set api call");
        }
    };
    xhttp.open("DELETE", "/k-pac/api/set/"+id, true);
    xhttp.send();
}

set_grid.events.on("cellDblClick", function(row,column,_e){
    if(!column.htmlEnable) {
        const id = row.id;
        window.open('/k-pac/app/set/'+id, '', 'popup=true,left=100,top=100,width=320,height=320,toolbar=0,location=0,menubar=0');
    }
});