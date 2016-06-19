function shortenURL () {

    var longUrl = document.getElementById("urlValue1").value;
    
    var shortURL = getShortURL(longUrl);

};

function getShortURL(longURL) {
    var request = new XMLHttpRequest();
    request.open('POST', "/api/c/", true);
    request.setRequestHeader('Content-Type', 'application/json');
    request.send(JSON.stringify({"longURL": longURL}));
    request.onload = function() {
        if (request.status >= 200 && request.status < 400) {
            var data = JSON.parse(request.responseText);
            var shortURL = 'http://litl.io/'.concat(data.aliasURL);
            var shortURLpreview  = 'Preview URL: http://litl.io/p/'.concat(data.aliasURL);
            var shortURLstats  = 'Statistics URL: http://litl.io/s/'.concat(data.aliasURL);
            var shortURLcharacter = 'Your URL has been reduced by '.concat(data.characterReduction).concat(" characters");
            document.getElementById("shortURL").textContent = shortURL;
            document.getElementById("shortURLpreview").textContent = shortURLpreview;
            document.getElementById("shortURLstats").textContent = shortURLstats;
            document.getElementById("shortURLcharacter").textContent = shortURLcharacter;
        } else {
            alert('Ooops, something went wrong...');
        }
    }
    
    request.onerror = function() {
        alert('Ooops, something went wrong...');
    };


};