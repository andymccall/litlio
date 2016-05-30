/**
 * Created by andymccall on 30/05/2016.
 */

//this will submit only if the value is not default
$("#submitURL").click(function () {
    if ($("#urlValue").val() === "https://enter.your.long.url.here.com/")
    {
        alert("Please enter a URL starting with http:// or https://");
        return false;
    }
});

//this will put default value if the field is empty
$("#urlValue").blur(function () {
    if(this.value == ''){
        this.value = 'https://enter.your.long.url.here.com/';
    }
});

//this will empty the field is the value is the default one
$("#urlValue").focus(function () {
    if (this.value == 'https://enter.your.long.url.here.com/') {
        this.value = '';
    }
});

