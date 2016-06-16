/**
 * Created by andymccall on 30/05/2016.
 */
//this will put default value if the field is empty
$("#urlValue1").blur(function () {
    if(this.value == ''){
        this.value = 'https://enter.your.long.url.here.com/';
    }
});

//this will empty the field is the value is the default one
$("#urlValue1").focus(function () {
    if (this.value == 'https://enter.your.long.url.here.com/') {
        this.value = '';
    }
});

//this will put default value if the field is empty
$("#urlValue2").blur(function () {
    if(this.value == ''){
        this.value = 'https://enter.your.long.url.here.com/';
    }
});

//this will empty the field is the value is the default one
$("#urlValue2").focus(function () {
    if (this.value == 'https://enter.your.long.url.here.com/') {
        this.value = '';
    }
});

//this will put default value if the field is empty
$("#memorableWord").blur(function () {
    if(this.value == ''){
        this.value = 'memorable-words';
    }
});

//this will empty the field is the value is the default one
$("#memorableWord").focus(function () {
    if (this.value == 'memorable-words') {
        this.value = '';
    }
});

