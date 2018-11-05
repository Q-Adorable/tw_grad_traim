$('document').ready(function () {
    $('#button').click(function () {
        let phone = $('#phone');
        let password = $('#password');
        let passwordAgain = $('#passwordAgain');
        console.log('phone:' + phone);
        console.log('password:' + password + "   passwordAgain:" + passwordAgain);
        if (password === passwordAgain) {
              console.log("yes");
        } else {
            console.log("no");
        }                                                               
    })
})