let data={};
let dataXml="";

function output(inp) {
    // document.body.appendChild(document.createElement('pre')).innerHTML = inp;
    // return document.createElement('pre').innerHTML=inp;
}

function addJson(){
    let name=document.getElementById("name").value;
    data[name]=document.getElementById("value").value;
    let out=syntaxHighlight(data);
    console.log(out);
    document.getElementById("root").innerHTML=out;

    console.log(data)
}


function syntaxHighlight(json) {
    if (typeof json != 'string') {
        json = JSON.stringify(json, undefined, 2);
    }
    json = json.replace(/&/g, '&amp;').replace(/</g, '&lt;').replace(/>/g, '&gt;');
    return json.replace(/("(\\u[a-zA-Z0-9]{4}|\\[^u]|[^\\"])*"(\s*:)?|\b(true|false|null)\b|-?\d+(?:\.\d*)?(?:[eE][+\-]?\d+)?)/g, function (match) {
        var cls = 'number';
        if (/^"/.test(match)) {
            if (/:$/.test(match)) {
                cls = 'key';
            } else {
                cls = 'string';
            }
        } else if (/true|false/.test(match)) {
            cls = 'boolean';
        } else if (/null/.test(match)) {
            cls = 'null';
        }
        return '<span class="' + cls + '">' + match + '</span>';
    });
}


function sendJson() {
    axios.post("/api/json",data)
        .then(function (response) {
            document.getElementById("result").innerHTML=response.data;
        })
}








function sendXml() {

    let parser = new DOMParser();
    let xmlDoc = parser.parseFromString(dataXml, "text/xml");
    console.log(xmlDoc)
    // axios.post("/api/xml","<data>"+dataXml+"</data>")
    //     .then(function (response) {
    //         document.getElementById("result").innerHTML=response.data;
    //     })
}



function taj() {

   let textxml=document.getElementById("textxml").value;
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open('POST', '/api/xml', true);

    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState === 4) {
            if (xmlhttp.status === 200) {
                alert(xmlhttp.responseText);
                // alert('done. use firebug/console to see network response');
            }
        }
    }
    // Send the POST request
    xmlhttp.setRequestHeader('Content-Type', 'text/xml');
    xmlhttp.send(textxml);
    // var config = {
    //     headers: {'Content-Type': 'text/xml'}
    // };
   // console.log(textxml)
   //  axios.post("/api/xml",textxml,config)
   //      .then(function (response) {
   //          // document.getElementById("result").innerHTML=response.data;
   //          console.log(response.data)
   //      })
}


function addXml(){
    let name=document.getElementById("name").value;
    dataXml+="<"+name+">"+document.getElementById("value").value+"</"+name+">";

    // console.log(out);
    document.getElementById("root").innerHTML=dataXml;

    console.log(dataXml)
}
