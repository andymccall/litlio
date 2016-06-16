function createURL () {

    var longUrl = document.getElementById("urlValue2").value;
    var memorableWord = document.getElementById("memorableWord").value;

    var memorableURL = getMemorableURL(longUrl, memorableWord);

};

function getMemorableURL(longURL, memorableWord) {
    var request = new XMLHttpRequest();
    request.open('POST', "/api/c/", true);
    request.setRequestHeader('Content-Type', 'application/json');
    request.send(JSON.stringify({"aliasURL": memorableWord,"longURL": longURL}));
    request.onload = function() {
        if (request.status >= 200 && request.status < 400) {
            var data = JSON.parse(request.responseText);
            var memorableURL = 'http://litl.io/'.concat(data.aliasURL);
            var memorableURLpreview  = 'Preview URL: http://litl.io/p/'.concat(data.aliasURL);
            var memorableURLstats  = 'Statistics URL: http://litl.io/s/'.concat(data.aliasURL);
            document.getElementById("memorableURL").textContent = memorableURL;
            document.getElementById("memorableURL").href = "http://litl.io/";
            document.getElementById("memorableURLpreview").textContent = memorableURLpreview;
            document.getElementById("memorableURLstats").textContent = memorableURLstats;

        } else {
            alert('Ooops, something went wrong...');
        }
    }

    request.onerror = function() {
        alert('Ooops, something went wrong...');
    };


};