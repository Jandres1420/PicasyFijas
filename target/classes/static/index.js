function lectura(lista){
    let file = "/index?lista=" + lista.value

    fetch (file,{method:'POST'})
        .then(x => x.text())
        .then(y => document.getElementById("postrespmsg").innerHTML = y)
}

function loadGetMsg(){
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
        document.getElementById("getrespmsg").innerHTML = this.responseText;
    }
    xhttp.open("GET", "/index");
    xhttp.send()
}
