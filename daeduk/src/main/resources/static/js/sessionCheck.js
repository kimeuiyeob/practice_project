$(document).ready(function () {
    $('#header').load('/header.html', function () {
        updateLoginButton();
    });

    function updateLoginButton() {
        var isLoggedIn = $('#loginCheck').val() === 'true';

        if (isLoggedIn) {
            $('#loginBtn')
                .text('로그아웃')
                .removeClass('btn btn-primary')
                .addClass('btn btn-logout')
                .attr('href', '/logout');
        } else {
            $('#loginBtn')
                .text('로그인')
                .removeClass('btn btn-logout')
                .addClass('btn btn-primary');
        }
    }
});