(function poll(){
    setTimeout(function(){
        $.ajax({ url: "/api/count", success: function(data){
            document.getElementById("count").textContent = data.count;
            poll();
        }, dataType: "json"});
    }, 3000);
})();